package kr.co.khedu.post.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentDto {

	private int commentId;
	private String memberId;
	private String registDate;
	private String content;
	private int likeCount;
	private int postId;
	private int parentId;
	// (댓글번호, 사용자명, 작성일, 댓글 내용, 댓글 좋아요 수, 게시글 번호)
	
	
	
}
