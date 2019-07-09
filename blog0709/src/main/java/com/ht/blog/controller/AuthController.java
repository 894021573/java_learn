package com.ht.blog.controller;

import com.ht.blog.common.help.result.CommonCodeMsg;
import com.ht.blog.common.help.valid.groups.CreateAction;
import com.ht.blog.common.help.valid.groups.auth.LoginAction;
import com.ht.blog.entity.HUser;
import com.ht.blog.service.AuthService;
import com.ht.blog.service.ext.CommonService;
import common.util.result.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
public class AuthController
{
    @Autowired
    private AuthService authService;

    @Autowired
    private CommonService commonService;

    // 注册
    @RequestMapping(path = "/register", method = RequestMethod.POST)
    public Response<Map<String, Object>> register(@Validated(CreateAction.class) HUser hUser)
    {
        return authService.register(hUser);
    }

    // 登录
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public Response<Map<String, Object>> login(@Validated(LoginAction.class) HUser hUser)
    {
        return authService.login(hUser);
    }

    @Autowired
    public void setAuthService(AuthService authService)
    {
        this.authService = authService;
    }
}
