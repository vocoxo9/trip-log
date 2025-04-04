package kr.co.khedu.template;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Template {
	public static SqlSession getSqlSession() {
		
		SqlSession sqlSession = null;
		
		String resource = "/mybatis-config.xml";

		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
			
			sqlSession = sqlSessionFactory.openSession();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sqlSession;
	}
}
