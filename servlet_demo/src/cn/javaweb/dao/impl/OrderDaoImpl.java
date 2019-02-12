package cn.javaweb.dao.impl;

import cn.javaweb.bean.Order;
import cn.javaweb.bean.OrderGoods;
import cn.javaweb.dao.OrderDao;
import cn.javaweb.dao.OrderGoodsDao;
import cn.javaweb.utils.DateUtil;
import cn.javaweb.utils.JDBCUtil;

import java.math.BigInteger;
import java.util.List;

public class OrderDaoImpl implements OrderDao
{

    @Override
    public int createOrder(Order order)
    {
        String sql = "INSERT INTO `order` ( `user_id`, `order_number`, `created_at`) VALUES (?, ?, ?)";
        int orderId = JDBCUtil.updateReturnGenerateId(sql, order.getUserId(), order.getOrderNumber(), DateUtil.getSecondTimestamp());

        return orderId;
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
