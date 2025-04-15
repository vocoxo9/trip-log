<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.co.khedu.member.model.dto.MemberDTO" %>
<% 
	String rootPath = request.getContextPath();
	MemberDTO loginMember = (MemberDTO) session.getAttribute("loginMember");
%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>마이페이지</title>

    <!-- CSS style -->
    <link rel="stylesheet" href="<%= rootPath %>/assets/css/member/myPage.css">
</head>

<body>
    <div id="root">
    <jsp:include page="../common/header.jsp" />
        <div class="container">
            <div class="mypage-left">
				<a href="<%=rootPath%>/members/mypage">내 정보 관리</a> <img
					src="<%=rootPath%>/assets/images/member/mypage-arrow.png" alt=">"><br>
				<hr>
				<a href="<%=rootPath%>/members/posts">내 글 정보 관리</a> <img
					src="<%=rootPath%>/assets/images/member/mypage-arrow.png" alt=">"><br>
				<hr>
				<a href="<%=rootPath%>/members/comments">내 댓글 정보 관리</a> <img
					src="<%=rootPath%>/assets/images/member/mypage-arrow.png" alt=">"><br>
				<hr>
				<a href="<%=rootPath%>/members/productLikes">상품 찜 목록</a> <img
					src="<%=rootPath%>/assets/images/member/mypage-arrow.png" alt=">"><br>
				<hr>
				<a href="javascript:void(0)">개발중 . . .</a> <img
					src="<%=rootPath%>/assets/images/member/mypage-arrow.png" alt=">">
				<hr>
            </div>
            <div class="mypage-right">
                <div class="mypage-right-title">
                    <img src="<%= rootPath %>/assets/images/member/mypage-rectangle.png" alt="메뉴바">
                    <div class="title">내 정보 관리</div>
                </div>
                <div class="mypageInfo">
                    <table>
                        <tr id="mypageRequired">
                            <th>닉네임</th>
                            <th>이메일</th>
                            <td></td>
                        </tr>
                        <tr>
                            <td>
                            	<img src="<%= rootPath %>/assets/images/member/sampleProfile.png" alt="프로필사진" id="myPageImage">
                            	${ loginMember.nickname }
                            	</td>
                            <td><%= loginMember.getEmail() %></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td id="space" colspan="3"></td>
                        </tr>
                        <tr id="mypageOption">
                            <th>생년월일</th>
                            <th>연락처</th>
                            <th>국적</th>
                        </tr>
                        <tr>
                            <td>
                            	<% if (loginMember.getBirthday() == null) {%>
                                   정보 없음    
                                <% } else {%>
                                   <%= loginMember.getBirthday() %>
                                <% } %>
                            </td>
                            <td>
                                <% if (loginMember.getPhone() == null) {%>
                                   정보 없음    
                                <% } else {%>
                                   <%= loginMember.getPhone() %>
                                <% } %>
                            </td>
                            <td>
                            	<% if (loginMember.getCountryName() == null) {%>
                                   정보 없음    
                                <% } else {%>
                                   <%= loginMember.getCountryName() %>
                                <% } %>
                            </td>
                        </tr>
                    </table>
                </div>

                <!-- 회원정보 수정 모달 -->
                <div class="mypage-update">
                    <button type="button" id="mypageUpdateBtn" data-bs-toggle="modal"
                        data-bs-target="#mypageUpdateModal" data-bs-whatever="@mdo">정보수정하기</button>

                    <div class="modal fade" id="mypageUpdateModal" tabindex="-1" aria-labelledby="exampleModalLabel"
                        aria-hidden="true">
                        <div class="modal-dialog modal-dialog-centered">
                            <div class="modal-content">
                            	<div class="modal-header">
					        		<h1 class="modal-title fs-5" id="title">회원정보 수정</h1>
					      		</div>
                                <div class="modal-body">
                                        <div class="requiredItems">
                                            <h5 class="modal-title" id="title">필수항목</h5>
                                            <div class="">
                                                <label for="email" class="col-form-label">이메일</label>
                                                <input type="email" class="form-control" name="email" id="email"
                                                    value="<%= loginMember.getEmail() %>" disabled readonly>
                                            </div>
                                            <% if (loginMember.getRole().equals("SOCIAL")) { %>
                                            	<div class="">
	                                                <label for="password" class="col-form-label">비밀번호</label>
	                                                <input type="password" class="form-control" name="password"
	                                                    id="password" value="${ loginMember.password}" readonly disabled>
	                                            </div>
	                                            <div class="">
                                                <label for="passwordCheck" class="col-form-label">비밀번호 확인</label>
                                                <input type="password" class="form-control" id="passwordCheck" value="${ loginMember.password}" readonly disabled>
                                            </div>
                                            <% } else {%>
	                                            <div class="">
	                                                <label for="password" class="col-form-label">비밀번호</label>
	                                                <input type="password" class="form-control" name="password"
	                                                    id="password">
	                                            </div>
	                                            <div class="">
	                                                <label for="passwordCheck" class="col-form-label">비밀번호 확인</label>
	                                                <input type="password" class="form-control" id="passwordCheck">
	                                            </div>
                                            <% } %>
                                        </div>

                                        <div class="optionalItems">
                                            <h5 class="modal-title" id="title">선택항목</h5>
                                            <table>
                                                <tr>
                                                    <td>
                                                        <label for="phone">연락처</label> <br>
                                                        <input type="tel" class="form-control" name="phone" id="phone" pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" placeholder="연락처(- 포함)">
                                                    </td>
                                                    <td>
                                                        <label for="nickname"> 닉네임</label> <br>
                                                        <input type="text" class="form-control" name="nickname" id="nickname" placeholder="닉네임">
                                                    </td>
                                                </tr>
                
                                                <tr>
                                                    <td>
                                                        <label for="birthday">생년월일</label> <br>
                                                        <input type="text" class="form-control" name="birthday" id="birthday"
                                                        				<% if (loginMember.getBirthday() == null) {%>
										                                   value="정보 없음"    
										                                <% } else {%>
										                                   value="<%= loginMember.getBirthday() %>"
										                                <% } %>
                                                        			 disabled readonly>
                                                        <input type="hidden" name="memberId" id="memberId" value="<%= loginMember.getMemberId() %>" />
                                                    </td>
                                                    <td>
                                                        <label for="countryId">국적</label> <br>
                                                        <div class="form-floating">
                                                            <select name="countryId" id="countryId">
                                                              <option value="1">대한민국</option>
                                                              <option value="2">일본</option>
                                                              <option value="3">중국</option>
                                                              <option value="4">베트남</option>
                                                              <option value="5">인도</option>
                                                              <option value="6">프랑스</option>
                                                              <option value="7">독일</option>
                                                              <option value="8">이탈리아</option>
                                                              <option value="9">스페인</option>
                                                              <option value="10">영국</option>
                                                              <option value="11">미국</option>
                                                              <option value="12">캐나다</option>
                                                              <option value="13">멕시코</option>
                                                              <option value="14">브라질</option>
                                                              <option value="15">아르헨티나</option>
                                                              <option value="16">콜롬비아</option>
                                                              <option value="17">칠레</option>
                                                              <option value="18">이집트</option>
                                                              <option value="19">남아프리카공화국</option>
                                                              <option value="20">나이지리아</option>
                                                              <option value="21">모로코</option>
                                                              <option value="22">호주</option>
                                                              <option value="23">뉴질랜드</option>
                                                              <option value="24">파푸아뉴기니</option>
                                                              <option value="25">남극</option>
                                                            </select>
                                                        </div>
                                                    </td>
                                                </tr>
                                            </table>
                                        </div>                                        
                                
                                </div>
                                <div class="modal-button">
                                    <button type="submit" class="btn btn-light" id="submitBtn"
                                        data-bs-dismiss="modal" onclick="return updatePwdCheck();">수정하기</button>
                                    <button type="button" class="btn btn-light" id="cancelBtn" data-bs-dismiss="modal"
                                        aria-label="Close">취소</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                
                
                <!-- 회원탈퇴 모달 -->
                <div class="mypage-delete">
	                <button type="button" id="mypageDeleteBtn" data-bs-toggle="modal" 
	                	data-bs-target="#mypageDeleteModal" data-bs-whatever="@mdo">탈퇴하기</button>
					
					<div class="modal fade" id="mypageDeleteModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
					  <div class="modal-dialog">
					    <div class="modal-content">
					      <div class="modal-header">
					        <h1 class="modal-title fs-5" id="title">회원탈퇴</h1>
					      </div>
					      <div class="modal-body">
					      <% if (loginMember.getRole().equals("SOCIAL")) { %>
					          <div class="mb-3">
					            <label for="password" class="col-form-label" id="title">비밀번호</label>
					            <input type="password" class="form-control" name="password" id="password" readonly disabled value="${loginMember.password}">
					          </div>
					          <div class="mb-3">
					            <label for="passwordCheck" class="col-form-label" id="title">비밀번호 확인</label>
					            <input type="password" class="form-control" id="passwordCheck" readonly disabled value="${loginMember.password}" >
					            <input type="hidden" name="memberId" id="memberId" value="<%= loginMember.getMemberId() %>" />
					          </div>
					      <% } else { %>
					      		<div class="mb-3">
					            <label for="password" class="col-form-label" id="title">비밀번호</label>
					            <input type="password" class="form-control" name="password" id="password" value="${loginMember.password}" />
					          </div>
					          <div class="mb-3">
					            <label for="passwordCheck" class="col-form-label" id="title">비밀번호 확인</label>
					            <input type="password" class="form-control" id="passwordCheck">
					            <input type="hidden" name="memberId" id="memberId" value="<%= loginMember.getMemberId() %>" />
					          </div>
					      <% } %>
					      </div>
					      <div class="modal-button">
					        <button type="submit" class="btn btn-light" id="submitBtn"
                                        data-bs-dismiss="modal" onclick="return delPwdCheck();">탈퇴하기</button>
                            <button type="button" class="btn btn-light" id="cancelBtn" data-bs-dismiss="modal"
                                        aria-label="Close">취소</button>
					      </div>
					    </div>
					  </div>
					</div> 
                </div>          
        </div>
       </div>
        <jsp:include page="../common/footer.jsp" />
    	<script src="<%= rootPath %>/assets/js/member/myPage.js"></script>
    </div> 
</body>

</html>