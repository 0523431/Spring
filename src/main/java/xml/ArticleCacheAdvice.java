package xml;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;

public class ArticleCacheAdvice {
	private Map<Integer, Article> cache = new HashMap<Integer, Article>();
	
	public Object cache(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("[ACA] cache before 실행");
		
		// getArgs()[0] : 핵심로직의 매개변수 값을 가져올 수 있게 해줌
		Integer id = (Integer)joinPoint.getArgs()[0];
		Article article = cache.get(id);
		if(article !=null) {
			System.out.println("[ACA] cache에서 Article["+ id +"] 가져옴");
			return article;
		}
		Object ret = joinPoint.proceed();
		
		// 정상종료가 되지않으면 이 쪽으로 올 수 없음
		System.out.println("[ACA] cache after 실행");
		// ret는 리턴값
		if(ret !=null) {
			cache.put(id, (Article)ret);
			System.out.println("[ACA] cache에 Article[" + id + "] 추가함");
		}
		return ret;
	}
}
