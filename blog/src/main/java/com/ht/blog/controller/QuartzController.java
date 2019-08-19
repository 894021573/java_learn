package com.ht.blog.controller;

import com.ht.blog.entity.QuartzBean;
import common.util.QuartzUtil;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuartzController
{
    //注入任务调度
    @Autowired
    private Scheduler scheduler;

    @RequestMapping("/createJob")
    @ResponseBody
    public String  createJob(QuartzBean quartzBean)  {
        try {
            //进行测试所以写死
            quartzBean.setJobClass("com.ht.blog.job.Job3");
            quartzBean.setJobName("job3");
            quartzBean.setCronExpression("*/5 * * * * ?");
            QuartzUtil.createScheduleJob(scheduler,quartzBean);
        } catch (Exception e) {
            return "创建失败";
        }
        return "创建成功";
    }

    @RequestMapping("/pauseJob")
    @ResponseBody
    public String  pauseJob()  {
        try {
            QuartzUtil.pauseScheduleJob (scheduler,"job3");
        } catch (Exception e) {
            return "暂停失败";
        }
        return "暂停成功";
    }

    @RequestMapping("/runOnce")
    @ResponseBody
    public String  runOnce()  {
        try {
            QuartzUtil.runOnce (scheduler,"job3");
        } catch (Exception e) {
            return "运行一次失败";
        }
        return "运行一次成功";
    }

    @RequestMapping("/resume")
    @ResponseBody
    public String  resume()  {
        try {

            QuartzUtil.resumeScheduleJob(scheduler,"job3");
        } catch (Exception e) {
            return "启动失败";
        }
        return "启动成功";
    }

    @RequestMapping("/update")
    @ResponseBody
    public String  update(QuartzBean quartzBean)  {
        try {
            //进行测试所以写死
            quartzBean.setJobClass("com.ht.blog.job.Job3");
            quartzBean.setJobName("job3");
            quartzBean.setCronExpression("10 * * * * ?");
            QuartzUtil.updateScheduleJob(scheduler,quartzBean);
        } catch (Exception e) {
            return "启动失败";
        }
        return "启动成功";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String  delete(QuartzBean quartzBean)  {
        try {
            QuartzUtil.deleteScheduleJob(scheduler,"articleJob");
        } catch (Exception e) {
            return "删除失败";
        }
        return "删除成功";
    }
}
