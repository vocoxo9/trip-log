package kr.co.khedu.post.service;

import kr.co.khedu.post.model.dto.PostEditDTO;
import kr.co.khedu.post.model.dto.PostSummaryDTO;
import kr.co.khedu.post.model.dto.PostWriteDTO;

import java.util.List;
import java.util.Optional;

public interface PostService {
    boolean isPostOwner(int postId, int memberId);

    List<? extends PostSummaryDTO> getPostSummaries(int page);

    List<? extends PostSummaryDTO> getPostSummariesByMemberId(int page, int memberId);

    Optional<PostEditDTO> searchFormById(int postId);

    int insertPost(PostWriteDTO form);

    int updatePost(PostEditDTO form);
}
