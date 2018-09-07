package com.example.demo.config;

import java.util.List;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;


@Configuration
public class JobOneConfiguration {
	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean(name = "jobOne")
	public Job jobOne(@Qualifier("step1") Step s1) {
		return jobBuilderFactory.get("jobOne")
				.incrementer(new RunIdIncrementer()).start(s1).build();
	}

	@Bean(name = "readOne")
	public JdbcCursorItemReader<Map<String, String>> reader() {
		JdbcCursorItemReader<Map<String, String>> reader = new JdbcCursorItemReader<>();
		// reader逻辑根据实际需要写，先不举例
		return reader;
	}

	@Bean(name = "processOne")
	public ItemProcessor<Map<String, String>, String> tableProcessor() {
		return new ItemProcessor<Map<String, String>, String>() {
			@Override
			public String process(Map<String, String> map) throws Exception {
				String insertSql = "";
				// process逻辑根据实际需要写，先不举例
				return insertSql;
			}
		};
	}

	@Bean(name = "writerOne")
	public ItemWriter<String> writer(DruidDataSource dataSource) {
		return new ItemWriter<String>() {
			public void write(List<? extends String> list) throws Exception {
				// writer逻辑根据实际需要写，先不举例
			}
		};
	}

	@Bean
	public Step step1(@Qualifier("readOne") ItemReader<Map<String, String>> reader,
			@Qualifier("writerOne") ItemWriter<String> writer,
			@Qualifier("processOne") ItemProcessor<Map<String, String>, String> processor) {
		return stepBuilderFactory.get("step1")
				.<Map<String, String>, String> chunk(100).reader(reader)
				.processor(processor).writer(writer).build();
	}

}
