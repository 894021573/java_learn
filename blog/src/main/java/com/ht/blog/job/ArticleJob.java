package com.ht.blog.job;

import com.ht.blog.service.ESArticleService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ArticleJob extends QuartzJobBean
{
    @Autowired
    ESArticleService esArticleService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException
    {
        esArticleService.listArticleToES();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Job4----" + sdf.format(new Date()));
    }
}
