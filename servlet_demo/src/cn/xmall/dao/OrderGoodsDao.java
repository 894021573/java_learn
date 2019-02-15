package cn.xmall.dao;

import cn.xmall.bean.OrderGoods;

import java.util.List;

public interface OrderGoodsDao
{
    int createOrderGoods(OrderGoods OrderGoods);

    List<OrderGoods> listOrderGoodsByOrderId(int orderId);
}
