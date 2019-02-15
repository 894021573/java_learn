package cn.xmall.test;

import cn.xmall.bean.Category;
import cn.xmall.service.CategoryService;
import cn.xmall.service.impl.CategoryServiceImpl;
import common.utils.JsonUtil;
import org.junit.Test;

import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class CategoryServiceTest
{
    private CategoryService categoryService = new CategoryServiceImpl();
    private Category category = new Category();

    @Test
    public void listCategory()
    {
        Map<String, Object> map =  categoryService.listCategory();
        System.out.println(JsonUtil.toJson(map));
    }

    @Test
    public void addCategory()
    {
        category.setName("hello");
        category.setParentId(1);
        Map<String,Object> map = categoryService.addCategory(category);
        assertEquals(map.get("code"),0);
    }

    @Test
    public void addCategoryButParentIdNotExist()
    {
        category.setName("hello");
        category.setParentId(999);
        Map<String,Object> map = categoryService.addCategory(category);
        assertEquals(map.get("message"),"父类不存在");
    }

    @Test
    public void deleteCategory()
    {
        categoryService.deleteCategory(7);
    }

    @Test
    public void updateCategory()
    {
        category.setId(5);
        category.setName("hello");
        category.setParentId(3);
        categoryService.updateCategory(category);
    }
}
