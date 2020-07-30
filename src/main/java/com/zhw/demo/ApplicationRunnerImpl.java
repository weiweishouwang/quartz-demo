package com.zhw.demo;

import com.zhw.demo.quartz.TaskProperties;
import com.zhw.demo.service.JobTriggerService;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;

@Component
@Order(1)
public class ApplicationRunnerImpl implements ApplicationRunner {
    @Autowired
    private JobTriggerService jobTriggerService;

    @Autowired
    private TaskProperties taskProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if (!CollectionUtils.isEmpty(taskProperties.getJobTriggers())) {
            taskProperties.getJobTriggers().stream().forEach(
                    jobTrigger -> {
                        try {
                            jobTriggerService.addJobAndTrigger(jobTrigger.getName(), jobTrigger.getCronExpression(), jobTrigger.getDescription());
                        } catch (SchedulerException e) {
                            e.printStackTrace();
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    });
        }
    }
}
