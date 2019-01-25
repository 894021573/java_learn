package cn.javaweb.service.impl;

import cn.javaweb.bean.Category;
import cn.javaweb.bean.Goods;
import cn.javaweb.dao.impl.CategoryDaoImpl;
import cn.javaweb.dao.impl.GoodsDaoImpl;
import cn.javaweb.service.GoodsService;
import cn.javaweb.service.bean.Cart;
import cn.javaweb.service.bean.CartItem;
import cn.javaweb.utils.JedisPoolUtil;
import cn.javaweb.utils.ReturnMapUtil;
import cn.javaweb.utils.SerializeUtil;
import redis.clients.jedis.Jedis;
import java.util.*;

public class GoodsServiceImpl implements GoodsService
{
    /**
     * 商品列表
     * @param userId
     * @param token
     * @return
     */
    @Override
    public Map<String, Object> listGoods(int userId, String token)
    {
        List<Goods> goods = (new GoodsDaoImpl()).listGoods();
        Integer[] params = new Integer[goods.size()];
        for (int i = 0; i < goods.size(); i++) {
            params[i] = goods.get(i).getCategoryId();
        }

        List<Category> categories = (new CategoryDaoImpl()).listCategory(params);

        for (int i = 0; i < goods.size(); i++) {
            for (int j = 0; j < categories.size(); j++) {
                if (goods.get(i).getCategoryId() == categories.get(j).getId()) {
                    goods.get(i).getCategory().setId(categories.get(j).getId());
                    goods.get(i).getCategory().setName(categories.get(j).getName());
                }
            }
        }

        // 输出结果
//        List<Map<String, Object>> list = new ArrayList<>();
//
//        for (int i = 0; i < goods.size(); i++) {
//            Map<String, Object> map = new LinkedHashMap<>();
//            map.put("id", goods.get(i).getId());
//            map.put("name", goods.get(i).getName());
//            map.put("price", goods.get(i).getPrice());
//            map.put("quantity", goods.get(i).getQuantity());
//            map.put("color", goods.get(i).getColor());
//            map.put("size", goods.get(i).getSize());
//
//            Map<String, Object> map2 = new LinkedHashMap<>();
//            map2.put("id", goods.get(i).getCategory().getId());
//            map2.put("name", goods.get(i).getCategory().getName());
//            map.put("category", map2);
//
//            list.add(map);
//        }

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("list_goods", goods);

        return ReturnMapUtil.setSuccessResult(resultMap);
    }

    /**
     * 添加到购物车
     * @param userId
     * @param goodsId
     * @return
     */
    @Override
    public Map<String, Object> addToCat(int userId, int goodsId)
    {
        // TODO 数据校验
        Goods goods = (new GoodsDaoImpl()).getGoodsById(goodsId);

        CartItem cartItem = new CartItem();
        if(goods != null){
            cartItem.setGoodsId(goodsId);
            cartItem.setGoodsName(goods.getName());
            cartItem.setPrice(goods.getPrice());
            cartItem.setQuantity(goods.getQuantity());
            cartItem.setColor(goods.getColor());
            cartItem.setSize(goods.getSize());

            Jedis jedis = JedisPoolUtil.getJedis();
            byte[] bytes = jedis.get(String.valueOf(userId).getBytes());
            Cart cart = new Cart();
            cart.setUserId(userId);

            if (bytes != null) {
                cart = (Cart) SerializeUtil.deserialize(bytes);
            }

            cart.saveItem(cartItem);
            jedis.set(String.valueOf(cart.getUserId()).getBytes(), SerializeUtil.serialize(cart));

            return ReturnMapUtil.setSuccessResult();
        }else{
            return ReturnMapUtil.setFailResult("无效的商品");
        }
    }

    /**
     * 获取购物车
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> listCartItems(int userId)
    {
        Jedis jedis = JedisPoolUtil.getJedis();
        Cart cart;

        byte[] bytes = jedis.get(String.valueOf(userId).getBytes());
        if (bytes == null) {
            cart = new Cart();
            cart.setUserId(userId);
        } else {
            cart = (Cart) SerializeUtil.deserialize(jedis.get(String.valueOf(userId).getBytes()));
        }

        Map<String, Object> result = new HashMap<>();
        result.put("cart", cart);

        return ReturnMapUtil.setSuccessResult(result);
    }
}
