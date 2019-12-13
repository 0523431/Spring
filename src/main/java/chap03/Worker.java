package chap03;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

// 객체화가 됨
// 이름 "worker(소문자)"으로 컨테이너에 저장이 됨
@Component
// 일회성 객체로 주입되게 해줌(worker의 영역이 달라짐)
@Scope(value="prototype", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class Worker {
	public void work(WorkUnit unit) {
		// this는 나 : worker객체
		System.out.println(this + " : work : " + unit);
	}
}
