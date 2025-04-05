<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String rootPath = request.getContextPath();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trip:Log</title>
<link rel="stylesheet" href="<%= rootPath %>/assets/css/main.css">
</head>
<body>
		<jsp:include page="common/header.jsp" />
		<%-- Main --%>
		<!-- <div class="banner"></div> -->
	    <div id="carouselExampleIndicators" class="carousel slide banner">
	        <div class="carousel-indicators">
	            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
	                aria-current="true" aria-label="Slide 1"></button>
	            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
	                aria-label="Slide 2"></button>
	            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
	                aria-label="Slide 3"></button>
	        </div>
	        <div class="carousel-inner">
	            <div class="carousel-item active">
	                <img src="assets/images/board/board-img1.jpg" class="d-block w-100 banner" alt="...">
	            </div>
	            <div class="carousel-item">
	                <img src="assets/images/board/board-img2.jpg" class="d-block w-100 banner" alt="...">
	            </div>
	            <div class="carousel-item">
	                <img src="assets/images/board/board-img3.jpg" class="d-block w-100 banner" alt="...">
	            </div>
	        </div>
	        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
	            data-bs-slide="prev">
	            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	            <span class="visually-hidden">Previous</span>
	        </button>
	        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
	            data-bs-slide="next">
	            <span class="carousel-control-next-icon" aria-hidden="true"></span>
	            <span class="visually-hidden">Next</span>
	        </button>
	    </div>
	
	    <div class="container mb-5">
	        <div class="board-list">
	            <div class="list-header">
	                <p>
	                    <span style="color: var(--icon-strong-color)">
	                        <i class="fa-solid fa-crown"></i>
	                        인기
	                    </span> 
	                    여행 후기
	                </p>
	
	                <!-- 더보기 p태그 자체를 클릭 시 여행 후기(커뮤니티) 목록 페이지로 이동 -->
	                <p>
	                    더보기 <i class="fa-solid fa-arrow-right"></i>
	                </p>
	            </div>
	            <div class="list-content">
	                <div class="list-item">
	                    <div class="list-item-image">
	                        <img src="assets/images/board/board-img1.jpg">
	                        <span class="list-item-text">
	                            <p class="list-item-text-title">
	                                <span>Title</span><span>25.04.02~25.04.02(00일)</span>
	                            </p>
	                            <p class="list-item-text-content">
	                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, ...
	                            </p>
	                            <p class="list-item-text-footer">
	                                <span>
	                                    <i class="fa-solid fa-heart" style="color: var(--heart-color)"></i>
	                                    <span>99개</span>
	                                </span>
	                                <span>
	                                    <i class="fa-solid fa-comment"></i>
	                                    <span>99개</span>
	                                </span>
	                            </p>
	                        </span>
	                    </div>
	                </div>
	                <div class="list-item">
	                    <div class="list-item-image">
	                        <img src="assets/images/board/board-img2.jpg">
	                        <span class="list-item-text">
	                            <p class="list-item-text-title">
	                                <span>Title</span><span>25.04.02~25.04.02(00일)</span>
	                            </p>
	                            <p class="list-item-text-content">
	                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, ...
	                            </p>
	                            <p class="list-item-text-footer">
	                                <span>
	                                    <i class="fa-solid fa-heart" style="color: var(--heart-color)"></i>
	                                    <span>99개</span>
	                                </span>
	                                <span>
	                                    <i class="fa-solid fa-comment"></i>
	                                    <span>99개</span>
	                                </span>
	                            </p>
	                        </span>
	                    </div>
	                </div>
	                <div class="list-item">
	                    <div class="list-item-image">
	                        <img src="assets/images/board/board-img3.jpg">
	                        <span class="list-item-text">
	                            <p class="list-item-text-title">
	                                <span>Title</span><span>25.04.02~25.04.02(00일)</span>
	                            </p>
	                            <p class="list-item-text-content">
	                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, ...
	                            </p>
	                            <p class="list-item-text-footer">
	                                <span>
	                                    <i class="fa-solid fa-heart" style="color: var(--heart-color)"></i>
	                                    <span>99개</span>
	                                </span>
	                                <span>
	                                    <i class="fa-solid fa-comment"></i>
	                                    <span>99개</span>
	                                </span>
	                            </p>
	                        </span>
	                    </div>
	                </div>
	                <div class="list-item">
	                    <div class="list-item-image">
	                        <img src="assets/images/board/board-img4.jpg">
	                        <span class="list-item-text">
	                            <p class="list-item-text-title">
	                                <span>Title</span><span>25.04.02~25.04.02(00일)</span>
	                            </p>
	                            <p class="list-item-text-content">
	                                Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, ...
	                            </p>
	                            <p class="list-item-text-footer">
	                                <span>
	                                    <i class="fa-solid fa-heart" style="color: var(--heart-color)"></i>
	                                    <span>99개</span>
	                                </span>
	                                <span>
	                                    <i class="fa-solid fa-comment"></i>
	                                    <span>99개</span>
	                                </span>
	                            </p>
	                        </span>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="product-list">
	            <div class="list-header">
	                <p>
	                    <span style="color: var(--icon-strong-color)">
	                        <i class="fa-solid fa-crown"></i>
	                        지금
	                    </span> 
	                    이 기회를 놓치지 마세요!
	                </p>
	                <p>
	                    더보기 <i class="fa-solid fa-arrow-right"></i>
	                </p>
	            </div>
	            <div class="product-list-content">
	                <div class="product-list-item">
	                    <div class="product-list-item-image">
	                        <img src="assets/images/board/board-img1.jpg">
	                    </div>
	                    <div class="product-list-item-info">
	                        <p class="product-list-item-name">상품명</p>
	                        <p class="product-list-item-avg">
	                            <i class="fa-solid fa-star"></i>
	                            <span>4.5</span>
	                        </p>
	                        <p class="product-list-item-price">
	                            <span>1,000,000</span>원
	                        </p>
	                    </div>
	                </div>
	                <div class="product-list-item">
	                    <div class="product-list-item-image">
	                        <img src="assets/images/board/board-img2.jpg">
	                    </div>
	                    <div class="product-list-item-info">
	                        <p class="product-list-item-name">상품명</p>
	                        <p class="product-list-item-avg">
	                            <i class="fa-solid fa-star"></i>
	                            <span>4.5</span>
	                        </p>
	                        <p class="product-list-item-price">
	                            <span>1,000,000</span>원
	                        </p>
	                    </div>
	                </div>
	                <div class="product-list-item">
	                    <div class="product-list-item-image">
	                        <img src="assets/images/board/board-img3.jpg">
	                    </div>
	                    <div class="product-list-item-info">
	                        <p class="product-list-item-name">상품명</p>
	                        <p class="product-list-item-avg">
	                            <i class="fa-solid fa-star"></i>
	                            <span>4.5</span>
	                        </p>
	                        <p class="product-list-item-price">
	                            <span>1,000,000</span>원
	                        </p>
	                    </div>
	                </div>
	                <div class="product-list-item">
	                    <div class="product-list-item-image">
	                        <img src="assets/images/board/board-img4.jpg">
	                    </div>
	                    <div class="product-list-item-info">
	                        <p class="product-list-item-name">상품명</p>
	                        <p class="product-list-item-avg">
	                            <i class="fa-solid fa-star"></i>
	                            <span>4.5</span>
	                        </p>
	                        <p class="product-list-item-price">
	                            <span>1,000,000</span>원
	                        </p>
	                    </div>
	                </div>
	            </div>
	        </div>
	        <div class="rank">
	            <div class="list-header">
	                <p>
	                    <span style="color: var(--icon-strong-color)">
	                        <i class="fa-solid fa-trophy"></i>
	                        좋아
	                    </span> 
	                    이번 달은 여기다!
	                </p>
	                <p>
	                    더보기 <i class="fa-solid fa-arrow-right"></i>
	                </p>
	            </div>
	            <div class="rank-content">
	                <div class="rank-content-left">
	                    <!-- <div style="position: relative; display: inline-block;"> -->
	                    <div>
	                        <i class="fa-solid fa-ranking-star"></i>
	                        <!-- <i class="fa-solid fa-star" style="position: absolute; top: 0.65rem; left: 6.3rem; font-size: 5.5rem; color: gold;"></i> -->
	                    </div>
	                </div>
	                <div class="rank-content-right">
	                    <ul class="rank-content-right-list">
	                        <li class="rank-content-right-list-item">가평<i class="fa-solid fa-medal"></i></li>
	                        <li class="rank-content-right-list-item">세글자<i class="fa-solid fa-medal"></i></li>
	                        <li class="rank-content-right-list-item">섬<i class="fa-solid fa-medal"></i></li>
	                    </ul>
	                </div>
	            </div>
	        </div>
	    </div>
		<jsp:include page="common/footer.jsp" />
</body>
</html>