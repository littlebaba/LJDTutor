package com.program.tutorrest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author Li on 2018/3/3.
 */
@Service
public class RedisService<T> {

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 设置String缓存
     * @param key
     * @param t
     * @param time
     */
    public void cacheString(String key,T t,int time){
        ValueOperations<String,T> operations = redisTemplate.opsForValue();
        operations.set(key,t,time, TimeUnit.HOURS);
    }

    /**
     * 设置Set缓存
     * @param key
     * @param t
     */
    public void cacheSet(String key,T t){
        SetOperations<String,T> opsForSet = redisTemplate.opsForSet();
        opsForSet.add(key,t);
    }
}
