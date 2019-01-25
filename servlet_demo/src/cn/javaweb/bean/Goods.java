package cn.javaweb.bean;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class Goods
{
    @Expose
    private int id;
    @Expose
    private int shopId;
    @Expose
    private int categoryId;
    @Expose
    private String name;
    @Expose
    private BigDecimal price;
    @Expose
    private int quantity;
    @Expose
    private String color;
    @Expose
    private String size;

    private int createdAt;
    private int updatedAt;

    private Category category = new Category();

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getShopId()
    {
        return shopId;
    }

    public void setShopId(int shopId)
    {
        this.shopId = shopId;
    }

    public int getCategoryId()
    {
        return categoryId;
    }

    public void setCategoryId(int categoryId)
    {
        this.categoryId = categoryId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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

    public Category getCategory()
    {
        return category;
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
