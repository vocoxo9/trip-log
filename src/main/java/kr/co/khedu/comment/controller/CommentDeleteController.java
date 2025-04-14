package kr.co.khedu.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.post.service.PostDetailService;
import kr.co.khedu.post.service.PostDetailServiceImpl;

/**
 * Servlet implementation class CommentDeleteController
 */
@WebServlet("/comment/delete")
public class CommentDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PostDetailService pdService = new PostDetailServiceImpl();
		
		// 전달받은 commentId 추출
		String cno = request.getParameter("commentId");
		int commentId = Integer.parseInt(cno);
		
		// 전달받은 commentId를 service객체로 전달하여 댓글 삭제 요청
		int result = pdService.deleteComment(commentId);
		
		if (result >0) {
			request.setAttribute("alertMsg", "댓글이 정상적으로 삭제되었습니다.");
		} else {
			request.setAttribute("errorMsg", "댓글이 삭제되지 않았습니다.");
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
