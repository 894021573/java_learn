package cn.mybatis.mapping;

import cn.mybatis.domain.QueryUser;
import cn.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper
{
    User getUser2(@Param("id") int id, @Param("name") String name);
    User getByQueryUser(QueryUser queryUser);
}
