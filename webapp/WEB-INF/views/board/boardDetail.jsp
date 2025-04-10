<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="kr.co.khedu.board.model.vo.CommentDto,
				java.util.ArrayList"%>
<%
String rootPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Board Detail</title>

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
<link rel="stylesheet"
	href="<%=rootPath%>/assets/css/board/boardDetail.css" />

<style>
</style>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>
</head>

<body>
	<div id="root">
		<div class="container">
			<div>
				<div class="board-detail-header" id="pageUp">
					<div class="card bg-dark text-white">
						<div class="position-relative">
							<img
								src="<%=rootPath%>/assets/images/board/boardDetail-title.png"
								class="card-img" alt="대표 이미지">
							<div
								class="card-img-overlay d-flex align-items-center justify-content-center"
								style="background-color: rgba(0, 0, 0, 0.5); backdrop-filter: blur(5px);">
								<h1 class="card-title">${ boardDetail.title }</h1>
							</div>
						</div>
					</div>
				</div>
				<div class="board-detail-body">
					<div class="content">
						<textarea id="content" name="content" cols rows="100" readonly>
                            <%--
                            안녕하세요, 고객님
                            
                            스페인/북유럽팀입니다.
                            
                            여행의 여독이 채 가시지 않은 시점 소중하고도 정성스러운 후기와 아름다운 
                            사진들과 함께 다시 찾아와주셔서 정말 감사드립니다.
                            이번 여행을 통해서 즐거운 추억을 만드신 것 같아 같은 담당으로서 기쁘고 뿌듯한 순간입니다.
                            
                            여행이란 항상 일상의 활력소가 되는 느낌입니다. 다녀온 뒤의 추억을 통해 일상을 살아갈 힘을 얻고,
                            다음 번 여행을 기다리며 설레는 행복감으로 하루 하루를 살아갈 수 있는 에너지를 주는 것이 
                            바로 ' 여행 ' 이라고 생각합니다.
                            
                            아름답고 행복했던 여행의 순간 순간을 오래 간직하여 주시길 바라겠습니다. 
                            수고해주신 인솔자님과 가이드님의 대한 칭찬의 말씀도 개별적으로 꼭 전달해드리도록 하겠습니다.
                            
                            다음 번에도 참좋은여행과 동행하여 주신다면 항상 더욱 더 발전된 모습으로,
                            말 그대로 ' 참좋은 여행 ' 을 다시 선물해드릴 수 있도록 최선을 다하겠습니다.
                            
                            감사합니다.
                            

                            안녕하세요, 고객님
                            
                            스페인/북유럽팀입니다.
                            
                            여행의 여독이 채 가시지 않은 시점 소중하고도 정성스러운 후기와 아름다운 
                            사진들과 함께 다시 찾아와주셔서 정말 감사드립니다.
                            이번 여행을 통해서 즐거운 추억을 만드신 것 같아 같은 담당으로서 기쁘고 뿌듯한 순간입니다.
                            
                            여행이란 항상 일상의 활력소가 되는 느낌입니다. 다녀온 뒤의 추억을 통해 일상을 살아갈 힘을 얻고,
                            다음 번 여행을 기다리며 설레는 행복감으로 하루 하루를 살아갈 수 있는 에너지를 주는 것이 
                            바로 ' 여행 ' 이라고 생각합니다.
                            
                            아름답고 행복했던 여행의 순간 순간을 오래 간직하여 주시길 바라겠습니다. 
                            수고해주신 인솔자님과 가이드님의 대한 칭찬의 말씀도 개별적으로 꼭 전달해드리도록 하겠습니다.
                            
                            다음 번에도 참좋은여행과 동행하여 주신다면 항상 더욱 더 발전된 모습으로,
                            말 그대로 ' 참좋은 여행 ' 을 다시 선물해드릴 수 있도록 최선을 다하겠습니다.
                            
                            감사합니다.
                            안녕하세요, 고객님
                            
                            스페인/북유럽팀입니다.
                            
                            여행의 여독이 채 가시지 않은 시점 소중하고도 정성스러운 후기와 아름다운 
                            사진들과 함께 다시 찾아와주셔서 정말 감사드립니다.
                            이번 여행을 통해서 즐거운 추억을 만드신 것 같아 같은 담당으로서 기쁘고 뿌듯한 순간입니다.
                            
                            여행이란 항상 일상의 활력소가 되는 느낌입니다. 다녀온 뒤의 추억을 통해 일상을 살아갈 힘을 얻고,
                            다음 번 여행을 기다리며 설레는 행복감으로 하루 하루를 살아갈 수 있는 에너지를 주는 것이 
                            바로 ' 여행 ' 이라고 생각합니다.
                            
                            아름답고 행복했던 여행의 순간 순간을 오래 간직하여 주시길 바라겠습니다. 
                            수고해주신 인솔자님과 가이드님의 대한 칭찬의 말씀도 개별적으로 꼭 전달해드리도록 하겠습니다.
                            
                            다음 번에도 참좋은여행과 동행하여 주신다면 항상 더욱 더 발전된 모습으로,
                            말 그대로 ' 참좋은 여행 ' 을 다시 선물해드릴 수 있도록 최선을 다하겠습니다.
                            
                            감사합니다.
                            안녕하세요, 고객님
                            
                            스페인/북유럽팀입니다.
                            
                            여행의 여독이 채 가시지 않은 시점 소중하고도 정성스러운 후기와 아름다운 
                            사진들과 함께 다시 찾아와주셔서 정말 감사드립니다.
                            이번 여행을 통해서 즐거운 추억을 만드신 것 같아 같은 담당으로서 기쁘고 뿌듯한 순간입니다.
                            
                            여행이란 항상 일상의 활력소가 되는 느낌입니다. 다녀온 뒤의 추억을 통해 일상을 살아갈 힘을 얻고,
                            다음 번 여행을 기다리며 설레는 행복감으로 하루 하루를 살아갈 수 있는 에너지를 주는 것이 
                            바로 ' 여행 ' 이라고 생각합니다.
                            
                            아름답고 행복했던 여행의 순간 순간을 오래 간직하여 주시길 바라겠습니다. 
                            수고해주신 인솔자님과 가이드님의 대한 칭찬의 말씀도 개별적으로 꼭 전달해드리도록 하겠습니다.
                            
                            다음 번에도 참좋은여행과 동행하여 주신다면 항상 더욱 더 발전된 모습으로,
                            말 그대로 ' 참좋은 여행 ' 을 다시 선물해드릴 수 있도록 최선을 다하겠습니다.
                            
                            감사합니다.
                            안녕하세요, 고객님
                            
                            스페인/북유럽팀입니다.
                            
                            여행의 여독이 채 가시지 않은 시점 소중하고도 정성스러운 후기와 아름다운 
                            사진들과 함께 다시 찾아와주셔서 정말 감사드립니다.
                            이번 여행을 통해서 즐거운 추억을 만드신 것 같아 같은 담당으로서 기쁘고 뿌듯한 순간입니다.
                            
                            여행이란 항상 일상의 활력소가 되는 느낌입니다. 다녀온 뒤의 추억을 통해 일상을 살아갈 힘을 얻고,
                            다음 번 여행을 기다리며 설레는 행복감으로 하루 하루를 살아갈 수 있는 에너지를 주는 것이 
                            바로 ' 여행 ' 이라고 생각합니다.
                            
                            아름답고 행복했던 여행의 순간 순간을 오래 간직하여 주시길 바라겠습니다. 
                            수고해주신 인솔자님과 가이드님의 대한 칭찬의 말씀도 개별적으로 꼭 전달해드리도록 하겠습니다.
                            
                            다음 번에도 참좋은여행과 동행하여 주신다면 항상 더욱 더 발전된 모습으로,
                            말 그대로 ' 참좋은 여행 ' 을 다시 선물해드릴 수 있도록 최선을 다하겠습니다.
                            
                            감사합니다.
                            --%>
                            ${ boardDetail.content }
                            
                        </textarea>
                        <input type="hidden" id="memberId" value="${ boardDetail.memberId }"/> <%--  나중에 연결하면 loginUser의 memberId로 바꾸기!! --%>
						<div class="nav-btn">
							<nav>
								<a href="#pageUp"><i class="fa-solid fa-circle-up"></i></a> <a
									href="#pageDown"><i class="fa-solid fa-circle-down"></i></a> <a
									href="#pageComment"><i class="fa-solid fa-pencil"></i></a>
							</nav>
						</div>
					</div>
					<div class="content-update-delete">
						<div class="buttons">
							<div class="update-delete-btn">
								<input type="hidden" name="postId"
									value="${ boardDetail.postId }" /> <i
									class="fa-solid fa-pen-to-square"></i> <i
									class="fa-solid fa-trash-can"></i>
							</div>
							<div class="board-like-count">
								<i class="fa-regular fa-heart"></i> <span class="like-count">${ boardDetail.likeCount }</span>
							</div>
						</div>
					</div>
					<div class="comments" id="pageComment">
						<div class="views">
							<div class="comment">
								<div class="comment-input">
									<!-- <input type="text" id="comment"> -->
									<textarea id="comment"></textarea>
									<i class="fa-regular fa-paper-plane"></i>
								</div>
								<%
								ArrayList<CommentDto> comments = (ArrayList<CommentDto>) request.getAttribute("comments");
								%>
								<%
								if (comments != null) {
								%>
								<%
								for (CommentDto c : comments) {
								%>
								<div class="comment-views">
									<div class="comment-user-profile">
										<i class="fa-solid fa-user"></i>
									</div>
									<div class="comment-view">
										<div class="comment-view-header">
											<div class="comment-user-name" id="userName"><%=c.getMemberId()%></div>
											<div class="date-update-delete">
												<div class="comment-date" id="registDate"><%=c.getRegistDate()%>일
													전
												</div>
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
											<textarea id="commentView" name="comment" readonly><%=c.getContent()%></textarea>
										</div>
										<div class="comment-view-footer">
											<div class="reply-btn active"
												data-target="<%=c.getCommentId()%>">
												<i class="fa-solid fa-square-caret-down"></i> <span
													id="replyWriter">댓글 달기</span>
											</div>
											<div class="reply-close-btn"
												data-target="<%=c.getCommentId()%>">
												<i class="fa-solid fa-square-caret-up"></i> <span
													id="replyCloser">댓글 닫기</span>
											</div>
											<div class="comment-like">
												<i class="fa-regular fa-heart"></i> <span class="like-count"><%=c.getLikeCount()%></span>
											</div>
										</div>
									</div>
								</div>

								<div class="reply" id="<%=c.getCommentId()%>">
									<div class="reply-input">
										<!-- <input type="text" id="reply"> -->
										<textarea id="reply"></textarea>
										<i class="fa-regular fa-paper-plane"></i>
									</div>
									
								</div>
								<%
								}
								%>
								<%
								}
								%>
							</div>
						</div>
					</div>

					<script>
						
					</script>
					<div class="down-btn">
						<i class="fa-solid fa-circle-arrow-down"></i>
					</div>
				</div>
				<div class="board-detail-footer" id="pageDown">
					<div class="before">
						<div class="before-board">이전글</div>
						<div class="board-title">제주 한달살이 2주차</div>
					</div>
					<div class="next">
						<div class="next-board">다음글</div>
						<div class="board-title">제주 한달살이 3주차</div>
					</div>
					<div class="end"></div>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=rootPath%>/assets/js/post/boardDetail.js"></script>



</body>
<!--
1) 네비게이터 바 만들기**
2) 댓글 수정 삭제 버튼 숨겼다가 ...클릭하면 나오게 바꾸기
    수정버튼 클릭 시 수정하는 칸 만들기
    삭제버튼 클릭 시 해당 댓글 삭제
3) 댓글달기 버튼 눌렀을 때 대댓글 입력칸과 대댓글들 나타나기 ->(진행중임, script보면 할일 적어둠)
4) 나머지 클릭버튼 처리하기**
5) 댓글 상하 폭 줄이기
6) 댓글 입력 창 textarea 로 변경하기**
7) 댓글 프로필 이미지 영역(div)으로 border-radius 줘서 원으로 영역 잡기
-->

</html>