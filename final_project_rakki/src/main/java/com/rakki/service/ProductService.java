package com.rakki.service;

import java.util.List;

import com.rakki.domain.Criteria;
import com.rakki.domain.ProductVo;

public interface ProductService {
	List<ProductVo> getList();
	List<ProductVo> getList(Criteria cri);
	int getTotal(Criteria cri);
	void register(ProductVo productVo);
	ProductVo getProductInfo(Long product_no);
	void insertProduct(ProductVo productVo);
	void removeProduct(Long product_no);
}
