package kr.co.khedu.product.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.common.PageInfo;
import kr.co.khedu.product.model.dto.ProductListDTO;
import kr.co.khedu.product.model.dto.ProductSearchDTO;
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
	 * @param productSearchDTO
	 * @return
	 */
	public int selectByProductNameCount(SqlSession sqlSession, ProductSearchDTO productSearchDTO) {
		return sqlSession.selectOne("productMapper.selectByProductNameCount", productSearchDTO);
	}

	/** 페이지 정보로 상품 데이터 조회
	 * 
	 * @param sqlSession
	 * @param productSearchDTO 
	 * @param pageInfo
	 * @return
	 */
	public List<ProductListDTO> findByProductNameLike(SqlSession sqlSession, ProductSearchDTO productSearchDTO, PageInfo pageInfo) {
		int offset = (pageInfo.getCurrentPageNo() - 1) * pageInfo.getItemLimit();
		RowBounds rowBounds = new RowBounds(offset, pageInfo.getItemLimit());
		
		return sqlSession.selectList("productMapper.findByProductNameLike", productSearchDTO, rowBounds);
	}

	public int insertProduct(SqlSession sqlSession, Product product) {
		return sqlSession.insert("productMapper.insertProduct", product);
	}

	public int deleteProduct(SqlSession sqlSession, int productId) {
		return sqlSession.delete("productMapper.deleteProduct", productId);
	}
}
