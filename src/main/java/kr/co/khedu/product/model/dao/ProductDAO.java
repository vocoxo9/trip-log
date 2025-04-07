package kr.co.khedu.product.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.product.model.vo.Product;

public class ProductDAO {

	public List<Product> selectProductList(SqlSession sqlSession) {
		return sqlSession.selectList("productMapper.selectProductList");
	}

	public Product selectProductByProductId(SqlSession sqlSession, int productId) {
		return sqlSession.selectOne("productMapper.selectProductByProductId", productId);
	}

}
