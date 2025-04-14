package kr.co.khedu.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.khedu.post.model.vo.CommentDto;
import kr.co.khedu.post.service.PostDetailService;
import kr.co.khedu.post.service.PostDetailServiceImpl;

/**
 * Servlet implementation class CommentUpdateController
 */
@WebServlet("/comment/update")
public class CommentUpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentUpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PostDetailService pdService = new PostDetailServiceImpl();
		
		// 전달받은 값 추출하기
		String mno = request.getParameter("memberId");
		String cno = request.getParameter("commentId");
		String pno = request.getParameter("postId");
		String updatedContent = request.getParameter("updatedContent");
		
		int memberId = Integer.parseInt(mno);
		int commentId = Integer.parseInt(cno);
		int postId = Integer.parseInt(pno);
		
		// service 객체로 전달받은 값 전달하여 update
		int result = pdService.updateComment(memberId, commentId, updatedContent);
		
		CommentDto updateComment = pdService.selectUpdateComment(commentId, postId);
		
		// 일반 객체 (JSONObject)에 담아 응답
				JSONObject jsonObj = new JSONObject();
				jsonObj.put("commentId", updateComment.getCommentId() );
				jsonObj.put("content", updateComment.getContent() );
				jsonObj.put("likeCount", updateComment.getLikeCount() );		
				jsonObj.put("memberId", updateComment.getMemberId() );
				jsonObj.put("postId", updateComment.getPostId() );
				jsonObj.put("registDate", updateComment.getRegistDate() );
				
				System.out.println("모든 처리 후 댓글수정 json의값 : " + jsonObj);
				System.out.println(jsonObj.get("lastComment"));
				
				response.setContentType("application/json; charset=UTF-8");
				response.getWriter().print(jsonObj);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
