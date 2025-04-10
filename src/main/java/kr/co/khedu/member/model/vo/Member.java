package kr.co.khedu.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
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
  
	// 회원가입용 생성자
	public Member(String email, String password, String nickname, Date birthday, String phone, int countryId) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.birthday = birthday;
		this.phone = phone;
		this.countryId = countryId;
	}

	public Member(int memberId, String email, String password, String role, String nickname, Date birthday,
			String phone, Date createdAt, Date deletedAt, int countryId) {
		super();
		this.memberId = memberId;
		this.email = email;
		this.password = password;
		this.nickname = nickname;
		this.birthday = birthday;
		this.phone = phone;
		this.countryId = countryId;
	}
}
