package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import spring.WriteImpl;

public class Main1 {
	public static void main(String[] args) {
		// 컨테이너 ctx에 객체를 넣어줌
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:aop.xml");
		
		WriteImpl bean = ctx.getBean("write", WriteImpl.class);
		bean.write();
	}
}
