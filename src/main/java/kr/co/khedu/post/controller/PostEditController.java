package kr.co.khedu.post.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.country.service.CountryServiceImpl;
import kr.co.khedu.post.model.dto.PostFormDTO;

import java.io.IOException;

@WebServlet("/post/edit")
public final class PostEditController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PostFormDTO form = new PostFormDTO(
                "Post Title",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Cras est leo, elementum mollis lectus eu, porta vehicula libero. " +
                        "In faucibus gravida enim, a ornare ante faucibus quis. " +
                        "Proin ac risus accumsan augue rutrum vulputate quis at dui. ",
                16
        );

        request.setAttribute("form", form);
        request.setAttribute("countries", new CountryServiceImpl().selectCountryList());
        request.getRequestDispatcher("/WEB-INF/views/post/write.jsp").forward(request, response);
    }
}
