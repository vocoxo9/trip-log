package kr.co.khedu.product.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.common.PageInfo;
import kr.co.khedu.product.model.dao.ProductDAO;
import kr.co.khedu.product.model.dto.ProductListDTO;
import kr.co.khedu.product.model.dto.ProductSearchDTO;
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
	 * @param productSearchDTO
	 * @return
	 */
	@Override
	public int selectByProductNameCount(ProductSearchDTO productSearchDTO) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int listCount = new ProductDAO().selectByProductNameCount(sqlSession, productSearchDTO);

		sqlSession.close();
		
		return listCount;
	}

	/** 페이지 정보와 키워드 값으로 상품 조회
	 * 
	 * @param productSearchDTO
	 * @param pageInfo
	 * @return
	 */
	@Override
	public List<ProductListDTO> selectByProductName(ProductSearchDTO productSearchDTO, PageInfo pageInfo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		List<ProductListDTO> productList = new ProductDAO().findByProductNameLike(sqlSession, productSearchDTO, pageInfo);
		
		sqlSession.close();
		
		return productList;
  }
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

}
