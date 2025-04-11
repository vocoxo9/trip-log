package kr.co.khedu.vote.model.dao;

import kr.co.khedu.vote.model.dto.VoteDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public final class VoteDAO {
    public List<? extends VoteDTO> selectVoteList(SqlSession sqlSession) {
        return sqlSession.selectList("voteMapper.getVotes");
    }
}
