package cn.javaweb.dao;

import cn.javaweb.bean.Order;

import java.math.BigInteger;
import java.util.List;

public interface OrderDao
{
    int createOrder(Order order);

    Order getOrderByOrderNumber(BigInteger orderNumber);

    List<Order> listOrderByUserId(int userId);
}
