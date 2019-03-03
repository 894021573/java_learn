package cn.xmall.dao.impl;

import cn.xmall.bean.Category;
import cn.xmall.dao.CategoryDao;
import common.utils.DateUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoryDaoImpl extends BaseDaoImpl<Category> implements CategoryDao
{
    public Category getCategoryById(int id)
    {
        return this.findOne("id = ?", id);
    }

    @Override
    public List<Category> listCategoryByIds(Integer[] params)
    {
        return this.findAll("id IN (" + this.handlerIn(params.length) + ")", params);
    }

    @Override
    public List<Category> listCategory()
    {
        return this.findAll();
    }

    @Override
    public int addCategory(Category category)
    {
        Map<String, Object> map = new HashMap<>();
        map.put("name", category.getName());
        map.put("parent_id", category.getParentId());
        map.put("created_at", DateUtil.getSecondTimestamp());

        return this.add(map);
    }

    @Override
    public int deleteCategory(int id)
    {
        return this.delete("id = ?", id);
    }

    @Override
    public int updateCategory(Category category)
    {
        return this.update("name = ? , parent_id = ? , updated_at = ?", "id = ?", category.getName(), category.getParentId(), DateUtil.getSecondTimestamp(), category.getId());
    }
}
