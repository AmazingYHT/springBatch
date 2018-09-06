package com.example.demo.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

public class JobCompletionListener extends JobExecutionListenerSupport {

	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {// 执行成功
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
		} else if (jobExecution.getStatus() == BatchStatus.FAILED) {// 失败
			System.out.println("BATCH JOB COMPLETED FAILED");
		}
	}
}
