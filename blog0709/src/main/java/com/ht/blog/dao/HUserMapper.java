package com.ht.blog.dao;

import com.ht.blog.entity.HUser;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface HUserMapper
{
    int insert(HUser hUser);

    List<HUser> selectAll();

    HUser selectOne(HUser hUser);

    HUser selectByUsername(String username);

    HUser selectByToken(String token);

    int updateToken(Integer id, String token, int expiredAt);
}