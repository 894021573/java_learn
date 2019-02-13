package cn.javaweb.dao.impl;

import cn.javaweb.bean.OrderGoods;
import cn.javaweb.dao.OrderGoodsDao;
import cn.javaweb.utils.DateUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderGoodsDaoImpl extends BaseDaoImpl<OrderGoods> implements OrderGoodsDao
{
    @Override
    public int createOrderGoods(OrderGoods orderGoods)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", orderGoods.getUserId());
        map.put("order_id", orderGoods.getOrderId());
        map.put("goods_id", orderGoods.getGoodsId());
        map.put("price", orderGoods.getPrice());
        map.put("buy_number", orderGoods.getBuyNumber());
        map.put("attribute_json", orderGoods.getAttributeJson());
        map.put("created_at", DateUtil.getSecondTimestamp());

        return this.save(map);
    }

    @Override
    public List<OrderGoods> listOrderGoodsByOrderId(int orderId)
    {
        return null;
    }
}
