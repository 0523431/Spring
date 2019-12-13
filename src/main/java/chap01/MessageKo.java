package chap01;

public class MessageKo implements Message {

	@Override
	public void sayHello(String msg) {
		System.out.println("반갑습니다. " + msg + "입니다.");
	}
}
