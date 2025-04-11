package kr.co.khedu.vote.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.vote.model.vo.TravelVote;
import kr.co.khedu.vote.service.TravelVoteService;
import kr.co.khedu.vote.service.TravelVoteServiceImpl;

/**
 * Servlet implementation class TravelVoteResultPageController
 */
@WebServlet("/vote/result")
public class TravelVoteResultPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TravelVoteResultPageController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("컨트롤러로 요청은 들어왔음");

		TravelVoteService tvService = new TravelVoteServiceImpl();

		HttpSession session = request.getSession();
		// 입력받은 값 추출하기 (고른 여행지)
		Member loginUser = (Member) session.getAttribute("loginUser");
		System.out.println(loginUser);
		int userId = 2;
		String tDestination = request.getParameter("travel");
		System.out.println(tDestination);

		// 해당 회원의 투표정보가 있는지 확인 (SELECT)
		TravelVote tVote = tvService.selectVote(userId);
		System.out.println("tVote : " + tVote);

		if (tVote == null) {
			// service 객체로 전달받은 값 전달하여 DB에 저장
			int result = tvService.insertVote(userId, tDestination);

		} else {
			// service 객체로 전달받은 값 전달하여 UPDATE
			int result = tvService.updateVote(userId, tDestination);
		}

		request.getRequestDispatcher("WEB-INF/views/vote/travelVoteResult.jsp");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
