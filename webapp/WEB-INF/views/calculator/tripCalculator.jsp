<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR" isELIgnored="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String rootPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>여행경비 계산기 페이지</title>

<%--
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
	integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
	integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link rel="stylesheet" href="<%=rootPath%>/assets/css/reset.css" />
 --%>
<link rel="stylesheet"
	href="<%=rootPath%>/assets/css/calculator/tripCalculator.css" />

</head>

<body>
	<div id="root">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<div class="container">
			<div class="calculator-header">
				<h2 class="title">여행경비 계산기 (제목)</h2>
			</div>
			<div class="calculator-body">
				<div class="calculator-body-first">
					<div class="calculator-tabs">
						<div class="tabs">
							<div class="tab active" data-target="숙박비">숙박비</div>
							<div class="tab" data-target="식비">식비</div>
							<div class="tab" data-target="교통비">교통비</div>
							<div class="tab" data-target="입장료">입장료</div>
							<div class="tab" data-target="예비">예비(기타)</div>
						</div>
						<!-- 카테고리 선택에 따라 바뀌는거 목록 바뀌는거 한 후 
                        display:flex주고, justify-content:space-between를 css적용 => 해결함 -->
						<!-- 숙박비 리스트 -->
						<div class="cost-list active" id="숙박비">
							<button class="add-btn">+</button>
							<div class="cost-items"></div>
							<!-- <div class="cost-item">
                            <input type="text" class="content" placeholder="메모를 입력하세요.">
                            <input type="number" class="price" placeholder="금액">
                        	</div> -->
						</div>

						<!-- 식비 리스트 -->
						<div class="cost-list" id="식비">
							<button class="add-btn">+</button>
							<div class="cost-items"></div>
							<!-- <div class="cost-item">
                            <input type="text" class="content" placeholder="메모를 입력하세요.">
                            <input type="number" class="price" placeholder="금액">
                        </div> -->
						</div>

						<!-- 교통비 리스트 -->
						<div class="cost-list" id="교통비">
							<button class="add-btn">+</button>
							<div class="cost-items"></div>
							<!-- <div class="cost-item">
                            <input type="text" class="content" placeholder="메모를 입력하세요.">
                            <input type="number" class="price" placeholder="금액">
                        </div> -->
						</div>

						<!-- 입장료 리스트 -->
						<div class="cost-list" id="입장료">
							<button class="add-btn">+</button>
							<div class="cost-items"></div>
							<!-- <div class="cost-item">
                            <input type="text" class="content" placeholder="메모를 입력하세요.">
                            <input type="number" class="price" placeholder="금액">
                        </div> -->
						</div>

						<!-- 예비(기타) 리스트 -->
						<div class="cost-list" id="예비">
							<button class="add-btn">+</button>
							<div class="cost-items"></div>
							<!-- <div class="cost-item">
                            <input type="text" class="content" placeholder="메모를 입력하세요.">
                            <input type="number" class="price" placeholder="금액">
                        </div> -->
						</div>
					</div>
					<div class="cost-lists">
						<div class="calculator-price">
							<div id="totalPrice">
								총 금액 : <span>값...</span> 원
							</div>
							<div id="duchPrice">
								1/N 금액 : <span>값...</span> 원
							</div>
						</div>
						<div class="submit">
							<button>제출하기</button>
						</div>
					</div>
				</div>
				<div class="calculator-body-second">
					<div class="people-count">
						<span>인원수</span>
						<div class="button">
							<i class="fa-solid fa-circle-minus" id="downBtn"></i> <span
								class="count" id="count">1</span> <i
								class="fa-solid fa-circle-plus" id="upBtn"></i>
						</div>
					</div>

					<div class="calculator-graph">
						<div class="donut-graph">
							<div class="graph">
								<svg width="200" height="200" viewBox="0 0 42 42" class="donut">
                                    <!-- 배경 원 -->
                                    <circle class="donut-ring" cx="21"
										cy="21" r="15.9155" fill="transparent" stroke="#eee"
										stroke-width="7"></circle>

                                    <!-- 도넛 그래프 조각 -->
                                    <!-- 식비 -->
                                    <circle class="donut-segment"
										id="food" cx="21" cy="21" r="15.9155" fill="transparent"
										stroke="#09F" stroke-width="7" stroke-dasharray="0 0"
										stroke-dashoffset="0"></circle>

                                    <!-- 예비(기타) -->
                                    <circle class="donut-segment"
										id="etc" cx="21" cy="21" r="15.9155" fill="transparent"
										stroke="#e74c3c" stroke-width="7" stroke-dasharray=""
										stroke-dashoffset=""></circle>

                                    <!-- 입장료 -->
                                    <circle class="donut-segment"
										id="ticket" cx="21" cy="21" r="15.9155" fill="transparent"
										stroke="#2ecc71" stroke-width="7" stroke-dasharray=""
										stroke-dashoffset=""></circle>

                                    <!-- 교통비 -->
                                    <circle class="donut-segment"
										id="bus" cx="21" cy="21" r="15.9155" fill="transparent"
										stroke="#E8C1A0" stroke-width="7" stroke-dasharray=""
										stroke-dashoffset=""></circle>

                                    <!-- 숙박비 -->
                                    <circle class="donut-segment"
										id="lodging" cx="21" cy="21" r="15.9155" fill="transparent"
										stroke="#f39c12" stroke-width="7" stroke-dasharray=""
										stroke-dashoffset=""></circle>

                                    <!-- 중앙 텍스트 -->
                                    <text x="50%" y="50%"
										dominant-baseline="middle" text-anchor="middle" font-size="4"
										fill="#333">총 금액</text>
                                </svg>
								<div class="color-explanation">
									<li id="lodging-label" style="color: #f39c12;">숙박비 : <span>%</span></li>
									<li id="food-label" style="color: #09F;">식비 : <span>%</span></li>
									<li id="bus-label" style="color: #E8C1A0;">교통비 : <span>%</span></li>
									<li id="ticket-label" style="color: #2ecc71;">입장료 : <span>%</span></li>
									<li id="etc-label" style="color: #e74c3c;">예비(기타) : <span>%</span></li>
								</div>
							</div>
						</div>
						<div class="percentage-explanation">
							<ul>
								<i class="fa-solid fa-tents">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;숙박비
									: &nbsp; <span></span>원
								</i>
								<i class="fa-solid fa-utensils">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;식비
									: &nbsp; <span></span>원
								</i>
								<i class="fa-solid fa-van-shuttle">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;교통비
									: &nbsp; <span></span>원
								</i>
								<i class="fa-solid fa-ticket">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;입장료
									: &nbsp; <span></span>원
								</i>
								<i class="fa-solid fa-suitcase-rolling">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;예비(기타)
									: &nbsp; <span></span>원
								</i>
							</ul>
							&nbsp;
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
				<script src="<%=rootPath%>/assets/js/calculator/tripCalculator.js"></script>
</body>

</html>