package cn.xmall.dao.impl;

import cn.xmall.bean.GoodsAttributeName;
import cn.xmall.dao.GoodsAttributeNameDao;

import java.util.List;

public class GoodsAttributeNameDaoImpl extends BaseDaoImpl<GoodsAttributeName> implements GoodsAttributeNameDao
{
    @Override
    public List<GoodsAttributeName> listGoodsAttributeName(Integer[] goodsAttributeNameIds)
    {
        return this.findAll("id IN (" + this.handlerIn(goodsAttributeNameIds.length) + ")", goodsAttributeNameIds);
    }
}
