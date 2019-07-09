package com.ht.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.blog.common.help.result.ArticleCodeMsg;
import com.ht.blog.dao.HArticleMapper;
import com.ht.blog.dao.HCommentMapper;
import com.ht.blog.entity.HArticle;
import com.ht.blog.entity.HComment;
import com.ht.blog.service.CommentService;
import com.ht.blog.vo.listArticle.ArticleVo;
import com.ht.blog.vo.listArticle.CategoryVo;
import com.ht.blog.vo.listArticle.ListArticleVo;
import com.ht.blog.vo.listCommentVo.UserVo;
import com.ht.blog.vo.listCommentVo.CommentVo;
import com.ht.blog.vo.listCommentVo.ListCommentVo;
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
public class CommentServiceImpl implements CommentService
{
    private HCommentMapper hCommentMapper;

    @Autowired
    HArticleMapper hArticleMapper;

    @Autowired
    public void sethCommentMapper(HCommentMapper hCommentMapper)
    {
        this.hCommentMapper = hCommentMapper;
    }

    // 发布文章
    @Override
    public Response<Map<String, Object>> addComment(HComment hComment)
    {
        // conentId是否存在
        HArticle hArticle = hArticleMapper.selectById(hComment.getContentId());

        if (hArticle == null) {
            return Response.error(ArticleCodeMsg.ARTICLE_NOT_EXISTS);
        }

        hComment.setCreatedAt(DateUtil.getSecondTimestamp(null));
        hCommentMapper.insert(hComment);

        hArticleMapper.incCommentNum(hComment.getContentId());

        Map<String, Object> param = new HashMap<>();
        param.put("id", hComment.getId());
        return Response.success(param);
    }

    @Override
    public Response<Map<String, Object>> listComment(int articleId, int pageNum, int pageSize)
    {
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.clearPage();
        List<HComment> comments = hCommentMapper.selectAll(articleId, pageNum, pageSize);
        Integer totalCommentNum = hCommentMapper.count(articleId);
        PageInfo<HComment> pageInfo = new PageInfo<>(comments);
        pageInfo.setPageNum(pageNum);
        pageInfo.setPageSize(pageSize);
        pageInfo.setTotal(totalCommentNum);

        // 返回数据
        Map<String, Object> param = new HashMap<>();
        ListCommentVo listCommentVo = new ListCommentVo();
        BeanUtils.copyProperties(pageInfo, listCommentVo, "list");

        List<CommentVo> commentVos = new ArrayList<>();
        for (int i = 0; i < pageInfo.getList().size(); i++) {
            CommentVo commentVo = new CommentVo();
            commentVo.setUserVo(new UserVo());

            BeanUtils.copyProperties(pageInfo.getList().get(i), commentVo);
            BeanUtils.copyProperties(pageInfo.getList().get(i).gethUser(), commentVo.getUserVo());
            commentVos.add(commentVo);
        }

        listCommentVo.setList(commentVos);

        param.put("comment", listCommentVo);
        return Response.success(param);
    }
}
