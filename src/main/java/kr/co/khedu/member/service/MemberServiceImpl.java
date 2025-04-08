package kr.co.khedu.member.service;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.member.model.dao.MemberDAO;
import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.template.Template;

public class MemberServiceImpl implements MemberService{
	private MemberDAO mDAO = new MemberDAO();
	
	
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

	// 이메일 중복확인
	@Override
	public int countMemberByEmail(String email) {
		SqlSession sqlSession = Template.getSqlSession();
		int result = mDAO.countMemberByEmail(sqlSession, email);
		sqlSession.close();
		return result;
	}
	
	@Override
	public Member selectMember() {
		SqlSession sqlSession = Template.getSqlSession();
		Member m = mDAO.selectMember(sqlSession);
		sqlSession.close();
		return m;
	}

	@Override
	public int updateMember(Member member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(int memNo) {
		// TODO Auto-generated method stub
		return 0;
	}


}
