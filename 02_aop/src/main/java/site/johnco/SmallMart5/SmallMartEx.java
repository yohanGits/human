package site.johnco.SmallMart5;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SmallMartEx {
	public static void main(String[] args) throws Exception {
	// ApplicationContext
	// getProduct2 xml aop
	
	// proxyFactoryBean
	// Advice 
	// PointCut
	// Advisor
		
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("mart3.xml");
	SmallMart mart = ctx.getBean("smallMartImpl", SmallMart.class);
	
	mart.getProduct("식빵");
	System.out.println("==================");
	mart.getProduct2("커피");
	
	ctx.close();
	}
}
