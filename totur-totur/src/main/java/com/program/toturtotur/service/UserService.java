package com.program.toturtotur.service;

import com.program.tutorcommon.entity.User;

/**
 * @author Li on 2018/5/12.
 */
public interface UserService {

    /**
     * 注册
     */
    int register(User user);

    /**
     * 登录
     */

    int login(User user);

}
