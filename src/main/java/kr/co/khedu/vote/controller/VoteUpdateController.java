package kr.co.khedu.vote.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.vote.model.vo.Vote;
import kr.co.khedu.vote.service.VoteService;
import kr.co.khedu.vote.service.VoteServiceImpl;

@WebServlet("/vote/update")
public class VoteUpdateController extends HttpServlet {
    private final VoteService tvService = new VoteServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        Member loginUser = (Member) session.getAttribute("loginMember");
        int userId = loginUser.getMemberId();

        String tDestination = request.getParameter("travel");
        Vote tVote = tvService.selectVote(userId);

        if (tVote == null) {
            tvService.insertVote(userId, tDestination);
        } else {
            tvService.updateVote(userId, tDestination);
        }

        request.getRequestDispatcher("/vote/result").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
