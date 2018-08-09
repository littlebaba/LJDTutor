package com.program.toturtotur.utils;

import com.program.toturtotur.entity.User;
import org.apache.shiro.authc.credential.PasswordService;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.hash.Md5Hash;

import java.security.Key;


/**
 * @author Li on 2018/5/12.
 */
public class SecurityUtil {

    public static User md5Base64(User user){
        String password = user.getPassword();
        String salt = "tutor";
        user.setPassword(new Md5Hash(password, salt).toString());
        return user;
    }

    public static String md5Base64(String str){
        String password = str;
        String salt = "tutor";
        return new Md5Hash(password, salt).toString();
    }
}
