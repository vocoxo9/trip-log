<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="kr.co.khedu.member.model.dto.MemberDTO,
					java.util.List"%>
<%
	String rootPath = request.getContextPath();
	MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Trip:Log</title>
<!-- BootStrap CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

<!-- Font Awesome CDN -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
	integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="<%=rootPath%>/assets/css/reset.css">
<link rel="stylesheet" href="<%=rootPath%>/assets/css/member/mypage2.css">
</head>
<body>
	<div id="root">
		<jsp:include page="../common/header.jsp" />
		<div class="container">
			<div class="mypage-left">
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
				<a href="<%=rootPath%>/members/#">결제 내역</a> <img
					src="<%=rootPath%>/assets/images/member/mypage-arrow.png" alt=">">
				<hr>
			</div>
			<div class="mypage-right">
				<div class="mypage-right-title">
					<img src="<%=rootPath%>/assets/images/member/mypage-rectangle.png"
						alt="메뉴바">
					<div id="title">내 댓글 정보 관리</div>
				</div>
				<div class="mypage-right-detail">
					<table class="table table-hover">
						<thead>
							<tr>
								<th>댓글 번호</th>
								<th>댓글</th>
								<th>작성 날짜</th>
								<th>공감수</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>1</td>
								<td>댓글 내용입니다</td>
								<td>25.03.28</td>
								<td>33</td>
							</tr>
							<tr>
								<td>2</td>
								<td>댓글 내용입니다</td>
								<td>25.03.28</td>
								<td>33</td>
							</tr>
							<tr>
								<td>3</td>
								<td>댓글 내용입니다</td>
								<td>25.03.28</td>
								<td>33</td>
							</tr>
							<tr>
								<td>4</td>
								<td>댓글 내용입니다</td>
								<td>25.03.28</td>
								<td>33</td>
							</tr>
							<tr>
								<td>5</td>
								<td>댓글 내용입니다</td>
								<td>25.03.28</td>
								<td>33</td>
							</tr>
						</tbody>
					</table>
				</div>

				<div id="pagingArea">
					<ul class="pagination">
						<li class="page-item"><a href=""
							class="page-link icon-paging"><i
								class="fa-solid fa-less-than"></i></a></li>
						<li class="page-item"><a href="" class="page-link">1</a></li>
						<li class="page-item"><a href="" class="page-link">2</a></li>
						<li class="page-item"><a href="" class="page-link">3</a></li>
						<li class="page-item"><a href="" class="page-link">4</a></li>
						<li class="page-item"><a href="" class="page-link">5</a></li>
						<li class="page-item"><a href="" class="page-link">6</a></li>
						<li class="page-item"><a href="" class="page-link">7</a></li>
						<li class="page-item"><a href="" class="page-link">8</a></li>
						<li class="page-item"><a href="" class="page-link">9</a></li>
						<li class="page-item"><a href=""
							class="page-link icon-paging"><i
								class="fa-solid fa-greater-than"></i></a></li>
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
	</div>
</body>
</html>