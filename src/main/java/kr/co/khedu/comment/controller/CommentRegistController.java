package kr.co.khedu.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.google.gson.JsonObject;

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
		String registDate = request.getParameter("registDate");
		String commentView = request.getParameter("commentView");
		
		// 결과 데이터 추출
		String result = "사용자명: [ " + name + " ], 작성일자: [ " + registDate + " ], 댓글 내용: [ " + commentView + " ] ";
		
		// 일반 객체 (JSONObject)에 담아 응답
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("name", name);
		jsonObj.put("registDate", registDate);
		jsonObj.put("commentView", commentView);
		
		response.setContentType("application/json; charset=UTF-8");
		response.getWriter().print(jsonObj);
		
		
	}

}
