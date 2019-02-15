package cn.xmall.dao.impl;

import cn.xmall.bean.GoodsAttribute;
import cn.xmall.bean.GoodsAttributeName;
import cn.xmall.dao.GoodsAttributeDao;

import java.util.List;

public class GoodsAttributeDaoImpl extends BaseDaoImpl<GoodsAttribute> implements GoodsAttributeDao
{
    @Override
    public List<GoodsAttribute> listGoodsAttribute(int goodsId)
    {
        List<GoodsAttribute> goodsAttributes = this.findAll("goods_id = ?", goodsId);

        Integer[] goodsAttributeNameIds = new Integer[goodsAttributes.size()];
        for (int i = 0; i < goodsAttributes.size(); i++) {
            goodsAttributeNameIds[i] = goodsAttributes.get(i).getAttributeNameId();
        }

        GoodsAttributeNameDaoImpl goodsAttributeNameDao = new GoodsAttributeNameDaoImpl();
        List<GoodsAttributeName> goodsAttributeNames = goodsAttributeNameDao.listGoodsAttributeName(goodsAttributeNameIds);

        for (int i = 0; i < goodsAttributes.size(); i++) {
            for (int j = 0; j < goodsAttributeNames.size(); j++) {
                if (goodsAttributes.get(i).getAttributeNameId() == goodsAttributeNames.get(j).getId()) {
                    goodsAttributes.get(i).setGoodsAttributeName(goodsAttributeNames.get(j));
                }
            }
        }

        return goodsAttributes;
    }
}
