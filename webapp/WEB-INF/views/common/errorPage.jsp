<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String rootPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-k6d4wzSIapyDyv1kpU366/PK5hCdSbCRGRCMv+eplOQJWyd1fbcAu9OCUj5zNLiq"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
	integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
<link href="<%=rootPath%>/assets/css/reset.css" rel="stylesheet">
<title>ErrorPage</title>
<style>
.error-area {
	width: 100%;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	padding: 3rem;
}

.error-icon {
	font-size: 15rem;
	color: var(- -sub-strong-color);
	padding: 1rem;
	margin-bottom: 1rem;
}

.error-message {
	font-weight: 600;
	font-size: 5rem;
	margin-bottom: 1.3rem;
}

.btn-area {
	padding: 1rem;
	font-size: 3rem;
}

.error-btn {
	font-weight: 900;
	font-size: 1.7rem;
	padding: 0.5rem 1.3rem;
	color: var(- -bg-color);
	background-color: var(- -sub-strong-color);
	border-radius: 1rem;
	border: 0.3rem solid var(- -sub-strong-color);
	transition: 0.3s ease-in-out;
}

.error-btn:hover {
	color: var(- -sub-strong-color);
	background-color: var(- -bg-color);
}
</style>
</head>
<body>
	<div id="root">
		<div class="container">
			<div class="error-area">
				<div class="error-icon">
					<i class="fa-solid fa-triangle-exclamation"></i>
				</div>
				<div class="error-message">
					<span><%= request.getAttribute("errorMsg") != null ? request.getAttribute("errorMsg") : "Something went wrong." %></span>
				</div>
				<div class="btn-area">
					<button class="error-btn" onclick="location.href='<%=rootPath %>'">Back to home</button>
				</div>
			</div>
		</div>
	</div>
</body>
</html>