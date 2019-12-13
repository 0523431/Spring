package chap02;

import java.util.Arrays;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		// 컨테이너
		// xml의 bean을 객체로 만들어줌
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		Project pro = ctx.getBean("project", Project.class);
		pro.build();
		
		pro = new Project(); // 빈 project객체일 뿐이야
//		pro.build();
		/* java.lang.NullPointerException at chap02.Project.build(Project.java:12) at
		 * chap02.Main1.main(Main1.java:16)
		 */
		
		BuildRunner br = ctx.getBean("runner", BuildRunner.class);
		br.build(Arrays.asList("value1","value2"), "value3");
		
		br = new BuildRunner();
		br.build(Arrays.asList("value1","value2"), "value3");
		
		// write가 객체 생성을 해야하는데, WriteImpl의 생성자는 매개변수가 필요함
		WriteImpl wi = ctx.getBean("write", WriteImpl.class);
		wi.write();
	}
}
