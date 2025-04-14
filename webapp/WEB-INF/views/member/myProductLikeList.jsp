<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="kr.co.khedu.member.model.dto.MemberDTO,
					java.util.List,
					kr.co.khedu.common.PageInfo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String rootPath = request.getContextPath();
MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trip:Log</title>
<%--
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
 --%>
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
				<a href="<%=rootPath%>/members/#">개발중 . . .</a> <img
					src="<%=rootPath%>/assets/images/member/mypage-arrow.png" alt=">">
				<hr>
			</div>
			<div class="mypage-right">
				<div class="mypage-right-title">
					<img src="<%=rootPath%>/assets/images/member/mypage-rectangle.png"
						alt="메뉴바">
					<div id="title">상품 찜 목록</div>
				</div>
				<div class="mypage-right-detail">
					<table id="myFavoriteProductList" class="table table-hover">
						<thead>
							<tr>
								<th>상품 번호</th>
								<th>상품명</th>
								<th>가격</th>
								<th>재고</th>
								<%-- <th>상품 구매 날짜</th> --%>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${ not empty myProductFavoriteList }">
									<c:forEach var="myFavoriteProduct" items="${myProductFavoriteList }">
										<tr>
											<td>${myFavoriteProduct.productId }</td>
											<td><a href="/trip-log/products/detail/${myFavoriteProduct.productId }">${myFavoriteProduct.productName }</a></td>
											<td>${myFavoriteProduct.price }</td>
											<td>${myFavoriteProduct.stock }</td>
											<%-- <td>2025.04.03</td> --%>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="4">찜한 상품이 없습니다...ㅠ</td>
									</tr>
								</c:otherwise>
							</c:choose>
						</tbody>
					</table>
				</div>
				<%
					int currentPageNo = 0; 	// 현재 페이지 번호
					int startPageNo = 0;	// 시작 페이지 번호
					int endPageNo = 0;		// 끝 페이지 번호
					int maxPageNo = 0; 		// 가장 마지막 페이지 번호
					
					if(pageInfo != null) {
						currentPageNo = pageInfo.getCurrentPageNo(); 	
						startPageNo = pageInfo.getStartPageNo();	
						endPageNo = pageInfo.getEndPageNo();		
						maxPageNo = pageInfo.getMaxPageNo();
					}
					
					System.out.println(pageInfo);
				%>
				<div id="pagingArea">
					<ul class="pagination">
						<c:choose>
							<c:when test="<%= currentPageNo == 1 || startPageNo == 1 %>">
								<%-- 현재 페이지 번호가 1일 경우 --%>
								<li class="page-item disabled">
									<a class="page-link icon-paging">
										<i class="fa-solid fa-less-than"></i>
									</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item">
									<a data-current="<%= currentPageNo - 1 %>" class="page-link icon-paging">
										<i class="fa-solid fa-less-than"></i>
									</a>
								</li>
							</c:otherwise>
						</c:choose>
						<% for (int pageNo = startPageNo; pageNo <= endPageNo; pageNo++) { %>
							<li class="page-item <% if (currentPageNo == pageNo) { %>active<% } %>">
	                           	<a class="page-link" data-current="<%= pageNo %>"><%= pageNo %></a>
	                        </li>
						<% } %>
						<c:choose>
							<c:when test="<%= currentPageNo == maxPageNo || maxPageNo == 0 %>">
								<li class="page-item disabled">
									<a href="" class="page-link icon-paging">
										<i class="fa-solid fa-greater-than"></i>
									</a>
								</li>
							</c:when>
							<c:otherwise>
								<li class="page-item">
									<a data-current="<%= currentPageNo + 1 %>" class="page-link icon-paging">
										<i class="fa-solid fa-greater-than"></i>
									</a>
								</li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp" />
		<script src="<%= rootPath %>/assets/js/member/myFavoriteProducts.js"></script>
	</div>
</body>
</html>