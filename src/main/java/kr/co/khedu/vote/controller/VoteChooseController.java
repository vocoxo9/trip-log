package kr.co.khedu.vote.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/vote/choose")
public final class VoteChooseController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Controller에 요청은 들어옴");

		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		request.getRequestDispatcher("/WEB-INF/views/vote/choose.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	// 1. 투표 선택 페이지
	// 2. 투표 반영
	// 3. 투표 결과 페이지
}
