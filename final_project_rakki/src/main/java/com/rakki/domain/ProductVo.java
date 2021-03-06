package com.rakki.domain;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data @Alias("product")
public class ProductVo {
	private Long product_no;
	private String category;
	private String brand;
	private String serialNo;
	private String image;
	private String name_ko;
	private String name_en;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date release;
	private String color;
	private String price_rel;
	
	private Long trade_price;
	private Long buy_price;
	private Long sell_price;
	private Long buy_min_price;  //즉시구매가중 가장 낮은가격
}
