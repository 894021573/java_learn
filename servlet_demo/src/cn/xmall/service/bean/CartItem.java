package cn.xmall.service.bean;

import cn.xmall.bean.GoodsAttribute;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CartItem implements Serializable
{
    @Expose
    private int goodsId;
    @Expose
    private int shopId;

    @Expose
    private String goodsName;
    @Expose
    private BigDecimal price;
    @Expose
    private int quantity;
    @Expose
    private int buyNumber;
    @Expose
    @SerializedName("list_goods_attribute")
    private List<GoodsAttribute> goodsAttributes = null;

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

    public int getBuyNumber()
    {
        return buyNumber;
    }

    public void setBuyNumber(int buyNum)
    {
        this.buyNumber = buyNum;
    }

    public List<GoodsAttribute> getGoodsAttributes()
    {
        return goodsAttributes;
    }

    public void setGoodsAttributes(List<GoodsAttribute> goodsAttributes)
    {
        this.goodsAttributes = goodsAttributes;
    }
}
