package kr.co.khedu.vote.service;

import kr.co.khedu.vote.model.vo.TravelVote;

public interface TravelVoteService {

	/* 해당 회원의 투표가 있는지 확인 (select) */
	TravelVote selectVote(int userId);

	/* 투표 등록 (insert) */
	int insertVote(int userId, String tDestination);

	/* 이미 투표한게 있다면 update */
	int updateVote(int userId, String tDestination);

	
}
