package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/*
	1. xml 2. annotaion 3. java
	3가지 방식이 있는데, 이건  자바방식
*/

// annotation.xml 파일의 역할을 하는 세줄
@Configuration // 설정 java 소스. xml 설정을 대체하는 소스
@ComponentScan(basePackages = {"annotation", "main"})
@EnableAspectJAutoProxy // AOP 설정(@Aspect를 쓸거니까 준비해줘)
public class AppCtx {
	/*
	 * // <bean id="memberService2" class="main.MemberService" /> // 객체를 만들어..?
	 * 
	 * @Bean public MemberService memberService2() { return new MemberService(); }
	 */
}
