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
        String sql = "SELECT id,category_id,name,price,quantity FROM goods LIMIT 10";
        List<Goods> listGoods = (List<Goods>) JDBCUtil.queryList(sql, Goods.class);

        return listGoods;
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
        String sql = "SELECT id,shop_id,name,price,quantity FROM goods WHERE id = ?";
        Goods goods = JDBCUtil.queryOne(sql, Goods.class, goodsId);

        return goods;
    }
}
