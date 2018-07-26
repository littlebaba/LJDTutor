package com.program.tutorrest.controller;

import com.program.tutorcommon.base.BaseController;
import com.program.tutorcommon.dto.TutorResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Li on 2018/3/2.
 */
@Api(value = "用户接口",description = "用户注册，登录，登出，获取用户信息等服务")
@RestController
@RequestMapping("/duser")
public class UserController extends BaseController{

    @ApiOperation("注册接口")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email",value = "用户邮箱",dataType = "String"),
            @ApiImplicitParam(name = "username",value = "用户名称",dataType = "String"),
            @ApiImplicitParam(name = "password",value = "用户密码",dataType = "String")
    })
    @PostMapping
    public TutorResult checkUserName(String username,String email,String password){
//        TutorResult result = restProcessor(()->{
//
//        });
        return null;
    }
}
