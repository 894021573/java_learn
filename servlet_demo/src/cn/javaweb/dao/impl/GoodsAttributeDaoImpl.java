package cn.javaweb.dao.impl;

import cn.javaweb.bean.GoodsAttribute;
import cn.javaweb.bean.GoodsAttributeName;
import cn.javaweb.dao.GoodsAttributeDao;
import cn.javaweb.utils.JDBCUtil;

import java.util.List;

public class GoodsAttributeDaoImpl implements GoodsAttributeDao
{
    @Override
    public List<GoodsAttribute> listGoodsAttribute(int goodsId)
    {
        String sql = "SELECT * FROM goods_attribute WHERE goods_id = ?";
        List<GoodsAttribute> goodsAttributes = (List<GoodsAttribute>) JDBCUtil.queryList(sql, GoodsAttribute.class, goodsId);

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
