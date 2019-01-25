package cn.javaweb.service.bean;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable
{
    @Expose
    private int goodsId;
    @Expose
    private String goodsName;
    @Expose
    private BigDecimal price;
    @Expose
    private int quantity;
    @Expose
    private int buyNum;
    @Expose
    private String color;
    @Expose
    private String size;

    public int getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(int goodsId)
    {
        this.goodsId = goodsId;
    }

    public String getGoodsName()
    {
        return goodsName;
    }

    public void setGoodsName(String goodsName)
    {
        this.goodsName = goodsName;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getBuyNum()
    {
        return buyNum;
    }

    public void setBuyNum(int buyNum)
    {
        this.buyNum = buyNum;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getSize()
    {
        return size;
    }

    public void setSize(String size)
    {
        this.size = size;
    }
}
