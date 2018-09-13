//package com.example.demo.config;
//
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecutionListener;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.JobScope;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@EnableBatchProcessing
//public class JobTwoConfiguration {
//
//	@Autowired
//	private JobBuilderFactory job;
//
//	@Autowired
//	private StepBuilderFactory step;
//
//	// job
//	@Bean(name="jobTwo")
//	public Job jobTwo(@Qualifier("step2") Step s2) {
//		return job.get("jobTwo").incrementer(new RunIdIncrementer())
//				.start(step2()).build();
//	}
//
//	@Bean(name="readTwo")
//	public JdbcCursorItemReader<Map<String, String>> reader2() {
//		JdbcCursorItemReader<Map<String, String>> reader = new JdbcCursorItemReader<>();
//		// reader逻辑根据实际需要写，先不举例
//		return reader;
//	}
//
//	@Bean
//	public ItemProcessor<Map<String, String>, String> tableProcessor2() {
//		return new ItemProcessor<Map<String, String>, String>() {
//			@Override
//			public String process(Map<String, String> map) throws Exception {
//				String insertSql = "";
//				// process逻辑根据实际需要写，先不举例
//				return insertSql;
//			}
//		};
//	}
//
//	@Bean
//	public ItemWriter<String> writer2() {
//		return new ItemWriter<String>() {
//			@Override
//			public void write(List<? extends String> list) throws Exception {
//				// writer逻辑根据实际需要写，先不举例
//			}
//		};
//	}
//
//	@Bean
//	@JobScope
//	public Step step2() {
//		return step.get("step2").<Map<String, String>, String> chunk(100)
//				.reader(reader2()).processor(tableProcessor2())
//				.writer(writer2()).build();
//	}
//
//}
