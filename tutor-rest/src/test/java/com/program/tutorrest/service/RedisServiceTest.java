package com.program.tutorrest.service;

import com.program.tutorcommon.entity.User;
import com.program.tutorrest.service.RedisService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Li on 2018/3/3.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisServiceTest {


    @Autowired
    RedisService redisService;

    @Test
    public void cacheString() {
        User user = new User();
        user.setUsername("liheng");
        user.setEmail("453984016@qq.com");
        redisService.cacheString("uuid5",user,1);
    }

    @Test
    public void cacheSet() {
        User user = new User();
        user.setId(99);
        redisService.cacheSet("u99",user.getId());
    }
}