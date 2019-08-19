package com.ht.blog.repository;

import com.ht.blog.entity.ESHArticle;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESHArticleRepository extends ElasticsearchRepository<ESHArticle, Integer>
{

}
