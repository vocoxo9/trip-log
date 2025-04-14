package kr.co.khedu.post.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.khedu.member.model.vo.Member;
import kr.co.khedu.post.service.PostDetailService;
import kr.co.khedu.post.service.PostDetailServiceImpl;
import kr.co.khedu.post.service.PostService;
import kr.co.khedu.post.service.PostServiceImpl;

@WebServlet("/post/delete")
public class PostDeleteController extends HttpServlet {
    private final PostService postService = new PostServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("게시글 삭제 요청 들어옴");
        PostDetailService pdService = new PostDetailServiceImpl();

        // 해당 post의 번호 추출
        String pno = request.getParameter("pno");
        int postId = Integer.parseInt(pno);

        // 멤버 아이디 추출
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

        System.out.println("Controller에서 postId : " + postId);

        // Service로 추출한 postId 전달하여 delete 요청
        int result = pdService.deletePost(postId);

        // postList 화면으로 서비스요청
        if (result > 0) {
            request.getRequestDispatcher("/post/list").forward(request, response);
        } else {
            // 삭제 실패
            request.setAttribute("errorMsg", "삭제 실패했습니다.");
            request.getRequestDispatcher("/WEB-INF/views/common/errorPage.jsp").forward(request, response);
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
