package kr.co.khedu.post.model.dto;

import lombok.Data;

@Data
public final class ReplyDTO {
    private final int postId;
    private final int commentId;
    private final String userName;
    private final int registDate;
    private final String content;
    private final int likeCount;
    private final int parentId;
}
