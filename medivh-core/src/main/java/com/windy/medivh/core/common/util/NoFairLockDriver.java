package com.windy.medivh.core.common.util;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.StandardLockInternalsDriver;
import org.apache.zookeeper.CreateMode;

/**
 * Created by windy on 2018/3/12.
 */
public class NoFairLockDriver  extends StandardLockInternalsDriver {
    /**
     * 随机数的长度
     */
    private int numLength;
    private static int DEFAULT_LENGTH = 5;

    public NoFairLockDriver() {
        this(DEFAULT_LENGTH);
    }

    public NoFairLockDriver(int numLength) {
        this.numLength = numLength;
    }

    @Override
    public String createsTheLock(CuratorFramework client, String path, byte[] lockNodeBytes) throws Exception
    {
        String newPath = path + getRandomSuffix();
        String ourPath;
        if ( lockNodeBytes != null )
        {
            //原来使用的是CreateMode.EPHEMERAL_SEQUENTIAL类型的节点
            //节点名称最终是这样的_c_c8e86826-d3dd-46cc-8432-d91aed763c2e-lock-0000000025
            //其中0000000025是zook服务器端资自动生成的自增序列 从0000000000开始
            //所以每个客户端创建节点的顺序都是按照0，1，2，3这样递增的顺序排列的，所以他们获取锁的顺序与他们进入的顺序是一致的，这也就是所谓的公平锁
            //现在我们将有序的编号换成随机的数字，这样在获取锁的时候变成非公平锁了
            ourPath = client.create().creatingParentContainersIfNeeded().withProtection().withMode(CreateMode.EPHEMERAL).forPath(newPath, lockNodeBytes);
            //ourPath = client.create().creatingParentContainersIfNeeded().withProtection().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(path, lockNodeBytes);
        }
        else
        {
            ourPath = client.create().creatingParentContainersIfNeeded().withProtection().withMode(CreateMode.EPHEMERAL).forPath(newPath);
            //ourPath = client.create().creatingParentContainersIfNeeded().withProtection().withMode(CreateMode.EPHEMERAL_SEQUENTIAL).forPath(path);
        }
        return ourPath;
    }

    /**
     * 获得随机数字符串
     */
    public String getRandomSuffix() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numLength; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }
}
