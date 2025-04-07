package kr.co.khedu.member.model.vo;

import java.sql.Date;

public class Member {
	private int memberId;
	private String email;
	private String password;
	private String role;
	private String nickname;
	private Date birthday;
	private String phone;
	private Date createdAt;
	private Date deletedAt;
	private int countryId;
	
	public Member() {
		super();
	}

	public Member(int memberId, String email, String password, String role, String nickname, Date birthday,
			String phone, Date createdAt, Date deletedAt, int countryId) {
		super();
		this.memberId = memberId;
		this.email = email;
		this.password = password;
		this.role = role;
		this.nickname = nickname;
		this.birthday = birthday;
		this.phone = phone;
		this.createdAt = createdAt;
		this.deletedAt = deletedAt;
		this.countryId = countryId;
	}
	
	public Member(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}
	
	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}
	
}
