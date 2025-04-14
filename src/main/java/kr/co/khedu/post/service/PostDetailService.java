package kr.co.khedu.post.service;

import java.util.ArrayList;

import kr.co.khedu.post.model.vo.CommentDto;
import kr.co.khedu.post.model.vo.PostDetailDto;
import kr.co.khedu.post.model.vo.PostLikeCountDto;
import kr.co.khedu.post.model.vo.ReplyDto;
import kr.co.khedu.post.model.vo.CommentLikeCountDto;

public interface PostDetailService {

	/* 게시글 정보 조회 */
	PostDetailDto selectPostDetail(int num);

	/* 댓글 리스트 조회 */
	ArrayList<CommentDto> selectCommentList(int pNum);

	/* 대댓글 리스트 조회 (비동기식) */
	ArrayList<ReplyDto> selectReplyList(int parentNum, int postNum);

	/* 댓글 등록 */
	int insertComment(String name, String commentView, int postId);

	/* 댓글 작성 시 해당 댓글 조회 (비동기식) */
	CommentDto selectLastComment(int postId);

	/* 해당 게시글의 전,후 게시글의 정보 조회 */
	PostDetailDto selectPost(int pNum);

	/* 해당 게시글 삭제 요청(DELETE) */
	int deletePost(int postId);

	/* 게시글 공감버튼 클릭 시 비동기처리 (등록) */
	int insertPostLike(int memberId, int postId);

	/* 게시글 공강버튼 클릭 시 비동기처리 (조회) */
	PostLikeCountDto selectPostLikeCount(int postId);

	/* 게시글 공감버튼 클릭 시 비동기처리 (삭제) */
	int deletePostLike(int memberId, int postId);

	/* 게시글 공감버튼 클릭 전 해당 회원이 해당 게시글을 좋아요를 했는지 확인(조회) */
	PostLikeCountDto checkPostLike(int memberId, int postId);

	/* 댓글 공감버튼 클릭 전 해당 회원이 해당 댓글을 좋아요를 했는지 확인(조회) */
	CommentLikeCountDto checkCommentLike(int memberId, int commentId);
	
	/* 댓글 공감버튼 클릭 시 비동기처리 (조회) */
	CommentLikeCountDto selectCommentLikeCount(int commentId);

	/* 댓글 공감버튼 클릭 시 비동기처리 (등록) */
	int insertCommentLike(int memberId, int commentId);

	/* 댓글 공감버튼 클릭 시 비동기 처리 (삭제) */
	int deleteCommentLike(int memberId, int commentId);

	/* 댓글 수정 (UPDATE) */
	int updateComment(int memberId, int commentId, String updatedContent);

	/* 댓글 수정 후 조회 */
	CommentDto selectUpdateComment(int commentId, int postId);

	/* 댓글 삭제 (DELETE) */
	int deleteComment(int commentId);

	
}
