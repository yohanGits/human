package site.johnco.SmallMart3;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class SmallMartEx {
	public static void main(String[] args) {
	// ApplicationContext
	// getProduct2 xml aop
	
	// proxyFactoryBean
	// Advice 
	// PointCut
	// Advisor
		
	ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("smallmart.xml");
	SmallMart mart = ctx.getBean("smallMart", SmallMart.class);
	
//	mart.getProduct("커피");
}
}
