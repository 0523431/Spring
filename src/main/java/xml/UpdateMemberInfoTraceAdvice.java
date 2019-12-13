package xml;

public class UpdateMemberInfoTraceAdvice {
	public void traceReturn(Object result, String memberId, UpdateInfo info) {
		// result : 핵심로직이 전달해준 결과값
		System.out.println("[TA] 정보 수정 : 결과 = " + result
									+ ", 대상회원 = " + memberId + ", 수정정보 = " + info);
	}
}
