package site.johnco.aop2;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javafx.beans.binding.When.ObjectConditionBuilder;

public class MsgDecorator implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("전 처리");
		Object obj = arg0.proceed();
		System.out.println("후 처리");
		return obj;
	}
	
}
