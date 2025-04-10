package kr.co.khedu.post.controller;

import kr.co.khedu.country.service.CountryServiceImpl;
import kr.co.khedu.member.model.vo.Member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/post/write")
public final class PostWriteController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Optional<Integer> optionalMemberId = Optional
                .ofNullable(request.getSession(false))
                .flatMap(session -> Optional.ofNullable(session.getAttribute("loginMember")))
                .map(member -> ((Member) member).getMemberId());

        if (optionalMemberId.isEmpty()) {
            request.setAttribute("errorMsg", "회원이 아닙니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
            return;
        }

        request.setAttribute("form", null);
        request.setAttribute("countries", new CountryServiceImpl().selectCountryList());
        request.getRequestDispatcher("/WEB-INF/views/post/write.jsp").forward(request, response);
    }
}
