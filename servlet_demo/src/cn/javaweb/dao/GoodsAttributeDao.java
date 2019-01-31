package cn.javaweb.dao;

import cn.javaweb.bean.Goods;
import cn.javaweb.bean.GoodsAttribute;

import java.util.List;

public interface GoodsAttributeDao
{
    List<GoodsAttribute> listGoodsAttribute(int goodsId);
}
