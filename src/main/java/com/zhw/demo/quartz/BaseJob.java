package com.zhw.demo.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public abstract class BaseJob extends QuartzJobBean {
	private static Logger logger = LoggerFactory.getLogger(BaseJob.class);

	private Object lock = new Object();
	private boolean running = false;

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		execute();
	}

	public void execute() {
		synchronized (lock) {
			if (running) {
				return;
			} else {
				running = true;
			}
		}

		try {
			doWork();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

		running = false;
	}

	public abstract void doWork();

}
