package kr.co.khedu.post.service;

import kr.co.khedu.post.model.dao.PostDAO;
import kr.co.khedu.post.model.dto.PostEditDTO;
import kr.co.khedu.post.model.dto.PostSummaryDTO;
import kr.co.khedu.post.model.dto.PostWriteDTO;
import kr.co.khedu.template.Template;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Optional;

public final class PostServiceImpl implements PostService {
    private final PostDAO postDAO = new PostDAO();

    @Override
    public boolean isPostOwner(int postId, int memberId) {
        SqlSession session = Template.getSqlSession();
        boolean result = postDAO.isPostOwner(session, postId, memberId);
        session.close();
        return result;
    }

    @Override
    public List<? extends PostSummaryDTO> getPostSummaries(int page) {
        page = Math.max(page, 1);
        int offset = (page - 1) * 6;

        SqlSession session = Template.getSqlSession();
        List<? extends PostSummaryDTO> summaries = postDAO.getPostSummaries(session, offset);
        session.close();
        return summaries;
    }

    @Override
    public List<? extends PostSummaryDTO> getPostSummariesByMemberId(int page, int memberId) {
        page = Math.max(page, 1);
        int offset = (page - 1) * 6;

        SqlSession session = Template.getSqlSession();
        List<? extends PostSummaryDTO> summaries = postDAO.getPostSummariesByMemberId(session, memberId, offset);
        session.close();
        return summaries;
    }

    @Override
    public Optional<PostEditDTO> searchFormById(int postId) {
        SqlSession session = Template.getSqlSession();
        Optional<PostEditDTO> optional = postDAO.searchFormById(session, postId);
        session.close();
        return optional;
    }

    @Override
    public int insertPost(PostWriteDTO form) {
        SqlSession session = Template.getSqlSession();
        int result = postDAO.insertPost(session, form);
        if (result > 0) {
            session.commit();
        }

        session.close();
        return result;
    }

    @Override
    public int updatePost(PostEditDTO form) {
        SqlSession session = Template.getSqlSession();
        int result = postDAO.updatePost(session, form);
        if (result > 0) {
            session.commit();
        }

        session.close();
        return result;
    }
}
