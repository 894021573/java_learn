package cn.javaweb.dao.impl;

import cn.javaweb.bean.Category;
import cn.javaweb.dao.CategoryDao;
import cn.javaweb.utils.JDBCUtil;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao
{
    @Override
    public List<Category> listCategory(Integer[] params)
    {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < params.length; i++) {
            stringBuilder.append("? ,");
        }

        String ss = stringBuilder.substring(0, stringBuilder.length() - 1);
        String sql = "SELECT id,name FROM category WHERE id IN (" + ss + ")";
        List<Category> categories = (List<Category>) (new JDBCUtil()).queryList(sql, params, Category.class);
        return categories;
    }
}
