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
				<script>
                // 모든 탭과 비용 입력 리스트 가져오기
                const tabs = document.querySelectorAll(".tab");
                const costLists = document.querySelectorAll(".cost-list");

                tabs.forEach(tab => {
                    tab.addEventListener("click", () => {
                        // 모든 탭에서 active 클래스 제거
                        tabs.forEach(t => t.classList.remove("active"));
                        tab.classList.add("active");

                        // 모든 비용 리스트 숨기기
                        costLists.forEach(list => list.classList.remove("active"));

                        // 클릭한 탭에 해당하는 리스트 보이기
                        const targetId = tab.getAttribute("data-target");
                        document.getElementById(targetId).classList.add("active");
                        console.log(targetId);
                    });
                });

                // 추가 버튼을 누르면 비용 입력 리스트 추가하기
                document.querySelectorAll(".add-btn").forEach(button => {
                    // 횟수제한을 두기 위한 변수
                    let count = 0;
                    button.addEventListener("click", (event) => {
                        if (count < 6) {

                            // 현재 클릭된 버튼이 속한 cost-list 찾기
                            const parentCostList = event.target.closest(".cost-list");

                            // 줄바꿈 추가
                            // const newline = document.createElement("br");
                            // parentCostList.appendChild(newline);

                            // 새로운 비용 입력 항목 생성
                            const newCostItem = document.createElement("div");
                            newCostItem.classList.add("cost-item");
                            const costItems = document.querySelector(".cost-items");

                            // 새 input 요소들 추가
                            const newContentInput = document.createElement("input");
                            newContentInput.type = "text";
                            newContentInput.classList.add("content");
                            newContentInput.placeholder = "메모를 입력하세요.";

                            const newPriceInput = document.createElement("input");
                            newPriceInput.type = "number";
                            newPriceInput.classList.add("price");
                            newPriceInput.placeholder = "금액";

                            // 삭제 버튼 추가
                            const deleteBtn = document.createElement("i");
                            deleteBtn.classList.add("fa-solid");
                            deleteBtn.classList.add("fa-trash");
                            deleteBtn.classList.add("delete-icon");
                            deleteBtn.addEventListener("click", () => {
                                newCostItem.remove();
                                // 삭제버튼을 눌렀을 경우 count 줄이기
                                count--;
                                console.log(count);
                                calculateTotal(); // 총액 다시 계산
                            });


                            // 새 img 태그 추가

                            // 요소들을 cost-item에 추가
                            newCostItem.appendChild(newContentInput);
                            newCostItem.appendChild(newPriceInput);
                            newCostItem.appendChild(deleteBtn);
                            // deleteBtn.src="image/delete-btn.png";

                            // cost-list에 추가
                            parentCostList.appendChild(newCostItem);
                            // 추가버튼을 눌렀을 경우 count 늘리기
                            count++;
                            console.log(count);
                        };
                    });
                });




                // 인원수 조절 기능
                const downBtn = document.getElementById("downBtn");
                const upBtn = document.getElementById("upBtn");
                const count = document.getElementById("count");

                let peopleCount = 0;    // 기본값 0

                downBtn.addEventListener("click", () => {
                    if (peopleCount > 1) {
                        peopleCount--;
                        count.textContent = peopleCount;
                    }
                });

                upBtn.addEventListener("click", () => {
                    peopleCount++;
                    count.textContent = peopleCount;
                });

                // 계산기 기능

                function calculateTotal() {
                    let total = 0;
                    document.querySelectorAll('.price').forEach(input => {
                        const value = parseInt(input.value) || 0;
                        total += value;
                    });

                    document.querySelector('#totalPrice span').innerText = total.toLocaleString();

                    const peopleCount = parseInt(document.querySelector('#count').innerText) || 1;
                    const duchPrice = Math.round(total / peopleCount);
                    document.querySelector('#duchPrice span').innerText = duchPrice.toLocaleString();


                }


                // 값이 입력되었을 때에 총합에 반영
                document.addEventListener('input', (e) => {
                    if (e.target.classList.contains('price')) {
                        calculateTotal();
                    }
                });

                document.addEventListener("click", (e) => {
                    if (e.target.classList.contains('fa-solid')) {
                        calculateTotal();
                    }
                });


                // 각 카테고리 별 총 금액 계산
                function getCategoryTotals() {
                    const totals = [];
                    const costLists = document.querySelectorAll(".cost-list");

                    costLists.forEach(list => {
                        let categoryTotal = 0;
                        const prices = list.querySelectorAll(".price");

                        prices.forEach(priceInput => {
                            const value = parseInt(priceInput.value) || 0;
                            categoryTotal += value;
                        });

                        totals.push(categoryTotal);
                    });

                    console.log("totals : " + totals);
                    return totals;
                }
                // 각 금액을 비율로 바꾸기
                // const totals = getCategoryTotals();
                // const overallTotal = totals.reduce((a, b) => a + b, 0);
                // const percentages = totals.map(t => Math.round((t / overallTotal) * 100));

                const submitBtn = document.querySelector(".submit");
                submitBtn.addEventListener("click", () => {
                    const totals = getCategoryTotals();
                    const overallTotal = totals.reduce((a, b) => a + b, 0);


                    // 0~3번까지는 round해서 미리 저장
                    let percentages = totals.map(t => Math.round((t / overallTotal) * 100));
                    let sum = percentages.slice(0, 4).reduce((a, b) => a + b, 0);
                    percentages[4] = 100 - sum;  // 마지막 요소는 보정해서 100% 맞추기
                    console.log("ㅠㅓ센테이지 : " + percentages);
                    console.log("ㅠㅓ센테이지 : " + percentages[0], typeof (percentages[0]));

                    // console.log("totals : " + totals);
                    // console.log("overallTotal : " + overallTotal);
                    document.querySelector('.donut text').textContent = overallTotal.toLocaleString() + "원";

                    const secondCircle = document.getElementById("food");
                    secondCircle.setAttribute('stroke-dasharray', `${percentages[1]} ${100 - percentages[1]}`);

                    const fiveCircle = document.getElementById("etc");
                    fiveCircle.setAttribute('stroke-dasharray', `${percentages[4]} ${100 - percentages[4]}`);
                    fiveCircle.setAttribute('stroke-dashoffset', `${-percentages[1]}`);

                    const fourCircle = document.getElementById("ticket");
                    fourCircle.setAttribute('stroke-dasharray', `${percentages[3]} ${100 - percentages[3]}`);
                    fourCircle.setAttribute('stroke-dashoffset', `${-(percentages[4] + percentages[1])}`);

                    const thirdCircle = document.getElementById("bus");
                    thirdCircle.setAttribute('stroke-dasharray', `${percentages[2]} ${100 - percentages[2]}`);
                    thirdCircle.setAttribute('stroke-dashoffset', `${-(percentages[4] + percentages[1] + percentages[3])}`);
                    console.log(-(percentages[0] + percentages[1]));

                    console.log(typeof (-(percentages[0] + percentages[1])));
                    const firstCircle = document.getElementById("lodging");
                    firstCircle.setAttribute('stroke-dasharray', `${percentages[0]} ${100 - percentages[0]}`);
                    firstCircle.setAttribute('stroke-dashoffset', `${-(percentages[4] + percentages[1] + percentages[2] + percentages[3])}`);
                    console.log(typeof (percentages[0]));

                    // 색깔 설명 라벨의 비율을 표시
                    const categoryIds = [
                        "lodging-label",
                        "food-label",
                        "bus-label",
                        "ticket-label",
                        "etc-label"
                    ];

                    percentages.forEach((percent, idx) => {
                        const span = document.querySelector("#" + categoryIds[idx] + " span");
                        // EL로 인식되는거 같아서 다시 구현 ㄱㄱ
                        span.textContent = percent + "%";
                    });

                    // 그래프 설명에 카테고리별 금액을 표시
                    // totals => [숙박비, 식비, 교통비, 입장료, 기타]

                    document.querySelector('.fa-tents span').textContent = totals[0].toLocaleString();
                    document.querySelector('.fa-utensils span').textContent = totals[1].toLocaleString();
                    document.querySelector('.fa-van-shuttle span').textContent = totals[2].toLocaleString();
                    document.querySelector('.fa-ticket span').textContent = totals[3].toLocaleString();
                    document.querySelector('.fa-suitcase-rolling span').textContent = totals[4].toLocaleString();

                });



            </script>
</body>

</html>