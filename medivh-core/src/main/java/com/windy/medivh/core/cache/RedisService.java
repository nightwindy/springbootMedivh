package com.windy.medivh.core.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Service;

@Service
public class RedisService {
    @Autowired
    private RedisTemplate redisTemplate;


    public Object get(String key) {
        return redisTemplate.boundValueOps(key).get();
    }


    public void delete(String key) {
        redisTemplate.delete(key);
    }


    public Boolean setNX(final String key, final String value, final int expire) {
        Boolean result = (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] keys = serializer.serialize(key);
                byte[] values = serializer.serialize(value);
                Boolean result = redisConnection.setNX(keys, values);
                if (result && expire > 0) {
                    redisConnection.expire(keys, expire);
                }
                return result;
            }
        });
        return result;
    }

    public Long incr(final String key, final int expire) {
        Long result = (Long) redisTemplate.execute(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer<String> serializer = redisTemplate.getStringSerializer();
                byte[] keys = serializer.serialize(key);
                Long result = redisConnection.incr(keys);
                if (expire > 0) {
                    redisConnection.expire(keys, expire);
                }
                return result;
            }
        });
        return result;
    }
}
