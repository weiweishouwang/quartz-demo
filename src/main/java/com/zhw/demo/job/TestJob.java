package com.zhw.demo.job;

import com.zhw.demo.quartz.BaseJob;
import org.springframework.stereotype.Component;

/**
 * Created by zhw on 2015/10/19 0019.
 */
@Component
public class TestJob extends BaseJob {

    @Override
    public void doWork() {
        System.out.println("hello world！");
    }
}
