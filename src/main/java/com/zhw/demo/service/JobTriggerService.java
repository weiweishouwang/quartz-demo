package com.zhw.demo.service;

import com.zhw.demo.quartz.TaskProperties;
import com.zhw.demo.quartz.BaseJob;
import com.zhw.demo.quartz.JobTriggerInfo;
import com.zhw.demo.quartz.QuartzService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;

/**
 * Created by zhw on 2020/7/29.
 * Quartz配置service
 */
@Service
public class JobTriggerService {

    @Autowired
    private QuartzService jobService;

    @Autowired
    private TaskProperties taskProperties;

    public List<JobTriggerInfo> getJobAndTriggers() throws SchedulerException {
        return jobService.getJobAndTriggers(taskProperties.getTriggerGroup());
    }

    public boolean deleteJobAndTrigger(String name) throws SchedulerException {
        return jobService.deleteJobAndTrigger(taskProperties.getTriggerGroup(), taskProperties.getJobGroup(), name);
    }

    public boolean addJobAndTrigger(String name, String cronExpression, String description) throws SchedulerException, ParseException {
        jobService.deleteJobAndTrigger(taskProperties.getTriggerGroup(), taskProperties.getJobGroup(), name);
        return jobService.addJobAndTrigger(taskProperties.getTriggerGroup(), taskProperties.getJobGroup(), name, cronExpression, description);
    }

    /**
     * 立即触发
     *
     * @param name
     */
    @Async
    public void execJob(String name) {
        jobService.execJob(name);
    }

}
