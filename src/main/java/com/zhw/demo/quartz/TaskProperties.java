package com.zhw.demo.quartz;

import com.zhw.demo.quartz.JobTrigger;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "task")
public class TaskProperties {

    private String jobGroup;

    private String triggerGroup;

    private List<JobTrigger> jobTriggers;

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getTriggerGroup() {
        return triggerGroup;
    }

    public void setTriggerGroup(String triggerGroup) {
        this.triggerGroup = triggerGroup;
    }

    public List<JobTrigger> getJobTriggers() {
        return jobTriggers;
    }

    public void setJobTriggers(List<JobTrigger> jobTriggers) {
        this.jobTriggers = jobTriggers;
    }
}
