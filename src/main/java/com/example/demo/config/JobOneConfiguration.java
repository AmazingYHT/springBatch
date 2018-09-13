//package com.example.demo.config;
//
//import java.util.List;
//import java.util.Map;
//
//
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.JobExecutionListener;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.core.launch.support.RunIdIncrementer;
//import org.springframework.batch.item.ItemProcessor;
//import org.springframework.batch.item.ItemReader;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.database.JdbcCursorItemReader;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.example.demo.listener.JobCompletionListener;
//
//@Configuration
//public class JobOneConfiguration {
//
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//
//	@Bean(name = "jobOne")
//	public Job jobOne(@Qualifier("step1") Step s1) {
//		return jobBuilderFactory.get("jobOne")
//				.incrementer(new RunIdIncrementer()).listener(listener())
//				.start(s1).build();
//	}
//
//	@Bean(name = "readerOne")
//	public JdbcCursorItemReader<Map<String, String>> reader() {
//		JdbcCursorItemReader<Map<String, String>> reader = new JdbcCursorItemReader<>();
//		// reader逻辑根据实际需要写，先不举例
//		return reader;
//	}
//
//	@Bean(name = "processorOne")
//	public ItemProcessor<Map<String, String>, String> processor() {
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
//	@Bean(name = "writerOne")
//	@StepScope
//	public ItemWriter<String> writer() {
//		return new ItemWriter<String>() {
//			public void write(List<? extends String> list) throws Exception {
//				// writer逻辑根据实际需要写，先不举例
//			}
//		};
//	}
//
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@Bean(name = "step1")
//	public Step step1(@Qualifier("readerOne") ItemReader reader,
//			@Qualifier("writerOne") ItemWriter writer,
//			@Qualifier("processorOne") ItemProcessor processor) {
//		return stepBuilderFactory.get("step1")
//				.<Map<String, String>, String> chunk(100).reader(reader)
//				.processor(processor).writer(writer).build();
//	}
//
//	@Bean
//	public JobExecutionListener listener() {
//		return new JobCompletionListener();
//	}
//}
