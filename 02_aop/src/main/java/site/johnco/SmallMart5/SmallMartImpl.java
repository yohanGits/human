package site.johnco.SmallMart5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SmallMartImpl implements SmallMart{
	public String getProduct(String msg) throws Exception {
		System.out.println(msg);
		return null;
	}
	public String getProduct2(String msg) throws Exception {
		System.out.println(msg);
		return null;
	}
}
