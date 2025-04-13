package kr.co.khedu.comment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import kr.co.khedu.post.model.vo.CommentLikeCountDto;
import kr.co.khedu.post.model.vo.PostLikeCountDto;
import kr.co.khedu.post.service.PostDetailService;
import kr.co.khedu.post.service.PostDetailServiceImpl;

/**
 * Servlet implementation class CommentLikeRegist
 */
@WebServlet("/commentLike/regist")
public class CommentLikeRegistController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentLikeRegistController() {
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
		String cno = request.getParameter("commentId");

		System.out.println("공감등록Controller에서 추출한 mno: " + mno);
		System.out.println("공감등록Controller에서 추출한 cno: " + cno);
		
		int memberId = Integer.parseInt(mno);
		int commentId = Integer.parseInt(cno);
		
		
		System.out.println("공감등록Controller에서 추출한 memberId: " + memberId);
		System.out.println("공감등록Controller에서 추출한 commentId: " + commentId);
		
		// 해당 회원으로 해당 댓글의 좋아요정보가 있는지 확인 (한사람당 각 게시글의 좋아요 한번 조건)
		CommentLikeCountDto check = pdService.checkCommentLike(memberId, commentId);
		
		System.out.println("전달받은 check : " + check);
		
		// 비어있다면 insert 비어있지 않다면 insert하지 않음
		if (check == null) {
			int result = pdService.insertCommentLike(memberId, commentId);			
			System.out.println("insert 함");
		} else {
			// 비어있지 않다면 delete 제거
			int result = pdService.deleteCommentLike(memberId, commentId);
			System.out.println("delete 함");
		}
		
		CommentLikeCountDto check2 = pdService.checkCommentLike(memberId, commentId);
		CommentLikeCountDto check3 = pdService.selectCommentLikeCount(commentId);
		
		// 해당 댓글의 번호와 좋아요 수 조회
		if (check2 == null) {
			CommentLikeCountDto commentLikeCount = new CommentLikeCountDto();
			// commentLikeCount.setCommentId(commentId);
			if (check3 ==null) {
				// CommentLikeCountDto commentLikeCount = new CommentLikeCountDto(commentId, 0);
				commentLikeCount.setCommentId(commentId);
				commentLikeCount.setCommentLikeCount(0);
			} else {
				// CommentLikeCountDto commentLikeCount = new CommentLikeCountDto(commentId, check3.getCommentLikeCount() );
				commentLikeCount.setCommentId(commentId);
				commentLikeCount.setCommentLikeCount( check3.getCommentLikeCount() );
				
			}
			System.out.println("댓글 delete후 commentLikeCount : " + commentLikeCount.getCommentLikeCount());
			// 일반 객체 (JSONObject)에 담아 응답
			JSONObject jsonObj = new JSONObject();
			jsonObj.put( "commentId", commentLikeCount.getCommentId() );
			jsonObj.put( "commentLikeCount", commentLikeCount.getCommentLikeCount() );
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(jsonObj);
		} else {
			CommentLikeCountDto commentLikeCount = pdService.selectCommentLikeCount(commentId);
			// 일반 객체 (JSONObject)에 담아 응답
			JSONObject jsonObj = new JSONObject();
			jsonObj.put( "commentId", commentLikeCount.getCommentId() );
			jsonObj.put( "commentLikeCount", commentLikeCount.getCommentLikeCount() );			
			response.setContentType("application/json; charset=UTF-8");
			response.getWriter().print(jsonObj);
		}
		
//		System.out.println("댓글의 좋아요 조회 후 좋아요 수 : " + commentLikeCount);

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
