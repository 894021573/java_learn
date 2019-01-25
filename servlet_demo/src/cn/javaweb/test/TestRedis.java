package cn.javaweb.test;

import cn.javaweb.utils.JedisPoolUtil;
import cn.javaweb.utils.SerializeUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.io.IOException;

public class TestRedis
{
    @Test
    public void test01()
    {
        Jedis jedis = new Jedis("127.0.0.1");
        System.out.println("ok");
        Cart cart = new Cart();
        cart.setName("111");

        CartItem a = new CartItem();
        a.setName("第一个");

        CartItem aa = new CartItem();
        aa.setName("di2ge");

        cart.setCartItem(a);
        cart.setCartItem(aa);
        jedis.set("ha".getBytes(), SerializeUtil.serialize(cart));

        System.out.println("ha".getBytes());
    }

    @Test
    public void test02() throws IOException, ClassNotFoundException
    {
        Jedis jedis = new Jedis("127.0.0.1");
        Cart cart = (Cart) SerializeUtil.deserialize(jedis.get("ha".getBytes()));
        //System.out.println(cart.getName());
        cart.showItem();

        cn.javaweb.service.bean.Cart cart2 = (cn.javaweb.service.bean.Cart) SerializeUtil.deserialize(jedis.get("16".getBytes()));
        String ss = cart2.getCartItems().get(10).getColor();
        System.out.println(ss);
    }

    @Test
    public void test03()
    {
        Jedis jedis = JedisPoolUtil.getJedis();
        jedis.set("name", "ga");
        System.out.println(jedis.get("name"));
    }

    @Test
    public void test04()
    {
        Jedis jedis = JedisPoolUtil.getJedis();
        jedis.set("name", "好");
        System.out.println(jedis.get("name"));
    }
}
