package com.ht.blog.configurer;

import com.ht.blog.job.ArticleJob;
import com.ht.blog.job.Job1;
import com.ht.blog.job.Job2;
import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig
{
//    @Bean
//    public JobDetail job1() {
//        return JobBuilder.newJob(Job1.class).withIdentity("job1").storeDurably().build();
//    }
//
//    @Bean
//    public Trigger job1Trigger() {
//        //5秒执行一次
//        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
//                .withIntervalInSeconds(5)
//                .repeatForever();
//        return TriggerBuilder.newTrigger().forJob(job1())
//                .withIdentity("job1")
//                .withSchedule(scheduleBuilder)
//                .build();
//    }
//
//    @Bean
//    public JobDetail job2() {
//        return JobBuilder.newJob(Job2.class).withIdentity("job2").storeDurably().build();
//    }
//
//    @Bean
//    public Trigger job2Trigger() {
//        //cron方式，每隔5秒执行一次
//        return TriggerBuilder.newTrigger().forJob(job2())
//                .withIdentity("job2")
//                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
//                .build();
//    }

    @Bean
    public JobDetail articleJob() {
        return JobBuilder.newJob(ArticleJob.class).withIdentity("articleJob").storeDurably().build();
    }

    @Bean
    public Trigger articleJobTrigger() {
        //cron方式，每隔5秒执行一次
        return TriggerBuilder.newTrigger().forJob(articleJob())
                .withIdentity("articleJob")
                .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                .build();
    }
}
