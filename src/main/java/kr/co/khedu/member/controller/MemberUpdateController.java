package kr.co.khedu.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.member.service.MemberService;
import kr.co.khedu.member.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/members/update")
public class MemberUpdateController extends HttpServlet {
	private final MemberService mService = new MemberServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Member loginMember = (Member)request.getSession().getAttribute("loginMember");
		int memberId = loginMember.getMemberId();
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String nickname = request.getParameter("nickname");
		int countryId = Integer.parseInt(request.getParameter("countryId"));
		
		Member member = new Member(memberId, password, nickname, phone, countryId);
		int result = mService.updateMember(member);
		
		
		if(result > 0) {
			request.getSession().setAttribute("loginMember", loginMember);
			response.getWriter().write("updated");
		} else {
			response.getWriter().write("fail");
		}
	}

}

