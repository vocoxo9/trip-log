package kr.co.khedu.post.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import kr.co.khedu.post.dto.PostSummaryDTO;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet("/post/list")
public final class PostListController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<? extends PostSummaryDTO> posts = List.of(
                new PostSummaryDTO(
                        "Post 1",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras est leo, elementum mollis lectus eu, porta vehicula libero. In faucibus gravida enim, a ornare ante faucibus quis. Proin ac risus accumsan augue rutrum vulputate quis at dui. Cras venenatis dolor et laoreet mattis. Integer felis mi, vehicula a lobortis non, imperdiet bibendum sem.",
                        new Date(System.currentTimeMillis()),
                        34,
                        10
                ),
                new PostSummaryDTO(
                        "Post 2",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
                        new Date(System.currentTimeMillis()),
                        81,
                        22
                ),
                new PostSummaryDTO(
                        "Post 3",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras est leo, elementum mollis lectus eu, porta vehicula libero.",
                        new Date(System.currentTimeMillis()),
                        64,
                        12
                ),
                new PostSummaryDTO(
                        "Post 4",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras est leo, elementum mollis lectus eu, porta vehicula libero. In faucibus gravida enim, a ornare ante faucibus quis. Proin ac risus accumsan augue rutrum vulputate quis at dui. Cras venenatis dolor et laoreet mattis.",
                        new Date(System.currentTimeMillis()),
                        8,
                        1
                ),
                new PostSummaryDTO(
                        "Post 5",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras est leo, elementum mollis lectus eu, porta vehicula libero.",
                        new Date(System.currentTimeMillis()),
                        6,
                        9
                ),
                new PostSummaryDTO(
                        "Post 6",
                        "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras est leo, elementum mollis lectus eu, porta vehicula libero. In faucibus gravida enim, a ornare ante faucibus quis. Proin ac risus accumsan augue rutrum vulputate quis at dui. Cras venenatis dolor et laoreet mattis. Integer felis mi, vehicula a lobortis non, imperdiet bibendum sem.",
                        new Date(System.currentTimeMillis()),
                        91,
                        32
                )
        );

        request.setAttribute("posts", posts);
        request.getRequestDispatcher("/WEB-INF/views/post/list.jsp").forward(request, response);
    }
}
