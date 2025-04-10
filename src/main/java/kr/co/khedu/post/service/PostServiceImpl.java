package kr.co.khedu.post.service;

import kr.co.khedu.post.model.dao.PostDAO;
import kr.co.khedu.post.model.dto.PostSummaryDTO;
import kr.co.khedu.template.Template;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public final class PostServiceImpl implements PostService {
    @Override
    public List<? extends PostSummaryDTO> getPostSummaries() {
        SqlSession session = Template.getSqlSession();
        List<? extends PostSummaryDTO> summaries = new PostDAO().getPostSummaries(session);
        session.close();
        return summaries;
    }
}
