package com.ht.blog.controller;

import com.ht.blog.common.help.valid.groups.auth.LoginAction;
import com.ht.blog.entity.HUser;
import com.ht.blog.service.AuthService;
import common.util.result.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AuthController
{
    private AuthService authService;

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
