package kr.co.khedu.board.service;

import kr.co.khedu.board.model.vo.BoardDetail;

public interface BoardDetailService {

	/* 게시글 정보 조회 */
	BoardDetail selectBoardDetail(int num);
	
}
