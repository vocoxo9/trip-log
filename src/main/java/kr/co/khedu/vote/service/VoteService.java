package kr.co.khedu.vote.service;

import kr.co.khedu.vote.model.dto.VoteDTO;
import kr.co.khedu.vote.model.vo.Vote;

import java.util.List;

public interface VoteService {
    List<? extends VoteDTO> selectVoteList();

    /* 해당 회원의 투표가 있는지 확인 (select) */
    Vote selectVote(int userId);

    /* 투표 등록 (insert) */
    int insertVote(int userId, String tDestination);

    /* 이미 투표한게 있다면 update */
    int updateVote(int userId, String tDestination);
}
