package cn.xmall.dao;

import cn.xmall.bean.GoodsAttribute;

import java.util.List;

public interface GoodsAttributeDao
{
    List<GoodsAttribute> listGoodsAttribute(int goodsId);
}
