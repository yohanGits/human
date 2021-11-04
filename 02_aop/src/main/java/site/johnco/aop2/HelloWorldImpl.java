package site.johnco.aop2;

public class HelloWorldImpl implements HelloWorld{

	@Override
	public void sayHello(String msg) {
		System.out.println("안녕 세상 :: " + msg);
	}
	
}
