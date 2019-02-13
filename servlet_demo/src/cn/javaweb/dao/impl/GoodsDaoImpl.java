package cn.javaweb.dao.impl;

import cn.javaweb.bean.Goods;
import cn.javaweb.dao.GoodsDao;

import java.util.List;

public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements GoodsDao
{
    @Override
    public List<Goods> listGoods()
    {
        return this.findAll("LIMIT 10");
    }

    @Override
    public List<Goods> listGoodsByShopId(int shop_id)
    {
        return null;
    }

    @Override
    public List<Goods> listGoodsByCategoryId(int category_id)
    {
        return null;
    }

    @Override
    public Goods getGoodsById(int goodsId)
    {
        return this.findOne("id = ?", goodsId);
    }
}
