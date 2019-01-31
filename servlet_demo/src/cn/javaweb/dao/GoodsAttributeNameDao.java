package cn.javaweb.dao;

import cn.javaweb.bean.GoodsAttributeName;

import java.util.List;

public interface GoodsAttributeNameDao
{
    List<GoodsAttributeName> listGoodsAttributeName(Integer[] goodsAttributeNameIds);
}
