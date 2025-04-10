package kr.co.khedu.board.service;

import java.util.ArrayList;

import kr.co.khedu.board.model.vo.BoardDetailDto;
import kr.co.khedu.board.model.vo.CommentDto;
import kr.co.khedu.board.model.vo.ReplyDto;

public interface BoardDetailService {

	/* 게시글 정보 조회 */
	BoardDetailDto selectBoardDetail(int num);

	/* 댓글 리스트 조회 */
	ArrayList<CommentDto> selectCommentList(int pNum);

	/* 대댓글 리스트 조회 (비동기식) */
	ArrayList<ReplyDto> selectReplyList(int parentNum, int postNum);

	/* 댓글 등록 */
	int insertComment(String name, String commentView, String postId);

	/* 댓글 작성 시 해당 댓글 조회 (비동기식) */
	CommentDto selectLastComment(String postId);
	
}
