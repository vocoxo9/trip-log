package kr.co.khedu.post.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.post.model.vo.CommentDto;
import kr.co.khedu.post.model.vo.PostDetailDto;
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

		// 게시글의 임의의 번호
//		int pNum = 1;
		String pno = request.getParameter("pno");
		
		int pNum = Integer.parseInt(pno);
		
		System.out.println("전달받은 pNum의 값은 : " + pNum);
		
		// Service 객체에 전달받은 게시글번호의 게시글 정보(게시글 번호, 제목, 내용,  좋아요) 조회
		PostDetailService pdService = new PostDetailServiceImpl();
		PostDetailDto postDetail = pdService.selectPostDetail(pNum);
		// => 조회된 결과가 있을 경우 PostDetail 객체 전달
		// 				없을 경우 null이 전달
		
		// Service 객체에 전달받은 게시글 번호의 -1, +1의 게시글의 번호와 제목을 조회
		// 게시글의 번호의 -1, +1 게시글 번호 변수에 저장
		int beforePNum = pNum - 1;
		int afterPNum = pNum + 1;
		
		// 이전글이 없을 경우나 다음글이 없을 경우 (+ 다음글도 마지막 길이 구해서 조건 넣기)
		if (beforePNum < 1) {
			PostDetailDto beforePost = new PostDetailDto(0, "글이 없습니다.");
			PostDetailDto afterPost = pdService.selectPost(afterPNum);

			if (beforePost == null) {
				beforePost.setPostId(0);
				beforePost.setTitle("이전글이 없습니다..");			
			}
			if (afterPost == null) {
				afterPost.setPostId(0);
				afterPost.setTitle("다음글이 없습니다..");			
			}
			System.out.println("Controller에서 beforePost : " + beforePost);
			System.out.println("Controller에서 afterPost : " + afterPost);
			
			request.setAttribute("beforePost", beforePost);
			request.setAttribute("afterPost", afterPost);
		} else {
			PostDetailDto beforePost = pdService.selectPost(beforePNum);			
			PostDetailDto afterPost = pdService.selectPost(afterPNum);
			
			if (beforePost == null) {
				beforePost.setPostId(0);
				beforePost.setTitle("이전글이 없습니다..");			
			}
			if (afterPost == null) {
				afterPost.setPostId(0);
				afterPost.setTitle("다음글이 없습니다..");			
			}
			System.out.println("Controller에서 beforePost : " + beforePost);
			System.out.println("Controller에서 afterPost : " + afterPost);
			
			request.setAttribute("beforePost", beforePost);
			request.setAttribute("afterPost", afterPost);
		}
		
		
		
		System.out.println("게시글 정보는 조회됨");
		if (postDetail != null) {
			System.out.println("Controller 에서 서비스에게 반환받은 postDetail : " + postDetail);
			// request 영역에 요청 후 반환받은 값 저장
			request.setAttribute("postDetail", postDetail);
			System.out.println("Controller에서의 postDetail : " + postDetail);
		}
		
		// Service 객체에 전달받은 게시글 번호의 댓글 리스트 조회(댓글번호, 사용자명, 작성일, 댓글 내용, 댓글 좋아요 수, 게시글 번호)
		ArrayList<CommentDto> comments = pdService.selectCommentList(pNum);
		System.out.println("comments controller에서 반환받음 : " + comments);
		
		
		if (comments != null) {
			request.setAttribute("comments", comments);
		}
		
	
		request.getRequestDispatcher("WEB-INF/views/post/postDetail.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
