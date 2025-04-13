package kr.co.khedu.member.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.post.model.dto.PostSummaryDTO;
import kr.co.khedu.post.service.PostService;
import kr.co.khedu.post.service.PostServiceImpl;

@WebServlet("/members/posts")
public final class MemberMypostController extends HttpServlet {
    private final PostService pService = new PostServiceImpl();

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

        int page = Optional.ofNullable(request.getParameter("page"))
                .map(Integer::parseInt)
                .orElse(1);

        int memberId = optionalMemberId.get();
        List<? extends PostSummaryDTO> postList = pService.getPostSummariesByMemberId(page, memberId);
        request.setAttribute("postList", postList);
        request.getRequestDispatcher("/WEB-INF/views/member/myPostList.jsp").forward(request, response);
    }
}
