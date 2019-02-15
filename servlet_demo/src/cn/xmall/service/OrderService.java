package cn.xmall.service;

import cn.xmall.service.bean.CartItem;

import java.util.List;
import java.util.Map;

public interface OrderService
{
    Map<String, Object> placeOrder(int userId, List<CartItem> cartItems);

    Map<String, Object> getOrder(int orderId);

    Map<String, Object> pay(int orderId);

    Map<String, Object> cancele(int orderId);

    Map<String, Object> delete(int orderId);
}
