<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String rootPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>

    <!-- CSS style -->
    <link href="resources/reset.css" rel="stylesheet">
    <link rel="stylesheet" href="<%= rootPath %>/assets/css/member/signupPage.css">

</head>

<body>
    <div id="root">
        <div class="signup-title">회원가입</div>
        <div class="container">
            <div class="signup-left">
                <div class="img-box">
                    <img src="resources/img/girl-1459248_1280 1.png" alt="회원가입 이미지">
                </div>
                <div class="img-text">
                    <p>시간이 지나도<strong>기억될 여행</strong>, <br>
                        <strong>트립로그</strong>에서 기록하세요!<br>
                        당신의 여행 기록이 누군가의 <br>다음 여행이 될 거예요!
                    </p>
                </div>
            </div>
            <div class="signup-right">
                <div class="signup-box">
                    <form action="#" method="post">
                        <div class="requiredItems">
                            <p id="requiredTitle">필수항목</p>
                            <label for="email">이메일</label> <br>
                            <input type="email" name="email" id="email" placeholder="이메일" required> <br>

                            <label for="password">비밀번호</label> <br>
                            <input type="password" name="password" id="password" placeholder="비밀번호" required> <br>

                            <label for="passwordCheck">비밀번호 확인</label> <br>
                            <input type="password" id="passwordCheck" placeholder="비밀번호 확인" required>

                        </div>

                        <div class="optionalItems">
                            <p id="optionTitle">선택항목</p>
                            <table>
                                <tr>
                                    <td>
                                        <label for="phone">연락처</label> <br>
                                        <input type="tel" name="phone" id="phone" placeholder="연락처">
                                    </td>
                                    <td>
                                        <label for="nickname"> 닉네임</label> <br>
                                        <input type="text" name="nickname" id="nickname" placeholder="닉네임">
                                    </td>
                                </tr>

                                <tr>
                                    <td>
                                        <label for="birthday">생년월일</label> <br>
                                        <input type="date" name="birthday" id="birthday">
                                    </td>
                                    <td>
                                        <div class="form-floating">
                                            <select name="country" id="country">
                                            <option selected>국적을 선택해 주세요.</option>
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
                                              <option value="20">나이지라</option>
                                              <option value="21">모로코</option>
                                              <option value="22">호주</option>
                                              <option value="23">뉴질랜드</option>
                                              <option value="24">파푸아뉴기니</option>
                                              <option value="25">남극</option>
                                            </select>
                                            <!-- <label for="floatingSelect">국적</label> -->
                                          </div>
                                    </td>
                                </tr>
                            </table>
                        </div>

                        <div class="singup-button">
                            <button type="submit" id="signupButton">가입하기</button>
                            <button type="button" id="cancelButton">취소</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</body>

</html>