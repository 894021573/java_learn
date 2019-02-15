package cn.xmall.test;

import cn.xmall.service.GoodsService;
import cn.xmall.service.RedisKeyService;
import cn.xmall.service.bean.Cart;
import cn.xmall.service.bean.CartItem;
import cn.xmall.service.impl.GoodsServiceImpl;
import cn.xmall.service.impl.OrderServiceImpl;
import common.utils.JedisPoolUtil;
import common.utils.JsonUtil;

import common.utils.SerializeUtil;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class GoodsServiceTest
{
    private cn.xmall.service.GoodsService goodsService = new GoodsServiceImpl();

    @Test
    public void listGoods()
    {
        Map<String, Object> map = goodsService.listGoods();
        System.out.println(JsonUtil.toJson(map));
        assertEquals((int) map.get("code"), 0);
    }

    @Test
    public void addToCart()
    {
        Map<String, Object> map = goodsService.addToCat(6, 1);
        Map<String, Object> map2 = goodsService.addToCat(6, 2);
        assertEquals((int) map.get("code"), 0);
    }

    @Test
    public void listCartItems()
    {
        Map<String, Object> map = goodsService.listCartItems(6);
        System.out.println(JsonUtil.toJson(map));
        assertEquals((int) map.get("code"), 0);
    }

    @Test
    public void getGoodsDetail()
    {
        Map<String, Object> map = goodsService.getGoodsDetail(1);
        System.out.println(JsonUtil.toJson(map));
        assertEquals((int) map.get("code"), 0);
    }

    @Test
    public void placeOrder()
    {
        int userId = 6;

        Jedis jedis = JedisPoolUtil.getJedis();
        Cart cart;

        String key = RedisKeyService.getCartOfUserId(userId);
        byte[] bytes = jedis.get(key.getBytes());
        if (bytes == null) {
            cart = new Cart();
            cart.setUserId(userId);
        } else {
            cart = (Cart) SerializeUtil.deserialize(bytes);
        }

        List<CartItem> cartItems = cart.getCartItems();

        Map<String, Object> map = (new OrderServiceImpl()).placeOrder(userId, cartItems);
    }
}
