package kr.co.khedu.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.member.model.dto.MemberDTO;
import kr.co.khedu.member.model.vo.Member;

public class MemberDAO {

	// 로그인
	public MemberDTO loginMember(SqlSession sqlSession, MemberDTO m) {
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
	
	// 회원가입
	public int insertMember(SqlSession sqlSession, Member member) {
		return sqlSession.insert("memberMapper.insertMember", member);
	}

	// 이메일 중복 조회
	public int countMemberByEmail(SqlSession sqlSession, String email) {
		return sqlSession.selectOne("memberMapper.countMemberByEmail", email);
	}

	// 회원정보 수정
	public int updateMember(SqlSession sqlSession, MemberDTO member) {
		return sqlSession.update("memberMapper.updateMember", member);
	}

	public int deleteMember(SqlSession sqlSession, int memNo) {
		return sqlSession.update("memberMapper.deleteMember", memNo);
	}

	public MemberDTO selectMember(SqlSession sqlSession, int memNo) {
		return sqlSession.selectOne("memberMapper.selectMember", memNo);
	}
	
	public MemberDTO socialMember(SqlSession sqlSession, MemberDTO m) {
		return sqlSession.selectOne("memberMapper.socialMember", m);
	}
	
	public int insertSocialMember(SqlSession sqlSession, Member member) {
		return sqlSession.insert("memberMapper.insertSocialMember", member);
	}
}
