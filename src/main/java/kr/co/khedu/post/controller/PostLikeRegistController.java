package kr.co.khedu.post.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.khedu.post.model.dto.PostLikeCountDTO;
import kr.co.khedu.post.service.PostDetailService;
import kr.co.khedu.post.service.PostDetailServiceImpl;

/**
 * Servlet implementation class PostLikeRegistController
 */
@WebServlet("/postLike/regist")
public class PostLikeRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostLikeRegistController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PostDetailService pdService = new PostDetailServiceImpl();
		
		// 전달받은 값 추출
		String mno = request.getParameter("memberId");
		String pno = request.getParameter("postId");
		
		int memberId = Integer.parseInt(mno);
		int postId = Integer.parseInt(pno);
		System.out.println("공감등록Controller에서 추출한 memberId: " + memberId);
		System.out.println("공감등록Controller에서 추출한 postId: " + postId);
		
		// 해당 회원으로 해당 게시글의 좋아요정보가 있는지 확인 (한사람당 각 게시글의 좋아요 한번 조건)
		PostLikeCountDTO check = pdService.checkPostLike(memberId, postId);
		
		System.out.println("전달받은 check : " + check);
		
		// 비어있다면 insert 비어있지 않다면 insert하지 않음
		if (check == null) {
			int result = pdService.insertPostLike(memberId, postId);			
		} else {
			int result = pdService.deletePostLike(memberId, postId);
		}
		
		PostLikeCountDTO check2 = pdService.checkPostLike(memberId, postId);
		PostLikeCountDTO check3 = pdService.selectPostLikeCount(postId);
		
		// 해당 게시글의 번호와 좋아요 수 조회
		if (check2 == null) {
			PostLikeCountDTO postLikeCount = new PostLikeCountDTO();
			if (check3 ==null) {
				postLikeCount.setPostId(postId);
				postLikeCount.setPostLikeCount(0);
			} else {
				postLikeCount.setPostId(postId);
				postLikeCount.setPostLikeCount( check3.getPostLikeCount() );
			}
			System.out.println("게시글 delete후 postLikeCount : " + postLikeCount.getPostLikeCount());
			// 일반 객체 (JSONObject)에 담아 응답
			JSONObject jsonObj = new JSONObject();
			jsonObj.put( "postId", postLikeCount.getPostId() );
			jsonObj.put( "postLikeCount", postLikeCount.getPostLikeCount() );
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(jsonObj);
		} else {
			PostLikeCountDTO postLikeCount = pdService.selectPostLikeCount(postId);
			// 일반 객체 (JSONObject)에 담아 응답
			JSONObject jsonObj = new JSONObject();
			jsonObj.put( "postId", postLikeCount.getPostId() );
			jsonObj.put( "postLikeCount", postLikeCount.getPostLikeCount() );			
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(jsonObj);
		}
		
//		// 해당 게시글의 번호와 좋아요 수 조회
//		PostLikeCountDto postLikeCount = pdService.selectPostLikeCount(postId);
//		
//		// 일반 객체 (JSONObject)에 담아 응답
//		JSONObject jsonObj = new JSONObject();
//		jsonObj.put("postId", postLikeCount.getPostId());
//		jsonObj.put("postLikeCount", postLikeCount.getPostLikeCount());
//		
//		System.out.println("공감등록 controller에서 postLikeCount : " + postLikeCount);
//		
//		response.setContentType("application/json; charset=UTF-8");
//		response.getWriter().print(jsonObj);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
