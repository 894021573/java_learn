package cn.xmall.service.impl;

import cn.xmall.bean.Goods;
import cn.xmall.bean.Order;
import cn.xmall.bean.OrderGoods;
import cn.xmall.dao.OrderDao;
import cn.xmall.dao.OrderGoodsDao;
import cn.xmall.dao.impl.OrderDaoImpl;
import cn.xmall.dao.impl.OrderGoodsDaoImpl;
import cn.xmall.service.OrderService;
import cn.xmall.service.bean.CartItem;
import common.enumx.OrderStatus;
import common.utils.JsonUtil;
import common.utils.RandomUtil;
import common.utils.ReturnMapUtil;

import java.util.List;
import java.util.Map;

public class OrderServiceImpl implements OrderService
{

    @Override
    public Map<String, Object> placeOrder(int userId, List<CartItem> cartItems)
    {
        cn.xmall.bean.Order order = new cn.xmall.bean.Order();
        order.setUserId(userId);
        order.setOrderNumber(RandomUtil.getOrderNumber());
        order.setStatus(OrderStatus.WAIT_PAY.getValue());

        OrderDao orderDao = new OrderDaoImpl();
        int orderId = orderDao.createOrder(order);

        if (orderId > 0) {
            for (CartItem cartItem : cartItems) {
                OrderGoods orderGoods = new OrderGoods();

                orderGoods.setUserId(userId);
                orderGoods.setOrderId(orderId);
                orderGoods.setGoodsId(cartItem.getGoodsId());
                orderGoods.setPrice(cartItem.getPrice());
                orderGoods.setBuyNumber(cartItem.getBuyNumber());

                Goods goods = (Goods) (new CommonServiceImpl()).getGoodsDetail(cartItem.getGoodsId());
                orderGoods.setAttributeJson(JsonUtil.toJson(goods.getGoodsAttributes()));

                OrderGoodsDao orderGoodsDao = new OrderGoodsDaoImpl();
                orderGoodsDao.createOrderGoods(orderGoods);
            }
        }

        return ReturnMapUtil.setSuccessResult();
    }

    @Override
    public Map<String, Object> getOrder(int orderId)
    {
        Order order = new OrderDaoImpl().getOrderById(orderId);
        List<OrderGoods> orderGoods = new OrderGoodsDaoImpl().listOrderGoodsByOrderId(orderId);
        order.setOrderGoods(orderGoods);

        return null;
    }

    @Override
    public Map<String, Object> pay(int orderId)
    {
        return null;
    }

    @Override
    public Map<String, Object> cancele(int orderId)
    {
        return null;
    }

    @Override
    public Map<String, Object> delete(int orderId)
    {
        return null;
    }
}
