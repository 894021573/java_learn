package com.ht.blog.service.impl;

import com.ht.blog.common.help.result.AuthCodeMsg;
import com.ht.blog.configurer.RabbitMQConfig;
import com.ht.blog.dao.HUserMapper;
import com.ht.blog.dao.HWebLogMapper;
import com.ht.blog.entity.HUser;
import com.ht.blog.entity.HWebLog;
import com.ht.blog.service.AuthService;
import com.ht.blog.service.WebLogService;
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
public class WebLogImpl implements WebLogService
{
    @Autowired
    private HWebLogMapper hWebLogMapper;

    @Override
    public Response<Map<String, Object>> insertLog(HWebLog hWebLog)
    {
        hWebLogMapper.insert(hWebLog);
        Map<String, Object> param = new HashMap<>();
        param.put("id", hWebLog.getId());
        return Response.success(param);
    }

    @Override
    public Response<Map<String, Object>> updateResponse(String response,Integer id)
    {
        hWebLogMapper.updateResponse(id,response,DateUtil.getSecondTimestamp(null));
        Map<String, Object> param = new HashMap<>();
        return Response.success(param);
    }
}
