package annotation;

import org.springframework.stereotype.Component;

// 설정에 의해서 MemberService라는 객체를 만들어줌
// 직접 호출하기때문에 @Aspect는 없어도 됨? ㅇㅇ ...?
@Component
public class MemberService {

	public void regist(xml.Member member) {
		System.out.println("annotation.MemberService.regist() 메서드 실행");
	}
	public boolean update(String memberId, xml.UpdateInfo info) {
		System.out.println("annotation.MemberService.update() 메서드 실행");
		return true;
	}
	public boolean delete(String id, String str) {
		System.out.println("annotation.MemberService.delete() 메서드 실행");
		return false;
	}
}
