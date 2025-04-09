package kr.co.khedu.vote.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		int num = 1;
		
		// Service 객체에 전달받은 게시글번호의 게시글 정보(게시글 번호, 제목, 내용,  좋아요) 조회
		BoardDetailService bService = new BoardDetailServiceImpl();
		BoardDetail boardDetail = bService.selectBoardDetail(num);
		
		
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
