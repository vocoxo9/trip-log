package kr.co.khedu.post.model.vo;

import lombok.Data;

import java.sql.Date;

@Data
public final class Post {
    private final int postId;
    private final String title;
    private final String content;
    private final int views;
    private final Date createdAt;
    private final int memberId;
    private final int countryId;
}
