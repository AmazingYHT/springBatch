package com.example.demo;

import java.util.Date;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.BeansException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
// @EnableTransactionManagement
@EnableBatchProcessing
@ComponentScan
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);
//		boolean oneJob = false;
//		boolean twoJob = false;
//
//		SpringApplication application = new SpringApplication(
//				DemoApplication.class);
//		application.setWebEnvironment(false);
//		ConfigurableApplicationContext ctx = application.run(args);
//		JobLauncher jobLauncher = ctx.getBean(JobLauncher.class);
//
//		// 无参数时，都执行
//		if (args.length == 0) {
//			oneJob = true;
//			twoJob = true;
//		} else {
//			for (String arg : args) {
//				if (arg.toLowerCase().equals("?")) {
//					System.out.println("Usage : Batch [-b] [-r]");
//				}
//				if (arg.toLowerCase().equals("-o") || arg == null) {
//					oneJob = true;
//				}
//				if (arg.toLowerCase().equals("-t")) {
//					twoJob = true;
//				}
//			}
//		}
//		if (oneJob) {
//			JobParameters jobParameters = new JobParametersBuilder().addDate(
//					"date", new Date()).toJobParameters();
//			jobLauncher.run(ctx.getBean("jobOne", Job.class), jobParameters);
//			// jobOne名称必须和JobOneConfiguration中配置的@bean Job 的方法名一致，后面jobTwo也是一样。
//		}
//		if (twoJob) {
//			JobParameters jobParameters = new JobParametersBuilder().addDate(
//					"date", new Date()).toJobParameters();
//			jobLauncher.run(ctx.getBean("jobTwo", Job.class), jobParameters);
//		}
//
//		System.exit(0);

	}
}
