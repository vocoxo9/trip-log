package kr.co.khedu.post.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class PostDetailDTO {
	private int postId;
	private String title;
	private String content;
	private int memberId;
	private int likeCount;
}
