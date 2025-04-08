package kr.co.khedu.member.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.member.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberSignupController
 */
@WebServlet("/members/sign-up")
public class MemberSignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String nickname = request.getParameter("nickname");
		String birthdayStr = request.getParameter("birthday");
		int country = Integer.parseInt(request.getParameter("countryId"));
		
		Date birthday = null;
		if(birthdayStr != null && !birthdayStr.isEmpty()) {
			birthday = Date.valueOf(birthdayStr);
		}
		
		Member member = new Member(email, password, nickname, birthday, phone, country);
		
		int result = new MemberServiceImpl().insertMember(member);
		
		if(result > 0 ) {
			request.getSession().setAttribute("alertMsg", "회원가입에 성공하였습니다!");
			response.sendRedirect(request.getContextPath());
		} else {
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
