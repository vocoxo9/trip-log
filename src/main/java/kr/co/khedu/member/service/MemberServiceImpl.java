package kr.co.khedu.member.service;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.member.model.dao.MemberDAO;
import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.template.Template;

public class MemberServiceImpl implements MemberService{
	private MemberDAO mDao = new MemberDAO();
	
	public Member loginMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginMember = mDao.selectMember(sqlSession, m);
		
	    sqlSession.close();
	    
	    return loginMember;
	}
}
