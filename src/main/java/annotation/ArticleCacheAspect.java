package annotation;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import xml.Article;

/*
1. Component : 객체화 시킴
2. Aspect : aspect(AOP클래스) 설정
3. Order(2) : 2번째 AOP 순서
*/
@Component
@Aspect
@Order(2)
public class ArticleCacheAspect {
	private Map<Integer, Article> cache = new HashMap<Integer, Article>();
	
	@Around("execution(public * *..ReadArticleService.*(..))")
	// joinPoint : 실행 순서
	public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
		// getArgs() : 호출되는 핵심로직의 매개변수 목록을 가져옴
		// getArgs()[0] : Object의 형태가 배열임을 알 수 있음
		Integer id = (Integer)joinPoint.getArgs()[0];
		
		// joinPoint.getSignature().getName() : 실행중인 핵심로직의 메서드 이름
		// 즉, getArticleAndReadCnt
		System.out.println("\n[ACA] " 
					+ joinPoint.getSignature().getName() + "(" + id + ") 메서드 호출 전");
		// get(id)을 가져와
		// 근데 그 article이 null이야
		Article article = cache.get(id);
		if(article !=null) {
			System.out.println("[ACA] cache에서 Article[" + id + "] 가져옴");
			return article; // if가 성립이 되면, 이 다음으로 넘어가지않아 그래서 main3에서 a1==a2가 성립할 수 있게 됨
		}
		
		// ret는 Article 객체야
		Object ret = joinPoint.proceed();
		System.out.println("\n[ACA] "
					+ joinPoint.getSignature().getName() + "(" + id +") 메서드 호출 후");
		if(ret !=null && ret instanceof Article) {
			cache.put(id, (Article)ret); // 등록하기
			System.out.println("[ACA] cache에 Article[" + id + "] 추가함");
		}
		return ret; // 메인으로 전달
	}
}
