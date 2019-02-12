package cn.javaweb.dao.impl;

import cn.javaweb.bean.OrderGoods;
import cn.javaweb.dao.OrderGoodsDao;
import cn.javaweb.utils.DateUtil;
import cn.javaweb.utils.JDBCUtil;

import java.util.List;

public class OrderGoodsDaoImpl implements OrderGoodsDao
{
    @Override
    public int createOrderGoods(OrderGoods orderGoods)
    {
        String sql1 = "INSERT INTO `order_goods` (`user_id`, `order_id`, `goods_id`, `price`, `buy_number`, `attribute_json`, `created_at`) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
        int affectNum = JDBCUtil.update(sql1, orderGoods.getUserId(),orderGoods.getOrderId(),orderGoods.getGoodsId(),orderGoods.getPrice(),orderGoods.getBuyNumber(),orderGoods.getAttributeJson(), DateUtil.getSecondTimestamp());

        return affectNum;
    }

    @Override
    public List<OrderGoods> listOrderGoodsByOrderId(int orderId)
    {
        return null;
    }
}
