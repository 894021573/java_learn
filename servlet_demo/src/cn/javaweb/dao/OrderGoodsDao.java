package cn.javaweb.dao;

import cn.javaweb.bean.Order;
import cn.javaweb.bean.OrderGoods;

import java.math.BigInteger;
import java.util.List;

public interface OrderGoodsDao
{
    int createOrderGoods(OrderGoods OrderGoods);

    List<OrderGoods> listOrderGoodsByOrderId(int orderId);
}
