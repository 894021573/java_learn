package cn.xmall.bean;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class OrderGoods
{
    @Expose
    private int id;
    @Expose
    private int userId;
    @Expose
    private int OrderId;
    @Expose
    private int goodsId;
    @Expose
    private int shopId;
    @Expose
    private BigDecimal price;
    @Expose
    private int buyNumber;
    private String attributeJson;

    private int createdAt;
    private int updatedAt;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getUserId()
    {
        return userId;
    }

    public void setUserId(int userId)
    {
        this.userId = userId;
    }

    public int getOrderId()
    {
        return OrderId;
    }

    public void setOrderId(int orderId)
    {
        OrderId = orderId;
    }

    public int getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(int goodsId)
    {
        this.goodsId = goodsId;
    }

    public int getShopId()
    {
        return shopId;
    }

    public void setShopId(int shopId)
    {
        this.shopId = shopId;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }

    public int getBuyNumber()
    {
        return buyNumber;
    }

    public void setBuyNumber(int buyNumber)
    {
        this.buyNumber = buyNumber;
    }

    public String getAttributeJson()
    {
        return attributeJson;
    }

    public void setAttributeJson(String attributeJson)
    {
        this.attributeJson = attributeJson;
    }

    public int getCreatedAt()
    {
        return createdAt;
    }

    public void setCreatedAt(int createdAt)
    {
        this.createdAt = createdAt;
    }

    public int getUpdatedAt()
    {
        return updatedAt;
    }

    public void setUpdatedAt(int updatedAt)
    {
        this.updatedAt = updatedAt;
    }
}
