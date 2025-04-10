package kr.co.khedu.board.service;

import java.util.ArrayList;

import kr.co.khedu.board.model.vo.BoardDetailDto;
import kr.co.khedu.board.model.vo.CommentDto;

public interface BoardDetailService {

	/* 게시글 정보 조회 */
	BoardDetailDto selectBoardDetail(int num);

	/* 댓글 리스트 조회 */
	ArrayList<CommentDto> selectCommentList(int pNum);
	
}
