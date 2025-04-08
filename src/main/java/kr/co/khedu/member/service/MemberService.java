package kr.co.khedu.member.service;
import kr.co.khedu.member.model.vo.Member;

public interface MemberService {
  Member loginMember(Member m);
	
	// 회원가입
	int insertMember(Member member);

	// 회원정보 수정
	int updateMember(Member member);
	
	// 회원정보 삭제 -> update
	int deleteMember(int memNo);
}
