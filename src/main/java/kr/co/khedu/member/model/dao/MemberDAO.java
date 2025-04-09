package kr.co.khedu.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.member.model.vo.Member;

public class MemberDAO {
	public Member selectMember(SqlSession sqlSession, Member member) {
		return sqlSession.selectOne("memberMapper.loginMember", member);
	}
	
	public int insertMember(SqlSession sqlSession, Member member) {
		return sqlSession.insert("memberMapper.insertMember", member);
	}
	public Member selectMemberBySocialEmail(SqlSession sqlSession, Member member) {
		return sqlSession.selectOne("memberMapper.socialLoginMember", member) ;
	}
	public int insertSocialMember(SqlSession sqlSession, Member member) {
		return sqlSession.insert("memberMapper.insertSocialMember", member);
	}
}
