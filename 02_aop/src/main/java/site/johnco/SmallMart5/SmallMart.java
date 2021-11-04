package site.johnco.SmallMart5;

import org.springframework.beans.factory.annotation.Autowired;

public interface SmallMart {
	String getProduct(String msg) throws Exception;
	String getProduct2(String msg) throws Exception;
}
