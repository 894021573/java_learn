package cn.javaweb.service;

import cn.javaweb.service.bean.Cart;
import cn.javaweb.service.bean.CartItem;

import java.util.Map;

public interface GoodsService
{
    /**
     * 商品列表
     * @param userId
     * @param token
     * @return
     */
    Map<String, Object> listGoods(int userId, String token);

    /**
     * 添加到购物车
     * @param userId
     * @param goodsId
     * @return
     */
    Map<String, Object> addToCat(int userId, int goodsId);

    /**
     * 获取购物车
     * @param userId
     * @return
     */
    Map<String, Object> listCartItems(int userId);
}
