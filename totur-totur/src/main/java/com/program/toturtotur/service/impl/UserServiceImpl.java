package com.program.toturtotur.service.impl;

import com.program.toturtotur.service.UserService;
import com.program.tutorcommon.base.BaseServiceImpl;
import com.program.tutorcommon.dao.UserDao;
import com.program.tutorcommon.entity.User;
import org.springframework.stereotype.Service;

/**
 * @author Li on 2018/2/14.
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<UserDao,User> implements UserService{


}
