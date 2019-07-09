package com.ht.blog.dao;

import com.ht.blog.entity.HCategory;
import java.util.List;

public interface HCategoryMapper {
    int insert(HCategory record);

    List<HCategory> selectAll();
}