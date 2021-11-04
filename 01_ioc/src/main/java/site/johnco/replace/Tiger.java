package site.johnco.replace;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.beans.factory.support.MethodReplacer;

public class Tiger implements MethodReplacer{

	@Override
	public Object reimplement(Object arg0, Method arg1, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		System.out.println(arg0.getClass().getCanonicalName()); // 메서드를 호출하는 객체 이름 실행하면 나오는것 중 CGLIB 중요
		System.out.println(arg1.getName()); // getContent
		System.out.println(Arrays.toString(arg2)); // []
		return "난 호랑이다 어흥";
	}
	
	
}
