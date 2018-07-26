package com.program.tutorrest.service.impl;

import com.program.tutorcommon.base.BaseServiceImpl;
import com.program.tutorcommon.dao.UserDao;
import com.program.tutorcommon.entity.User;
import com.program.tutorrest.service.RedisService;
import com.program.tutorrest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

/**
 * @author Li on 2018/3/2.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao,User> implements UserService{

    @Autowired
    private RedisService<Integer> redisSocketService;

    @Autowired
    private RedisService<User> redisService;

    @Value("${REDIS_USERID_KEY}")
    private String REDIS_USERID_KEY;

    @Value("${REDIS_USER_KEY}")
    private String REDIS_USER_KEY;

    @Value("${REDIS_USER_TIME}")
    private Integer REDIS_USER_TIEM;


    /**
     * 验证用户名是否可用
     *
     * @param username
     * @return
     */
    @Override
    public boolean checkUsername(String username) {
        User user = repository.findByUsername(username);
        return user == null;
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     */
    @Override
    public boolean checkUserEmail(String email) {
        User user = repository.findByEmail(email);
        return user == null;
    }

    /**
     * 注册用户
     *
     * @param email
     * @param username
     * @param password
     */
    @Override
    public void createUser(String email, String username, String password) {
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setInitTime(new Date());
        user.setPassword(DigestUtils.md5DigestAsHex(password.getBytes()));
        repository.save(user);
    }

    /**
     * 根据Email查询用户
     *
     * @param email
     * @return
     */
    @Override
    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    /**
     * 用户登录，返回token字符串
     *
     * @param user
     * @return
     */
    @Override
    public String loginUser(User user) {
        String token = UUID.randomUUID().toString();
        redisService.cacheString(REDIS_USER_KEY+token,user,REDIS_USER_TIEM);
        redisSocketService.cacheSet(REDIS_USERID_KEY,user.getId());
        return token;
    }

}
