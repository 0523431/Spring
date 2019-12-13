package chap01;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		// 컨테이너
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		// greeter객체 / Greeter타입 클래스
		Greeter g = ctx.getBean("greeter", Greeter.class);
		System.out.println(g.greet("스프링"));
		
		// 인터페이스를 사용함으로써 결합도를 더 낮출 수 있음
		// Message객체 / Message타입 클래스 (MessageKo가 Message를 구현했으니까)
		Message m = ctx.getBean("message", Message.class);
		m.sayHello("chocolatepie");
		
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		if(g == g2) {
			System.out.println("g객체와 g2객체는 같은 객체입니다");
		}
	}
}
