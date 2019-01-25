package cn.javaweb.dao;

import cn.javaweb.bean.Goods;
import cn.javaweb.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface GoodsDao
{
    List<Goods> listGoods();

    List<Goods> listGoodsByShopId(int shop_id);

    List<Goods> listGoodsByCategoryId(int category_id);

    Goods getGoodsById(int goodsId);
}
