package site.johnco.SmallMart2;

import org.springframework.aop.framework.ProxyFactory;

import site.johnco.SmallMart.advice.AfterLogging;
import site.johnco.SmallMart.advice.AroudLogging;
import site.johnco.SmallMart.advice.BeforeLogging;
import site.johnco.SmallMart.advice.ThrowsLogging;
import site.johnco.aop3.One;

public class SmallMartEx {
	public static void main(String[] args) {
		SmallMart mart = new SmallMartImpl();
		
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvice(new BeforeLogging());
		
		factory.setTarget(mart);
		
		SmallMart proxy = (SmallMart)factory.getProxy(); 
		
//		ProxyFactory factory = new ProxyFactory();
//		factory.addAdvisor(advisor);
//		factory.setTarget(mart);
//		One oneP1 = (One)factory.getProxy();
	
	
	try {
//		mart.getProduct("커피");
		proxy.getProduct("커피");
		
		proxy.getProduct2("커피2");
//		mart.getProduct(null);
//		proxy.getProduct(null);
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
}
