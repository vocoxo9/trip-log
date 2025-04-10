<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.khedu.member.model.dto.MemberDTO,
					java.util.List,
					kr.co.khedu.common.PageInfo,
					kr.co.khedu.post.model.vo.Post" %>
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
                <a href="<%=rootPath%>/members/mypage">내 정보 관리</a> <img src="<%= rootPath %>/assets/images/member/mypage-arrow.png" alt=">"><br>
                <hr>
                <a href="<%=rootPath%>/members/posts">내 글 정보 관리</a> <img src="<%= rootPath %>/assets/images/member/mypage-arrow.png" alt=">"><br>
                <hr>
                <a href="<%=rootPath%>/members/#">내 댓글 정보 관리</a> <img src="<%= rootPath %>/assets/images/member/mypage-arrow.png" alt=">"><br>
                <hr>
                <a href="<%=rootPath%>/members/#">상품 찜 목록</a> <img src="<%= rootPath %>/assets/images/member/mypage-arrow.png" alt=">"><br>
                <hr>
                <a href="<%=rootPath%>/members/#">결제 내역</a> <img src="<%= rootPath %>/assets/images/member/mypage-arrow.png" alt=">">
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
                                <th>글 번호</th>
                                <th>글 제목</th>
                                <th>작성자</th>
                                <th>작성날짜</th>
                                <th>조회수</th>
                                <th>수정</th>
                                <th>삭제</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<% 
                        		List<Post> postList = (List<Post>)request.getAttribute("postList");
                        	%>
                        	<% for ( Post p : postList ){ %>
                            <tr>
                                <td><%= p.getPostId() %></td>
                                <td><%= p.getTitle() %></td>
                                <td><%= p.getMemberId() %></td>
                                <td><%= p.getCreatedAt() %></td>
                                <td><%= p.getViews() %></td>
                                <td><a href="" id="edit"><i class="fa-solid fa-pen-to-square fa-lg"></i></a></td>
                                <td><a href="" id="edit"><i class="fa-solid fa-trash-can fa-lg"></i></a></td>
                            </tr>
                            <% } %>
                            <tr>
                                <td>1</td>
                                <td>글 제목입니다.</td>
                                <td>관리자</td>
                                <td>25.03.28</td>
                                <td>99</td>
                                <td><a href=""><i class="fa-solid fa-pen-to-square fa-lg"></i></a></td>
                                <td><a href=""><i class="fa-solid fa-trash-can fa-lg"></i></a></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>글 제목입니다.</td>
                                <td>관리자</td>
                                <td>25.03.28</td>
                                <td>99</td>
                                <td><a href=""><i class="fa-solid fa-pen-to-square fa-lg"></i></a></td>
                                <td><a href=""><i class="fa-solid fa-trash-can fa-lg"></i></a></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>글 제목입니다.</td>
                                <td>관리자</td>
                                <td>25.03.28</td>
                                <td>99</td>
                                <td><a href=""><i class="fa-solid fa-pen-to-square fa-lg"></i></a></td>
                                <td><a href=""><i class="fa-solid fa-trash-can fa-lg"></i></a></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>글 제목입니다.</td>
                                <td>관리자</td>
                                <td>25.03.28</td>
                                <td>99</td>
                                <td><a href=""><i class="fa-solid fa-pen-to-square fa-lg"></i></a></td>
                                <td><a href=""><i class="fa-solid fa-trash-can fa-lg"></i></a></td>
                            </tr>
                            <tr>
                                <td>1</td>
                                <td>글 제목입니다.</td>
                                <td>관리자</td>
                                <td>25.03.28</td>
                                <td>99</td>
                                <td><a href=""><i class="fa-solid fa-pen-to-square fa-lg"></i></a></td>
                                <td><a href=""><i class="fa-solid fa-trash-can fa-lg"></i></a></td>
                            </tr>
                        </tbody>
                    </table>
                </div>

                <div id="pagingArea">
                    <ul class="pagination">
                        <li class="page-item"><a href="" class="page-link icon-paging"><i class="fa-solid fa-less-than"></i></a></li>
                        <li class="page-item"><a href="" class="page-link">1</a></li>
                        <li class="page-item"><a href="" class="page-link">2</a></li>
                        <li class="page-item"><a href="" class="page-link">3</a></li>
                        <li class="page-item"><a href="" class="page-link">4</a></li>
                        <li class="page-item"><a href="" class="page-link">5</a></li>
                        <li class="page-item"><a href="" class="page-link">6</a></li>
                        <li class="page-item"><a href="" class="page-link">7</a></li>
                        <li class="page-item"><a href="" class="page-link">8</a></li>
                        <li class="page-item"><a href="" class="page-link">9</a></li>
                        <li class="page-item"><a href="" class="page-link icon-paging"><i class="fa-solid fa-greater-than"></i></a></li>
                    </ul>
                </div>
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
	</script>
</body>

</html>