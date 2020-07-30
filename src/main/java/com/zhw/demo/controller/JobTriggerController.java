package com.zhw.demo.controller;

import com.zhw.demo.quartz.JobTriggerInfo;
import com.zhw.demo.service.JobTriggerService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.util.List;

/**
 * Created by zhw on 2020/7/29.
 * Quartz配置controller
 */
@RestController
public class JobTriggerController {

    @Autowired
    private JobTriggerService jobTriggerService;

    @RequestMapping(value = "/deleteJobAndTrigger")
    public List<JobTriggerInfo> deleteJobAndTrigger(String name) throws SchedulerException {
        jobTriggerService.deleteJobAndTrigger(name);
        return jobTriggerService.getJobAndTriggers();
    }

    @RequestMapping(value = "/addJobAndTrigger")
    public List<JobTriggerInfo> addJobAndTrigger(String name, String cronExpression, String description) throws ParseException, SchedulerException {
        jobTriggerService.addJobAndTrigger(name, cronExpression, description);
        return jobTriggerService.getJobAndTriggers();
    }

    @RequestMapping(value = "/getJobAndTriggers")
    public List<JobTriggerInfo> getJobAndTriggers() throws SchedulerException {
        return jobTriggerService.getJobAndTriggers();
    }

    @RequestMapping(value = "/execJob")
    public String execJob(String jobName) {
        jobTriggerService.execJob(jobName);
        return "success";
    }


}
