package site.johnco.SmallMart.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroudLogging implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println(arg0.getMethod().getName() + " :: " + arg0.getArguments()[0] + " :: around 사전");
		Object obj = arg0.proceed();
		System.out.println(arg0.getMethod().getName() + " :: " + arg0.getArguments()[0] + " :: around사후");
		return obj;
	}
	
}
