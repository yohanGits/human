package site.johnco.SmallMart;

public class SmallMartImpl implements SmallMart{
	public String getProduct(String msg) throws Exception {
		System.out.println(msg);
		if(msg == null) throw new Exception("예외 발생됨");
		return null;
	}
}
