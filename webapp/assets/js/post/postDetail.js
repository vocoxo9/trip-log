



// 댓글 달기 누르면 대댓글 작성란과 대댓글 나타내기
const replyBtns = document.querySelectorAll(".reply-btn");
const replyCloseBtns = document.querySelectorAll(".reply-close-btn");
const reply = document.querySelectorAll(".reply");
// => '댓글 달기' 버튼과 '댓글 닫기' 버튼 선택

// 각 댓글달기 버튼 클릭 시 각 reply 나타내고, 해당 버튼은 사라지고, 댓글닫기 버튼 활성화
replyBtns.forEach(replyBtn => {
	replyBtn.addEventListener("click", () => {
		const targetId = replyBtn.getAttribute("data-comment-target");
		// const replyElement = document.querySelector(".reply#" + targetId);
		// replyElement.classList.add("active"); // reply div 표시
		const replyElement = document.getElementById("reply" + targetId);

		if (replyElement && replyElement.classList.contains("reply")) {
			// 이 요소는 class="reply"를 가진 id=targetId인 요소
			replyElement.classList.add("active");
		}


		replyBtn.classList.remove("active"); // '댓글 달기' 버튼 숨김

		// '댓글 닫기' 버튼 활성화
		const replyCloseBtn = document.querySelector(`.reply-close-btn[data-comment-target="${targetId}"]`);
		replyCloseBtn.classList.add("active");

		// ---------------------

		// 비동기 통신으로 대댓글 리스트 가져오기
		const dataTarget = document.querySelector(`[data-comment-target="${targetId}"].reply-close-btn`).getAttribute('data-comment-target');
		const postId = document.querySelector("input[name=postId]").value;
		$.ajax({
			url: "replyList/select",
			type: 'post',
			data: {
				parentNum: targetId,
				postNum: postId
			},
			success: function(result) {
				console.log("** Ajax 통신 성공!! **")
				let element = "";
				for (let i of result) {
					console.log("result.commentId의 값 : " + i.commentId);
					console.log(i);
					element += '<div class="reply-views">'
						+ '<input type="hidden" name="replyId" value="' + i.commentId + '"/>'
						+ '<div class="reply-user-profile">'
						+ '<i class="fa-solid fa-user">' + '</i>'
						+ '</div>'
						+ '<div class="reply-view">'
						+ '<div class="reply-view-header">'
						+ '<div class="reply-user-name">' + i.nickname + '</div>'
						+ '<div class="date-update-delete">'
						+ '<div class="reply-date">' + i.registDate + '일 전 </div>'
						+ '<div class="update-delete-menu active">'
						+ '<i class="fa-solid fa-ellipsis"></i>'
						+ '</div>'
						+ '<div class="reply-update-delete">'
						+ '<i class="fa-solid fa-pen-to-square">' + '</i>'
						+ '<i class="fa-solid fa-trash-can">' + '</i>'
						+ '</div>'
						+ '</div>'
						+ '</div>'
						+ '<div class="reply-view-body">'
						+ '<textarea id="replyView" name="reply" readonly>		' + i.content + '</textarea>'
						+ '</div>'
						+ '<div class="reply-view-footer">'
						+ '<div class="reply-like" id="' + i.commentId + '">'
						+ '<i class="fa-regular fa-heart">' + '</i>' + ' <span class="like-count">' + i.likeCount + '</span>'
						+ '</div>'
						+ '</div>'
						+ '</div>'
						+ '</div>'
				}
				// $(".reply#" + targetId).append(element);
				$("#reply" + targetId + " .reply-input").after(element);

				// ----

				// 대댓글 좋아요 기능
				const replyLikeBtns = document.querySelectorAll(".comments .reply .reply-view .fa-regular.fa-heart");  // 대댓글 좋아요 버튼

				replyLikeBtns.forEach(btn => {
					btn.addEventListener("click", (event) => {
						const replyViews = event.target.closest(".reply-views");
						const replyId = replyViews.querySelector('input[name="replyId"]').value;  // 로그인한 사용자 ID

						console.log("대댓글 ID: " + replyId);  // 대댓글 ID 확인=> 나중에 연결하면 loginUser의 memberId로 바꾸기

						// AJAX 요청 보내기 (대댓글 좋아요)
						$.ajax({
							url: "commentLike/regist", // 댓글 좋아요와 동일한 요청 주소
							type: "post",
							data: {
								memberId: $("#memberId").val(),  // 로그인한 사용자 ID
								commentId: replyId     // 대댓글 ID
							},
							success: function(result) {
								console.log(`${replyId}`);
								console.log("** Ajax 통신 성공@@ **");
								const element = '<i class="fa-regular fa-heart"></i>'
									+ '<span class="like-count">' + result.commentLikeCount + '</span>';
								$(`.reply-view #${replyId}.reply-like`).html(element);
							},
							error: function(err) {
								console.log("** Ajax 통신 실패 ㅠㅜ **");
								console.log(err);
							},
							complete: function() {
								console.log("** Ajax 통신 완료!! **");
							}

						});

					});

				});

				// ----

				// 대댓글의 etc버튼
				const replyEtcBtns = document.querySelectorAll(".reply-view .update-delete-menu");
				replyEtcBtns.forEach(etcBtn => {
					etcBtn.addEventListener("click", () => {
						const parentReply = etcBtn.closest(".reply-view"); // 가장 가까운 부모 요소를 찾음
						const replyUDBtn = parentReply.querySelector(".reply-update-delete");
						etcBtn.classList.toggle("active");
						replyUDBtn.classList.toggle("active");
					});
				});

			},

			error: function(err) {
				console.log("** Ajax 통신 실패 ㅠㅜ **")
				console.log(err);
			},

			complete: function() {
				console.log("** Ajax 통신 완료 **")

			}

		});
	});
});

// 활성화된 각 댓글닫기 버튼 클릭 시 각reply 사라지고, 해당 버튼 사라지고, 댓글달기 버튼 활성화
replyCloseBtns.forEach(closeBtn => {
	closeBtn.addEventListener("click", () => {
		const targetId = closeBtn.getAttribute("data-comment-target");
		const replyElement = document.getElementById("reply" + targetId);

		if (replyElement && replyElement.classList.contains("reply")) {
			// 이 요소는 class="reply"를 가진 id=targetId인 요소
			replyElement.classList.remove("active"); // reply 숨김
		}
		closeBtn.classList.remove("active"); // '댓글 닫기' 버튼 숨김

		// 추가되었던 reply의 reply-views 클래스를 가진 자식 요소들 삭제
		const replyViews = document.querySelectorAll(`#reply${targetId} .reply-views`);
		replyViews.forEach(view => {
			view.remove(); // reply-views 요소를 삭제
		});

		// '댓글 달기' 버튼 다시 활성화
		const replyBtn = document.querySelector(`[data-comment-target="${targetId}"]`);
		replyBtn.classList.add("active");
	});
});


// 댓글의 etc버튼
const commentEtcBtns = document.querySelectorAll(".comment-view .update-delete-menu");
commentEtcBtns.forEach(etcBtn => {
	etcBtn.addEventListener("click", () => {
		const targetId = etcBtn.getAttribute('data-etc-target');

		// etc 버튼 사라지게
		etcBtn.classList.remove("active");
		// ---
		const targetElement = document.getElementById("etc" + targetId);

		if (targetElement && targetElement.classList.contains("comment-update-delete")) {
			if (targetElement) {
				targetElement.classList.toggle("active");
			}
		}
		// ---

	});
});

// 답글의 etc버튼
const replyEtcBtns = document.querySelectorAll(".reply-view .update-delete-menu");
replyEtcBtns.forEach(etcBtn => {
	etcBtn.addEventListener("click", () => {
		const parentReply = etcBtn.closest(".reply-view"); // 가장 가까운 부모 요소를 찾음
		const replyUDBtn = parentReply.querySelector(".reply-update-delete");
		etcBtn.classList.toggle("active");
		replyUDBtn.classList.toggle("active");
	});
});

// ------------------

// 댓글 등록 비동기처리
const commentRegistBtn = document.querySelector(".comment-input i");
commentRegistBtn.addEventListener("click", () => {
	const viewArea = document.getElementById("pageComment");
	const postId = document.querySelector("input[name=postId]").value;

	console.log(" memberId가 제대로 들어오는지 " + $("#memberId").val());
	$.ajax({
		url: 'comment/regist',
		type: "post",
		data: {
			postId: postId,
			commentView: $("#comment").val()
		},
		success: function(result) {
			console.log("** Ajax 통신 성공 **");
			console.log(result);
			let element = "";
			console.log("댓글 사용자명 : " + result.name);
			console.log("댓글 내용 : " + result.postId);
			console.log("댓글 좋아요 수" + result.likeCount);
			element += "<div class='comment'>"
				+ "<div class='comment-views'>"
				+ "<div class='comment-user-profile'>"
				+ "<i class='fa-solid fa-user'>" + "</i>"
				+ "</div>"
				+ "<div class='comment-view'>"
				+ "<div class='comment-view-header'>"
				+ "<div class='comment-user-name'>" + result.nickname + "</div>"
				+ "<div class='date-update-delete'>"
				+ "<div class='comment-date'>" + result.registDate + "일전</div>"
				+ "<div class='update-delete-menu active' data-etc-target='" + result.commentId + "'>"
				+ "<i class='fa-solid fa-ellipsis'>" + "</i>"
				+ "</div>"
				+ "<div class='comment-update-delete' id='" + result.commentId + "'>"
				+ "<i class='fa-solid fa-pen-to-square'>" + "</i>" + "<i class='fa-solid fa-trash-can'>" + "</i>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "<div class='comment-view-body'>"
				+ "<textarea id='commentView' name='comment' readonly>     " + result.content + "</textarea>"
				+ "</div>"
				+ "<div class='comment-view-footer'>"
				+ "<div class='reply-btn active' data-comment-target='" + result.commentId + "'>"
				+ "<i class='fa-solid fa-square-caret-down'>" + "</i>" + "<span id='replyWriter'>댓글 달기</span>"
				+ "</div>"
				+ "<div class='reply-close-btn' data-comment-target='" + result.commentId + "'>"
				+ "<i class='fa-solid fa-square-caret-up'>" + "</i>" + "<span id='replyCloser'>댓글 닫기</span>"
				+ "</div>"
				+ "<div class='comment-like' id='" + result.commentId + "'>"
				+ "<i class='fa-regular fa-heart'>" + "</i>" + "<span class='like-count'>" + result.likeCount + "</span>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "<div class='reply' id='" + result.commentId + "'>"
				+ "<div class='reply-input'>"
				+ "<textarea id='reply'>" + "</textarea>"
				+ "<i class='fa-regular fa-paper-plane'>" + "</i>"
				+ "</div>"
				+ "</div>"
			$(".comment-input").after(element);

			// ------- 여기까지 댓글 등록 비동기처리 ------------
			// ======== 밑으로는 비동기 된 댓글의 기능들 붙여넣기 =========
			// 댓글 좋아요 기능
			const commentLikeBtns = document.querySelectorAll(".comment .comment-like .fa-regular.fa-heart");
			commentLikeBtns.forEach(commentLikeBtn => {
				commentLikeBtn.addEventListener("click", (event) => {
					const comment = event.target.closest(".comment");
					const commentId = comment.querySelector('input[name="commentId"]').value;
					// const commentId = document.querySelector('input[type="hidden"][name="commentId"]').value;
					console.log("commentId : " + commentId);
					$.ajax({
						url: "commentLike/regist",
						type: "post",
						data: {
							memberId: $("#memberId").val(),	// => 나중에 연결하면 loginUser의 memberId로 바꾸기
							commentId: commentId
						},
						success: function(result) {
							console.log(`${commentId}`);
							console.log("** Ajax 통신 성공@@ **");
							const element = '<i class="fa-regular fa-heart"></i>'
								+ '<span class="like-count">' + result.commentLikeCount + '</span>';
							$(`.comment #${commentId}.comment-like`).html(element);
						},
						error: function(err) {
							console.log("** Ajax 통신 실패 ㅠㅜ **");
							console.log(err);
						},
						complete: function() {
							console.log("** Ajax 통신 완료!! **");
						}

					});

				});

			});
		},
		error: function(err) {
			console.log("** Ajax 통신 실패 ㅠㅜ **");
			console.log(err);
		},
		complete: function() {
			console.log("** Ajax 통신 완료!! **");
		}
	});

});

// 게시글 좋아요 기능
const postLikeBtn = document.querySelector(".board-like-count .fa-regular.fa-heart");
postLikeBtn.addEventListener("click", () => {
	const postId = document.querySelector("input[name=postId]").value;
	$.ajax({
		url: "postLike/regist",
		type: "post",
		data: {
			memberId: $("#memberId").val(),	// => 나중에 연결하면 loginUser의 memberId로 바꾸기
			postId: postId
		},
		success: function(result) {
			console.log(`${postId}`);
			console.log("** Ajax 통신 성공@@ **");
			const element = '<i class="fa-regular fa-heart"></i>'
				+ '<span class="like-count">' + result.postLikeCount + '</span>';
			$(".board-like-count").html(element);
		},
		error: function(err) {
			console.log("** Ajax 통신 실패 ㅠㅜ **");
			console.log(err);
		},
		complete: function() {
			console.log("** Ajax 통신 완료!! **");
		}

	});

});

// 댓글 좋아요 기능
const commentLikeBtns = document.querySelectorAll(".comment .comment-like .fa-regular.fa-heart");
commentLikeBtns.forEach(commentLikeBtn => {
	commentLikeBtn.addEventListener("click", (event) => {
		const comment = event.target.closest(".comment");
		const commentId = comment.querySelector('input[name="commentId"]').value;
		// const commentId = document.querySelector('input[type="hidden"][name="commentId"]').value;
		console.log("commentId : " + commentId);
		$.ajax({
			url: "commentLike/regist",
			type: "post",
			data: {
				memberId: $("#memberId").val(),	// => 나중에 연결하면 loginUser의 memberId로 바꾸기
				commentId: commentId
			},
			success: function(result) {
				console.log(`${commentId}`);
				console.log("** Ajax 통신 성공@@ **");
				const element = '<i class="fa-regular fa-heart"></i>'
					+ '<span class="like-count">' + result.commentLikeCount + '</span>';
				$(`.comment #${commentId}.comment-like`).html(element);
			},
			error: function(err) {
				console.log("** Ajax 통신 실패 ㅠㅜ **");
				console.log(err);
			},
			complete: function() {
				console.log("** Ajax 통신 완료!! **");
			}

		});

	});

});

// 댓글 수정 기능
const updateBtns = document.querySelectorAll(".comments .comment-update-delete .fa-solid.fa-pen-to-square");
updateBtns.forEach(updateBtn => {

	updateBtn.addEventListener("click", (event) => {

		// 클릭된 버튼이 속한 부모 요소를 찾는다 (이 경우 댓글 요소)
		const comment = event.target.closest(".comment");

		// 기존 댓글의 내용을 가져온다 (예시에서는 c.getContent()로 되어 있지만, 실제로는 해당 내용이 필요)
		const content = comment.querySelector(".comment-view-body textarea").value;

		// 기존 comment-view-body를 새로운 내용으로 덮어쓴다.
		const commentViewBody = comment.querySelector(".comment-view-body");
		commentViewBody.innerHTML = '';  // 기존 내용을 지우고 새로 추가하기 위해

		// comment-view-body에 display: flex 추가
		commentViewBody.style.display = 'flex';

		// 새로운 <textarea>와 <i> 요소 생성
		const textArea = document.createElement("textarea");
		textArea.id = "commentView";
		textArea.name = "comment";
		textArea.value = content; // 기존 댓글 내용 설정

		const paperPlaneIcon = document.createElement("i");
		paperPlaneIcon.classList.add("fa-regular", "fa-paper-plane");
		paperPlaneIcon.style.fontSize = '1.5rem';  // 아이콘 크기 설정

		// 댓글수정 등록 클릭 insert 후 조회하여 비동기 처리
		paperPlaneIcon.addEventListener("click", () => {
			console.log("버튼 클릭됨");
			// 여기서 원하는 작업을 추가하면 됩니다.
			// 예: 댓글 수정 또는 댓글 등록 등의 작업을 추가할 수 있습니다.
			// 예시로 댓글 수정하는 로직
			const updatedContent = textArea.value;  // 새롭게 작성된 댓글 내용
			console.log("수정된 댓글 내용:", updatedContent);
			const postId = document.querySelector("input[name=postId]").value;
			const comment = event.target.closest(".comment");
			const commentId = comment.querySelector('input[name="commentId"]').value;
			$.ajax({
				url: "comment/update",
				type: "post",
				data: {
					memberId: $("#memberId").val(),	// => 나중에 연결하면 loginUser의 memberId로 바꾸기
					commentId: commentId,
					postId: postId,
					updatedContent: updatedContent
				},
				success: function(result) {
					const comment = document.querySelector(".comment");
					console.log(`${commentId}`);
					console.log("** Ajax 통신 성공@@ **");
					const element = "<div class='comment-view-header'>"
						+ "<div class='comment-user-name'>" + result.nickname + "</div>"
						+ "<div class='date-update-delete'>"
						+ "<div class='comment-date'>" + result.registDate + " 일전</div>"
						+ "<div class='update-delete-menu active' data-etc-target='" + result.commentId + "'>"
						+ "<i class='fa-solid fa-ellipsis'>" + "</i>"
						+ "</div>"
						+ "<div class='comment-update-delete' id='" + result.commentId + "'>"
						+ "<i class='fa-solid fa-pen-to-square'>" + "</i>" + "<i class='fa-solid fa-trash-can'>" + "</i>"
						+ "</div>"
						+ "</div>"
						+ "</div>"
						+ "<div class='comment-view-body'>"
						+ "<textarea id='commentView' name='comment' readonly>     " + result.content + "</textarea>"
						+ "</div>"
						+ "<div class='comment-view-footer'>"
						+ "<div class='reply-btn active' data-comment-target='" + result.commentId + "'>"
						+ "<i class='fa-solid fa-square-caret-down'>" + "</i>" + "<span id='replyWriter'>댓글 달기</span>"
						+ "</div>"
						+ "<div class='reply-close-btn' data-comment-target='" + result.commentId + "'>"
						+ "<i class='fa-solid fa-square-caret-up'>" + "</i>" + "<span id='replyCloser'>댓글 닫기</span>"
						+ "</div>"
						+ "<div class='comment-like' id='" + result.commentId + "'>"
						+ "<i class='fa-regular fa-heart'>" + "</i>" + "<span class='like-count'>" + result.likeCount + "</span>"
						+ "</div>"
						+ "</div>"
						+ "</div>";
					$(`.comment-view[data-comment-target ="${commentId}"]`).html(element);
				},
				error: function(err) {
					console.log("** Ajax 통신 실패 ㅠㅜ **");
					console.log(err);
				},
				complete: function() {
					console.log("** Ajax 통신 완료!! **");
				}

			});

			// 필요한 경우 서버에 요청 보내기 또는 화면 업데이트를 할 수 있습니다.
		});

		// 생성된 요소들을 comment-view-body에 추가
		commentViewBody.appendChild(textArea);
		commentViewBody.appendChild(paperPlaneIcon);

	});
});

// -------------

// 댓글 삭제 기능
const deleteBtns = document.querySelectorAll(".comments .comment-update-delete .fa-solid fa-trash-can");
deleteBtns.forEach(deleteBtn => {
	deleteBtn.addEventListener("click", (event) => {
		const comment = event.target.closest(".comment");
		const commentId = comment.querySelector('input[name="commentId"]').value;

		$.ajax({
			url: "comment/delete",
			type: "post",
			data: {
				commentId: commentId
			},
			success: function(result) {
				console.log("전달받은 데이터 commentId : " + commentId);
				console.log("** Ajax 통신 성공!@!@ **");
			},
			error: function(err) {
				console.log("** Ajax 통신 실패 **");

			},
			complete: function() {
				console.log("** Ajax 통신 완료!! **");
			}
		});
	});
});





