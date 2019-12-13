package main;

import org.springframework.stereotype.Component;

import xml.Member;
import xml.UpdateInfo;

// @Component는 무조건 객체화시켜주는게 아니라, xml설정이 되어 있어야 가능함
@Component("memberService2")
public class MemberService {
	public void regist(Member member) {
		System.out.println("main.MemberService.regist() 메서드 실행");
	}
	public boolean update(String memberId, UpdateInfo info) {
		System.out.println("main.MemberService.update() 메서드 실행");
		return true;
	}
	public boolean delete(String id, String str) {
		System.out.println("main.MemberService.delete() 메서드 실행");
		return false;
	}
}
