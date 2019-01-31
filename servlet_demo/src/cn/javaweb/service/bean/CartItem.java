package cn.javaweb.service.bean;

import cn.javaweb.bean.GoodsAttribute;
import com.google.gson.annotations.Expose;

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
    private int buyNum;
    @Expose
    private List<GoodsAttribute> listGoodsAttribute = null;

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

    public int getBuyNum()
    {
        return buyNum;
    }

    public void setBuyNum(int buyNum)
    {
        this.buyNum = buyNum;
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
