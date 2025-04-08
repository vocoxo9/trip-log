package kr.co.khedu.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.common.PageInfo;
import kr.co.khedu.product.model.dao.ProductDAO;
import kr.co.khedu.product.model.vo.Product;
import kr.co.khedu.template.Template;

public class ProductServiceImpl implements ProductService {

	@Override
	public List<Product> selectProductList() {
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Product> pList = new ProductDAO().selectProductList(sqlSession);
		
		sqlSession.close();
		
		return pList;
	}

	@Override
	public Product selectProductByProductId(int productId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Product product = new ProductDAO().selectProductByProductId(sqlSession, productId);
		
		sqlSession.close();
		
		return product;
	}

	/** 상품 전체 갯수 조회
	 * @param keyword
	 * @return
	 */
	public int selectByProductNameCount(String keyword) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = new ProductDAO().selectByProductNameCount(sqlSession, keyword);

		sqlSession.close();
		
		return listCount;
	}

	/** 페이지 정보와 키워드 값으로 상품 조회
	 * 
	 * @param keyword
	 * @param pageInfo
	 * @return
	 */
	public List<Product> selectByProductName(String keyword, PageInfo pageInfo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		List<Product> productList = new ProductDAO().findByProductNameLike(sqlSession, keyword, pageInfo);
		
		sqlSession.close();
		
		return productList;
	}

}
