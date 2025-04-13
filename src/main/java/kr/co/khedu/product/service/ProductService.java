package kr.co.khedu.product.service;

import java.util.List;

import kr.co.khedu.common.PageInfo;
import kr.co.khedu.member.model.dto.MemberFavoriteProductDTO;
import kr.co.khedu.product.model.dto.ProductFavoriteDTO;
import kr.co.khedu.product.model.dto.ProductListDTO;
import kr.co.khedu.product.model.dto.ProductReviewDTO;
import kr.co.khedu.product.model.dto.ProductSearchDTO;
import kr.co.khedu.product.model.vo.Product;
import kr.co.khedu.product.model.vo.Review;

public interface ProductService {
	// 상품 목록 조회(날짜순)
	List<Product> selectProductList();

	// 상품 번호로 상품 조회
	Product selectProductByProductId(int productId);

	// 상품 전체 갯수 조회
	int selectByProductNameCount(ProductSearchDTO productSearchDTO);

	// 페이지 정보와 키워드 값으로 상품 조회
	List<ProductListDTO> selectByProductName(ProductSearchDTO productSearchDTO, PageInfo pageInfo);
	
	// 상품 등록 
	int insertProduct(Product product);

	// 상품 삭제 기능
	int deleteProduct(int productId);

	// 리뷰 등록
	int insertProductReview(Review review);

	// 리뷰 조회
	double selectProductReview(int productId);

	// 상품 수정
	int updateProduct(Product product);

	// 리뷰 작성한 회원 조회
	List<ProductReviewDTO> selectProductReviewMemberList(int productId);

	// 상품 찜 기능
	int insertProductFavoirte(ProductFavoriteDTO productFavoriteDTO);

	// 해당 회원이 해당 상품을 찜 했는지 조회
	ProductFavoriteDTO selectProductFavoriteChecked(ProductFavoriteDTO productFavoriteDTO);

	// 상품 찜 취소
	int deleteProductFavoirte(ProductFavoriteDTO productFavoriteDTO);

	// 내 상품 찜 목록 조회
	List<MemberFavoriteProductDTO> selectMyProductFavorite(int memberId, PageInfo pageInfo);

	// 내 상품 찜 목록 수 조회
	int selectMyProductFavoriteCount(int memberId);

}
