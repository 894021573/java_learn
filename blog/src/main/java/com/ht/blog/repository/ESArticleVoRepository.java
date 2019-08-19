package com.ht.blog.repository;

import com.ht.blog.entity.ESHArticle;
import com.ht.blog.vo.listArticle.ESArticleVo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESArticleVoRepository extends ElasticsearchRepository<ESArticleVo, Integer>
{

}
