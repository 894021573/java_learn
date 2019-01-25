package cn.javaweb.dao;

import cn.javaweb.bean.Category;
import cn.javaweb.bean.Goods;

import java.util.List;

public interface CategoryDao
{
    List<Category> listCategory(Integer[] param);
}
