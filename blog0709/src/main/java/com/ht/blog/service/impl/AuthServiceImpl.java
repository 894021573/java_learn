package com.ht.blog.service.impl;

import com.ht.blog.common.help.result.AuthCodeMsg;
import com.ht.blog.configurer.RabbitMQConfig;
import com.ht.blog.dao.HUserMapper;
import com.ht.blog.entity.HUser;
import com.ht.blog.service.AuthService;
import com.ht.blog.service.ext.MailService;
import com.ht.blog.vo.AuthLoginVo;
import common.util.DateUtil;
import common.util.SecurityUtil;
import common.util.result.Response;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthServiceImpl implements AuthService
{
    private HUserMapper hUserMapper;

    @Autowired
    private MailService mailService;

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Autowired
    public void sethUserMapper(HUserMapper hUserMapper)
    {
        this.hUserMapper = hUserMapper;
    }

    // 注册
    @Override
    public Response<Map<String, Object>> register(HUser hUser)
    {
        // 判断用户名是否存在
        if (hUserMapper.selectByUsername(hUser.getUsername()) != null) {
            return Response.error(AuthCodeMsg.USERNAME_EXISTS);
        }

        hUser.setPassword(SecurityUtil.md5(hUser.getPassword()));
        hUser.setCreatedAt(DateUtil.getSecondTimestamp(null));
        int addRow = hUserMapper.insert(hUser);

        if (addRow > 0) {
            AuthLoginVo authLoginVo = new AuthLoginVo();
            BeanUtils.copyProperties(hUser, authLoginVo);
            Map<String, Object> param = new HashMap<>();
            param.put("user", authLoginVo);

            Map<String,String> map = new HashMap<>();
            map.put("title","欢迎" + hUser.getNickname());
            map.put("content","欢迎写blog");
            map.put("email",hUser.getEmail());

            rabbitTemplate.convertAndSend(RabbitMQConfig.SEND_REGISTER_MAIL_QUEUE_NAME, map);

//            mailService.sendMail("欢迎注册","热烈欢迎","894021573@qq.com");

            return Response.success(param);
        }

        return Response.error(AuthCodeMsg.REGISTER_FAIL);
    }

    // 登录
    @Override
    public Response<Map<String, Object>> login(HUser hUser)
    {
        hUser.setPassword(SecurityUtil.md5(hUser.getPassword()));
        hUser = hUserMapper.selectOne(hUser);

        Map<String, Object> param = new HashMap<>();

        if (hUser != null) {
            // 更新token
            String token = SecurityUtil.makeToken();
            int expiredAt = DateUtil.getSecondTimestamp(null) + 3600 * 24;
            hUser.setToken(token);
            hUser.setExpiredAt(expiredAt);
            hUserMapper.updateToken(hUser.getId(), token, expiredAt);

            AuthLoginVo authLoginVo = new AuthLoginVo();
            BeanUtils.copyProperties(hUser, authLoginVo);
            param.put("user", authLoginVo);

            return Response.success(param);
        }

        return Response.error(AuthCodeMsg.LOGIN_FAIL);
    }
}
