package com.windy.medivh.common.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.UUID;

/**
 * Created by alex on 2016/11/8.
 */
public class WorkIdGeneratorWithRedis implements WorkIdGenerator {

    private final Logger logger = LoggerFactory.getLogger(WorkIdGeneratorWithRedis.class);
    private final String key = "subaru_snowflake";

    private String appName;
    private JedisPool jedisPool;

    public WorkIdGeneratorWithRedis(JedisPool jedisPool, String appName) {
        this.jedisPool = jedisPool;
        this.appName = appName;
    }

    private String genKey() throws Exception {
        //为了保证唯一性，使用mac地址来标示每台物理机
        return String.format("snowflake_%s_%s", getMACAddress(InetAddress.getLocalHost()), this.appName);
    }

    //获取MAC地址的方法
    private String getMACAddress(InetAddress ia) throws Exception {
        byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
        StringBuilder builder = new StringBuilder();
        for (byte m : mac) {
            //mac[i] & 0xFF 是为了把byte转化为正整数
            String s = Integer.toHexString(m & 0xFF);//TODO 使用String.format代替？
            builder.append(s.length() == 1 ? 0 + s : s);
        }
        return builder.toString();
    }

    //TODO 这里需要使用redis事务来进行操作，同时加redis锁
    public Long workId() {
        Jedis jedis = jedisPool.getResource();
        try {
            String appKey = genKey();
            String workIdStr = jedis.get(appKey);
            if (StringUtils.isEmpty(workIdStr)) {
                Long workId = jedis.incr(key);
                jedis.set(appKey, workId.toString());
                return workId;
            }
            return Long.valueOf(workIdStr);
        } catch (Throwable t2) {
            logger.error("生成workId失败:", t2);
        } finally {
            try {
                jedis.close();
            } catch (Throwable t) {
                logger.error("生成workId失败:", t);
                try {
                    jedisPool.close();
                } catch (Throwable t1) {
                    logger.error("生成workId失败:", t1);
                }
            }
        }
        throw new Error("生成workId失败");
    }
}
