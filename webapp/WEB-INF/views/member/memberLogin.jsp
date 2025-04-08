<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String rootPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
<link href="<%=rootPath%>/assets/css/reset.css" rel="stylesheet">
<link href="<%=rootPath%>/assets/css/member/memberLogin.css"
	rel="stylesheet" />
<title>Trip-log</title>
</head>
<body>
	<div id="root">
		<div class="container">
			<div class="login-container">
				<h2>로그인</h2>

				<form action="<%=rootPath%>/auth/sign-in" method="post">
					<label for="email">이메일</label> 
					<input type="email" id="email" name="email" placeholder="이메일" required /> 
					
					<label for="password">비밀번호</label>
					<input type="password" id="password" name="password" placeholder="비밀번호" required />

					<button type="submit" class="login-btn">로그인</button>
				</form>

				<button class="social-btn kakao">
					<img src="<%=rootPath%>/assets/images/member/kakao-talk-logo.png"
						alt="Kakao Logo" /> 카카오로 시작하기
				</button>

				<button class="social-btn google">
					<img
						src="https://www.gstatic.com/firebasejs/ui/2.0.0/images/auth/google.svg"
						alt="Google Logo" /> Google로 시작하기
				</button>

				<div class="signup">
					아직 회원이 아니신가요? <a href="#">회원가입</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>