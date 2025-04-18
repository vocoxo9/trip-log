package kr.co.khedu.post.model.dto;

import lombok.Data;

import java.sql.Date;

@Data
public final class PostSummaryDTO {
    private final int postId;
    private final String title;
    private final String content;
    private final Date createdAt;
    private final int likes;
    private final int comments;
}
