package kr.co.khedu.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.khedu.board.model.vo.CommentDto;
import kr.co.khedu.board.service.BoardDetailService;
import kr.co.khedu.board.service.BoardDetailServiceImpl;

/**
 * Servlet implementation class CommentRegistController
 */
@WebServlet("/comment/regist")
public class CommentRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentRegistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 데이터 추출
		String name = request.getParameter("name");
		String commentView = request.getParameter("commentView");
		String postId = request.getParameter("postId");
		
		System.out.println("name : " + name);
		System.out.println("commentView : " + commentView);
		System.out.println("postId : " + postId);
		
		// Service 객체에 전달받은 값들을 전달 - DB에 저장(insert)
		BoardDetailService bdService = new BoardDetailServiceImpl();
		int result = bdService.insertComment(name, commentView, postId);
		
		// 결과 데이터 추출
		CommentDto lastComment = bdService.selectLastComment(postId);
		
		System.out.println("Controller에서 lastComment : " + lastComment);
		System.out.println("lastComment의 타입 : " + lastComment.getClass().getName());
		
		// 일반 객체 (JSONObject)에 담아 응답
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("lastComment", lastComment);
		
		System.out.println(jsonObj.get("lastComment"));
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonObj);
		
		// => ajax 응답이 실패됨 여쭤보기
		
		
	}

}
