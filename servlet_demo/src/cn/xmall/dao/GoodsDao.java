package cn.xmall.dao;

import cn.xmall.bean.Goods;

import java.util.List;

public interface GoodsDao
{
    List<Goods> listGoods();

    List<Goods> listGoodsByShopId(int shopId);

    List<Goods> listGoodsByCategoryId(int categoryId);

    Goods getGoodsById(int goodsId);
}
