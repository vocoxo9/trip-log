



// 댓글 달기 누르면 대댓글 작성란과 대댓글 나타내기
const replyBtns = document.querySelectorAll(".reply-btn");
const reply = document.querySelectorAll(".reply");
const replyCloseBtns = document.querySelectorAll(".reply-close-btn");
// => '댓글 달기' 버튼과 '댓글 닫기' 버튼 선택

// 각 댓글달기 버튼 클릭 시 각 reply 나타내고, 해당 버튼은 사라지고, 댓글닫기 버튼 활성화
replyBtns.forEach(replyBtn => {
	replyBtn.addEventListener("click", () => {
		const targetId = replyBtn.getAttribute("data-target");
		const replyElement = document.getElementById(targetId);
		replyElement.classList.add("active"); // reply 표시
		replyBtn.classList.remove("active"); // '댓글 달기' 버튼 숨김

		// '댓글 닫기' 버튼 활성화
		const replyCloseBtn = document.querySelector(`[data-target="${targetId}"].reply-close-btn`);
		replyCloseBtn.classList.add("active");

		// ---------------------

		// 비동기 통신으로 대댓글 리스트 가져오기
		const dataTarget = document.querySelector(`[data-target="${targetId}"].reply-close-btn`).getAttribute('data-target');
		const postId = document.querySelector("input[name=postId]").value;
		$.ajax({
			url: "replyList/select",
			type: 'post',
			data: {
				parentNum: dataTarget,
				postNum: postId
			},

			success: function(result) {
				console.log("** Ajax 통신 성공!! **")
				let element = "";
				for (let i of result) {
					console.log(i);
					element += '<div class="reply-views">'
						+ '<div class="reply-user-profile">'
						+ '<i class="fa-solid fa-user">' + '</i>'
						+ '</div>'
						+ '<div class="reply-view">'
						+ '<div class="reply-view-header">'
						+ '<div class="reply-user-name">' + i.userName + '</div>'
						+ '<div class="date-update-delete">'
						+ '<div class="reply-date">' + i.registDate + '일 전 </div>'
						+ '<div class="update-delete-menu active">'
						+ '<i class="fa-solid fa-ellipsis">' + '</i>'
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
						+ '<div>'
						+ '<i class="fa-regular fa-heart">' + '</i>' + ' <span class="like-count">' + i.likeCount + '</span>'
						+ '</div>'
						+ '</div>'
						+ '</div>'
						+ '</div>'
				}
				$(".reply#" + dataTarget).append(element);
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
		const targetId = closeBtn.getAttribute("data-target");
		const replyElement = document.getElementById(targetId);
		replyElement.classList.remove("active"); // reply 숨김
		closeBtn.classList.remove("active"); // '댓글 닫기' 버튼 숨김

		// '댓글 달기' 버튼 다시 활성화
		const replyBtn = document.querySelector(`[data-target="${targetId}"]`);
		replyBtn.classList.add("active");
	});
});


const commentEtcBtns = document.querySelectorAll(".comment-view .update-delete-menu");
const commentUDBtn = document.querySelector(".comment-view .comment-update-delete");
commentEtcBtns.forEach(etcBtn => {
	etcBtn.addEventListener("click", () => {
		etcBtn.classList.remove("active");
		commentUDBtn.classList.add("active");
	});
});
const replyEtcBtns = document.querySelectorAll(".reply-view .update-delete-menu");
const replyUDBtn = document.querySelector(".reply-view .reply-update-delete");
replyEtcBtns.forEach(etcBtn => {
	etcBtn.addEventListener("click", () => {
		etcBtn.classList.remove("active");
		replyUDBtn.classList.add("active");
	});
});


const commentRegistBtn = document.querySelector(".comment-input i");
commentRegistBtn.addEventListener("click", () => {
	const viewArea = document.getElementById("pageComment");
	const postId = document.querySelector("input[name=postId]").value;
	$.ajax({
		url: 'comment/regist',
		type: "post",
		data: {
			name: $("#memberId").val(),	// => 나중에 연결하면 loginUser의 memberId로 바꾸기
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
				+ "<div class='comment-user-name'>" + result.memberId + "</div>"
				+ "<div class='date-update-delete'>"
				+ "<div class='comment-date'>" + result.registDate + "</div>"
				+ "<div class='update-delete-menu active'>"
				+ "<i class='fa-solid fa-ellipsis'>" + "</i>"
				+ "</div>"
				+ "<div class='comment-update-delete'>"
				+ "<i class='fa-solid fa-pen-to-square'>" + "</i>" + "<i class='fa-solid fa-trash-can'>" + "</i>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "<div class='comment-view-body'>"
				+ "<textarea id='commentView' name='comment' readonly>     " + result.content + "</textarea>"
				+ "</div>"
				+ "<div class='comment-view-footer'>"
				+ "<div class='reply-btn active' data-target='data-target'>"
				+ "<i class='fa-solid fa-square-caret-down'>" + "</i>" + "<span id='replyWriter'>댓글 달기</span>"
				+ "</div>"
				+ "<div class='reply-close-btn' data-target='data-target'>"
				+ "<i class='fa-solid fa-square-caret-up'>" + "</i>" + "<span id='replyCloser'>댓글 닫기</span>"
				+ "</div>"
				+ "<div class='comment-like'>"
				+ "<i class='fa-regular fa-heart'>" + "</i>" + "<span class='like-count'>" + result.likeCount + "</span>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "<div class='reply' id='data-target'>"
				+ "<div class='reply-input'>"
				+ "<!-- " + "<input type='text' id='reply'>" + " -->"
				+ "<textarea id='reply'>" + "</textarea>"
				+ "<i class='fa-regular fa-paper-plane'>" + "</i>"
				+ "</div>"
				+ "<div class='reply-views'>"
				+ "<div class='reply-user-profile'>"
				+ "<i class='fa-solid fa-user'>" + "</i>"
				+ "</div>"
				+ "<div class='reply-view'>"
				+ "<div class='reply-view-header'>"
				+ "<div class='reply-user-name'>사용자 이름</div>"
				+ "<div class='date-update-delete'>"
				+ "<div class='reply-date'>작성날짜</div>"
				+ "<div class='update-delete-menu active'>"
				+ "<i class='fa-solid fa-ellipsis'>" + "</i>"
				+ "</div>"
				+ "<div class='reply-update-delete'>"
				+ "<i class='fa-solid fa-pen-to-square'>" + "</i>" + "<i class='fa-solid fa-trash-can'>" + "</i>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "<div class='reply-view-body'>"
				+ "<textarea id='replyView' name='reply' readonly>		감사합니다.^*</textarea>"
				+ "</div>"
				+ "<div class='reply-view-footer'>"
				+ "<div>"
				+ "<i class='fa-regular fa-heart'>" + "</i>" + "<span class='like-count'>0</span>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
				+ "</div>"
			$(".comment").prepend(element);
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


