package com.ht.blog.dao;

import com.ht.blog.entity.HUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HUserMapper {
    int insert(HUser record);

    List<HUser> selectAll();

    HUser selectOne(HUser hUser);
}