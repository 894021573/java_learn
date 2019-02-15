package cn.xmall.dao;

import cn.xmall.bean.Order;

import java.math.BigInteger;
import java.util.List;

public interface OrderDao
{
    int createOrder(Order order);

    Order getOrderById(int orderId);

    List<Order> listOrderByUserId(int userId);
}
