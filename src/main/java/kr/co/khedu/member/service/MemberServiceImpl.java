package kr.co.khedu.member.service;

import org.apache.ibatis.session.SqlSession;

import kr.co.khedu.member.model.dao.MemberDAO;
import kr.co.khedu.member.model.dto.MemberDTO;
import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.template.Template;

public class MemberServiceImpl implements MemberService {

	private MemberDAO mDAO = new MemberDAO();

	public MemberDTO loginMember(MemberDTO m) {
		SqlSession sqlSession = Template.getSqlSession();

		MemberDTO loginMember = mDAO.loginMember(sqlSession, m);

		sqlSession.close();

		return loginMember;
	}

	@Override
	public int insertMember(Member member) {
		SqlSession sqlSession = Template.getSqlSession();
		if (sqlSession == null) {
		    throw new RuntimeException("SqlSession 생성 실패");
		}

		int result = 0;

		try {
			result = mDAO.insertMember(sqlSession, member);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return result;
	}

	@Override
	public int countMemberByEmail(String email) {
		SqlSession sqlSession = Template.getSqlSession();
		if (sqlSession == null) {
		    throw new RuntimeException("SqlSession 생성 실패");
		}

		int result = 0;

		try {
			result = mDAO.countMemberByEmail(sqlSession, email);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return result;
	}

	@Override
	public int updateMember(MemberDTO member) {
		SqlSession sqlSession = Template.getSqlSession();
		if (sqlSession == null) {
		    throw new RuntimeException("SqlSession 생성 실패");
		}

		int result = 0;

		try {
			result = mDAO.updateMember(sqlSession, member);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return result;
	}

	@Override
	public int deleteMember(int memNo) {
		SqlSession sqlSession = Template.getSqlSession();
		if (sqlSession == null) {
		    throw new RuntimeException("SqlSession 생성 실패");
		}

		int result = 0;

		try {
			result = mDAO.deleteMember(sqlSession, memNo);
			if (result > 0) {
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			sqlSession.rollback();
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return result;
	}

	@Override
	public MemberDTO selectMember(int memNo) {
		SqlSession sqlSession = Template.getSqlSession();
		if (sqlSession == null) {
			throw new RuntimeException("SqlSession 생성 실패");
		}

		try {
			MemberDTO mDTO = mDAO.selectMember(sqlSession, memNo);
			return mDTO;
		} finally {
			sqlSession.close();
		}
	}

	@Override
	public int insertSocialMember(Member member) {
		SqlSession sqlSession = Template.getSqlSession();

		int result = mDAO.insertSocialMember(sqlSession, member);

		if (result > 0) {
			sqlSession.commit();
		}
		sqlSession.close();
		return result;
	}

	@Override
	public MemberDTO socialMember(MemberDTO member) {
		SqlSession sqlSession = Template.getSqlSession();

		MemberDTO loginMember = mDAO.socialMember(sqlSession, member);

		sqlSession.close();

		return loginMember;
	}
}
