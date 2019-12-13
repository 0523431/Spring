package main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import xml.Article;
import xml.Member;
import xml.MemberService;
import xml.ReadArticleService;
import xml.UpdateInfo;

public class Main2 {
	public static void main(String[] args) {
		String[] config = {"di.xml", "aop2.xml"};
		
		// di는 객체를 하나 만들고
		// aop2는 설정을 저장
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		// service : xml.ReadArticleServiceImpl 객체 저장
		ReadArticleService service = ctx.getBean("readArticleService", ReadArticleService.class);
		try {
			Article a1 = service.getArticleAndReadCnt(1);
			System.out.println("a1객체의 정체 ==========> "+a1);
			
			// 다시 호출
			// 근데 메서드 실행 전에 LoggingAdvice가 실행
			Article a2 = service.getArticleAndReadCnt(1);
			System.out.println("[main] a1==a2 : " + (a1==a2));
			
			// 전처리 무조건 수행
			// getArticleAndReadCnt(0) 메서드 호출
			// =================================> 여기서 aop가 실행되고
			// [LA]메서드 예외 발생 후 수행함. 발생 예외 : id는 0이 안됨
			// [LA]메서드 실행 후 수행함
			service.getArticleAndReadCnt(0);
		} catch(Exception e) {
			// [main] id는 0이 안됨
			System.out.println("[main] " + e.getMessage());
		}
		
		System.out.println("=========================================================");
		System.out.println("\nUpdateMemberInfoTrace Aspect 연습");
		MemberService msvc = ctx.getBean("memberService", MemberService.class);
		msvc.regist(new Member());
		msvc.update("hong", new UpdateInfo());
		msvc.delete("hong2", "test");
		
		System.out.println("=========================================================");
		System.out.println("\nmain.MemberService() 메서드 연습");
		main.MemberService msvc2 = ctx.getBean("memberService2", main.MemberService.class);
		//main.MemberService msvc2 = new main.MemberService();
		msvc2.regist(new Member());
		msvc2.update("hong", new UpdateInfo());
		msvc2.delete("hong2", "test");
	}
}
