<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%
	String rootPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= rootPath %>/assets/css/product/productList.css">
</head>
<body>
	<div id="root">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<div class="container">
			<div class="product-list-area">
				<div class="product-menu-area">
					<div class="product-insert-btn-area">
						<a class="product-insert-btn"> 
							<i class="fa-solid fa-cart-plus"></i> <!-- 상품등록 -->
						</a>
					</div>
					<div class="order-select">
						<select class="form-select" aria-label="Default select example">
							<option value="1" selected>최신순</option>
							<option value="2">평점순</option>
							<option value="3">찜순</option>
						</select>
					</div>
				</div>

				<ul class="product-list">
					<c:choose>
						<c:when test="${ not empty pList }">
							<c:forEach var="p" items="${ pList }">
								<li class="product-list-card">
									<a href="products/detail/${p.productId }"> <%-- url 요청 주소 생각하기! + 상품의 찜 아이콘 우측 정렬하기! --%>
										<span class="product-list-card-header">
											<span class="heart-icon"><i class="fa-solid fa-heart"></i></span>
										</span>
										<img src="<%= rootPath %>/assets/images/product/sample-img.jpg"
											class="product-image" />
										<span class="product-list-card-body">
											<span class="product-item-title">${ p.name }</span>
											<span><fmt:formatNumber value="${p.price}" type="number" groupingUsed="true" />원</span>
											<span>
												<!-- 평점 값으로 별 색상 채우기 -->
												<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
												<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
												<i class="fa-solid fa-star"></i>
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
		</div>
		<jsp:include page="../common/footer.jsp"></jsp:include>
		<script src="assets/js/product/productList.js"></script>
	</div>
</body>
</html>