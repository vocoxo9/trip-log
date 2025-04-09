package kr.co.khedu.board.model.vo;

public class BoardDetail {

	private int postId;
	private String title;
	private String content;
	
	// -------------------------
	
	public BoardDetail() {
		super();
	}
	public BoardDetail(int postId, String title, String content) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
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
	
	// ------------------------
	
	@Override
	public String toString() {
		return "BoardDetail [postId=" + postId + ", title=" + title + ", content=" + content + "]";
	}
	
	
	
	
	
}
