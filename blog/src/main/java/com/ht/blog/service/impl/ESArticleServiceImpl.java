package com.ht.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ht.blog.common.help.result.ArticleCodeMsg;
import com.ht.blog.common.help.result.CategoryCodeMsg;
import com.ht.blog.dao.HArticleMapper;
import com.ht.blog.dao.HCategoryMapper;
import com.ht.blog.dao.HUserMapper;
import com.ht.blog.entity.ESHArticle;
import com.ht.blog.entity.HArticle;
import com.ht.blog.entity.HCategory;
import com.ht.blog.repository.ESArticleVoRepository;
import com.ht.blog.repository.ESHArticleRepository;
import com.ht.blog.service.ArticleService;
import com.ht.blog.service.ESArticleService;
import com.ht.blog.vo.listArticle.*;
import common.util.DateUtil;
import common.util.result.Response;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ESArticleServiceImpl implements ESArticleService
{
    @Autowired
    private HArticleMapper hArticleMapper;

    @Autowired
    private ESArticleVoRepository esArticleVoRepository;

    // 文章列表
    @Override
    public List<ESArticleVo> listArticleToES()
    {
        int startTime = DateUtil.getSecondTimestamp(null) - 10;
        int endTime = DateUtil.getSecondTimestamp(null);

        List<HArticle> articles = hArticleMapper.selectAllForTask(startTime, endTime);

        List<ESArticleVo> esArticleVos = new ArrayList<>();
        for (int i = 0; i < articles.size(); i++) {
            ESArticleVo esArticleVo = new ESArticleVo();
            esArticleVo.setUserVo(new UserVo());
            esArticleVo.setCategoryVo(new CategoryVo());
            BeanUtils.copyProperties(articles.get(i), esArticleVo);
            BeanUtils.copyProperties(articles.get(i).gethUser(), esArticleVo.getUserVo());
            BeanUtils.copyProperties(articles.get(i).gethCategory(), esArticleVo.getCategoryVo());
            esArticleVos.add(esArticleVo);

            esArticleVoRepository.save(esArticleVo);
        }

        return esArticleVos;
    }

    @Override
    public Response<Map<String, Object>> searchArticleFromES(String title, Integer currentPage, Integer pageSize)
    {
        currentPage = currentPage - 1;
        QueryBuilder queryBuilder = QueryBuilders.wildcardQuery("title.keyword", "*" + title + "*");
        QueryBuilder queryBuilder2 = QueryBuilders.wildcardQuery("content.keyword", "*" + title + "*");
        //按照顺序构建builder,bool->must->wildcard ,有了上文的JSON,顺序就很好理解了
        BoolQueryBuilder must = QueryBuilders.boolQuery().should(queryBuilder).should(queryBuilder2);
        //封装pageable分页
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<ESArticleVo> queryResult = esArticleVoRepository.search(must, pageable);

        ESListArticleVo esListArticleVo = new ESListArticleVo();
        esListArticleVo.setList(queryResult.getContent());
        esListArticleVo.setPageNum(currentPage + 1);
        esListArticleVo.setPageSize(pageSize);
        esListArticleVo.setTotal(queryResult.getTotalElements());

        Map<String, Object> param = new HashMap<>();
        param.put("article", esListArticleVo);

        //返回
        return Response.success(param);
    }

    @Override
    public Response<Map<String, Object>> deleteArticleIndex()
    {
        esArticleVoRepository.deleteAll();

        Map<String, Object> param = new HashMap<>();
        return Response.success(param);
    }
}
