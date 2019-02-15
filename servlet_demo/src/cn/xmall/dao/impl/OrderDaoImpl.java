package cn.xmall.dao.impl;

import cn.xmall.bean.Order;
import cn.xmall.dao.OrderDao;
import common.utils.DateUtil;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderDaoImpl extends BaseDaoImpl<Order> implements OrderDao
{

    @Override
    public int createOrder(Order order)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("user_id", order.getUserId());
        map.put("order_number", order.getOrderNumber());
        map.put("status", order.getStatus());
        map.put("created_at", DateUtil.getSecondTimestamp());

        return this.add(map);
    }

    @Override
    public Order getOrderById(int orderId)
    {
        return this.findOne("id = ?", orderId);
    }

    @Override
    public List<Order> listOrderByUserId(int userId)
    {
        return null;
    }
}
