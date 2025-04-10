package kr.co.khedu.product.service;

import java.util.List;

import kr.co.khedu.common.PageInfo;
import kr.co.khedu.product.model.dto.ProductListDTO;
import kr.co.khedu.product.model.dto.ProductSearchDTO;
import kr.co.khedu.product.model.vo.Product;

public interface ProductService {
	// 상품 목록 조회(날짜순)
	List<Product> selectProductList();

	// 상품 번호로 상품 조회
	Product selectProductByProductId(int productId);

	/** 상품 전체 갯수 조회
	 * @param productSearchDTO
	 * @return
	 */
	int selectByProductNameCount(ProductSearchDTO productSearchDTO);

	/** 페이지 정보와 키워드 값으로 상품 조회
	 * 
	 * @param productSearchDTO
	 * @param pageInfo
	 * @return
	 */
	List<ProductListDTO> selectByProductName(ProductSearchDTO productSearchDTO, PageInfo pageInfo);
	
	// 상품 등록 
	int insertProduct(Product product);
}
