package com.program.toturtotur.service.impl;

import com.program.toturtotur.dao.StudentDao;
import com.program.toturtotur.dao.UserDao;
import com.program.toturtotur.entity.User;
import com.program.toturtotur.service.UserService;
import com.program.toturtotur.utils.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Li on 2018/5/12.
 */
@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserDao repository;
    /**
     * 注册
     *
     * @param user
     */
    @Override
    public int register(User user) {
        User isExit = repository.findByUsername(user.getUsername());
        if (isExit ==null){
            user.setPassword(SecurityUtil.md5Base64(user.getPassword().trim()));
            repository.save(user);
            return 1;
        }

        return 0;
    }

    /**
     * 登录
     *
     * @param user
     */
    @Override
    public int login(User user) {
        User isExit = repository.findByUsername(user.getUsername());
//        if (isExit != null){
//            User aesUser = SecurityUtil.aesCipher(user);
//            if (isExit.getPassword().equals(aesUser.getPassword())){
//                return 1;
//            }
//        }
        return 0;
    }
}
