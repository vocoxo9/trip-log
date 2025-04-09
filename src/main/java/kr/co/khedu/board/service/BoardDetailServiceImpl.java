package kr.co.khedu.board.service;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.board.model.dao.BoardDetailDAO;
import kr.co.khedu.board.model.vo.BoardDetail;
import kr.co.khedu.template.Template;

public class BoardDetailServiceImpl implements BoardDetailService {

	BoardDetailDAO bdDao = new BoardDetailDAO();
	
	@Override
	public BoardDetail selectBoardDetail(int num) {
		
		System.out.println("서비스로 요청은 들어옴");
		
		SqlSession sqlSession = Template.getSqlSession();
		
		System.out.println("sqlSession 객체 생성까지 함");
		
		BoardDetail boardDetail = bdDao.selectBoardDetail(sqlSession, num);

		System.out.println("DAO로 요청후 반환받음");
		
		sqlSession.close();
		
		
		return boardDetail;
	}

}
