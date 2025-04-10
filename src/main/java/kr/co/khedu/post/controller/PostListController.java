package kr.co.khedu.post.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.khedu.post.model.dto.PostSummaryDTO;
import kr.co.khedu.post.service.PostServiceImpl;

import java.io.IOException;
import java.util.List;

@WebServlet("/post/list")
public final class PostListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<? extends PostSummaryDTO> posts = new PostServiceImpl().getPostSummaries();

        request.setAttribute("posts", posts);
        request.getRequestDispatcher("/WEB-INF/views/post/list.jsp").forward(request, response);
    }
}
