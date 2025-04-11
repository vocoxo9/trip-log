package kr.co.khedu.post.model.vo;

public class PostDetailDto {

	private int postId;
	private String title;
	private String content;
	private int memberId;
	private int likeCount;
	
	// -------------------------
	
	public PostDetailDto() {
		super();
	}
	public PostDetailDto(int postId, String title, String content, int memberId, int likeCount) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.memberId = memberId;
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
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
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
		return "BoardDetailDto [postId=" + postId + ", title=" + title + ", content=" + content + ", memberId="
				+ memberId + ", likeCount=" + likeCount + "]";
	}
	
	
	
	
	
}
