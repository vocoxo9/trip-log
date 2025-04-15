package kr.co.khedu.post.model.dao;

import java.util.ArrayList;
import java.util.HashMap;

import kr.co.khedu.post.model.dto.*;
import org.apache.ibatis.session.SqlSession;

public class PostDetailDAO {

	public PostDetailDTO selectPostDetail(SqlSession sqlSession, int pNum) {

		System.out.println("조회하는 DAO에서 pNum : " + pNum);

		PostDetailDTO postDetail = sqlSession.selectOne("postMapper.searchPostDetail", pNum);


		return postDetail;

	}

	public PostPairDTO getPostPair(SqlSession sqlSession, int postId) {

		return sqlSession.selectOne("postMapper.getPostPair", postId);
	}

	public ArrayList<CommentDTO> selectCommentList(SqlSession sqlSession, int pNum) {
		System.out.println("DAO로 요청은 들어옴");

		ArrayList<CommentDTO> comments = (ArrayList)sqlSession.selectList("postMapper.selectCommentList", pNum);

		return comments;
	}

	public ArrayList<ReplyDTO> selectReplyList(SqlSession sqlSession, int parentNum, int postNum) {

		HashMap hashMap = new HashMap();
		hashMap.put("parentNum", parentNum);
		hashMap.put("postNum", postNum);

		ArrayList<ReplyDTO> replys = (ArrayList)sqlSession.selectList("postMapper.selectReplyList", hashMap);


		return replys;
	}

	public int insertComment(SqlSession sqlSession, String name, String content, int postId) {

		HashMap hashMap = new HashMap();
		hashMap.put("name", name);
		hashMap.put("content", content);
		hashMap.put("postId", postId);

		System.out.println("memberId: " + name);
		System.out.println("content: " + content);
		System.out.println("postId:" + postId);

		int result = sqlSession.insert("postMapper.insertComment", hashMap);

		System.out.println("@@DAO에서 요청 후 서비스에서 반환받긴함");

		if (result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}

		return result;
	}

	public CommentDTO selectLastComment(SqlSession sqlSession, int postId) {

		CommentDTO lastComment = sqlSession.selectOne("postMapper.selectLastComment", postId);
		System.out.println("DAO에서 전달받은 postId" + postId);
		System.out.println("DAO에서 DB처리 후 : " + lastComment);

		return lastComment;
	}

	public PostDetailDTO selectPost(SqlSession sqlSession, int pNum) {

		PostDetailDTO post = sqlSession.selectOne("postMapper.selectPost", pNum);

		return post;
	}

	public int deletePost(SqlSession sqlSession, int postId) {

		int result = sqlSession.delete("postMapper.deletePost", postId);

		return result;
	}

	public int insertPostLike(SqlSession sqlSession, int memberId, int postId) {

		HashMap hashMap = new HashMap();
		hashMap.put("memberId", memberId);
		hashMap.put("postId", postId);
		System.out.println("공감등록에서 DAO memberId : " + memberId);
		System.out.println("공감등록에서 DAO postId : " + postId);

		int result = sqlSession.insert("postMapper.insertPostLike", hashMap);

		return result;

	}

	public PostLikeCountDTO selectPostLikeCount(SqlSession sqlSession, int postId) {

		PostLikeCountDTO postLikeCount = (PostLikeCountDTO)sqlSession.selectOne("postMapper.selectPostLikeCount", postId);

		return postLikeCount;

	}

	public PostLikeCountDTO checkPostLike(SqlSession sqlSession, int memberId, int postId) {

		HashMap hashMap = new HashMap();
		hashMap.put("memberId", memberId);
		hashMap.put("postId", postId);

		PostLikeCountDTO check = (PostLikeCountDTO)sqlSession.selectOne("postMapper.checkPostLike", hashMap);

		return check;

	}

	public CommentLikeCountDTO checkCommentLike(SqlSession sqlSession, int memberId, int commentId) {

		HashMap hashMap = new HashMap();
		hashMap.put("memberId", memberId);
		hashMap.put("commentId", commentId);

		CommentLikeCountDTO check = (CommentLikeCountDTO)sqlSession.selectOne("postMapper.checkCommentLike", hashMap);

		return check;
	}

	public int deletePostLike(SqlSession sqlSession, int memberId, int postId) {

		HashMap hashMap = new HashMap();
		hashMap.put("memberId", memberId);
		hashMap.put("postId", postId);
		System.out.println("게시글공감 삭제에서 DAO memberId : " + memberId);
		System.out.println("게시글공감 삭제에서 DAO postId : " + postId);

		int result = sqlSession.insert("postMapper.deletePostLike", hashMap);

		return result;

	}

	public int insertCommentLike(SqlSession sqlSession, int memberId, int commentId) {

		HashMap hashMap = new HashMap();
		hashMap.put("memberId", memberId);
		hashMap.put("commentId", commentId);
		System.out.println("공감등록에서 DAO memberId : " + memberId);
		System.out.println("공감등록에서 DAO postId : " + commentId);

		int result = sqlSession.insert("postMapper.insertCommentLike", hashMap);

		return result;

	}

	public CommentLikeCountDTO selectCommentLikeCount(SqlSession sqlSession, int commentId) {

		CommentLikeCountDTO commentLikeCount = (CommentLikeCountDTO)sqlSession.selectOne("postMapper.selectCommentLikeCount", commentId);

		return commentLikeCount;

	}

	public int deleteCommentLike(SqlSession sqlSession, int memberId, int commentId) {

		HashMap hashMap = new HashMap();
		hashMap.put("memberId", memberId);
		hashMap.put("commentId", commentId);
		System.out.println("공감삭제에서 DAO memberId : " + memberId);
		System.out.println("공감삭제에서 DAO commentId : " + commentId);

		int result = sqlSession.insert("postMapper.deleteCommentLike", hashMap);

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

		int result = sqlSession.update("postMapper.updateComment", hashMap);

		return result;

	}

	public CommentDTO selectUpdateComment(SqlSession sqlSession, int commentId, int postId) {

		HashMap hashMap = new HashMap();
		hashMap.put("commentId", commentId);
		hashMap.put("postId", postId);

		CommentDTO updateComment = sqlSession.selectOne("postMapper.selectUpdateComment", hashMap);

		return updateComment;

	}

	public int deleteComment(SqlSession sqlSession, int commentId) {

		int result = sqlSession.delete("postMapper.deleteComment", commentId);

		return result;
	}



}
