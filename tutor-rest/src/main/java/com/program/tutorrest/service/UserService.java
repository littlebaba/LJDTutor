package com.program.tutorrest.service;

import com.program.tutorcommon.base.BaseService;
import com.program.tutorcommon.entity.User;

/**
 * @author Li on 2018/3/2.
 */
public interface UserService extends BaseService<User>{

    /**
     * 验证用户名是否可用
     * @param username
     * @return
     */
    boolean checkUsername(String username);

    /**
     * 验证邮箱
     * @param email
     * @return
     */
    boolean checkUserEmail(String email);

    /**
     * 注册用户
     * @param email
     * @param username
     * @param password
     */
    void createUser(String email,String username,String password);

    /**
     * 根据Email查询用户
     * @param email
     * @return
     */
    User findByEmail(String email);

    /**
     * 用户登录，返回token字符串
     * @param user
     * @return
     */
    String loginUser(User user);
}
