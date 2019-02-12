package cn.javaweb.bean;

import com.google.gson.annotations.Expose;

import java.math.BigInteger;
import java.util.List;

public class Order
{
    @Expose
    private int id;
    @Expose
    private int userId;
    @Expose
    private BigInteger orderNumber;
    @Expose
    private List<OrderGoods> orderGoods;

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

    public BigInteger getOrderNumber()
    {
        return orderNumber;
    }

    public void setOrderNumber(BigInteger orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public List<OrderGoods> getOrderGoods()
    {
        return orderGoods;
    }

    public void setListOrderGoods(List<OrderGoods> orderGoods)
    {
        this.orderGoods = orderGoods;
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
