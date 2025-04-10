package kr.co.khedu.member.service;

import kr.co.khedu.member.model.dto.MemberDTO;
import kr.co.khedu.member.model.vo.Member;

public interface MemberService {
	// DTO test
	// MemberDTO dtoTest(MemberDTO m);

	// 로그인
	MemberDTO loginMember(MemberDTO m);

	// 회원가입
	int insertMember(Member member);

	// 이메일 중복확인
	int countMemberByEmail(String email);

	// 회원정보 수정
	int updateMember(MemberDTO member);

	// 회원정보 삭제 -> update
	int deleteMember(int memNo);
	
	MemberDTO selectMember(int memNo);

	// 쇼셜로그인 가입
	int insertSocialMember(Member member);
}
