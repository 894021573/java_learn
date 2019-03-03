package cn.xmall.service.impl;

import cn.xmall.bean.*;
import cn.xmall.dao.OrderDao;
import cn.xmall.dao.OrderGoodsDao;
import cn.xmall.dao.impl.*;
import cn.xmall.service.GoodsService;
import cn.xmall.service.RedisKeyService;
import cn.xmall.service.bean.Cart;
import cn.xmall.service.bean.CartItem;
import common.enumx.OrderStatus;
import redis.clients.jedis.Jedis;
import common.utils.*;

import java.util.*;

public class GoodsServiceImpl implements GoodsService
{
    @Override
    public Map<String, Object> listGoods()
    {
        List<Goods> goods = (new GoodsDaoImpl()).listGoods();
        Integer[] params = new Integer[goods.size()];
        for (int i = 0; i < goods.size(); i++) {
            params[i] = goods.get(i).getCategoryId();
        }

        List<Category> categories = (new CategoryDaoImpl()).listCategoryByIds(params);

        for (int i = 0; i < goods.size(); i++) {
            for (int j = 0; j < categories.size(); j++) {
                if (goods.get(i).getCategoryId() == categories.get(j).getId()) {
                    goods.get(i).setCategory(categories.get(j));
                }
            }
        }

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("list_goods", goods);
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
}
