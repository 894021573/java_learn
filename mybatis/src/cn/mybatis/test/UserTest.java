package cn.mybatis.test;


import cn.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserTest
{
    @Test
    public void selectOneTest() throws IOException
    {
        //mybatis的配置文件
        String resource = "config.xml";
        //使用类加载器加载mybatis的配置文件（它也加载关联的映射文件）
        InputStream is = Resources.getResourceAsStream("config.xml");
//        InputStream is = UserTest.class.getClassLoader().getResourceAsStream(resource);
        //构建sqlSession的工厂
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
        //使用MyBatis提供的Resources类加载mybatis的配置文件（它也加载关联的映射文件）
        //Reader reader = Resources.getResourceAsReader(resource);
        //构建sqlSession的工厂
        //SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //创建能执行映射文件中sql的sqlSession
        SqlSession session = sessionFactory.openSession();
        /**
         * 映射sql的标识字符串，
         * me.gacl.mapping.userMapper是userMapper.xml文件中mapper标签的namespace属性的值，
         * getUser是select标签的id属性值，通过select标签的id属性值就可以找到要执行的SQL
         */
        String statement = "cn.mybatis.mapping.UserMapper.getUser";//映射sql的标识字符串
        //执行查询返回一个唯一user对象的sql
        Map<String, Object> map = new HashMap<>();
        map.put("id", 1);
        map.put("name", "11");
//        User user = session.selectOne(statement, 1);
        User user = session.selectOne(statement, map);
        System.out.println(user);

        Map<String, Object> map1 = new HashMap<>();
        map1.put("id", 2);
        map1.put("name", "加");
        User user1 = session.selectOne("cn.mybatis.mapping.UserMapper.getUserByName", map1);
        System.out.println(user1);
    }

    @Test
    public void selectAll() throws IOException
    {
        InputStream in = Resources.getResourceAsStream("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        List<User> userList = sqlSession.selectList("cn.mybatis.mapping.UserMapper.getAll",111);
        for(int i=0; i < userList.size();i++)
        {
            System.out.println(userList.get(i).getName());
        }
    }

    @Test
    public void insertUser() throws IOException
    {
        InputStream in = Resources.getResourceAsStream("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setName("hello");
        user.setAge(10);
        int i = sqlSession.insert("cn.mybatis.mapping.UserMapper.insertUser", user);
        sqlSession.commit(); // 一定要
        System.out.println(i);
        System.out.println(user.getId());
    }

    @Test
    public void updateUser() throws IOException
    {
        InputStream in = Resources.getResourceAsStream("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(16);
        user.setName("world");
        sqlSession.update("cn.mybatis.mapping.UserMapper.updateUser", user);
        sqlSession.commit();
    }

    @Test
    public void deleteUser() throws IOException
    {
        InputStream in = Resources.getResourceAsStream("config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        User user = new User();
        user.setId(16);
        sqlSession.delete("cn.mybatis.mapping.UserMapper.deleteUser", user);
        sqlSession.commit();
    }
}