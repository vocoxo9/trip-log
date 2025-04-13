package kr.co.khedu.post.model.dao;

import kr.co.khedu.post.model.dto.PostEditDTO;
import kr.co.khedu.post.model.dto.PostSummaryDTO;
import kr.co.khedu.post.model.dto.PostWriteDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public final class PostDAO {
    public boolean isPostOwner(SqlSession session, int postId, int memberId) {
        return session.<Integer>selectOne(
                "postMapper.isPostOwner",
                Map.of(
                        "postId", postId,
                        "memberId", memberId
                )
        ) > 0;
    }

    public List<? extends PostSummaryDTO> getPostSummaries(SqlSession session, int offset) {
        return session.selectList("postMapper.getPostSummaries", offset);
    }

    public List<? extends PostSummaryDTO>  getPostSummariesByMemberId(SqlSession session, int memberId, int offset) {
        return session.selectList(
                "postMapper.getPostSummariesByMemberId",
                Map.of(
                        "memberId", memberId,
                        "offset", offset
                )
        );
    }

    public Optional<PostEditDTO> searchFormById(SqlSession session, int postId) {
        return Optional.ofNullable(
                session.selectOne("postMapper.searchFormById", postId)
        );
    }

    public int insertPost(SqlSession session, PostWriteDTO form) {
        return session.insert("postMapper.insertPost", form);
    }

    public int updatePost(SqlSession session, PostEditDTO form) {
        return session.insert("postMapper.updatePost", form);
    }
}
