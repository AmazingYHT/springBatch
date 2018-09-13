package com.example.demo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @Component
// @Configurable
// @EnableScheduling
public class JobInvokerController {
	//@Autowired
	JobLauncher jobLauncher;

	//@Autowired
	Job jobob;

	@RequestMapping("/invokejob")
	// @Scheduled(cron = "0 */1 *  * * * ")
	public String handle() throws Exception {

		// job 和 job 参数
		// Map<String, JobParameter> parameters = new HashMap<>();
		// parameters.put("business_date", new JobParameter("20170704"));
		// JobParameters jobParameters = new JobParameters(parameters);
		// Job job = context.getBean(Job.class);
		// // 运行 job
		// JobLauncher jobLauncher = context.getBean(JobLauncher.class);
		// jobLauncher.run(job, jobParameters);

		 JobParameters jobParameters = new JobParametersBuilder().addLong(
		 "time", System.currentTimeMillis()).toJobParameters();
		 jobLauncher.run(jobob, jobParameters);
		
		return "Batch job has been invoked";
	}
}
