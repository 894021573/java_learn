package cn.xmall.dao;

import cn.xmall.bean.Category;

import java.util.List;

public interface CategoryDao
{
    Category getCategoryById(int id);

    List<Category> listCategoryByIds(Integer[] param);

    List<Category> listCategory();

    int addCategory(Category category);

    int deleteCategory(int id);

    int updateCategory(Category category);
}
