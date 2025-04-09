package kr.co.khedu.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.member.model.vo.Member;

public class MemberDAO {
	
	// 로그인
	public Member selectMember(SqlSession sqlSession, Member m) {
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
	
	// 회원가입
	public int insertMember(SqlSession sqlSession, Member member) {
		return sqlSession.insert("memberMapper.insertMember", member);
	}

	// ??
	public Member selectMember(SqlSession sqlSession) {
		return sqlSession.selectOne("memberMapper.selectMember");
	}

	// 이메일 중복확인
	public int countMemberByEmail(SqlSession sqlSession, String email) {
		return sqlSession.selectOne("memberMapper.countMemberByEmail", email);
	}
	
	// 회원정보 수정
	public int updateMember(SqlSession sqlSession, Member member) {
		return sqlSession.update("memberMapper.updateMember", member);
	}

	public int deleteMember(SqlSession sqlSession, int memNo) {
		return sqlSession.update("memberMapper.deleteMember", memNo);
	}

}
