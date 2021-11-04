package site.johnco.aop6;

import lombok.Setter;

public class MyBean {
	public void setDependency(MyDependency dependency){
		this.dependency = dependency;
	}
	@Setter
	private MyDependency dependency;
	
	public void run(){
		dependency.hello(6000);
		dependency.hello(4000);
		dependency.goodbye(6000);
		dependency.goodbye(4000);
	}
}
