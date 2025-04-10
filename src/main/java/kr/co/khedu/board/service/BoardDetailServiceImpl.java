package kr.co.khedu.board.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.board.model.dao.BoardDetailDAO;
import kr.co.khedu.board.model.vo.BoardDetailDto;
import kr.co.khedu.board.model.vo.CommentDto;
import kr.co.khedu.board.model.vo.ReplyDto;
import kr.co.khedu.template.Template;

public class BoardDetailServiceImpl implements BoardDetailService {

	BoardDetailDAO bdDao = new BoardDetailDAO();
	
	@Override
	public BoardDetailDto selectBoardDetail(int num) {
		
		
		SqlSession sqlSession = Template.getSqlSession();
		
		
		BoardDetailDto boardDetail = bdDao.selectBoardDetail(sqlSession, num);

		
		sqlSession.close();
		
		
		return boardDetail;
	}

	
	@Override
	public ArrayList<CommentDto> selectCommentList(int pNum) {
		System.out.println("서비스로 요청은 들어옴");
		
		SqlSession sqlSession = Template.getSqlSession();
		System.out.println("sqlSession 객체 생성까지 함");

		ArrayList<CommentDto> comments = bdDao.selectCommentList(sqlSession, pNum);
		System.out.println("DAO로 요청후 반환받음");
		
		sqlSession.close();
		
		return comments;
	}

	
	@Override
	public ArrayList<ReplyDto> selectReplyList(int parentNum, int postNum) {

		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<ReplyDto> replys = bdDao.selectReplyList(sqlSession, parentNum, postNum);

		sqlSession.close();
		
		return replys;
	}

	
	
	
}
