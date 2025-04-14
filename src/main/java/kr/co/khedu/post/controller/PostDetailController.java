package kr.co.khedu.post.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.post.model.dto.CommentDTO;
import kr.co.khedu.post.model.dto.PostDetailDTO;
import kr.co.khedu.post.service.PostDetailService;
import kr.co.khedu.post.service.PostDetailServiceImpl;

/**
 * Servlet implementation class PostDetailController
 */
@WebServlet("/postDetail")
public class PostDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PostDetailService pdService = new PostDetailServiceImpl();

		// 게시글의 임의의 번호
//		int pNum = 1;
		String pno = request.getParameter("pno");
		
		int pNum = Integer.parseInt(pno);
		
		System.out.println("전달받은 pNum의 값은 : " + pNum);
		
		// Service 객체에 전달받은 게시글번호의 게시글 정보(게시글 번호, 제목, 내용,  좋아요) 조회
		PostDetailDTO postDetail = pdService.selectPostDetail(pNum);
		// => 조회된 결과가 있을 경우 PostDetail 객체 전달
		// 				없을 경우 null이 전달

		var pair = pdService.getPostPair(pNum);
		
		// 게시글의 번호의 -1, +1 게시글 번호 변수에 저장
		int beforePNum = pair.getPrevious();
		int afterPNum = pair.getNext();
		
		// Service 객체에 전달받은 게시글 번호의 -1, +1의 게시글의 번호와 제목을 조회
		PostDetailDTO beforePost = pdService.selectPost(beforePNum);
		PostDetailDTO afterPost = pdService.selectPost(afterPNum);

		System.out.println("Controller에서 beforePost : " + beforePost);
		System.out.println("Controller에서 afterPost : " + afterPost);

		// request 영역에 이전글/다음글 저장
		request.setAttribute("beforePost", beforePost);
		request.setAttribute("afterPost", afterPost);

		
		System.out.println("게시글 정보는 조회됨");

		// Service 객체에 전달받은 게시글 번호의 댓글 리스트 조회(댓글번호, 사용자명, 작성일, 댓글 내용, 댓글 좋아요 수, 게시글 번호)
		ArrayList<CommentDTO> comments = pdService.selectCommentList(pNum);
		System.out.println("comments controller에서 반환받음 : " + comments);
		
		
		if (comments != null) {
			request.setAttribute("comments", comments);
		}
		
		// 조회한 게시글이 있는지 없는지 검사
		if (postDetail != null) {
			// 조회된 게시글이 있는 경우
			System.out.println("Controller 에서 서비스에게 반환받은 postDetail : " + postDetail);
			// request 영역에 요청 후 반환받은 값 저장
			request.setAttribute("postDetail", postDetail);
			System.out.println("Controller에서의 postDetail : " + postDetail);
			request.getRequestDispatcher("WEB-INF/views/post/postDetail.jsp").forward(request, response);
		} else {
			// 조회된 게시글이 없는 경우 error페이지로
			request.setAttribute("errorMsg", "잘못된 접근입니다.");
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
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
