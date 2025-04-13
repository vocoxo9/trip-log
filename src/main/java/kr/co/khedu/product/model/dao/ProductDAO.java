package kr.co.khedu.product.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.common.PageInfo;
import kr.co.khedu.product.model.dto.ProductListDTO;
import kr.co.khedu.product.model.dto.ProductReviewDTO;
import kr.co.khedu.product.model.dto.ProductSearchDTO;
import kr.co.khedu.product.model.vo.Product;
import kr.co.khedu.product.model.vo.Review;

public class ProductDAO {

	// 상품 목록 조회
	public List<Product> selectProductList(SqlSession sqlSession) {
		return sqlSession.selectList("productMapper.selectProductList");
	}

	// 상품 아이디로 상품 조회 (상세페이지)
	public Product selectProductByProductId(SqlSession sqlSession, int productId) {
		return sqlSession.selectOne("productMapper.selectProductByProductId", productId);
	}

	// 상품 전체 갯수 조회
	public int selectByProductNameCount(SqlSession sqlSession, ProductSearchDTO productSearchDTO) {
		return sqlSession.selectOne("productMapper.selectByProductNameCount", productSearchDTO);
	}

	// 페이지 정보로 상품 데이터 조회
	public List<ProductListDTO> findByProductNameLike(SqlSession sqlSession, ProductSearchDTO productSearchDTO, PageInfo pageInfo) {
		int offset = (pageInfo.getCurrentPageNo() - 1) * pageInfo.getItemLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getItemLimit());
		
		return sqlSession.selectList("productMapper.findByProductNameLike", productSearchDTO, rowBounds);
	}

	// 상품 등록
	public int insertProduct(SqlSession sqlSession, Product product) {
		return sqlSession.insert("productMapper.insertProduct", product);
	}

	// 상품 삭제
	public int deleteProduct(SqlSession sqlSession, int productId) {
		return sqlSession.delete("productMapper.deleteProduct", productId);
	}

	// 상품 리뷰 등록
	public int insertProductReview(SqlSession sqlSession, Review review) {
		return sqlSession.insert("productMapper.insertProductReview", review);
	}

	// 상품 리뷰 조회
	public double selectProductReview(SqlSession sqlSession, int productId) {
		return sqlSession.selectOne("productMapper.selectProductReview", productId);
	}
	
	// 상품 리뷰 작성한 회원 목록
	public List<ProductReviewDTO> selectProductReviewMemberList(SqlSession sqlSession, int productId) {
		return sqlSession.selectList("productMapper.selectProductReviewMemberList", productId);
	}

	// 상품 수정
	public int updateProduct(SqlSession sqlSession, Product product) {
		return sqlSession.update("productMapper.updateProduct", product);
	}
}
