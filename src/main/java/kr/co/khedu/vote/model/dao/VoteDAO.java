package kr.co.khedu.vote.model.dao;

import kr.co.khedu.vote.model.dto.VoteDTO;
import kr.co.khedu.vote.model.vo.Vote;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.List;

public final class VoteDAO {
    public List<? extends VoteDTO> selectVoteList(SqlSession sqlSession) {
        return sqlSession.selectList("voteMapper.getVotes");
    }

    public int insertVote(SqlSession sqlSession, int userId, String tDestination) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userId", userId);
        hashMap.put("tDestination", tDestination);


        int result = sqlSession.insert("voteMapper.insertVote", hashMap);

        if (result > 0) {
            // 투표 성공!
            sqlSession.commit();
        } else {
            // 투표 실패 ㅠ
            sqlSession.rollback();
        }

        return result;
    }

    public Vote selectVote(SqlSession sqlSession, int userId) {
        return sqlSession.selectOne("voteMapper.selectVote", userId);
    }

    public int updateVote(SqlSession sqlSession, int userId, String tDestination) {

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("userId", userId);
        hashMap.put("tDestination", tDestination);

        int result = sqlSession.update("voteMapper.updateVote", hashMap);

        if (result > 0) {
            // 투표 수정 성공!
            sqlSession.commit();
        } else {
            // 투표 수정 실패 ㅠ
            sqlSession.rollback();
        }

        return result;
    }
}
