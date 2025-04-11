<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글 작성</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
            crossorigin="anonymous"></script>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"
            integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.7.2/css/all.min.css"
          integrity="sha512-Evv84Mr4kqVGRNSgIGL/F/aIDqQb7xQ2vcrdIwxfjThSH8CSR7PBEakCr51Ck+w+/U6swU2Im1vVX0SVk9ABhg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <link href="${pageContext.request.contextPath}/assets/css/reset.css" rel="stylesheet">
    <style>
        .CodeMirror,
        .CodeMirror-scroll {
            min-height: 360px !important;

            border-left: none !important;
            border-right: none !important;
            border-bottom: none !important;
        }

        .post-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 2rem 1rem;
            line-height: 1.5;

            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 1.5rem;
        }

        .title-area {
            width: 100%;
            max-width: 800px;

            border: 0.15rem solid #118C8C;
            border-radius: 12px;
        }

        .title-area > input {
            width: 100%;
            padding: 0rem 0.75rem;

            border-color: transparent;
            border-radius: 12px;
        }

        .content-area {
            width: 100%;
            max-width: 800px;

            border: 0.15rem solid #118C8C;
            border-radius: 12px;

            padding: 0.25rem 0.25rem;
        }

        .content-area > textarea {
            width: 100%;
        }

        .button-area {
            display: flex;
            align-items: center;
            gap: 1rem;
        }

        .button-area > button {
            min-width: 75px;
            min-height: 30px;

            border: 0.15rem solid #118C8C;
            border-radius: 12px;
        }

        .button-area > button:nth-child(1) {
            background-color: #118C8C;
            color: white;
        }

        .button-area > button:nth-child(2) {
            background: none;
            color: #118C8C;
        }
    </style>

    <!-- SimpleMDE CDN -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.css">
    <script src="https://cdn.jsdelivr.net/simplemde/latest/simplemde.min.js"></script>

    <!-- SimpleMDE 구현 -->
    <script>
        $(() => {
            //
            // SimpleMDE 객체의 생성자 매개변수에 textarea 엘리먼트를 전달할 수 있습니다.
            //
            // 엘리먼트를 전달할 시 해당 엘리먼트에 에디터가 적용됩니다.
            // 얼리먼트를 전달하지 않을 시 첫 textarea 엘리먼트에 에디터가 적용됩니다.
            //
            const simple = new SimpleMDE({
                status: false,
	            spellChecker: false
            });
        })
    </script>
</head>

<body>
<div id="root">
    <jsp:include page="../common/header.jsp" />
    <form class="post-container" action='${pageContext.request.contextPath}/post/writeAction' method="post">
        <div class="id-area">
            <input type="hidden" name="postId" value='${form.postId}'>
        </div>
        <div class="country-area">
            <select name="countryId" aria-label="국가">
                <c:forEach var="country" items="${countries}">
                    <option value="${country.countryId}"
                            ${form.countryId eq country.countryId ? 'selected' : ''}>
                        ${country.name}
                    </option>
                </c:forEach>
            </select>
        </div>
        <div class="title-area">
            <input type="text"
                   name="title"
                   id="title"
                   aria-label="제목 입력"
                   value="${empty form ? '' : form.title}">
        </div>
        <div class="content-area">
            <textarea name="content" aria-label="내용 입력">${empty form ? '' : form.content}</textarea>
        </div>
        <div class="button-area">
            <button type="submit">
                ${empty form ? '작성' : '수정'}
            </button>
            <button>취소</button>
        </div>
    </form>
    <jsp:include page="../common/footer.jsp" />
</div>
</body>

</html>