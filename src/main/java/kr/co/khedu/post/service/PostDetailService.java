package kr.co.khedu.post.service;

import java.util.ArrayList;

import kr.co.khedu.post.model.vo.CommentDto;
import kr.co.khedu.post.model.vo.PostDetailDto;
import kr.co.khedu.post.model.vo.ReplyDto;

public interface PostDetailService {

	/* 게시글 정보 조회 */
	PostDetailDto selectPostDetail(int num);

	/* 댓글 리스트 조회 */
	ArrayList<CommentDto> selectCommentList(int pNum);

	/* 대댓글 리스트 조회 (비동기식) */
	ArrayList<ReplyDto> selectReplyList(int parentNum, int postNum);

	/* 댓글 등록 */
	int insertComment(String name, String commentView, String postId);

	/* 댓글 작성 시 해당 댓글 조회 (비동기식) */
	CommentDto selectLastComment(String postId);
	
}
