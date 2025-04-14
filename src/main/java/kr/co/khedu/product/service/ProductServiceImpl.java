package kr.co.khedu.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.common.PageInfo;
import kr.co.khedu.member.model.dto.MemberFavoriteProductDTO;
import kr.co.khedu.product.model.dao.ProductDAO;
import kr.co.khedu.product.model.dto.ProductFavoriteDTO;
import kr.co.khedu.product.model.dto.ProductListDTO;
import kr.co.khedu.product.model.dto.ProductReviewDTO;
import kr.co.khedu.product.model.dto.ProductSearchDTO;
import kr.co.khedu.product.model.vo.Product;
import kr.co.khedu.product.model.vo.Review;
import kr.co.khedu.template.Template;

public class ProductServiceImpl implements ProductService {

	// 상품 전체 조회
	@Override
	public List<Product> selectProductList() {
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Product> pList = new ProductDAO().selectProductList(sqlSession);
		
		sqlSession.close();
		
		return pList;
	}

	// 상품 아이디로 상품 조회
	@Override
	public Product selectProductByProductId(int productId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Product product = new ProductDAO().selectProductByProductId(sqlSession, productId);
		
		sqlSession.close();
		
		return product;
	}

	// 상품 전체 갯수 조회
	@Override
	public int selectByProductNameCount(ProductSearchDTO productSearchDTO) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = new ProductDAO().selectByProductNameCount(sqlSession, productSearchDTO);

		sqlSession.close();
		
		return listCount;
	}

	// 페이지 정보와 키워드 값으로 상품 조회
	@Override
	public List<ProductListDTO> selectByProductName(ProductSearchDTO productSearchDTO, PageInfo pageInfo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		List<ProductListDTO> productList = new ProductDAO().findByProductNameLike(sqlSession, productSearchDTO, pageInfo);
		
		sqlSession.close();
		
		return productList;
	}
	
	// 상품 등록 기능
	@Override
	public int insertProduct(Product product) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = new ProductDAO().insertProduct(sqlSession, product);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}

	// 상품 삭제 기능
	@Override
	public int deleteProduct(int productId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = new ProductDAO().deleteProduct(sqlSession, productId);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}

	// 상품 리뷰 등록 기능
	@Override
	public int insertProductReview(Review review) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = new ProductDAO().insertProductReview(sqlSession, review);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public double selectProductReview(int productId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		double reviewScore = new ProductDAO().selectProductReview(sqlSession, productId);
		
		sqlSession.close();
		
		return reviewScore;
	}

	@Override
	public int updateProduct(Product product) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = new ProductDAO().updateProduct(sqlSession, product);
		
		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public List<ProductReviewDTO> selectProductReviewMemberList(int productId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		List<ProductReviewDTO> productReviewMemberList = new ProductDAO().selectProductReviewMemberList(sqlSession, productId);
		
		for(ProductReviewDTO pr : productReviewMemberList) {
			System.out.println("pr : " + pr);
		}
		
		sqlSession.close();
		
		return productReviewMemberList;
	}

	@Override
	public int insertProductFavorite(ProductFavoriteDTO productFavoriteDTO) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = new ProductDAO().insertProductFavoirte(sqlSession, productFavoriteDTO);

		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public ProductFavoriteDTO selectProductFavoriteChecked(ProductFavoriteDTO productFavoriteDTO) {
		SqlSession sqlSession = Template.getSqlSession();
		
		ProductFavoriteDTO result = new ProductDAO().selectProductFavoriteChecked(sqlSession, productFavoriteDTO);
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public int deleteProductFavoirte(ProductFavoriteDTO productFavoriteDTO) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = new ProductDAO().deleteProductFavoirte(sqlSession, productFavoriteDTO);

		if(result > 0) {
			sqlSession.commit();
		}
		
		sqlSession.close();
		
		return result;
	}

	// 내 상품 찜 데이터 수 조회
	@Override
	public int selectMyProductFavoriteCount(int memberId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int count = new ProductDAO().selectMyProductFavoriteCount(sqlSession, memberId);
		
		sqlSession.close();
		
		return count;
	}

	@Override
	public List<MemberFavoriteProductDTO> selectMyProductFavorite(int memberId, PageInfo pageInfo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		List<MemberFavoriteProductDTO> myProductFavoriteList = new ProductDAO().selectMyProductFavorite(sqlSession, memberId, pageInfo);
		
		sqlSession.close();
		
		return myProductFavoriteList;
	}

}
