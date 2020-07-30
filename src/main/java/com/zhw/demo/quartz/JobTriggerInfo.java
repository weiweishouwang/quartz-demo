package com.zhw.demo.quartz;


import org.quartz.CronExpression;
import org.quartz.Scheduler;

import java.util.Date;

public class JobTriggerInfo {

    private String jobName;
    private String jobGroup;
    private boolean durability;

    private String trigerName;
    private String trigerGroup;
    private String cronEx;
    private Date startTime;
    private Date endTime;
    private Date nextFireTime;
    private Date previousFireTime;
    private String state;
    private String description;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDurability() {
        return durability;
    }

    public void setDurability(boolean durability) {
        this.durability = durability;
    }

    public String getTrigerName() {
        return trigerName;
    }

    public void setTrigerName(String trigerName) {
        this.trigerName = trigerName;
    }

    public String getTrigerGroup() {
        return trigerGroup;
    }

    public void setTrigerGroup(String trigerGroup) {
        this.trigerGroup = trigerGroup;
    }

    public String getCronEx() {
        return cronEx;
    }

    public void setCronEx(String cronEx) {
        this.cronEx = cronEx;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getNextFireTime() {
        return nextFireTime;
    }

    public void setNextFireTime(Date nextFireTime) {
        this.nextFireTime = nextFireTime;
    }

    public Date getPreviousFireTime() {
        return previousFireTime;
    }

    public void setPreviousFireTime(Date previousFireTime) {
        this.previousFireTime = previousFireTime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
