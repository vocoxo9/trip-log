package kr.co.khedu.post.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.sql.Date;

@AllArgsConstructor
@Getter
public final class PostSummaryDTO {
    private final String title;
    private final String content;
    private final Date createdAt;
    private final int likes;
    private final int comments;
}
