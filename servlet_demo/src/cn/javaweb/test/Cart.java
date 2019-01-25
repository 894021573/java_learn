package cn.javaweb.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Serializable
{
    private String name;
    private List<CartItem> cartItems = new ArrayList<>();
    private CartItem cartItem = new CartItem();

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setCartItem(CartItem cartItem)
    {
        cartItems.add(cartItem);
    }

    public void showItem()
    {
        for (CartItem cartItem : cartItems) {
            System.out.println(cartItem.getName());
        }
    }
}
