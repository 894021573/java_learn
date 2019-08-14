package com.ht.blog.service;

import com.ht.blog.entity.HUser;
import com.ht.blog.entity.HWebLog;
import common.util.result.Response;

import java.util.Map;

public interface WebLogService
{
    Response<Map<String,Object>> insertLog(HWebLog hWebLog);
    Response<Map<String,Object>> updateResponse(String response,Integer id);
}
