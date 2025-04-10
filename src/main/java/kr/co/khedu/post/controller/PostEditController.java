package kr.co.khedu.post.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.country.service.CountryService;
import kr.co.khedu.country.service.CountryServiceImpl;
import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.post.model.dto.PostEditDTO;
import kr.co.khedu.post.service.PostService;
import kr.co.khedu.post.service.PostServiceImpl;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/post/edit")
public final class PostEditController extends HttpServlet {
    private final PostService postService = new PostServiceImpl();
    private final CountryService countryService = new CountryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // postId 파라미터 얻기
        Optional<Integer> optionalPostId = Optional
                .ofNullable(request.getParameter("postId"))
                .filter(string -> !string.isBlank())
                .map(Integer::parseInt);

        // 없으면 에러
        if (optionalPostId.isEmpty()) {
            request.setAttribute("errorMsg", "글 파라미터가 없습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
            return;
        }

        // 포스트 정보 불러오기
        int postId = optionalPostId.get();
        Optional<PostEditDTO> optionalForm = postService.searchFormById(postId);

        // 없으면 에러
        if (optionalForm.isEmpty()) {
            request.setAttribute("errorMsg", "글을 찾을 수 없습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
            return;
        }

        // 멤버 아이디 찾기
        Optional<Integer> optionalMemberId = Optional
                .ofNullable(request.getSession(false))
                .flatMap(session -> Optional.ofNullable(session.getAttribute("loginMember")))
                .map(member -> ((Member) member).getMemberId());

        // 없으면 에러
        if (optionalMemberId.isEmpty()) {
            request.setAttribute("errorMsg", "회원이 아닙니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
            return;
        }

        // 글을 작성한 멤버와 세션의 멤버가 다르면 에러
        int memberId = optionalMemberId.get();
        if (!postService.isPostOwner(postId, memberId)) {
            request.setAttribute("errorMsg", "수정할 권한이 없습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
            return;
        }

        PostEditDTO form = optionalForm.get();
        request.setAttribute("form", form);
        request.setAttribute("countries", countryService.selectCountryList());
        request.getRequestDispatcher("/WEB-INF/views/post/write.jsp").forward(request, response);
    }
}
