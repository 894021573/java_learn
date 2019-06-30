package com.ht.blog.service.impl;

import com.ht.blog.common.help.result.AuthCodeMsg;
import com.ht.blog.dao.HUserMapper;
import com.ht.blog.entity.HUser;
import com.ht.blog.service.AuthService;
import com.ht.blog.vo.AuthLoginVo;
import common.util.SecurityUtil;
import common.util.result.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService
{
    private HUserMapper hUserMapper;

    @Override
    public Response<Map<String, Object>> login(HUser hUser)
    {
        hUser.setPassword(SecurityUtil.md5(hUser.getPassword()));
        hUser = hUserMapper.selectOne(hUser);

        Map<String, Object> param = new HashMap<>();

        if (hUser != null) {
            AuthLoginVo authLoginVo = new AuthLoginVo();
            BeanUtils.copyProperties(hUser, authLoginVo);
            param.put("user", authLoginVo);

            return Response.success(param);
        }

        return Response.error(AuthCodeMsg.LOGIN_FAIL);
    }

    @Autowired
    public void sethUserMapper(HUserMapper hUserMapper)
    {
        this.hUserMapper = hUserMapper;
    }
}
