<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Comment Template</title>
</head>
<body>

	<div class="views">
		<div class="comment">
			<div class="comment-views">
				<div class="comment-user-profile">
					<i class="fa-solid fa-user"></i>
				</div>
				<div class="comment-view">
					<div class="comment-view-header">
						<div class="comment-user-name">김일현</div>
						<div class="date-update-delete">
							<div class="comment-date">한달전</div>
							<div class="update-delete-menu active">
								<i class="fa-solid fa-ellipsis"></i>
							</div>
							<div class="comment-update-delete">
								<i class="fa-solid fa-pen-to-square"></i> <i
									class="fa-solid fa-trash-can"></i>
							</div>
						</div>
					</div>
					<div class="comment-view-body">
						<textarea id="commentView" name="comment" readonly>     좋은 정보 감사합니다.
     잘 보고 갑니다~ㅎㅎ
                                    </textarea>
					</div>
					<div class="comment-view-footer">
						<div class="reply-btn active" data-target="첫번째">
							<i class="fa-solid fa-square-caret-down"></i> <span
								id="replyWriter">댓글 달기</span>
						</div>
						<div class="reply-close-btn" data-target="첫번째">
							<i class="fa-solid fa-square-caret-up"></i> <span
								id="replyCloser">댓글 닫기</span>
						</div>
						<div class="comment-like">
							<i class="fa-regular fa-heart"></i> <span class="like-count">0</span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="reply" id="첫번째">
			<div class="reply-input">
				<!-- <input type="text" id="reply"> -->
				<textarea id="reply"></textarea>
				<i class="fa-regular fa-paper-plane"></i>
			</div>
			<div class="reply-views">
				<div class="reply-user-profile">
					<i class="fa-solid fa-user"></i>
				</div>
				<div class="reply-view">
					<div class="reply-view-header">
						<div class="reply-user-name">사용자 이름</div>
						<div class="date-update-delete">
							<div class="reply-date">작성날짜</div>
							<div class="update-delete-menu active">
								<i class="fa-solid fa-ellipsis"></i>
							</div>
							<div class="reply-update-delete">
								<i class="fa-solid fa-pen-to-square"></i> <i
									class="fa-solid fa-trash-can"></i>
							</div>
						</div>
					</div>
					<div class="reply-view-body">
						<textarea id="replyView" name="reply" readonly>
    감사합니다.^*
                                    </textarea>
					</div>
					<div class="reply-view-footer">
						<div>
							<i class="fa-regular fa-heart"></i> <span class="like-count">0</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>