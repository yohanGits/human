package site.johnco.SmallMart5;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component @Aspect
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
	@Before("execution(* *2(..))")
	public void before(JoinPoint jp){
		System.out.println("before");
	}
}
