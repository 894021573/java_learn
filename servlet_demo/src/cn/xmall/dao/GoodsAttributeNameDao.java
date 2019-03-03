package cn.xmall.dao;

import cn.xmall.bean.GoodsAttributeName;

import java.util.List;

public interface GoodsAttributeNameDao
{
    List<GoodsAttributeName> listGoodsAttributeName(Integer[] goodsAttributeNameIds);
}
