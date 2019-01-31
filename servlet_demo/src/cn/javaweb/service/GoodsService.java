package cn.javaweb.service;

import cn.javaweb.service.bean.CartItem;

import java.util.List;
import java.util.Map;

public interface GoodsService
{
    /**
     * 商品列表
     *
     * @return
     */
    Map<String, Object> listGoods();

    /**
     * 添加到购物车
     *
     * @param userId
     * @param goodsId
     * @return
     */
    Map<String, Object> addToCat(int userId, int goodsId);

    /**
     * 获取购物车
     *
     * @param userId
     * @return
     */
    Map<String, Object> listCartItems(int userId);

    /**
     * 获取商品详情
     *
     * @param goodsId
     * @return
     */
    Map<String, Object> getGoodsDetail(int goodsId);

    /**
     * 下单
     *
     * @param cartItems
     * @return
     */
    Map<String, Object> placeOrder(List<CartItem> cartItems);
}
