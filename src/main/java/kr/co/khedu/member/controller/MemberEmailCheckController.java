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
 * Servlet implementation class MemberIdCheckController
 */
@WebServlet("/members/email-check")
public class MemberEmailCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberEmailCheckController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String email = request.getParameter("email");
		if (email == null || email.trim().isEmpty()) {
		    response.getWriter().print("invalid");
		}
		
		new Member().setEmail(email);
		
		MemberService mService = new MemberServiceImpl();
		
		int count = mService.countMemberByEmail(email);
		
		if(count == 0) {
			response.getWriter().print("available");
		}else {
			response.getWriter().print("unavailable");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
