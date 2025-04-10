package kr.co.khedu.post.model.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class Post {
	
	private int postId;
	private String title;
	private String content;
	private int views;
	private Date createdAt;
	private int memberId;
	private int countryId;
}
