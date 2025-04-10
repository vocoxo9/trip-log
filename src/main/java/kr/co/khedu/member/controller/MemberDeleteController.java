package kr.co.khedu.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.member.service.MemberService;
import kr.co.khedu.member.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberDeleteController
 */
@WebServlet("/members/delete")
public class MemberDeleteController extends HttpServlet {
	private final MemberService mService = new MemberServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Member loginMember = (Member)request.getSession().getAttribute("loginMember");
		
		int memberId = loginMember.getMemberId();

		int result = mService.deleteMember(memberId);
		if( result > 0) {	
			response.sendRedirect(request.getContextPath());		
		} else {
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);			
		}
		
	}

}