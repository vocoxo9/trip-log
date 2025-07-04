package kr.co.khedu.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.member.model.dto.MemberDTO;
import kr.co.khedu.member.service.MemberService;
import kr.co.khedu.member.service.MemberServiceImpl;

/**
 * Servlet implementation class MemberUpdateController
 */
@WebServlet("/members/update")
public class MemberUpdateController extends HttpServlet {
	private final MemberService mService = new MemberServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		MemberDTO loginMember = (MemberDTO)request.getSession().getAttribute("loginMember");
		// 세션 정보 확인
		if (loginMember == null) {
			response.getWriter().write("failed");
			return;
		}
		
		int memberId = loginMember.getMemberId();
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		String nickname = request.getParameter("nickname");
		int countryId = Integer.parseInt(request.getParameter("countryId"));

		// 필수항목 유효성 검사
		if (password == null || password.trim().isEmpty()) {
			response.getWriter().write("failed");
			return;
		}
		
		MemberDTO member = new MemberDTO(memberId, password, nickname, phone, countryId);
		int result = mService.updateMember(member);
		
		if(result > 0) {
			MemberDTO updateMember = mService.selectMember(memberId);
			request.getSession().setAttribute("loginMember", updateMember);
			response.getWriter().write("updated");
		} else {
			request.setAttribute("errorMsg", "회원정보 수정에 실패하였습니다.");
		    request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
	}

}

