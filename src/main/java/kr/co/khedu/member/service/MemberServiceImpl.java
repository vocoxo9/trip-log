package kr.co.khedu.member.service;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.member.model.dao.MemberDAO;
import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.template.Template;

public class MemberServiceImpl implements MemberService{
	
	private MemberDAO mDAO = new MemberDAO();
	
	public Member loginMember(Member m) {
		SqlSession sqlSession = Template.getSqlSession();
		
		Member loginMember = mDAO.selectMember(sqlSession, m);
		
	    sqlSession.close();
	    
	    return loginMember;
	}
	
	@Override
	public int insertMember(Member member) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = mDAO.insertMember(sqlSession, member);
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public int countMemberByEmail(String email) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = mDAO.countMemberByEmail(sqlSession, email);
		
		sqlSession.close();
		
		return result;
	}
	
	@Override
	public int updateMember(Member member) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = mDAO.updateMember(sqlSession, member);

		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		
		return result;
	}

	@Override
	public int deleteMember(int memNo) {
		SqlSession sqlSession = Template.getSqlSession();
		
		int result = mDAO.deleteMember(sqlSession, memNo);
		
		if(result > 0) {
			sqlSession.commit();
		}
		sqlSession.commit();
		
		return result;
	}

}
