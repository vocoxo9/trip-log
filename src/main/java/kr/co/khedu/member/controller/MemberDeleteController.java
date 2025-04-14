package kr.co.khedu.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.member.model.dto.MemberDTO;
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
		response.setContentType("text/html; charset=UTF-8");
		
		MemberDTO loginMember = (MemberDTO)request.getSession().getAttribute("loginMember");
		int memberId = loginMember.getMemberId();

		int result = mService.deleteMember(memberId);
		
		if( result > 0) {	
			request.getSession().invalidate();
			response.getWriter().write("deleted");
		} else {
			request.setAttribute("errorMsg", "회원 탈퇴에 실패했습니다.");
		    request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);	
		}
		
	}

}