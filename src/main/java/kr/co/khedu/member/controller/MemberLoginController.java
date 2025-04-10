package kr.co.khedu.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.khedu.keys.KeyManager;
import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.member.service.MemberService;
import kr.co.khedu.member.service.MemberServiceImpl;

//@WebServlet("/members/sign-in")
@WebServlet(urlPatterns = {"/members/sign-in", "/auth/sign-in"})
public class MemberLoginController extends HttpServlet{
	
	private final MemberService memberService = new MemberServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 카카오 api 관련 키값
		request.setAttribute("kakaoScriptKey", KeyManager.get("kakao.scriptKey"));
		request.setAttribute("kakaoRestKey", KeyManager.get("kakao.restkKey"));
		request.setAttribute("kakaoClientSecret", KeyManager.get("kakao.clientSecret"));
		request.setAttribute("kakaoRedirectUri", KeyManager.get("kakao.redirectUri"));
		// 구글 로그인 api 관련 키값
		request.setAttribute("googleClientId", KeyManager.get("google.clientId"));
		request.setAttribute("googleClientSecret", KeyManager.get("google.clientSecret"));
		request.setAttribute("googleRedirectUri", KeyManager.get("google.redirectUri"));
		
		request.getRequestDispatcher("/WEB-INF/views/member/memberLogin.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Member m = new Member();
		m.setEmail(email);
        m.setPassword(password);
		
        Member loginMember = memberService.loginMember(m);
        
        if(loginMember != null) {
        	HttpSession session = request.getSession();
        	session.setAttribute("loginMember", loginMember);
        	response.sendRedirect(request.getContextPath());
        }else {
			 request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }
	}
	
}
