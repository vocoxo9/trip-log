package kr.co.khedu.post.model.dto;

import lombok.Data;

@Data
public final class CommentDTO {
	private int commentId;
	private String memberId;
	private String nickname;
	private String registDate;
	private String content;
	private int likeCount;
	private int postId;
	private int parentId;
}
