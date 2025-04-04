<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
	<div class="container">
		<div class="product-list-area">
			<div class="product-menu-area">
				<div class="product-insert-btn-area">
					<a class="product-insert-btn"> <i class="fa-solid fa-cart-plus"></i>
						<!-- 상품등록 -->
					</a>
				</div>
				<div class="dropdown">
					<button class="btn btn-secondary dropdown-toggle" type="button"
						data-bs-toggle="dropdown" aria-expanded="false">정렬</button>
					<ul class="dropdown-menu">
						<li><a class="dropdown-item" href="#">최신순</a></li>
						<li><a class="dropdown-item" href="#">리뷰순</a></li>
						<li><a class="dropdown-item" href="#">인기순</a></li>
					</ul>
				</div>
			</div>

			<div class="product-list">
				<div class="product-list-card">
					<div class="product-list-card-header">
						<span class="heart-icon"><i class="fa-solid fa-heart"></i></span>
					</div>
					<img src="./images/sample-img.jpg" class="product-image" />
					<div class="product-list-card-body">
						<p>상품명</p>
						<p>1,000,000 원</p>
						<p>
							<!-- 평점 값으로 별 색상 채우기 -->
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i>
						</p>
					</div>
				</div>
				<div class="product-list-card">
					<div class="product-list-card-header">
						<span class="heart-icon"><i class="fa-solid fa-heart"></i></span>
					</div>
					<img src="./images/sample-img.jpg" class="product-image" />
					<div class="product-list-card-body">
						<p>상품명</p>
						<p>1,000,000 원</p>
						<p>
							<!-- 평점 값으로 별 색상 채우기 -->
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i>
						</p>
					</div>
				</div>
				<div class="product-list-card">
					<div class="product-list-card-header">
						<span class="heart-icon"><i class="fa-solid fa-heart"></i></span>
					</div>
					<img src="./images/sample-img.jpg" class="product-image" />
					<div class="product-list-card-body">
						<p>상품명</p>
						<p>1,000,000 원</p>
						<p>
							<!-- 평점 값으로 별 색상 채우기 -->
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i>
						</p>
					</div>
				</div>
				<div class="product-list-card">
					<div class="product-list-card-header">
						<span class="heart-icon"><i class="fa-solid fa-heart"></i></span>
					</div>
					<img src="./images/sample-img.jpg" class="product-image" />
					<div class="product-list-card-body">
						<p>상품명</p>
						<p>1,000,000 원</p>
						<p>
							<!-- 평점 값으로 별 색상 채우기 -->
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i>
						</p>
					</div>
				</div>
				<div class="product-list-card">
					<div class="product-list-card-header">
						<span class="heart-icon"><i class="fa-solid fa-heart"></i></span>
					</div>
					<img src="./images/sample-img.jpg" class="product-image" />
					<div class="product-list-card-body">
						<p>상품명</p>
						<p>1,000,000 원</p>
						<p>
							<!-- 평점 값으로 별 색상 채우기 -->
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i>
						</p>
					</div>
				</div>
				<div class="product-list-card">
					<div class="product-list-card-header">
						<span class="heart-icon"><i class="fa-solid fa-heart"></i></span>
					</div>
					<img src="./images/sample-img.jpg" class="product-image" />
					<div class="product-list-card-body">
						<p>상품명</p>
						<p>1,000,000 원</p>
						<p>
							<!-- 평점 값으로 별 색상 채우기 -->
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i>
						</p>
					</div>
				</div>
				<div class="product-list-card">
					<div class="product-list-card-header">
						<span class="heart-icon"><i class="fa-solid fa-heart"></i></span>
					</div>
					<img src="./images/sample-img.jpg" class="product-image" />
					<div class="product-list-card-body">
						<p>상품명</p>
						<p>1,000,000 원</p>
						<p>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i>
						</p>
					</div>
				</div>
				<div class="product-list-card">
					<div class="product-list-card-header">
						<span class="heart-icon"><i class="fa-solid fa-heart"></i></span>
					</div>
					<img src="./images/sample-img.jpg" class="product-image" />
					<div class="product-list-card-body">
						<p>상품명</p>
						<p>1,000,000 원</p>
						<p>
							<!-- 평점 값으로 별 색상 채우기 -->
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i>
						</p>
					</div>
				</div>
				<div class="product-list-card">
					<div class="product-list-card-header">
						<span class="heart-icon"><i class="fa-solid fa-heart"></i></span>
					</div>
					<img src="./images/sample-img.jpg" class="product-image" />
					<div class="product-list-card-body">
						<p>상품명</p>
						<p>1,000,000 원</p>
						<p>
							<!-- 평점 값으로 별 색상 채우기 -->
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i>
						</p>
					</div>
				</div>
				<div class="product-list-card">
					<div class="product-list-card-header">
						<span class="heart-icon"><i class="fa-solid fa-heart"></i></span>
					</div>
					<img src="./images/sample-img.jpg" class="product-image" />
					<div class="product-list-card-body">
						<p>상품명</p>
						<p>1,000,000 원</p>
						<p>
							<!-- 평점 값으로 별 색상 채우기 -->
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i>
						</p>
					</div>
				</div>
				<div class="product-list-card">
					<div class="product-list-card-header">
						<span class="heart-icon"><i class="fa-solid fa-heart"></i></span>
					</div>
					<img src="./images/sample-img.jpg" class="product-image" />
					<div class="product-list-card-body">
						<p>상품명</p>
						<p>1,000,000 원</p>
						<p>
							<!-- 평점 값으로 별 색상 채우기 -->
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i>
						</p>
					</div>
				</div>
				<div class="product-list-card">
					<div class="product-list-card-header">
						<span class="heart-icon"><i class="fa-solid fa-heart"></i></span>
					</div>
					<img src="./images/sample-img.jpg" class="product-image" />
					<div class="product-list-card-body">
						<p>상품명</p>
						<p>1,000,000 원</p>
						<p>
							<!-- 평점 값으로 별 색상 채우기 -->
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i> <i class="fa-solid fa-star"></i>
							<i class="fa-solid fa-star"></i>
						</p>
					</div>
				</div>
			</div>
		</div>

		
	</div>
</body>
</html>