package kr.co.khedu.board.model.vo;

public class CommentDto {

	private int commentId;
	private String memberId;
	private String registDate;
	private String content;
	private int likeCount;
	private int postId;
	// (댓글번호, 사용자명, 작성일, 댓글 내용, 댓글 좋아요 수, 게시글 번호)
	
	// 생성자 부
	public CommentDto() {
		super();
	}
	public CommentDto(int commentId, String memberId, String registDate, String content, int likeCount, int postId) {
		super();
		this.commentId = commentId;
		this.memberId = memberId;
		this.registDate = registDate;
		this.likeCount = likeCount;
		this.postId = postId;
	}
	
	// getter() / setter()
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRegistDate() {
		return registDate;
	}
	public void setRegistDate(String registDate) {
		this.registDate = registDate;
	}
	public int getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(int likeCount) {
		this.likeCount = likeCount;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	// toString()
	@Override
	public String toString() {
		return "CommentDto [commentId=" + commentId + ", memberId=" + memberId + ", registDate=" + registDate
				+ ", content=" + content + ", likeCount=" + likeCount + ", postId=" + postId + "]";
	}
	
	
}
