package com.springbootdemo.mapper;

import com.springbootdemo.bean.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper
{
    @Select("SELECT * FROM user WHERE id = #{id}")
    User selectUser(int id);
}
