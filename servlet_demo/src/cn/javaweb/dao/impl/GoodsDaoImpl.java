package cn.javaweb.dao.impl;

import cn.javaweb.bean.Goods;
import cn.javaweb.dao.GoodsDao;
import cn.javaweb.utils.JDBCUtil;

import java.util.List;

public class GoodsDaoImpl implements GoodsDao
{
    @Override
    public List<Goods> listGoods()
    {
        String sql = "SELECT id,category_id,name,price,quantity,color,size FROM goods LIMIT 10";
        List<Goods> goods = (List<Goods>) (new JDBCUtil()).queryList(sql, Goods.class);

        return goods;
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
        String sql = "SELECT id,name,price,quantity,color,size FROM goods WHERE id = ?";
        Goods goods = (new JDBCUtil()).queryOne(sql, Goods.class, goodsId);

        return goods;
    }
}
