package cn.xmall.bean;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class GoodsAttribute implements Serializable
{
    private int id;
    @Expose
    private int goodsId;

    @Expose
    private int attributeNameId;

    @Expose
    private String attributeValue;

    private int createdAt;
    private int updatedAt;

    @Expose
    private GoodsAttributeName goodsAttributeName;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getGoodsId()
    {
        return goodsId;
    }

    public void setGoodsId(int goodsId)
    {
        this.goodsId = goodsId;
    }

    public int getAttributeNameId()
    {
        return attributeNameId;
    }

    public void setAttributeNameId(int attributeNameId)
    {
        this.attributeNameId = attributeNameId;
    }

    public String getAttributeValue()
    {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue)
    {
        this.attributeValue = attributeValue;
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

    public GoodsAttributeName getGoodsAttributeName()
    {
        return goodsAttributeName;
    }

    public void setGoodsAttributeName(GoodsAttributeName goodsAttributeName)
    {
        this.goodsAttributeName = goodsAttributeName;
    }
}
