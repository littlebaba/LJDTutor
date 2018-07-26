package com.program.toturtotur.config;

import com.program.toturtotur.service.UserService;
import com.program.toturtotur.utils.SecurityUtil;
import com.program.tutorcommon.dao.UserDao;
import com.program.tutorcommon.entity.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author Li on 2018/5/12.
 */
public class MyRealm extends AuthorizingRealm {
    Logger log = LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    UserDao userDao;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        String username = (String) token.getPrincipal();
        User user = userDao.findByUsername(username);

        if (!username.equals(user.getUsername())){
            throw new UnknownAccountException();
        }
        AuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(),user.getPassword(),getName());
        log.warn(""+username+"--"+token+"--"+info);
        return info;
    }
}
