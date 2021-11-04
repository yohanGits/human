package site.johnco.SmallMart4;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class MyAdvice{
	public void simple (JoinPoint jp, int value){
		if(value > 5000){
			System.out.println("advice.access!!!");
		}
	}
	
	public Object around(ProceedingJoinPoint pjp) throws Throwable{
		System.out.println("pre around!!!!!");
		Object obj = pjp.proceed();
		System.out.println("suf around!!!!!");
		return obj;
	}
	public void before(JoinPoint jp){
		System.out.println("before");
	}
}
