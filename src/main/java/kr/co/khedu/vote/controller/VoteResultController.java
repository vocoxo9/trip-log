package kr.co.khedu.vote.controller;

import kr.co.khedu.vote.model.dto.VoteDTO;
import kr.co.khedu.vote.service.VoteService;
import kr.co.khedu.vote.service.VoteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/vote/result")
public final class VoteResultController extends HttpServlet {
    private final VoteService voteService = new VoteServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<? extends VoteDTO> votes = voteService.selectVoteList();
        
        if (votes == null) {
            request.setAttribute("errorMsg", "투표 결과를 불러올 수 없습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
            return;
        }
        
        request.setAttribute("votes", votes);
        request.getRequestDispatcher("/WEB-INF/views/vote/result.jsp").forward(request, response);
    }
}
