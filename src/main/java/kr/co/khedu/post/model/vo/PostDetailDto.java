package kr.co.khedu.post.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostDetailDto {

	private int postId;
	private String title;
	private String content;
	private int memberId;
	private int likeCount;
	
	// -------------------------
	
	public PostDetailDto(int postId, String title) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.memberId = memberId;
		this.likeCount = likeCount;
	}


	// -------------------------
	
	
	
	
	
}
