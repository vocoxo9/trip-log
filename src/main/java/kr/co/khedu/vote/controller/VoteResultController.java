package kr.co.khedu.vote.controller;

import com.google.gson.Gson;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

@WebServlet("/vote/result")
public final class VoteResultController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String result = new Gson().toJson(
                Map.of(
                        "가평", 26,
                        "강릉", 13,
                        "속초", 1,
                        "여수", 13,
                        "춘천", 19,
                        "전주", 4,
                        "부산", 16,
                        "제주도", 8
                )
        );

        request.setAttribute("result", result);
        request.getRequestDispatcher("/WEB-INF/views/vote/result.jsp").forward(request, response);
    }
}
