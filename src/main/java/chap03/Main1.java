package chap03;

import org.springframework.context.support.GenericXmlApplicationContext;

public class Main1 {
	public static void main(String[] args) {
		// 컨테이너
		// xml의 bean을 객체로 만들어줌
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:annotation.xml");
		
		Executor exec = ctx.getBean("executor", Executor.class);
		exec.addUnit(new WorkUnit());
		exec.addUnit(new WorkUnit());
		
		System.out.println();
		
		HomeController home = ctx.getBean("homeController", HomeController.class);
		home.checkSensorAndAlarm();
		System.out.println("================침임 없음================");
		System.out.println("======================================");
		
		// 창문에 침입함
		InfraredRaySensor sensor = ctx.getBean("windowSensor", InfraredRaySensor.class);
		sensor.foundObject();
		home.checkSensorAndAlarm();
		
		System.out.println("======================================");
		System.out.println("현관센서 새로 생성했으나 이건 ctx를 통한게 아니라 감지하지 못함");
		sensor = new InfraredRaySensor("현관센서");
		sensor.isObjectFounded();
		home.checkSensorAndAlarm();
	}
}
