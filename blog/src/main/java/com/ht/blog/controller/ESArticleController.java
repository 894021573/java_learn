package com.ht.blog.controller;

import com.ht.blog.entity.ESHArticle;
import com.ht.blog.entity.HUser;
import com.ht.blog.repository.ESHArticleRepository;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.net.www.http.Hurryable;

import java.util.List;
import java.util.Random;

@RestController
public class ESArticleController
{
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private ESHArticleRepository articleRepository;

    // 创建索引
    @GetMapping("save")
    public Object save(@RequestParam(defaultValue = "myTitle") String title)
    {
        ESHArticle article = new ESHArticle();
        article.setId((new Random()).nextInt(1000));
        article.setTitle(title);
        article.setContent("myContent");
        HUser hUser = new HUser();
        hUser.setNickname("haha");
        hUser.setEmail("email");
        article.sethUser(hUser);
        articleRepository.save(article);
        return "SUCESS";
    }

    // 删除数据
    @GetMapping("deleteDocument")
    public Object deleteDocument(@RequestParam int id)
    {
        ESHArticle article = new ESHArticle();
        article.setId(id); // 删除指定id的数据
        articleRepository.delete(article);
        return "SUCESS";
    }

    // 删除索引
    @GetMapping("deleteIndex")
    public Object deleteIndex()
    {
        articleRepository.deleteAll();
        return "SUCESS";
    }

    // 修改数据
    @GetMapping("update")
    public Object update(@RequestParam int id, @RequestParam String title)
    {
        ESHArticle article = new ESHArticle();
        article.setId(id);
        article.setTitle(title);
        articleRepository.save(article);
        return "SUCESS";
    }

    // 查询数据
    @GetMapping("find")
    public Object find(@RequestParam int id)
    {
        return articleRepository.findById(id);
    }

    /**
     * ElasticSearch之Search封装查询
     *
     * @param title 搜索标题
     * @author zhengkai.blog.csdn.net
     */
    @GetMapping("search")
    public Object search(@RequestParam(defaultValue = "SpringBoot") String title, @RequestParam(defaultValue = "0") Integer currentPage, @RequestParam(defaultValue = "10") Integer pageSize)
    {
        //以下查询等同于封装了{"query":{"bool":{"must":[{"wildcard":{"title.keyword":{"wildcard":"*SpringBoot*","boost":1}}}],"disable_coord":false,"adjust_pure_negative":true,"boost":1}}}
        //按标题进行模糊查询
        QueryBuilder queryBuilder = QueryBuilders.wildcardQuery("title.keyword", "*" + title + "*");
        //按照顺序构建builder,bool->must->wildcard ,有了上文的JSON,顺序就很好理解了
        BoolQueryBuilder must = QueryBuilders.boolQuery().must(queryBuilder);
        //封装pageable分页
        Pageable pageable = PageRequest.of(currentPage, pageSize);
        Page<ESHArticle> queryResult = articleRepository.search(must, pageable);
        //返回
        return queryResult;
    }

    /**
     * ElasticSearch之elasticsearchTemplate查询
     *
     * @param title 搜索标题
     * @author zhengkai.blog.csdn.net
     */
    @GetMapping("originSearch")
    public Object originSearch(@RequestParam(defaultValue = "SpringBoot") String title)
    {
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        QueryBuilder queryBuilder = QueryBuilders.wildcardQuery("title.keyword", "*" + title + "*");
        BoolQueryBuilder must = boolQuery.must(queryBuilder);
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        NativeSearchQuery build = nativeSearchQueryBuilder.withQuery(must).build();
        List<ESHArticle> queryForList = elasticsearchTemplate.queryForList(build, ESHArticle.class);

        return queryForList;
    }
}
