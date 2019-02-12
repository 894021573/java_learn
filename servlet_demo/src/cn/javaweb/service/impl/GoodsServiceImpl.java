package cn.javaweb.service.impl;

import cn.javaweb.bean.*;
import cn.javaweb.dao.OrderDao;
import cn.javaweb.dao.OrderGoodsDao;
import cn.javaweb.dao.impl.*;
import cn.javaweb.service.GoodsService;
import cn.javaweb.service.RedisKeyService;
import cn.javaweb.service.bean.Cart;
import cn.javaweb.service.bean.CartItem;
import cn.javaweb.utils.*;
import redis.clients.jedis.Jedis;

import java.math.BigInteger;
import java.util.*;

public class GoodsServiceImpl implements GoodsService
{
    @Override
    public Map<String, Object> listGoods()
    {
        List<Goods> listGoods = (new GoodsDaoImpl()).listGoods();
        Integer[] params = new Integer[listGoods.size()];
        for (int i = 0; i < listGoods.size(); i++) {
            params[i] = listGoods.get(i).getCategoryId();
        }

        List<Category> categories = (new CategoryDaoImpl()).listCategory(params);

        for (int i = 0; i < listGoods.size(); i++) {
            for (int j = 0; j < categories.size(); j++) {
                if (listGoods.get(i).getCategoryId() == categories.get(j).getId()) {
                    listGoods.get(i).setCategory(categories.get(j));
                }
            }
        }

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("list_goods", listGoods);
        return ReturnMapUtil.setSuccessResult(resultMap);
    }

    @Override
    public Map<String, Object> addToCat(int userId, int goodsId)
    {
        Goods goods = (Goods) (new CommonServiceImpl()).getGoodsDetail(goodsId);

        if (goods != null) { // 商品存在
            CartItem cartItem = new CartItem();
            cartItem.setGoodsId(goodsId);
            cartItem.setShopId(goods.getShopId());
            cartItem.setGoodsName(goods.getName());
            cartItem.setPrice(goods.getPrice());
            cartItem.setQuantity(goods.getQuantity());
            cartItem.setGoodsAttributes(goods.getGoodsAttributes());

            Jedis jedis = JedisPoolUtil.getJedis();
            String key = RedisKeyService.getCartOfUserId(userId);

            byte[] bytes = jedis.get(key.getBytes());
            Cart cart = new Cart();
            cart.setUserId(userId);

            if (bytes != null) {
                cart = (Cart) SerializeUtil.deserialize(bytes);
            }

            cart.saveItem(cartItem);
            byte[] bb = SerializeUtil.serialize(cart);
            jedis.set(key.getBytes(), bb);
            return ReturnMapUtil.setSuccessResult();
        } else {
            return ReturnMapUtil.setFailResult("无效的商品");
        }
    }

    @Override
    public Map<String, Object> listCartItems(int userId)
    {
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

        Map<String, Object> result = new HashMap<>();
        result.put("get_cart", cart);
        return ReturnMapUtil.setSuccessResult(result);
    }

    @Override
    public Map<String, Object> getGoodsDetail(int goodsId)
    {
        Goods goods = (Goods) (new CommonServiceImpl()).getGoodsDetail(goodsId);

        if (goods != null) {
            Map<String, Object> result = new HashMap<>();
            result.put("get_goods", goods);
            return ReturnMapUtil.setSuccessResult(result);
        } else {
            return ReturnMapUtil.setFailResult("商品不存在");
        }
    }

    @Override
    public Map<String, Object> placeOrder(int userId, List<CartItem> cartItems)
    {
        Order order = new Order();
        order.setUserId(userId);
        order.setOrderNumber(RandomUtil.getOrderNumber());

        OrderDao orderDao = new OrderDaoImpl();
        int orderId = orderDao.createOrder(order);

        if (orderId > 0) {
            for (CartItem cartItem : cartItems) {
                OrderGoods orderGoods = new OrderGoods();

                orderGoods.setUserId(userId);
                orderGoods.setOrderId(orderId);
                orderGoods.setGoodsId(cartItem.getGoodsId());
                orderGoods.setPrice(cartItem.getPrice());
                orderGoods.setBuyNumber(cartItem.getBuyNumber());

                Goods goods = (Goods) (new CommonServiceImpl()).getGoodsDetail(cartItem.getGoodsId());
                orderGoods.setAttributeJson(JsonUtil.toJson(goods.getGoodsAttributes()));

                OrderGoodsDao orderGoodsDao = new OrderGoodsDaoImpl();
                orderGoodsDao.createOrderGoods(orderGoods);
            }
        }

        return ReturnMapUtil.setSuccessResult();
    }


}
