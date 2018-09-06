package com.example.demo.step;

import org.springframework.batch.item.ItemProcessor;

public class Processor implements ItemProcessor<String, String>{

	/* 
	 * 处理拿过来的数据
	 */
	@Override
	public String process(String data) throws Exception {
		 return data.toUpperCase();
	}

}
