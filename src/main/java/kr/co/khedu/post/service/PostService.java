package kr.co.khedu.post.service;

import kr.co.khedu.post.model.dto.PostSummaryDTO;

import java.util.List;

public interface PostService {
    List<? extends PostSummaryDTO> getPostSummaries();
}
