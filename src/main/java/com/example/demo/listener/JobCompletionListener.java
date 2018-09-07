package com.example.demo.listener;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;

/**
 * @author 用来看当前任务的执行状态
 *
 */
public class JobCompletionListener extends JobExecutionListenerSupport {

	long startTime;
	long endTime;

	public void beforeJob(JobExecution jobExecution) {
		startTime = System.currentTimeMillis();
		System.out.println("任务处理开始...");
	}

	public void afterJob(JobExecution jobExecution) {
		if (jobExecution.getStatus() == BatchStatus.COMPLETED) {// 执行成功
			System.out.println("BATCH JOB COMPLETED SUCCESSFULLY");
			endTime = System.currentTimeMillis();
			System.out.println("任务处理结束...");
			System.out.println("耗时:" + (endTime - startTime) + " ms");
		} else if (jobExecution.getStatus() == BatchStatus.FAILED) {// 失败
			System.out.println("BATCH JOB COMPLETED FAILED");
		}
	}
}
