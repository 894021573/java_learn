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
        List<GoodsAttribute> goodsAttributeList = (List<GoodsAttribute>) JDBCUtil.queryList(sql, GoodsAttribute.class, goodsId);

        Integer[] goodsAttributeNameIds = new Integer[goodsAttributeList.size()];
        for (int i = 0; i < goodsAttributeList.size(); i++) {
            goodsAttributeNameIds[i] = goodsAttributeList.get(i).getAttributeNameId();
        }

        GoodsAttributeNameDaoImpl goodsAttributeNameDao = new GoodsAttributeNameDaoImpl();
        List<GoodsAttributeName> goodsAttributeNameList = goodsAttributeNameDao.listGoodsAttributeName(goodsAttributeNameIds);

        for (int i = 0; i < goodsAttributeList.size(); i++) {
            for (int j = 0; j < goodsAttributeNameList.size(); j++) {
                if (goodsAttributeList.get(i).getAttributeNameId() == goodsAttributeNameList.get(j).getId()) {
                    goodsAttributeList.get(i).setGoodsAttributeName(goodsAttributeNameList.get(j));
                }
            }
        }

        return goodsAttributeList;
    }
}
