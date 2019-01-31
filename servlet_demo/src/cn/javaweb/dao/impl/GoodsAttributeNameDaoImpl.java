package cn.javaweb.dao.impl;

import cn.javaweb.bean.Category;
import cn.javaweb.bean.GoodsAttribute;
import cn.javaweb.bean.GoodsAttributeName;
import cn.javaweb.dao.GoodsAttributeNameDao;
import cn.javaweb.utils.JDBCUtil;

import java.util.List;

public class GoodsAttributeNameDaoImpl implements GoodsAttributeNameDao
{
    @Override
    public List<GoodsAttributeName> listGoodsAttributeName(Integer[] goodsAttributeNameIds)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < goodsAttributeNameIds.length; i++) {
            stringBuilder.append("? ,");
        }

        String ss = stringBuilder.substring(0, stringBuilder.length() - 1);
        String sql = "SELECT * FROM goods_attribute_name WHERE id IN (" + ss + ")";
        List<GoodsAttributeName> goodsAttributeNameList = (List<GoodsAttributeName>) JDBCUtil.queryList(sql, goodsAttributeNameIds, GoodsAttributeName.class);

        return goodsAttributeNameList;
    }
}
