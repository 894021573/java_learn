package com.ht.blog.dao;

import com.ht.blog.entity.HCategory;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface HCategoryMapper {
    int insert(HCategory record);

    int update(HCategory hCategory);

    List<HCategory> selectAll(int userId);

    int incNum(int id);

    HCategory selectCategory(int userId, String name);

    HCategory selectById(int id);

    int deleteCategory(int id);


}