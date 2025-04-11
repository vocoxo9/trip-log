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
 * Servlet implementation class MemberMypostController
 */
@WebServlet("/members/posts")
public class MemberMypostController extends HttpServlet {
	// private final PostService pService = new PostServiceImpl();
	
	private final MemberService mService = new MemberServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDTO loginMember = (MemberDTO)request.getSession().getAttribute("loginMember");
		if(loginMember == null) {
			response.sendRedirect(request.getContextPath());
		}
		int memberId = loginMember.getMemberId();
		
		/* 
			List<Post> postList = pService.selectPostsByMemberId(memberId);
			request.setAttribute("postList", postList);
			request.getRequestDispatcher("/WEB-INF/views/member/myPostList.jsp").forward(request, response); 
		*/
		request.getRequestDispatcher("/WEB-INF/views/member/myPostList.jsp").forward(request, response);
		
		// 
	}

}
