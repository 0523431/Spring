package xml;

public class LoggingAdvice {
	public void before() {
		System.out.println("\n[LA]메서드 실행 전 전처리 수행 기능");
	}
	
	// 핵심로직 정상 종료 후에 있는 리턴값 ret
	// 즉, ret는 핵심로직에서 전달한 결과값
	public void afterReturning(Object ret) {
		System.out.println("[LA]메서드 정상 처리 후 수행함 ret="+ret);
	}
	
	// 핵심로직 예외 종료 후 발생하는 예외객체 ex
	public void afterThrowing(Throwable ex) {
		System.out.println("[LA]메서드 예외 발생 후 수행함. 발생 예외 : " + ex.getMessage());
	}
	
	// 핵심로직 종료
	public void afterFinally() {
		System.out.println("[LA]메서드 실행 후 수행함");
	}
}
