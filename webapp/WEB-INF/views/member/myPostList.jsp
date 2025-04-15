<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.khedu.member.model.dto.MemberDTO,
					java.util.List,
					kr.co.khedu.common.PageInfo,
					kr.co.khedu.post.model.dto.PostSummaryDTO" %>
<% 
	String rootPath = request.getContextPath();
	MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 글 정보 관리</title>

    <!-- CSS style -->
        <link rel="stylesheet" href="<%= rootPath %>/assets/css/member/myPostList.css">
</head>

<body>
    <div id="root">
    <jsp:include page="../common/header.jsp" />
        <div class="container">
            <div class="mypost-left">
				<a href="<%=rootPath%>/members/mypage">내 정보 관리</a> <img
					src="<%=rootPath%>/assets/images/member/mypage-arrow.png" alt=">"><br>
				<hr>
				<a href="<%=rootPath%>/members/posts">내 글 정보 관리</a> <img
					src="<%=rootPath%>/assets/images/member/mypage-arrow.png" alt=">"><br>
				<hr>
				<a href="<%=rootPath%>/members/comments">내 댓글 정보 관리</a> <img
					src="<%=rootPath%>/assets/images/member/mypage-arrow.png" alt=">"><br>
				<hr>
				<a href="<%=rootPath%>/members/productLikes">상품 찜 목록</a> <img
					src="<%=rootPath%>/assets/images/member/mypage-arrow.png" alt=">"><br>
				<hr>
				<a href="<%=rootPath%>/members/#">개발중 . . .</a> <img
					src="<%=rootPath%>/assets/images/member/mypage-arrow.png" alt=">">
				<hr>
            </div>
            <div class="mypost-right">
                <div class="mypost-right-title">
                    <img src="<%= rootPath %>/assets/images/member/mypage-rectangle.png" alt="메뉴바">
                    <div id="title">내 글 정보 관리</div>
                </div>
                <div class="mypost-right-detail">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>글 제목</th>
                                <th>작성날짜</th>
                                <th>조회수</th>
                                <th>좋아요</th>
                                <th>수정</th>
                                <th>삭제</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<%
                        		List<? extends PostSummaryDTO> postList = (List<? extends PostSummaryDTO>) request.getAttribute("postList");
                        	%>
                        	<% for (PostSummaryDTO post : postList) { %>
                            <tr>
                                <td><%= post.getTitle() %></td>
                                <td><%= post.getCreatedAt() %></td>
                                <td><%= post.getLikes() %></td>
                                <td><%= post.getComments() %></td>
                                <td><a href="" id="edit"><i class="fa-solid fa-pen-to-square fa-lg"></i></a></td>
                                <td><a href="" id="edit"><i class="fa-solid fa-trash-can fa-lg"></i></a></td>
                            </tr>
                            <% } %>
                            <% if (postList.isEmpty()) { %>
                                <div class="post-empty">
                                    <h3>포스트가 없습니다.</h3>
                                </div>
                            <% } %>
                        </tbody>
                    </table>
                </div>
                <jsp:include page="../common/pageNation.jsp" />
            </div>
        </div>
	<jsp:include page="../common/footer.jsp" />
    </div>

	<script>
		window.addEventListener('load', function(){
			const postTr = document.querySelectorAll(".mypost-right-detail tbody tr");

			for(const ele of postTr){
				ele.onclick = function(){
					location.href = "/trip-log/posts/detail?no=" + ele.children[0].innerText;
					// TODO : 주소 수정
				}
			}
		});

		$(() => {
            $('.page-item').click(function(event) {
                event.preventDefault()

                const number = $(this).text().trim()
                if (!number) {
                    return
                }

                let url = window.location.href
                if (url.indexOf('?') > -1) {
                    url = url.replace(/([?&])page=\d+/, '?page=' + number)
                } else {
                    url += '?page=' + number
                }

                window.location.href = url
            })
        })
	</script>
</body>

</html>