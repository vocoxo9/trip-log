package kr.co.khedu.vote.model.dao;

import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.vote.model.vo.TravelVote;

public class TravelVoteDAO {

	public int insertVote(SqlSession sqlSession, int userId, String tDestination) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("userId", userId);
		hashMap.put("tDestination", tDestination);
		
		
		int result = sqlSession.insert("TravelVoteMapper.insertVote", hashMap);
		
		if (result > 0) {
			// 투표 성공!
			sqlSession.commit();
		} else {
			// 투표 실패 ㅠ
			sqlSession.rollback();
		}
				
		return result;
	}

	public TravelVote selectVote(SqlSession sqlSession, int userId) {

		TravelVote tVote = sqlSession.selectOne("TravelVoteMapper.selectVote", userId);
		
		return tVote;
	}

	public int updateVote(SqlSession sqlSession, int userId, String tDestination) {
		
		HashMap hashMap = new HashMap();
		hashMap.put("userId", userId);
		hashMap.put("tDestination", tDestination);
		
		int result = sqlSession.update("TravelVoteMapper.updateVote", hashMap);
		
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
