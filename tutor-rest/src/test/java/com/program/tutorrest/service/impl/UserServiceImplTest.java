package com.program.tutorrest.service.impl;

import com.program.tutorcommon.entity.User;
import com.program.tutorrest.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author Li on 2018/3/2.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserService userService;

    @Test
    public void checkUsername() {
        Assert.assertEquals(false,userService.checkUsername("aa"));
    }

    @Test
    public void checkUserEmail() {
        Assert.assertEquals(false,userService.checkUserEmail("453984016@qq.com"));
    }

    @Test
    public void createUser() {
        userService.createUser("11@qq.com","bean","bean");
    }

    @Test
    public void findByEmail() {
        User user = userService.findByEmail("519550523@qq.com");
        Assert.assertEquals("519550523@qq.com",user.getEmail());
    }

    @Test
    public void loginUser() {
        User user = new User();
        user.setId(13);
        userService.loginUser(user);
    }


}