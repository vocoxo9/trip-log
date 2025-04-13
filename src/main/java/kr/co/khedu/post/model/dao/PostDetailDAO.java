package kr.co.khedu.post.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.post.model.vo.CommentDto;
import kr.co.khedu.post.model.vo.CommentLikeCountDto;
import kr.co.khedu.post.model.vo.PostDetailDto;
import kr.co.khedu.post.model.vo.PostLikeCountDto;
import kr.co.khedu.post.model.vo.ReplyDto;

public class PostDetailDAO {

	public PostDetailDto selectPostDetail(SqlSession sqlSession, int pNum) {
		
		System.out.println("조회하는 DAO에서 pNum : " + pNum);
		
		PostDetailDto postDetail = sqlSession.selectOne("postDetailMapper.searchPostDetail", pNum);
		
		
		return postDetail;
		
	}

	public ArrayList<CommentDto> selectCommentList(SqlSession sqlSession, int pNum) {
		System.out.println("DAO로 요청은 들어옴");

		ArrayList<CommentDto> comments = (ArrayList)sqlSession.selectList("postDetailMapper.selectCommentList", pNum);
		
		return comments;
	}

	public ArrayList<ReplyDto> selectReplyList(SqlSession sqlSession, int parentNum, int postNum) {

		HashMap hashMap = new HashMap();
		hashMap.put("parentNum", parentNum);
		hashMap.put("postNum", postNum);
		
		ArrayList<ReplyDto> replys = (ArrayList)sqlSession.selectList("postDetailMapper.selectReplyList", hashMap);
		
		
		return replys;
	}

	public int insertComment(SqlSession sqlSession, String name, String commentView, int postId) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("name", name);
		hashMap.put("commentView", commentView);
		hashMap.put("postId", postId);
		
		int result = sqlSession.insert("postDetailMapper.insertComment", hashMap);
		
		System.out.println("@@DAO에서 요청 후 서비스에서 반환받긴함");
		
		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	public CommentDto selectLastComment(SqlSession sqlSession, int postId) {
		
		CommentDto lastComment = sqlSession.selectOne("postDetailMapper.selectLastComment", postId);
		System.out.println("DAO에서 전달받은 postId" + postId);
		System.out.println("DAO에서 DB처리 후 : " + lastComment);
		
		return lastComment;
	}

	public PostDetailDto selectPost(SqlSession sqlSession, int pNum) {
		
		PostDetailDto post = sqlSession.selectOne("postDetailMapper.selectPost", pNum);
		
		return post;
	}

	public int deletePost(SqlSession sqlSession, int postId) {

		int result = sqlSession.delete("postDetailMapper.deletePost", postId);
		
		return result;
	}
	
	public int insertPostLike(SqlSession sqlSession, int memberId, int postId) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("memberId", memberId);
		hashMap.put("postId", postId);
		System.out.println("공감등록에서 DAO memberId : " + memberId);
		System.out.println("공감등록에서 DAO postId : " + postId);
		
		int result = sqlSession.insert("postDetailMapper.insertPostLike", hashMap);
		
		return result;
		
	}
	
	public PostLikeCountDto selectPostLikeCount(SqlSession sqlSession, int postId) {
		
		PostLikeCountDto postLikeCount = (PostLikeCountDto)sqlSession.selectOne("postDetailMapper.selectPostLikeCount", postId);
		
		return postLikeCount;
		
	}
	
	public PostLikeCountDto checkPostLike(SqlSession sqlSession, int memberId, int postId) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("memberId", memberId);
		hashMap.put("postId", postId);
		
		PostLikeCountDto check = (PostLikeCountDto)sqlSession.selectOne("postDetailMapper.checkPostLike", hashMap);
		
		return check;
		
	}
	
	public CommentLikeCountDto checkCommentLike(SqlSession sqlSession, int memberId, int commentId) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("memberId", memberId);
		hashMap.put("commentId", commentId);
		
		CommentLikeCountDto check = (CommentLikeCountDto)sqlSession.selectOne("postDetailMapper.checkCommentLike", hashMap);
		
		return check;
	}
	
	public int deletePostLike(SqlSession sqlSession, int memberId, int postId) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("memberId", memberId);
		hashMap.put("postId", postId);
		System.out.println("게시글공감 삭제에서 DAO memberId : " + memberId);
		System.out.println("게시글공감 삭제에서 DAO postId : " + postId);
		
		int result = sqlSession.insert("postDetailMapper.deletePostLike", hashMap);
		
		return result;
		
	}
	
	public int insertCommentLike(SqlSession sqlSession, int memberId, int commentId) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("memberId", memberId);
		hashMap.put("commentId", commentId);
		System.out.println("공감등록에서 DAO memberId : " + memberId);
		System.out.println("공감등록에서 DAO postId : " + commentId);
		
		int result = sqlSession.insert("postDetailMapper.insertCommentLike", hashMap);
		
		return result;
		
	}
	
	public CommentLikeCountDto selectCommentLikeCount(SqlSession sqlSession, int commentId) {
		
		CommentLikeCountDto commentLikeCount = (CommentLikeCountDto)sqlSession.selectOne("postDetailMapper.selectCommentLikeCount", commentId);
		
		return commentLikeCount;
		
	}
	
	public int deleteCommentLike(SqlSession sqlSession, int memberId, int commentId) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("memberId", memberId);
		hashMap.put("commentId", commentId);
		System.out.println("공감삭제에서 DAO memberId : " + memberId);
		System.out.println("공감삭제에서 DAO commentId : " + commentId);
		
		int result = sqlSession.insert("postDetailMapper.deleteCommentLike", hashMap);
		
		return result;
		
	}

	public int updateComment(SqlSession sqlSession, int memberId, int commentId, String updatedContent) {

		HashMap hashMap = new HashMap();
		hashMap.put("memberId", memberId);
		hashMap.put("commentId", commentId);
		hashMap.put("updatedContent", updatedContent);
		System.out.println("댓글수정에서 DAO memberId : " + memberId);
		System.out.println("댓글수정에서 DAO commentId : " + commentId);
		System.out.println("댓글수정에서 DAO updatedContent : " + updatedContent);
		
		int result = sqlSession.update("postDetailMapper.updateComment", hashMap);
		
		return result;
		
	}

	public CommentDto selectUpdateComment(SqlSession sqlSession, int commentId, int postId) {

		HashMap hashMap = new HashMap();
		hashMap.put("commentId", commentId);
		hashMap.put("postId", postId);
		
		CommentDto updateComment = sqlSession.selectOne("postDetailMapper.selectUpdateComment", hashMap);
		
		return updateComment;
		
	}
	
	

}
