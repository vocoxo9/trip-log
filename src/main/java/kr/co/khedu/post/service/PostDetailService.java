package kr.co.khedu.post.service;

import java.util.ArrayList;

import kr.co.khedu.post.model.dto.*;

public interface PostDetailService {

	/* 게시글 정보 조회 */
	PostDetailDTO selectPostDetail(int num);

	/* 댓글 리스트 조회 */
	ArrayList<CommentDTO> selectCommentList(int pNum);

	PostPairDTO getPostPair(int postId);

	/* 대댓글 리스트 조회 (비동기식) */
	ArrayList<ReplyDTO> selectReplyList(int parentNum, int postNum);

	/* 댓글 등록 */
	int insertComment(String name, String commentView, int postId);

	/* 댓글 작성 시 해당 댓글 조회 (비동기식) */
	CommentDTO selectLastComment(int postId);

	/* 해당 게시글의 전,후 게시글의 정보 조회 */
	PostDetailDTO selectPost(int pNum);

	/* 해당 게시글 삭제 요청(DELETE) */
	int deletePost(int postId);

	/* 게시글 공감버튼 클릭 시 비동기처리 (등록) */
	int insertPostLike(int memberId, int postId);

	/* 게시글 공강버튼 클릭 시 비동기처리 (조회) */
	PostLikeCountDTO selectPostLikeCount(int postId);

	/* 게시글 공감버튼 클릭 시 비동기처리 (삭제) */
	int deletePostLike(int memberId, int postId);

	/* 게시글 공감버튼 클릭 전 해당 회원이 해당 게시글을 좋아요를 했는지 확인(조회) */
	PostLikeCountDTO checkPostLike(int memberId, int postId);

	/* 댓글 공감버튼 클릭 전 해당 회원이 해당 댓글을 좋아요를 했는지 확인(조회) */
	CommentLikeCountDTO checkCommentLike(int memberId, int commentId);
	
	/* 댓글 공감버튼 클릭 시 비동기처리 (조회) */
	CommentLikeCountDTO selectCommentLikeCount(int commentId);

	/* 댓글 공감버튼 클릭 시 비동기처리 (등록) */
	int insertCommentLike(int memberId, int commentId);

	/* 댓글 공감버튼 클릭 시 비동기 처리 (삭제) */
	int deleteCommentLike(int memberId, int commentId);

	/* 댓글 수정 (UPDATE) */
	int updateComment(int memberId, int commentId, String updatedContent);

	/* 댓글 수정 후 조회 */
	CommentDTO selectUpdateComment(int commentId, int postId);

	/* 댓글 삭제 (DELETE) */
	int deleteComment(int commentId);

	
}
