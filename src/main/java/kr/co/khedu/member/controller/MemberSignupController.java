package kr.co.khedu.member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.member.service.MemberService;
import kr.co.khedu.member.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberSignupController
 */
@WebServlet("/members/sign-up")
public class MemberSignupController extends HttpServlet {

	private final MemberService mService = new MemberServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/signUp.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String nickname = request.getParameter("nickname");
		String birthdayStr = request.getParameter("birthday");
		int countryId = Integer.parseInt(request.getParameter("countryId"));

		// 필수항목 유효성 검사
		if (email == null || email.trim().isEmpty() || 
				password == null || password.trim().isEmpty() ||
				nickname == null || nickname.trim().isEmpty()) {
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			return;
		}

		// 생년월일 처리
		Date birthday = null;
		if (birthdayStr != null && !birthdayStr.isEmpty()) {
			birthday = Date.valueOf(birthdayStr);
		}

		// 이메일 중복 체크
		if (mService.countMemberByEmail(email) > 0 ) {
			request.setAttribute("errorMsg", "이미 사용 중인 이메일입니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
			return;
		}
		
		// 회원가입 처리
		Member member = new Member(email, password, nickname, birthday, phone, countryId);
		int result = new MemberServiceImpl().insertMember(member);

		if (result > 0) {
			response.sendRedirect(request.getContextPath());
		} else {
			request.setAttribute("errorMsg", "회원가입에 실패하였습니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}
