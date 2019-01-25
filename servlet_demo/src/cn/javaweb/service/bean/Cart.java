package cn.javaweb.service.bean;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Cart implements Serializable
{
    @Expose
    private int userId;
    @Expose
    private List<CartItem> cartItems = new ArrayList<>();

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public List<CartItem> getCartItems()
    {
        return cartItems;
    }

    public void saveItem(CartItem cartItem)
    {
        int findIndex = 0;
        CartItem findCartItem = null;
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).getGoodsId() == cartItem.getGoodsId()) {
                findIndex = i;
                findCartItem = cartItems.get(i);
                break;
            }
        }

        if (findCartItem == null) {
            cartItem.setBuyNum(1);
            cartItems.add(cartItem);
        } else {
            cartItem.setBuyNum(findCartItem.getBuyNum() + 1);
            cartItems.set(findIndex, cartItem);
        }
    }

    public void removeItem(int goodsId)
    {
        cartItems.remove(goodsId);
    }

    public void clear()
    {
        cartItems.clear();
    }
}
