package kr.co.khedu.comment.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import kr.co.khedu.post.model.vo.ReplyDto;
import kr.co.khedu.post.service.PostDetailService;
import kr.co.khedu.post.service.PostDetailServiceImpl;

/**
 * Servlet implementation class ReplyListSelectController
 */
@WebServlet("/replyList/select")
public class ReplyListSelectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyListSelectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int parentNum = Integer.parseInt(request.getParameter("parentNum"));
		int postNum = Integer.parseInt(request.getParameter("postNum"));
		
		PostDetailService bdService = new PostDetailServiceImpl();
		ArrayList<ReplyDto> replys = (ArrayList<ReplyDto>)bdService.selectReplyList(parentNum, postNum);
		// => 조회된 결과가 있을 경우 ArrayList<ReplyDto> 전달
		//				없을 경우 null이 전달
		System.out.println("controller에서의 replys : " + replys);
		
		if (replys != null) {
			// 일반 객체 (JSONObject)에 담아 응답
			Gson gson = new Gson();
			
			response.setContentType("application/json; charset=UTF-8");
			gson.toJson( replys, response.getWriter() );
			System.out.println("gSon통해서");
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
