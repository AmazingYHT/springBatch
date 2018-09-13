package com.example.demo.config;

import java.util.List;
import java.util.Map;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.listener.JobCompletionListener;
import com.example.demo.step.Reader;

@Configuration
public class AppConfig {
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job job() {
		return jobBuilderFactory.get("job").listener(listener()).start(step1())
				.build();
	}

	@Bean
	protected Step step1() {
		return stepBuilderFactory.get("step1").<String, String> chunk(10)
				.reader(reader()).processor(processor()).writer(writer())
				.build();
	}

	protected ItemReader<String> reader() {
		 JdbcCursorItemReader<String> reader = new JdbcCursorItemReader<>();
		//Reader read = new Reader();

		 
		 
		return reader;
	}

	/**
	 * 读和写之间的转换过程
	 * 
	 * @return
	 */
	protected ItemProcessor<String, String> processor() {
		return new ItemProcessor<String, String>() {
			public String process(String str) throws Exception {
				// process逻辑根据实际需要写，先不举例
				return str;
			}
		};
	}

	protected ItemWriter<String> writer() {
		return new ItemWriter<String>() {
			public void write(List<? extends String> list) throws Exception {
				// writer逻辑根据实际需要写，先不举例
				
			}
		};
	}

	/**
	 * @param tasklet
	 *            执行完毕清理
	 * @return
	 */
	// @Bean
	// protected Step step2(Tasklet tasklet) {
	// return stepBuilderFactory.get("step2").tasklet(tasklet).build();
	// }

	@Bean
	public JobExecutionListener listener() {
		return new JobCompletionListener();
	}
}
