package kr.co.khedu.post.service;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.post.model.dao.PostDetailDAO;
import kr.co.khedu.post.model.vo.CommentDto;
import kr.co.khedu.post.model.vo.CommentLikeCountDto;
import kr.co.khedu.post.model.vo.PostDetailDto;
import kr.co.khedu.post.model.vo.PostLikeCountDto;
import kr.co.khedu.post.model.vo.ReplyDto;
import kr.co.khedu.template.Template;

public class PostDetailServiceImpl implements PostDetailService {

	PostDetailDAO pdDao = new PostDetailDAO();
	
	@Override
	public PostDetailDto selectPostDetail(int pNum) {
		
		System.out.println("조회하는 service에서 pNum : " + pNum);
		
		SqlSession sqlSession = Template.getSqlSession();
		
		
		PostDetailDto postDetail = pdDao.selectPostDetail(sqlSession, pNum);

		
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
	public int insertComment(String name, String commentView, int postId) {

		SqlSession sqlSession = Template.getSqlSession();
		
		int result = pdDao.insertComment(sqlSession, name, commentView, postId);
		
		sqlSession.close();
		
		return result;
		
	}


	@Override
	public CommentDto selectLastComment(int postId) {
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
		
		if (post == null) {
			post = new PostDetailDto(0, "글이 없습니다@@@.", "---", 0, 0);
		}
		
		sqlSession.close();
		
		return post;
	}


	@Override
	public int deletePost(int postId) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = pdDao.deletePost(sqlSession, postId);
		
		if (result > 0) {
			// 삭제 성공!
			sqlSession.commit();
			
		} else {
			// 삭제 실패
			sqlSession.rollback();
			
		}
		
		sqlSession.close();
		
		return result;
	}


	@Override
	public int insertPostLike(int memberId, int postId) {

		SqlSession sqlSession = Template.getSqlSession();
		
		int result = pdDao.insertPostLike(sqlSession, memberId, postId);
		
		if (result > 0) {
			// 공감 등록 성공!
			sqlSession.commit();
			
		} else {
			// 공감 등록 실패
			sqlSession.rollback();
			
		}
		
		sqlSession.close();
		
		return result;
		
	}


	@Override
	public PostLikeCountDto selectPostLikeCount(int postId) {

		SqlSession sqlSession = Template.getSqlSession();
		
		PostLikeCountDto postLikeCount = pdDao.selectPostLikeCount(sqlSession, postId);
		
		sqlSession.close();
		
		return postLikeCount;
		
	}


	@Override
	public PostLikeCountDto checkPostLike(int memberId, int postId) {

		SqlSession sqlSession = Template.getSqlSession();
		
		PostLikeCountDto check = pdDao.checkPostLike(sqlSession, memberId, postId);
		
		sqlSession.close();
		
		return check;
		
	}
	

	@Override
	public int deletePostLike(int memberId, int postId) {

		SqlSession sqlSession = Template.getSqlSession();
		
		int result = pdDao.deletePostLike(sqlSession, memberId, postId);
		
		if (result > 0) {
			// 공감 삭제 성공!
			sqlSession.commit();
			
		} else {
			// 공감 삭제 실패
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
		
	}


	@Override
	public CommentLikeCountDto checkCommentLike(int memberId, int commentId) {

		SqlSession sqlSession = Template.getSqlSession();
		
		CommentLikeCountDto check = pdDao.checkCommentLike(sqlSession, memberId, commentId);
		
		sqlSession.close();
		
		return check;
		
	}


	@Override
	public int insertCommentLike(int memberId, int commentId) {

		SqlSession sqlSession = Template.getSqlSession();
		
		int result = pdDao.insertCommentLike(sqlSession, memberId, commentId);
		
		if (result > 0) {
			// 공감 등록 성공!
			sqlSession.commit();
			
		} else {
			// 공감 등록 실패
			sqlSession.rollback();
			
		}
		
		sqlSession.close();
		
		return result;
		
	}


	@Override
	public CommentLikeCountDto selectCommentLikeCount(int commentId) {

		SqlSession sqlSession = Template.getSqlSession();
		
		CommentLikeCountDto commentLikeCount = pdDao.selectCommentLikeCount(sqlSession, commentId);
		
		
		
		sqlSession.close();
		
		return commentLikeCount;
	}


	@Override
	public int deleteCommentLike(int memberId, int commentId) {

		SqlSession sqlSession = Template.getSqlSession();
		
		int result = pdDao.deleteCommentLike(sqlSession, memberId, commentId);
		
		if (result > 0) {
			// 공감 등록 성공!
			sqlSession.commit();
			
		} else {
			// 공감 등록 실패
			sqlSession.rollback();
			
		}
		
		sqlSession.close();
		
		return result;
		
	}


	@Override
	public int updateComment(int memberId, int commentId, String updatedContent) {

		SqlSession sqlSession = Template.getSqlSession();
		
		int result = pdDao.updateComment(sqlSession, memberId, commentId, updatedContent);
		
		if (result > 0) {
			// 댓글 수정 성공
			sqlSession.commit();
		} else {
			// 댓글 수정 실패
			sqlSession.rollback();
		}
		
		sqlSession.close();
		
		return result;
		
	}


	@Override
	public CommentDto selectUpdateComment(int commentId, int postId) {

		SqlSession sqlSession = Template.getSqlSession();
		
		CommentDto updateComment = pdDao.selectUpdateComment(sqlSession, commentId, postId);
		
		sqlSession.close();
		
		return updateComment;
		
	}


	@Override
	public int deleteComment(int commentId) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = pdDao.deleteComment(sqlSession, commentId);
		
		if (result > 0) {
			// 삭제 성공
			sqlSession.commit();
		} else {
			// 삭제 실패
			sqlSession.rollback();			
		}
				
		sqlSession.close();
				
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
}
