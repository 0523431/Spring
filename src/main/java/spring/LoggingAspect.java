package spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.util.StopWatch;

public class LoggingAspect {
	public Object logging(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[LA]로그 시작");
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object ret = joinPoint.proceed(); // 여기서 write()가 실행되고 
		
		sw.stop();
		System.out.println("[LA]메서드 실행 시간 : " + sw.getTotalTimeMillis() + "밀리초");
		
		return ret;
	}
}
