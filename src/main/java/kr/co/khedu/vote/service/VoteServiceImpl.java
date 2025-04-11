package kr.co.khedu.vote.service;

import kr.co.khedu.template.Template;
import kr.co.khedu.vote.model.dao.VoteDAO;
import kr.co.khedu.vote.model.dto.VoteDTO;
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
}
