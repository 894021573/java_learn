package common.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JedisPoolUtil
{
    private static JedisPool pool = null;

    static {
        //加载配置文件
        InputStream in = JedisPoolUtil.class.getClassLoader().getResourceAsStream("config.properties");
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //获得池子对象
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxIdle(Integer.parseInt(pro.get("redis.maxIdle").toString()));//最大闲置个数
        poolConfig.setMinIdle(Integer.parseInt(pro.get("redis.minIdle").toString()));//最小闲置个数
        poolConfig.setMaxTotal(Integer.parseInt(pro.get("redis.maxTotal").toString()));//最大连接数
        pool = new JedisPool(poolConfig, pro.getProperty("redis.url"), Integer.parseInt(pro.get("redis.port").toString()));
    }

    //获得jedis资源的方法
    public static Jedis getJedis()
    {
        return pool.getResource();
    }

    //存值：
    public static void set(String key, String value)
    {
        getJedis().set(key, value);
    }

    //取值：
    public static void get(String key)
    {
        getJedis().get(key);
    }
}
