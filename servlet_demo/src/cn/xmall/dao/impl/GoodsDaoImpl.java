package cn.xmall.dao.impl;

import cn.xmall.bean.Goods;
import cn.xmall.dao.GoodsDao;

import java.util.List;

public class GoodsDaoImpl extends BaseDaoImpl<Goods> implements GoodsDao
{
    @Override
    public List<Goods> listGoods()
    {
        return this.findAll("LIMIT 10");
    }

    @Override
    public List<Goods> listGoodsByShopId(int shopId)
    {
        return null;
    }

    @Override
    public List<Goods> listGoodsByCategoryId(int categoryId)
    {
        return null;
    }

    @Override
    public Goods getGoodsById(int goodsId)
    {
        return this.findOne("id = ?", goodsId);
    }
}
