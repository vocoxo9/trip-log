<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String rootPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%= rootPath %>/assets/css/product/productRegister.css">
</head>
<body>
<div id="root">
	<jsp:include page="../common/header.jsp"></jsp:include>
        <div class="container">
            <div class="productEnrollForm">
                <form action="products/auth/register" method="post">
                    <div class="mb-5">
                        <label for="productName" class="product-register-label">상품명을 작성하세요.</label>
                        <input class="form-control product-register-input" id="productName" name="name" rows="3"></input>
                    </div>
                    <div class="mb-5">
                        <label for="productStock" class="product-register-label">재고를 작성하세요.</label>
                        <input class="form-control product-register-input" id="productStock" name="stock" rows="3"></input>
                    </div>
                    <div class="mb-5">
                        <label for="productPrice" class="product-register-label">가격을 작성하세요.</label>
                        <input class="form-control product-register-input" id="productPrice" name="price" rows="3"></input>
                    </div>
                    <div class="mb-5">
                        <label for="productDescription" class="product-register-label">상품설명을 작성하세요.</label>
                        <textarea class="form-control product-register-input" id="productDescription" name="description"
                            rows="3"></textarea>
                    </div>
                    <div class="product-register-btn-group">
                        <button type="submit" class="button">등록</button>
                        <button type="reset" class="button">초기화</button>
                    </div>
                </form>
            </div>
        </div>
	<jsp:include page="../common/footer.jsp"></jsp:include>
   </div>
</body>
</html>