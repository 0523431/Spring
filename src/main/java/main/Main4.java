package main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import xml.Article;
import xml.Member;
import xml.ReadArticleService;
import xml.UpdateInfo;

public class Main4 {
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		ReadArticleService service = ctx.getBean("readArticleService", ReadArticleService.class);
		try {
			Article a1 = service.getArticleAndReadCnt(1);
			Article a2 = service.getArticleAndReadCnt(1);
			System.out.println("[main] a1==a2 : " + (a1==a2));
			service.getArticleAndReadCnt(0);
		} catch(Exception e) {
			System.out.println("[main] " + e.getMessage());
		}

		System.out.println("=========================================================");
		System.out.println("어노테이션 ==> annotation.MemberService");
		annotation.MemberService msvc = ctx.getBean("memberService", annotation.MemberService.class);
		msvc.regist(new Member());
		msvc.update("hong", new UpdateInfo());
		msvc.delete("hong2", "test");
		
		System.out.println("=========================================================");
		System.out.println("main패키지에 있는 MemberService @Component(\"memberService2\")");
		main.MemberService msvc2 = ctx.getBean("memberService2", main.MemberService.class);
		msvc2.regist(new Member());
		msvc2.update("hong", new UpdateInfo());
		msvc2.delete("hong2", "test");
	}
}
