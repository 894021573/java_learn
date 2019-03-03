package cn.mybatis.test;

import cn.mybatis.domain.QueryUser;
import cn.mybatis.domain.User;
import cn.mybatis.mapping.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class UserProxyTest
{
    @Test
    public void getUser() throws IOException
    {
        InputStream in = Resources.getResourceAsStream("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 动态代理 + 多个参数
        User user = userMapper.getUser2(8,"第八个");
        System.out.println(user.getName());
    }

    @Test
    public void getByQueryUser() throws IOException
    {
        InputStream in = Resources.getResourceAsStream("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        QueryUser queryUser = new QueryUser();
        User user = new User();
        user.setId(1);
        queryUser.setUser(user);
        User user1 = userMapper.getByQueryUser(queryUser);
        System.out.println(user1);
    }
}
