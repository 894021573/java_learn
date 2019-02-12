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
    private List<CartItem> listCartItem = new ArrayList<>();

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
        return listCartItem;
    }

    public void saveItem(CartItem cartItem)
    {
        int findIndex = 0;
        CartItem findCartItem = null;
        for (int i = 0; i < listCartItem.size(); i++) {
            if (listCartItem.get(i).getGoodsId() == cartItem.getGoodsId()) {
                findIndex = i;
                findCartItem = listCartItem.get(i);
                break;
            }
        }

        if (findCartItem == null) {
            cartItem.setBuyNumber(1);
            listCartItem.add(cartItem);
        } else {
            cartItem.setBuyNumber(findCartItem.getBuyNumber() + 1);
            listCartItem.set(findIndex, cartItem);
        }
    }

    public void removeItem(int goodsId)
    {
        listCartItem.remove(goodsId);
    }

    public void clear()
    {
        listCartItem.clear();
    }
}
