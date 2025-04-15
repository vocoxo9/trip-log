package kr.co.khedu.vote.service;

import kr.co.khedu.template.Template;
import kr.co.khedu.vote.model.dao.VoteDAO;
import kr.co.khedu.vote.model.dto.VoteDTO;
import kr.co.khedu.vote.model.vo.Vote;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public final class VoteServiceImpl implements VoteService {
    private final VoteDAO voteDAO = new VoteDAO();

    @Override
    public List<? extends VoteDTO> selectVoteList() {
        SqlSession session = Template.getSqlSession();
        List<? extends VoteDTO> votevoteList = voteDAO.selectVoteList(session);
        session.close();
        return votevoteList;
    }

    @Override
    public int insertVote(int userId, String tDestination) {

        SqlSession sqlSession = Template.getSqlSession();

        int result = voteDAO.insertVote(sqlSession, userId, tDestination);
        if (result > 0) {
            sqlSession.commit();
        }

        sqlSession.close();

        return result;
    }

    @Override
    public Vote selectVote(int userId) {

        SqlSession sqlSession = Template.getSqlSession();

        Vote tVote = voteDAO.selectVote(sqlSession, userId);

        sqlSession.close();

        return tVote;
    }

    @Override
    public int updateVote(int userId, String tDestination) {

        SqlSession sqlSession = Template.getSqlSession();

        int result = voteDAO.updateVote(sqlSession, userId, tDestination);
        if (result > 0) {
            sqlSession.commit();
        }

        sqlSession.close();

        return result;
    }
}
