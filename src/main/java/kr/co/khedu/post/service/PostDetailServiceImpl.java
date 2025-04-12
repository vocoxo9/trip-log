package kr.co.khedu.post.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.post.model.dao.PostDetailDAO;
import kr.co.khedu.post.model.vo.CommentDto;
import kr.co.khedu.post.model.vo.PostDetailDto;
import kr.co.khedu.post.model.vo.ReplyDto;
import kr.co.khedu.template.Template;

public class PostDetailServiceImpl implements PostDetailService {

	PostDetailDAO pdDao = new PostDetailDAO();
	
	@Override
	public PostDetailDto selectPostDetail(int num) {
		
		
		SqlSession sqlSession = Template.getSqlSession();
		
		
		PostDetailDto postDetail = pdDao.selectPostDetail(sqlSession, num);

		
		sqlSession.close();
		
		
		return postDetail;
	}

	
	@Override
	public ArrayList<CommentDto> selectCommentList(int pNum) {
		System.out.println("서비스로 요청은 들어옴");
		
		SqlSession sqlSession = Template.getSqlSession();
		System.out.println("sqlSession 객체 생성까지 함");

		ArrayList<CommentDto> comments = pdDao.selectCommentList(sqlSession, pNum);
		System.out.println("DAO로 요청후 반환받음");
		
		sqlSession.close();
		
		return comments;
	}

	
	@Override
	public ArrayList<ReplyDto> selectReplyList(int parentNum, int postNum) {

		SqlSession sqlSession = Template.getSqlSession();
		
		ArrayList<ReplyDto> replys = pdDao.selectReplyList(sqlSession, parentNum, postNum);

		sqlSession.close();
		
		return replys;
	}


	@Override
	public int insertComment(String name, String commentView, String postId) {

		SqlSession sqlSession = Template.getSqlSession();
		
		int result = pdDao.insertComment(sqlSession, name, commentView, postId);
		
		sqlSession.close();
		
		return result;
		
	}


	@Override
	public CommentDto selectLastComment(String postId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		System.out.println("Service요청 들어왔구여");

		CommentDto lastComment = pdDao.selectLastComment(sqlSession, postId);
		
		System.out.println("반환받았구여");
		
		sqlSession.close();
		
		return lastComment;
	}


	@Override
	public PostDetailDto selectPost(int pNum) {
		SqlSession sqlSession = Template.getSqlSession();
		
		PostDetailDto post = pdDao.selectPost(sqlSession, pNum);
		
		sqlSession.close();
		
		return post;
	}
	
	
	
	

	
	
	
}
