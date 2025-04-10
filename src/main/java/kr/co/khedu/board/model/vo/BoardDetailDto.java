package kr.co.khedu.board.model.vo;

public class BoardDetailDto {

	private int postId;
	private String title;
	private String content;
	private int likeCount;
	
	// -------------------------
	
	public BoardDetailDto() {
		super();
	}
	public BoardDetailDto(int postId, String title, String content, int likeCount) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.likeCount = likeCount;
	}


	// -------------------------
	
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}

	
	// ------------------------
	
	@Override
	public String toString() {
		return "BoardDetailDto [postId=" + postId + ", title=" + title + ", content=" + content + ", likeCount="
				+ likeCount + "]";
	}

	
	
	
	
	
}
