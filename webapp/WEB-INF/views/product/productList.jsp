<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.co.khedu.common.PageInfo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String rootPath = request.getContextPath();
	PageInfo pageInfo = (PageInfo) request.getAttribute("pageInfo");
	String keyword = (String) request.getAttribute("keyword") == null ? "" : (String) request.getAttribute("keyword");
	String sortCondition = (String) request.getAttribute("sortCondition") == null ? "" : (String) request.getAttribute("sortCondition");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trip:Log</title>
<link rel="stylesheet" href="<%= rootPath %>/assets/css/product/productList.css">
</head>
<body>
	<div id="root">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<div class="container">
			<div class="product-list-area">
				<div class="product-search-bar-area">
					<form action="/trip-log/products" method="get" id="productSearchForm">
						<div class="product-search-bar">
							<input type="search" name="keyword" value="<%= keyword %>" class="form-control me-3" id="exampleFormControlInput1" placeholder="찾으시는 상품이 있을까요?">

							<div class="order-select">
								<select class="sort-select form-select" name="sort">
									<option value="recentValue">최신순</option>
									<option value="reviewValue">평점순</option>
									<option value="priceValue">가격순</option>
								</select>
							</div>
							<button class="search-btn">검색</button>
						</div>						
					</form>
				</div>
				
				<%-- 관리자일 경우에만 보이기 --%>
				<c:if test="${ loginMember.getMemberId() == 1 }">
					<div class="product-menu-area">
						<div class="product-insert-btn-area">
							<a href="register" class="product-insert-btn"> 
								<i class="fa-solid fa-cart-plus"></i> <!-- 상품등록 -->
							</a>
						</div>
					</div>
				</c:if>

				<ul class="product-list">
					<c:choose>
						<c:when test="${ not empty pList }">
							<c:forEach var="p" items="${ pList }">
								<li class="product-list-card">
									<a href="products/detail/${p.productId }">
										<span class="product-list-card-header">
											<%-- <span class="heart-icon"><i class="fa-solid fa-heart"></i></span> --%>
											<span class="location-text"><i class="fa-solid fa-location-dot"></i> ${ p.countryName } </span>
										</span>
										<%--
										<c:choose>
											<c:when test="${p.changeFileName == defaultPath}">
											${pageContext.request.contextPath}/${defaultPath}
												<img src="${pageContext.request.contextPath}/${defaultPath}" alt="Product Image" class="product-image" />
											</c:when>
											<c:otherwise>
												<img src="/trip-log${p.changeFileName}" alt="Product Image" class="product-image" />
											</c:otherwise>
										</c:choose>
										 --%>
										<%--
										<img src="<%= rootPath %>/resources/upload/${product.changeFileName}" alt="Product Image" class="product-image" />
										 --%>
										 <img src="<%= rootPath %>/${p.changeFileName}" alt="Product Image" class="product-image" />
										<span class="product-list-card-body">
											<span class="product-item-title">${ p.name }</span>
											<span><fmt:formatNumber value="${p.price}" type="number" groupingUsed="true" />원</span>
											<span>
												<i class="fa-solid fa-star"></i> ${ p.score }
											</span>
										</span>
									</a>
								</li>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<li class="product-list-card" style="width: 100%; display:flex; justify-content: center; text-align: center;">
								<p>등록된 상품이 없습니다...ㅠ</p>
							</li>
						</c:otherwise>
					</c:choose>
				</ul>
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
						<c:when test="<%= currentPageNo == 1 %>">
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
						<c:when test="<%= currentPageNo == maxPageNo %>">
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
		<jsp:include page="../common/footer.jsp"></jsp:include>
		<script src="assets/js/product/productList.js"></script>
	</div>
</body>
</html>