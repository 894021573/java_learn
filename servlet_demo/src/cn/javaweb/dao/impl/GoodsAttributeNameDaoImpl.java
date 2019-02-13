package cn.javaweb.dao.impl;

import cn.javaweb.bean.GoodsAttributeName;
import cn.javaweb.dao.GoodsAttributeNameDao;

import java.util.List;

public class GoodsAttributeNameDaoImpl extends BaseDaoImpl<GoodsAttributeName> implements GoodsAttributeNameDao
{
    @Override
    public List<GoodsAttributeName> listGoodsAttributeName(Integer[] goodsAttributeNameIds)
    {
        return this.findAll("id IN (" + this.handlerIn(goodsAttributeNameIds.length) + ")", goodsAttributeNameIds);
    }
}
