package com.ht.blog.dao;

import com.ht.blog.entity.HWebLog;
import java.util.List;

public interface HWebLogMapper {
    int insert(HWebLog record);

    List<HWebLog> selectAll();

    int updateResponse(Integer id,String response,Integer updatedAt);
}