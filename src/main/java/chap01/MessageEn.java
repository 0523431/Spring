package chap01;

public class MessageEn implements Message {

	@Override
	public void sayHello(String msg) {
		System.out.println("Hello, My name is " + msg);
	}
}
