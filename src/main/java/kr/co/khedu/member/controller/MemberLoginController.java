package kr.co.khedu.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.khedu.member.model.dto.MemberDTO;
import kr.co.khedu.member.service.MemberService;
import kr.co.khedu.member.service.MemberServiceImpl;

//@WebServlet("/members/sign-in")
@WebServlet(urlPatterns = {"/members/sign-in", "/auth/sign-in"})
public class MemberLoginController extends HttpServlet{
	
	private final MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/member/memberLogin.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		System.out.println(email);
		System.out.println(password);
		
		MemberDTO mDTO = new MemberDTO(email, password);
		//Member m = new Member();
		//m.setEmail(email);
        // m.setPassword(password);
		
		MemberDTO loginMember = memberService.loginMember(mDTO);
		
        //Member loginMember = memberService.loginMember(m);
        
        if(loginMember != null) {
        	HttpSession session = request.getSession();
        	session.setAttribute("loginMember", loginMember);
        	response.sendRedirect(request.getContextPath());
        }else {
        	request.setAttribute("errorMsg", "로그인 정보가 잘못되었습니다");
			 request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }
	}
	
}
