package cn.javaweb.dao.impl;

import cn.javaweb.bean.Category;
import cn.javaweb.dao.CategoryDao;

import java.util.List;

public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao
{
    @Override
    public List<Category> listCategory(Integer[] params)
    {
        return this.findAll("id IN (" + this.handlerIn(params.length) + ")", params);
    }
}
