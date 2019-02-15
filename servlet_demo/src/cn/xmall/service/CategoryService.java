package cn.xmall.service;

import cn.xmall.bean.Category;

import java.util.Map;

public interface CategoryService
{
    Map<String, Object> listCategory();

    Map<String, Object> addCategory(Category category);

    Map<String, Object> deleteCategory(int id);

    Map<String, Object> updateCategory(Category category);
}
