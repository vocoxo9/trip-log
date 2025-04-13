package kr.co.khedu.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.post.service.PostDetailService;
import kr.co.khedu.post.service.PostDetailServiceImpl;

/**
 * Servlet implementation class PostDeleteController
 */
@WebServlet("/post/delete")
public class PostDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("게시글 삭제 요청 들어옴");
		PostDetailService pdService = new PostDetailServiceImpl();
		
		// 해당 post의 번호 추출
		String pno = request.getParameter("pno");
		int postId = Integer.parseInt(pno);
		
		System.out.println("Controller에서 postId : " + postId);
		
		// Service로 추출한 postId 전달하여 delete 요청
		int result = pdService.deletePost(postId);
		
		// postList 화면으로 서비스요청
		if (result > 0) {
			// 삭제 성공
			request.getSession().setAttribute("alertMsg", "삭제 성공했습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/pageNation.jsp");
		} else {
			// 삭제 실패
			request.setAttribute("alertMsg", "삭제 실패했습니다.");
			request.getRequestDispatcher("WEB-INF/views/common/pageNation.jsp");
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
