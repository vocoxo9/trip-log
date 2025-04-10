package kr.co.khedu.product.service;

import java.util.List;

import kr.co.khedu.product.model.vo.Product;

public interface ProductService {
	// 상품 목록 조회(날짜순)
	List<Product> selectProductList();

	// 상품 번호로 상품 조회
	Product selectProductByProductId(int productId);
	
	// 상품 등록 
	int insertProduct(Product product);
}
