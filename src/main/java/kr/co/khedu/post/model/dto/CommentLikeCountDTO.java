package kr.co.khedu.post.model.dto;

import lombok.Data;

@Data
public final class CommentLikeCountDTO {
	private int commentId;
	private int commentLikeCount;
}
