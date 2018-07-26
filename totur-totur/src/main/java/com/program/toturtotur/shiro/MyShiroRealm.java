package com.program.toturtotur.shiro;

import com.program.tutorcommon.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;

/**
 * @author Li on 2018/2/22.
 */
public class MyShiroRealm extends AuthorizingRealm{


//    @Resource
//    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
//        User user = userService.findByUserName(username);
        User user = null;
        if (user == null){
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user.getId(),
                user.getPassword(),
                ByteSource.Util.bytes(username),
                getName()
        );
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("UserSession",user);
        session.setAttribute("UserSessionId",user.getId());
        return authenticationInfo;
    }
}
