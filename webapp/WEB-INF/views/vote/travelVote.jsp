<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="EUC-KR"%>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
        integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
        integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
        crossorigin="anonymous" referrerpolicy="no-referrer" />
    --%>
<link rel="stylesheet"
	href="<%=rootPath%>/assets/css/vote/travelVote.css" />
<style>
</style>

</head>

<body>
	<div id="root">
		<jsp:include page="../common/header.jsp"></jsp:include>
		<div class="container">
			<div class="vote-header">
				<div class="vote-header-title">
					<h2 class="title">이번달은 우리 어디로 갈래?</h2>
				</div>
				<div class="vote-header-subtitle">
					<h6>가장 가고싶은 여행지를 골라주세요.</h6>
				</div>
			</div>
			<form action="vote/result" method="get">
				<input type="hidden" name="userId" value="${ loginUser.userId }"/>
				<div class="vote-body">
					<div class="vote-lists">
						<div class="vote-list">
							<div class="vote-list-image">
								<img src="<%=rootPath%>/assets/images/vote/가평.png" alt="">
							</div>
							<div class="vote-list-name">
								<!-- 비어있는 원 -->
								<input type="radio" name="travel" id="가평" value="가평"> <label
									for="가평">가평</label>
							</div>
						</div>
						<div class="vote-list">
							<div class="vote-list-image">
								<img src="<%=rootPath%>/assets/images/vote/강릉.png" alt="">
							</div>
							<div class="vote-list-name">
								<!-- 비어있는 원 -->
								<input type="radio" name="travel" id="강릉" value="강릉"> <label
									for="강릉">강릉</label>
							</div>
						</div>
						<div class="vote-list">
							<div class="vote-list-image">
								<img src="<%=rootPath%>/assets/images/vote/속초.png" alt="">
							</div>
							<div class="vote-list-name">
								<!-- 비어있는 원 -->
								<input type="radio" name="travel" id="속초" value="속초"> <label
									for="속초">속초</label>
							</div>
						</div>
						<div class="vote-list">
							<div class="vote-list-image">
								<img src="<%=rootPath%>/assets/images/vote/여수.png" alt="">
							</div>
							<div class="vote-list-name">
								<!-- 비어있는 원 -->
								<input type="radio" name="travel" id="여수" value="여수"> <label
									for="여수">여수</label>
							</div>
						</div>
					</div>
					<div class="vote-lists">
						<div class="vote-list">
							<div class="vote-list-image">
								<img src="<%=rootPath%>/assets/images/vote/춘천.png" alt="">
							</div>
							<div class="vote-list-name">
								<!-- 비어있는 원 -->
								<input type="radio" name="travel" id="춘천" value="춘천"> <label
									for="춘천">춘천</label>
							</div>
						</div>
						<div class="vote-list">
							<div class="vote-list-image">
								<img src="<%=rootPath%>/assets/images/vote/전주.png" alt="">
							</div>
							<div class="vote-list-name">
								<!-- 비어있는 원 -->
								<input type="radio" name="travel" id="전주" value="전주"> <label
									for="전주">전주</label>
							</div>
						</div>
						<div class="vote-list">
							<div class="vote-list-image">
								<img src="<%=rootPath%>/assets/images/vote/부산.png" alt="">
							</div>
							<div class="vote-list-name">
								<!-- 비어있는 원 -->
								<input type="radio" name="travel" id="부산" value="부산"> <label
									for="부산">부산</label>
							</div>
						</div>
						<div class="vote-list">
							<div class="vote-list-image">
								<img src="<%=rootPath%>/assets/images/vote/제주도.png" alt="">
							</div>
							<div class="vote-list-name">
								<!-- 비어있는 원 -->
								<input type="radio" name="travel" id="제주도" value="제주도"> <label
									for="제주도">제주도</label>
							</div>
						</div>
					</div>
				</div>

				<div class="vote-footer">
					<button class="vote-btn">투표하기</button>
				</div>
			</form>
		</div>
		<jsp:include page="../common/footer.jsp"></jsp:include>
	</div>
</body>
<!-- 
1) 사진만 추가하면 끝임**
2) 체크 칸 다시바꾸기 input 으로 (데이터를 DB로 전달해야되기 때문에)
-->

</html>