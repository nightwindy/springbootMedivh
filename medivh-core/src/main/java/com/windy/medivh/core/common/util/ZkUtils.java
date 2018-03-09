package com.windy.medivh.core.common.util;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.BackgroundCallback;
import org.apache.curator.framework.api.CuratorEvent;
import org.apache.curator.framework.api.CuratorListener;
import org.apache.curator.framework.recipes.cache.ChildData;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * Created by windy on 2018/3/8.
 */
public class ZkUtils {


    private static CuratorFramework client;

    /**
     *
     * 你可以使用命名空间Namespace避免多个应用的
     * 节点的名称冲突。
     * CuratorFramework提供了命名空间的概念，
     * 这样CuratorFramework会为它的API调用的path加上命名空间
     */

    public static final String MEDIVH_NAMESPACE = "medivh-app";

    /*@Value("${zkServerList}")*/
    private static String connectString="127.0.0.1:2181";//ZK服务器地址


    public  static CuratorFramework getClient() {
        if (client == null) {
            //重试连接策略
            //重试3次，每次间隔时间指数增长(有具体增长公式)重试次数的增加，计算出的sleep时间也会越来越大
            RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
            client = CuratorFrameworkFactory.builder()
                    .connectString(connectString)
                    .sessionTimeoutMs(5000)//如果3秒连接不上客户端，就超时
                    .connectionTimeoutMs(5000)//session的有效时间5秒
                    .retryPolicy(retryPolicy)//设置重连接策略，重连接5次，每次失败后休息2秒
                    .namespace(MEDIVH_NAMESPACE) // API调用的path加上命名空间
                    .build();
            client.start();
        }
        return client;
    }

    public static void create(CuratorFramework client, String path, byte[] payload) throws Exception {
        // /namespace/app1/我的歌  创建节点和数据
        client.create().creatingParentsIfNeeded().forPath(path, payload);
    }
    public static void createEphemeral(CuratorFramework client, String path, byte[] payload) throws Exception {
        // 临时节点 节点创建模式默认为持久化节点
        //creatingParentsIfNeeded（）之后Curator能够自动递归创建所有所需的父节点。
        //假如没有creatingParentsIfNeeded 自动抛出异常
        client.create().creatingParentsIfNeeded().withMode(CreateMode.EPHEMERAL).forPath(path, payload);
    }
    public static String createEphemeralSequential(CuratorFramework client, String path, byte[] payload) throws Exception {
        // this will create the given EPHEMERAL-SEQUENTIAL ZNode with the given
        // data using Curator protection.
        return client.create().withProtection().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(path, payload);
    }
    public static void setData(CuratorFramework client, String path, byte[] payload) throws Exception {
        // set data for the given node
        client.setData().forPath(path, payload);
    }
    public static void setDataAsync(CuratorFramework client, String path, byte[] payload) throws Exception {
        // this is one method of getting event/async notifications
        CuratorListener listener = new CuratorListener() {
            //回调值为CuratorEvent，里面包含事件类型、响应吗和节点的详细信息。
            /*
            0	OK，即调用成功
            -4	ConnectionLoss，即客户端与服务端断开连接
            -110	NodeExists，即节点已经存在
            -112	SessionExpired，即会话过期

             */
            @Override
            public void eventReceived(CuratorFramework client, CuratorEvent event) throws Exception {
                // examine event for details
            }
        };
        client.getCuratorListenable().addListener(listener);
        // set data for the given node asynchronously. The completion
        // notification
        // is done via the CuratorListener.
        client.setData().inBackground().forPath(path, payload);
    }
    public static void setDataAsyncWithCallback(CuratorFramework client, BackgroundCallback callback, String path, byte[] payload) throws Exception {
        // this is another method of getting notification of an async completion
        client.setData().inBackground(callback).forPath(path, payload);
    }
    public static void delete(CuratorFramework client, String path) throws Exception {
        // delete the given node
        client.delete().deletingChildrenIfNeeded().forPath(path);
    }
    public static void guaranteedDelete(CuratorFramework client, String path) throws Exception {
        // delete the given node and guarantee that it completes
        client.delete().guaranteed().forPath(path);
    }
    public static List<String> watchedGetChildren(CuratorFramework client, String path) throws Exception {
        /**
         * Get children and set a watcher on the node. The watcher notification
         * will come through the CuratorListener (see setDataAsync() above).
         */
        return client.getChildren().watched().forPath(path);
    }
    public static List<String> watchedGetChildren(CuratorFramework client, String path, Watcher watcher) throws Exception {
        /**
         * Get children and set the given watcher on the node.
         */
        return client.getChildren().usingWatcher(watcher).forPath(path);
    }

    public static Stat checkExists(CuratorFramework client, String path) throws Exception {
       return client.checkExists().forPath(path);//Stat就是对zonde所有属性的一个映射， stat=null表示节点不存在！ 
    }

    public static List<String> checkAllChildExists(CuratorFramework client, String path) throws Exception {
       return client.getChildren().forPath(path);//获取path下的子节点 不包含其子节点下的子节点
    }
//监听path路径下的儿子节点 不包含孙子节点
    public static PathChildrenCache pathCache(CuratorFramework client, String path,Boolean bol) throws Exception {
        PathChildrenCache cache = new PathChildrenCache(client, path, bol);
        cache.getListenable().addListener(new PathChildrenCacheListener() {
            @Override
            public void childEvent(CuratorFramework client, PathChildrenCacheEvent event) throws Exception {
                PathChildrenCacheEvent.Type eventType = event.getType();
                switch (eventType) {
                    case CONNECTION_RECONNECTED:
                        cache.rebuild();
                        break;
                    case CONNECTION_SUSPENDED:
                    case CONNECTION_LOST:
                        System.out.println("Connection error,waiting...");
                        break;
                    default:
                        System.out.println("PathChildrenCache changed : {path:" + event.getData().getPath() + " data:" +
                                new String(event.getData().getData()) + "}");
                }
            }
        });
        return cache;
    }
    public static void main(String[] args) {

        CuratorFramework client = getClient();
        try {
            //ZkUtils.create(client,"/medivh/music","Jay".getBytes());
            Stat stat = ZkUtils.checkExists(client, "/medivh/music2");

            List<String> strings = ZkUtils.checkAllChildExists(client, "/medivh");

            PathChildrenCache cache =ZkUtils.pathCache(client, "/medivh", true);
            /*
            NORMAL：正常初始化。
            BUILD_INITIAL_CACHE：在调用start()之前会调用rebuild()。
            POST_INITIALIZED_EVENT： 当Cache初始化数据后发送一个PathChildrenCacheEvent.Type#INITIALIZED事件
             */
            cache.start(PathChildrenCache.StartMode.BUILD_INITIAL_CACHE);
            List<ChildData> datas = cache.getCurrentData();
            for (ChildData data : datas) {
                System.out.println("pathcache:{" + data.getPath() + ":" + new String(data.getData())+"}");
            }

            ZkUtils.create(client,"/medivh/music4","我的哥".getBytes());


            System.out.printf("xx");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
