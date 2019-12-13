package chap03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 객체화됨
// 이름 "executor(소문자)"으로 컨테이너에 저장이 됨
@Component
public class Executor {
	
	// DI(의존성 주입)
	// setter가 없어도 주입이 가능해짐!
	// 컨테이너 중 Worker객체를 찾아서 주입 (Worker 역시 객체화되어 있음)
	@Autowired
	private Worker worker;
	
	public void addUnit(WorkUnit unit) {
		worker.work(unit);
	}
}
