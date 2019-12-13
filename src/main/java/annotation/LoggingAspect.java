package annotation;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*
	1. Component : 객체화 시킴
	2. Aspect : aspect클래스 설정
	3. Order(3) : 3번째 AOP 순서
*/
@Component
@Aspect
@Order(3)
public class LoggingAspect {
	// 핵심로직 대상을 선정
	final String publicMethod = "execution(public * annotation..*(..))";
	
	// publicMethod가 실행되기 전에 나를 실행해주시오
	@Before(publicMethod)
	public void beford() {
		System.out.println();
		System.out.println("[LA] 메서드 실행 전 실행");
	}
	
	// 잊지마, return값은 ret로 전달되는 거야
	@AfterReturning(pointcut=publicMethod, returning="ret")
	public void afterReturning(Object ret) {
		System.out.println("[LA] 메서드 정상 종료 후 실행 afterReturning(Object ret) | 리턴값 = " + ret);
	}
	
	@AfterThrowing(pointcut=publicMethod, throwing="ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("[LA] 메서드 예외 종료 후 실행 afterThrowing(Throwable ex) | 예외 메시지 = " + ex.getMessage());
	}
	
	// 정상,비정상 종료든 상관없이 나를 실행해주라
	@After(publicMethod)
	public void afterFinally() {
		System.out.println("[LA] 메서드 종료 후 실행 = afterFinally()");
	}
}
