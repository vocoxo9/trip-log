package kr.co.khedu.board.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.board.model.vo.BoardDetailDto;
import kr.co.khedu.board.model.vo.CommentDto;
import kr.co.khedu.board.model.vo.ReplyDto;

public class BoardDetailDAO {

	public BoardDetailDto selectBoardDetail(SqlSession sqlSession, int num) {
		
		
		BoardDetailDto boardDetail = sqlSession.selectOne("boardDetailMapper.searchBoardDetail", num);
		
		
		return boardDetail;
		
	}

	public ArrayList<CommentDto> selectCommentList(SqlSession sqlSession, int pNum) {
		System.out.println("DAO로 요청은 들어옴");

		ArrayList<CommentDto> comments = (ArrayList)sqlSession.selectList("boardDetailMapper.selectCommentList", pNum);
		
		return comments;
	}

	public ArrayList<ReplyDto> selectReplyList(SqlSession sqlSession, int parentNum, int postNum) {

		HashMap hashMap = new HashMap();
		hashMap.put("parentNum", parentNum);
		hashMap.put("postNum", postNum);
		
		ArrayList<ReplyDto> replys = (ArrayList)sqlSession.selectList("boardDetailMapper.selectReplyList", hashMap);
		
		
		return replys;
	}

	public int insertComment(SqlSession sqlSession, String name, String commentView, String postId) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("name", name);
		hashMap.put("commentView", commentView);
		hashMap.put("postId", postId);
		
		int result = sqlSession.insert("boardDetailMapper.insertComment", hashMap);
		
		System.out.println("@@DAO에서 요청 후 서비스에서 반환받긴함");
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	public CommentDto selectLastComment(SqlSession sqlSession, String postId) {
		
		CommentDto lastComment = sqlSession.selectOne("boardDetailMapper.selectLastComment", postId);
		System.out.println("DAO에서 DB처리 후 ");
		
		return lastComment;
	}

}
