package kr.co.khedu.vote.service;

import kr.co.khedu.vote.model.dto.VoteDTO;

import java.util.List;

public interface VoteService {
    List<? extends VoteDTO> selectVoteList();
}
