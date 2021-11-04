package site.johnco.replace;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MagicEx {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("replace.xml");
		Magician magician = ctx.getBean("magician", Magician.class);
		magician.magic();
		
		ctx.close();
	}
}
