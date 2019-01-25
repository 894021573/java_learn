package cn.javaweb.test;


import java.io.Serializable;

public class CartItem implements Serializable
{
    private String name;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
