package cn.javaweb.bean;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;
import java.util.List;

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

    private int createdAt;
    private int updatedAt;

    //===其他属性===//
    @Expose
    private Category category = new Category();
    @Expose
    private List<GoodsAttribute> listGoodsAttribute = null;

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

    public Category getCategory()
    {
        return category;
    }

    public void setCategory(Category category)
    {
        this.category = category;
    }

    public List<GoodsAttribute> getListGoodsAttribute()
    {
        return listGoodsAttribute;
    }

    public void setListGoodsAttribute(List<GoodsAttribute> listGoodsAttribute)
    {
        this.listGoodsAttribute = listGoodsAttribute;
    }
}
