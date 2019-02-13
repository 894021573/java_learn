package cn.javaweb.dao.impl;

import cn.javaweb.bean.Order;
import cn.javaweb.dao.OrderDao;
import cn.javaweb.utils.DateUtil;

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
        map.put("created_at", DateUtil.getSecondTimestamp());

        return this.save(map);
    }

    @Override
    public Order getOrderByOrderNumber(BigInteger orderNumber)
    {
        return null;
    }

    @Override
    public List<Order> listOrderByUserId(int userId)
    {
        return null;
    }
}
