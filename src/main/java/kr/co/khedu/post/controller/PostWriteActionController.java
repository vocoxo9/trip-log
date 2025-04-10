package kr.co.khedu.post.controller;

import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.post.model.dto.PostEditDTO;
import kr.co.khedu.post.model.dto.PostWriteDTO;
import kr.co.khedu.post.service.PostService;
import kr.co.khedu.post.service.PostServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@WebServlet("/post/writeAction")
public final class PostWriteActionController extends HttpServlet {
    private final PostService postService = new PostServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        Optional<Integer> optionalMemberId = Optional
                .ofNullable(request.getSession(false))
                .flatMap(session -> Optional.ofNullable(session.getAttribute("loginMember")))
                .map(member -> ((Member) member).getMemberId());

        if (optionalMemberId.isEmpty()) {
            request.setAttribute("errorMsg", "회원이 아닙니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
            return;
        }

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int countryId = Integer.parseInt(request.getParameter("countryId"));
        int memberId = optionalMemberId.get();

        Optional<Integer> optionalPostId = Optional
                .ofNullable(request.getParameter("postId"))
                .filter(string -> !string.isBlank())
                .map(Integer::parseInt);

        if (optionalPostId.isEmpty()) {
            postService.insertPost(new PostWriteDTO(title, content, countryId, memberId));
            response.sendRedirect("/trip-log/post/list");
            return;
        }

        int postId = optionalPostId.get();
        if (!postService.isPostOwner(postId, memberId)) {
            request.setAttribute("errorMsg", "수정할 권한이 없습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
            return;
        }

        postService.updatePost(new PostEditDTO(postId, title, content, countryId, memberId));
        response.sendRedirect("/trip-log/post/list");
    }
}
