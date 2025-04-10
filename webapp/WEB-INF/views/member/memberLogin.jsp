<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%
	String rootPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="google-signin-client_id" content="656177775181-k2rlucfj6kjrb8ka3j0g7218rmlktm2h.apps.googleusercontent.com">
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

<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.7.4/kakao.min.js"
	integrity="sha384-DKYJZ8NLiK8MN4/C5P2dtSmLQ4KwPaoqAfyA/DfmEc1VDxu4yyC7wy6K1Hs90nka"
	crossorigin="anonymous">
</script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<title>Trip-log</title>
</head>
<body>
	<div id="root">
		<div class="container">
			<div class="login-container">
				<h2>로그인</h2>

				<form action="<%=rootPath%>/auth/sign-in" method="post">
					<label for="email">이메일</label> <input type="email" id="email"
						name="email" placeholder="이메일" required /> <label for="password">비밀번호</label>
					<input type="password" id="password" name="password"
						placeholder="비밀번호" required />

					<button type="submit" class="login-btn">로그인</button>
				</form>

				<button id="kakaoLogin-btn" onclick="signKakaoLogin();"
					class="social-btn kakao">
					<img src="<%=rootPath%>/assets/images/member/kakao-talk-logo.png"
						alt="Kakao Logo" /> 카카오로 시작하기
				</button>

				<button class="social-btn google" onclick="signGoogleLogin();">
					<img
						src="https://www.gstatic.com/firebasejs/ui/2.0.0/images/auth/google.svg"
						alt="Google Logo" /> Google로 시작하기
				</button>
				<div class="signup">
					아직 회원이 아니신가요? <a href="<%=rootPath%>/members/sign-up">회원가입</a>
				</div>
			</div>
		</div>
	</div>
	<script>
	Kakao.init('${kakaoScriptKey}');

	function signKakaoLogin() {
	    Kakao.Auth.authorize({
	        redirectUri:'${kakaoRedirectUri}',
	        scope: 'account_email', 
	        prompt: 'select_account'
	    });
	}
	
	function signGoogleLogin(){
		const prompt = 'consent select_account';
		const authUrl = `https://accounts.google.com/o/oauth2/auth?client_id=656177775181-k2rlucfj6kjrb8ka3j0g7218rmlktm2h.apps.googleusercontent.com&redirect_uri=http://localhost:8080/trip-log/google-login/callback&response_type=code&prompt=select_account%20consent&scope=email`;
		
		window.location.href = authUrl;
		console.log(authUrl);
	}
	</script>
	
	<%--<script src="assets/js/member/socialLogin.js"></script>--%>
</body>
</html>