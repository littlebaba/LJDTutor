package com.program.toturtotur.service.impl;

import com.program.toturtotur.service.UserService;
import com.program.toturtotur.utils.SecurityUtil;
import com.program.tutorcommon.base.BaseServiceImpl;
import com.program.tutorcommon.dao.UserDao;
import com.program.tutorcommon.entity.User;
import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.apache.shiro.authc.credential.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Li on 2018/5/12.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao, User> implements UserService {

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
