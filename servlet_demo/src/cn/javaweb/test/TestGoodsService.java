package cn.javaweb.test;

import cn.javaweb.service.GoodsService;
import cn.javaweb.service.bean.CartItem;
import cn.javaweb.service.impl.GoodsServiceImpl;
import cn.javaweb.utils.JsonUtil;

import org.junit.Test;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class TestGoodsService
{
    private GoodsService goodsService = new GoodsServiceImpl();

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
        List<CartItem> cartItems = null;
        Map<String, Object> map = goodsService.placeOrder(cartItems);
    }
}
