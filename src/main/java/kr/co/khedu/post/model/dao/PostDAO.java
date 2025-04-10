package kr.co.khedu.post.model.dao;

import kr.co.khedu.post.model.dto.PostSummaryDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public final class PostDAO {
    public List<? extends PostSummaryDTO> getPostSummaries(SqlSession session) {
        return session.selectList("postMapper.getPostSummaries");
    }
}
