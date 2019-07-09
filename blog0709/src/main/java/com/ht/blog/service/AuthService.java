package com.ht.blog.service;

import com.ht.blog.entity.HUser;
import common.util.result.Response;

import java.util.Map;

public interface AuthService
{
    Response<Map<String,Object>> register(HUser hUser);
    Response<Map<String,Object>> login(HUser hUser);
}
