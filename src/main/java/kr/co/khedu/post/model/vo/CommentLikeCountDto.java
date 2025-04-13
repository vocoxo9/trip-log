package kr.co.khedu.post.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentLikeCountDto {

	private int commentId;
	private int commentLikeCount;
	
}
