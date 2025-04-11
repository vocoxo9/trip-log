package kr.co.khedu.vote.service;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.template.Template;
import kr.co.khedu.vote.model.dao.TravelVoteDAO;
import kr.co.khedu.vote.model.vo.TravelVote;

public class TravelVoteServiceImpl implements TravelVoteService {

	TravelVoteDAO tvDao = new TravelVoteDAO();
	
	@Override
	public int insertVote(int userId, String tDestination) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = tvDao.insertVote(sqlSession, userId, tDestination);
		
		sqlSession.close();
		
		return result;
	}

	@Override
	public TravelVote selectVote(int userId) {
		
		SqlSession sqlSession = Template.getSqlSession();
		
		TravelVote tVote = tvDao.selectVote(sqlSession, userId);
		
		sqlSession.close();
		
		return tVote;
	}

	@Override
	public int updateVote(int userId, String tDestination) {
		
		SqlSession sqlSession = Template.getSqlSession();

		int result = tvDao.updateVote(sqlSession, userId, tDestination);

		sqlSession.close();
		
		return result;
	}
	
	
	

	
	
}
