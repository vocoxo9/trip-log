package kr.co.khedu.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.member.model.vo.Member;

public class MemberDAO {
	public Member selectMember(SqlSession sqlSession, Member m) {
		
		return sqlSession.selectOne("memberMapper.loginMember", m);
	}
	// 회원가입
	public int insertMember(SqlSession sqlSession, Member member) {
		return sqlSession.insert("memberMapper.insertMember", member);
	}
}
