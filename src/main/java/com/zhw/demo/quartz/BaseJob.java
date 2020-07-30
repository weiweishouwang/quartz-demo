package com.zhw.demo.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BaseJob {
	private static Logger logger = LoggerFactory.getLogger(BaseJob.class);

	private Object lock = new Object();
	private boolean running = false;

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
