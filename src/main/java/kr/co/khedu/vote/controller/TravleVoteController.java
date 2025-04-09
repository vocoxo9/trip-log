package kr.co.khedu.vote.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.board.model.vo.BoardDetail;
import kr.co.khedu.board.service.BoardDetailService;
import kr.co.khedu.board.service.BoardDetailServiceImpl;

/**
 * Servlet implementation class TravleVoteController
 */
@WebServlet("/travelVote")
public class TravleVoteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public TravleVoteController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.getRequestDispatcher("WEB-INF/views/vote/travelVote.jsp").forward(request, response);
		// => travelVote 페이지로 이동
		System.out.println("Controller에 요청은 들어옴");
		
		// 게시글의 임의의 번호
		int num = 1;
		
		// Service 객체에 전달받은 게시글번호의 게시글 정보(게시글 번호, 제목, 내용,  좋아요) 조회
		BoardDetailService bdService = new BoardDetailServiceImpl();
		BoardDetail boardDetail = bdService.selectBoardDetail(num);
		// => 조회된 결과가 있을 경우 BoardDetail 객체 전달
		// 				없을 경우 null이 전달
		
		if (boardDetail != null) {
			System.out.println("Controller 에서 서비스에게 반환받은 boardDetail : " + boardDetail);
			// request 영역에 요청 후 반환받은 값 저장
			request.setAttribute("boardDetail", boardDetail);
			System.out.println("Controller에서의 boardDetail : " + boardDetail);
		}
		
		
		
		request.getRequestDispatcher("WEB-INF/views/board/boardDetail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
