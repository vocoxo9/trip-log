package kr.co.khedu.board.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReplyDto {

	private int postId;
	private int commentId;
	private String userName;
	private int registDate;
	private String content;
	private int likeCount;
	private int parentId;
	
}
