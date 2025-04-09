package kr.co.khedu.member.service;
import kr.co.khedu.member.model.vo.Member;

public interface MemberService {
	Member loginMember(Member m);
	
	// �쉶�썝媛��엯
	int insertMember(Member member);

	// �쉶�썝�젙蹂� �닔�젙
	int updateMember(Member member);
	
	// �쉶�썝�젙蹂� �궘�젣 -> update
	int deleteMember(int memNo);
	
	Member socialMember(Member member);
	
	int insertSocialMember(Member member);
}
