package com.ht.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.blog.common.help.result.ArticleCodeMsg;
import com.ht.blog.common.help.valid.message.HArticleMessage;
import com.ht.blog.dao.HArticleMapper;
import com.ht.blog.dao.HCategoryMapper;
import com.ht.blog.dao.HUserMapper;
import com.ht.blog.entity.HArticle;
import com.ht.blog.entity.HCategory;
import com.ht.blog.entity.HUser;
import com.ht.blog.service.ArticleService;
import com.ht.blog.vo.listArticle.ArticleVo;
import com.ht.blog.vo.listArticle.CategoryVo;
import com.ht.blog.vo.listArticle.ListArticleVo;
import com.ht.blog.vo.listArticle.UserVo;
import common.util.DateUtil;
import common.util.result.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService
{
    private HArticleMapper hArticleMapper;
    private HUserMapper hUserMapper;
    private HCategoryMapper hCategoryMapper;

    @Autowired
    public void sethArticleMapper(HArticleMapper hArticleMapper)
    {
        this.hArticleMapper = hArticleMapper;
    }

    @Autowired
    public void sethUserMapper(HUserMapper hUserMapper)
    {
        this.hUserMapper = hUserMapper;
    }

    @Autowired
    public void sethCategoryMapper(HCategoryMapper hCategoryMapper)
    {
        this.hCategoryMapper = hCategoryMapper;
    }

    // 文章列表
    @Override
    public Response<Map<String, Object>> listArticle(int pageNum, int pageSize, int userId)
    {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.clearPage(); // 手动清理 ThreadLocal 存储的分页参，否则之后的查询语句会自动添加limit
        List<HArticle> articles = hArticleMapper.selectAll(pageNum, pageSize, userId);
        Integer totalArticleNum = hArticleMapper.count(userId);
        PageInfo<HArticle> pageInfo = new PageInfo<>(articles);
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(totalArticleNum);

        // 返回数据
        Map<String, Object> param = new HashMap<>();
        ListArticleVo listArticleVo = new ListArticleVo();
        BeanUtils.copyProperties(pageInfo, listArticleVo, "list");

        List<ArticleVo> articleVos = new ArrayList<>();
        for (int i = 0; i < pageInfo.getList().size(); i++) {
            ArticleVo articleVo = new ArticleVo();
            articleVo.setUserVo(new UserVo());
            articleVo.setCategoryVo(new CategoryVo());
            BeanUtils.copyProperties(pageInfo.getList().get(i), articleVo);
            BeanUtils.copyProperties(pageInfo.getList().get(i).gethUser(), articleVo.getUserVo());
            BeanUtils.copyProperties(pageInfo.getList().get(i).gethCategory(), articleVo.getCategoryVo());
            articleVos.add(articleVo);
        }

        listArticleVo.setList(articleVos);

        param.put("article", listArticleVo);
        return Response.success(param);
    }

    // 发布文章
    @Override
    public Response<Map<String, Object>> addArticle(HArticle hArticle)
    {
        hArticle.setCreatedAt(DateUtil.getSecondTimestamp(null));
        hArticleMapper.insert(hArticle);

        Map<String, Object> param = new HashMap<>();
        param.put("id", hArticle.getId());
        return Response.success(param);
    }

    // 展示文章
    @Override
    public Response<Object> showArticle(int id)
    {
        HArticle hArticle = hArticleMapper.selectById(id);

        if (hArticle == null) {
            return Response.error(ArticleCodeMsg.ARTICLE_NOT_EXISTS);
        }

        return Response.success(hArticle);
    }

    // 分类
    @Override
    public Response<Object> listCategory()
    {
        List<HCategory> categories = hCategoryMapper.selectAll();

        return Response.success(categories);
    }
}
