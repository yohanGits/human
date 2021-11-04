package site.johnco.SmallMart;

import org.springframework.aop.framework.ProxyFactory;

import site.johnco.SmallMart.advice.AfterLogging;
import site.johnco.SmallMart.advice.AroudLogging;
import site.johnco.SmallMart.advice.BeforeLogging;
import site.johnco.SmallMart.advice.ThrowsLogging;

public class SmallMartEx {
	public static void main(String[] args) {
		SmallMart mart = new SmallMartImpl();
		
		ProxyFactory factory = new ProxyFactory();
		factory.addAdvice(new AroudLogging());
		factory.addAdvice(new BeforeLogging());
		factory.addAdvice(new BeforeLogging());
		factory.addAdvice(new AfterLogging());
		factory.addAdvice(new ThrowsLogging());
		
		factory.setTarget(mart);
		
		SmallMart proxy = (SmallMart)factory.getProxy(); 
	
	
	try {
//		mart.getProduct("커피");
		proxy.getProduct("커피");
//		mart.getProduct(null);
//		proxy.getProduct(null);
		
	} catch (Exception e) {
		
		e.printStackTrace();
	}
}
}
