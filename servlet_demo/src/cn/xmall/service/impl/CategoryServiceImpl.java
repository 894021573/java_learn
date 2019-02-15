package cn.xmall.service.impl;

import cn.xmall.bean.Category;
import cn.xmall.dao.CategoryDao;
import cn.xmall.dao.impl.CategoryDaoImpl;
import cn.xmall.service.CategoryService;
import common.utils.CategoryUtil;
import common.utils.ReturnMapUtil;

import java.util.*;

public class CategoryServiceImpl implements CategoryService
{
    @Override
    public Map<String, Object> listCategory()
    {
        CategoryDao categoryDao = new CategoryDaoImpl();
        List<Category> categories = categoryDao.listCategory();

        List<Map<String, Object>> maps = new ArrayList<>();

        for (Category category : categories) {
            Map<String, Object> map = new HashMap<>();
            map.put("id", category.getId());
            map.put("parent_id", category.getParentId());
            map.put("name", category.getName());
            maps.add(map);
        }

        CategoryUtil.recursionCategory(maps, 0, 1);
        List<Map<String, Object>> outCategories = CategoryUtil.getOutCategories();

        Map<String, Object> resultMap = new LinkedHashMap<>();
        resultMap.put("list_categories", outCategories);
        return ReturnMapUtil.setSuccessResult(resultMap);
    }

    @Override
    public Map<String, Object> addCategory(Category category)
    {
        CategoryDao categoryDao = new CategoryDaoImpl();

        if(categoryDao.getCategoryById(category.getParentId()) == null)
        {
            return ReturnMapUtil.setFailResult("父类不存在");
        }

        categoryDao.addCategory(category);
        return ReturnMapUtil.setSuccessResult();
    }

    @Override
    public Map<String, Object> deleteCategory(int id)
    {
        CategoryDao categoryDao = new CategoryDaoImpl();
        categoryDao.deleteCategory(id);
        return ReturnMapUtil.setSuccessResult();
    }

    @Override
    public Map<String, Object> updateCategory(Category category)
    {
        CategoryDao categoryDao = new CategoryDaoImpl();

        if(categoryDao.getCategoryById(category.getParentId()) == null)
        {
            return ReturnMapUtil.setFailResult("父类不存在");
        }

        categoryDao.updateCategory(category);
        return ReturnMapUtil.setSuccessResult();
    }
}
