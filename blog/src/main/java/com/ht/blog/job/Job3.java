package com.ht.blog.job;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Job3 extends QuartzJobBean
{
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException
    {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Job3----" + sdf.format(new Date()));
    }
}
