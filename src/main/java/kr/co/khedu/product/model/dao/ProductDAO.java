package kr.co.khedu.product.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.common.PageInfo;
import kr.co.khedu.product.model.vo.Product;

public class ProductDAO {

	public List<Product> selectProductList(SqlSession sqlSession) {
		return sqlSession.selectList("productMapper.selectProductList");
	}

	public Product selectProductByProductId(SqlSession sqlSession, int productId) {
		return sqlSession.selectOne("productMapper.selectProductByProductId", productId);
	}

	/** 상품 전체 갯수 조회
	 * @param sqlSession
	 * @param keyword
	 * @return
	 */
	public int selectByProductNameCount(SqlSession sqlSession, String keyword) {
		return sqlSession.selectOne("productMapper.selectByProductNameCount", keyword);
	}

	/** 페이지 정보로 상품 데이터 조회
	 * 
	 * @param sqlSession
	 * @param keyword 
	 * @param pageInfo
	 * @return
	 */
	public List<Product> findByProductNameLike(SqlSession sqlSession, String keyword, PageInfo pageInfo) {
		int offset = (pageInfo.getCurrentPageNo() - 1) * pageInfo.getItemLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getItemLimit());
		
		return sqlSession.selectList("productMapper.findByProductNameLike", keyword, rowBounds);
	}

}
