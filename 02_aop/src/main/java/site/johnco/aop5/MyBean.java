package site.johnco.aop5;

import lombok.Setter;

public class MyBean {
	@Setter
	private MyDependency dependency;
	
	public void run(){
		dependency.hello();
		dependency.goodbye();
	}
}
