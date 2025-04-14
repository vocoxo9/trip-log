package kr.co.khedu.post.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostLikeCountDto {

	private int postId;
	private int postLikeCount;
	
}
