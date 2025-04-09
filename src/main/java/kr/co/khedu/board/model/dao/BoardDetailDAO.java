package kr.co.khedu.board.model.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.board.model.vo.BoardDetail;

public class BoardDetailDAO {

	public BoardDetail selectBoardDetail(SqlSession sqlSession, int num) {
		
		System.out.println("DAO로 요청은 들어옴");
		
		BoardDetail boardDetail = sqlSession.selectOne("boardDetailMapper.searchBoardDetail", num);
		
		System.out.println("@@DAO에서 요청 후 DB처리까지는 됨");
		
		return boardDetail;
		
	}

}
