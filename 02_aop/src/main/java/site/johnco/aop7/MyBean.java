package site.johnco.aop7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;

@Component
public class MyBean {
	@Autowired
	public void setDependency(MyDependency dependency){
		this.dependency = dependency;
	}
	private MyDependency dependency;
	
	public void run(){
		dependency.hello(6000);
		dependency.hello(4000);
		dependency.goodbye(6000);
		dependency.goodbye(4000);
	}
}
