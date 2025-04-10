<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.Date" %>
<%@ page import="kr.co.khedu.post.model.dto.PostSummaryDTO" %>
<%
    String rootPath = request.getContextPath();

    // 포스트 목록
    List<? extends PostSummaryDTO> posts = (List<? extends PostSummaryDTO>) request.getAttribute("posts");
%>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글 목록</title>
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
    <link href="<%= rootPath %>/assets/css/reset.css" rel="stylesheet">
    <style>
        .sort-area {
            display: flex;
            justify-content: center;
            margin-bottom: 2rem;
        }
    </style>
    <style>
        .post-container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 2rem 1rem;
            line-height: 1.5;
        }

        .post-grid {
            display: grid;
            gap: 2rem;
            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
        }

        .post-card {
            display: flex;
            flex-direction: column;
            background: #fff;
            border: 0.25rem solid #BAD9CE;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.08);
            overflow: hidden;
            transition: all 0.3s ease;
            height: 100%;
        }

        .post-thumbnail {
            margin: 0;
            position: relative;
            aspect-ratio: 16/9;
            overflow: hidden;
            padding: 1.25rem 1.5rem 0;
        }

        .post-thumbnail > img {
            width: 100%;
            height: 100%;
            object-fit: cover;
            transition: transform 0.5s ease;
        }

        .post-header {
            padding: 1.25rem 1.5rem 0;
        }

        .post-title {
            margin: 0;
            font-size: 1.25rem;
            font-weight: 600;
        }

        .post-title a {
            color: inherit;
            text-decoration: none;
            transition: color 0.2s;
        }

        .post-content {
            padding: 0.75rem 1.5rem;
            color: #555;
            font-size: 0.95rem;
            flex-grow: 1;
        }

        .post-footer {
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
            padding: 1rem 1.5rem;
            border-top: 1px solid #f0f0f0;
            margin-top: auto;
            background: rgba(250, 250, 250, 0.8);
        }

        .post-date {
            font-size: 0.85rem;
            color: #666;
        }

        .post-meta {
            display: flex;
            gap: 1.25rem;
        }

        .meta-item {
            display: flex;
            align-items: center;
            gap: 0.35rem;
            font-size: 0.9rem;
            color: #666;
            cursor: default;
        }
    </style>

    <!-- 네비게이션 스타일 -->
    <style>
        .pagination {
            display: flex;
            justify-content: center;
            margin-top: 2rem;
            gap: 0.4rem;
        }

        .pagination li {
            list-style: none;
        }

        .pagination a {
            color: var(--text-color);
            padding: 0.4rem 0.9rem;
            display: inline-flex;
            justify-content: center;
            align-items: center;
            height: 40px;
        }

        .pagination a:hover {
            color: var(--bg-color);
            background-color: var(--strong-color);
        }

        .icon-paging {
            background-color: var(--main-color);
            padding: 0.3rem;
        }
    </style>
</head>

<body>
<div id="root">
    <jsp:include page="../common/header.jsp" />
    <div class="post-container">
        <div class="sort-area">
            <select aria-label="정렬 기준">
                <option value="views">조회 수</option>
                <option value="likes">좋아요 수</option>
                <option value="comments">댓글 수</option>
            </select>
        </div>
        <section class="post-grid">
            <%
                for (PostSummaryDTO post : posts) {
            %>
            <article class="post-card">
                <figure class="post-thumbnail">
                    <img src="https://via.placeholder.com/400x300" alt="게시물 이미지">
                </figure>

                <header class="post-header">
                    <h2 class="post-title">
                        <a href="#">
                            <%=
                                post.getTitle().length() > 25 ?
                                post.getTitle().substring(0, 25) + "..." :
                                post.getTitle()
                            %>
                        </a>
                    </h2>
                </header>

                <div class="post-content">
                    <p>
                        <%=
                            post.getContent().length() > 200 ?
                            post.getContent().substring(0, 200) + "..." :
                            post.getContent()
                        %>
                    </p>
                </div>

                <footer class="post-footer">
                    <div class="post-date">
                        <%= post.getCreatedAt() %>
                    </div>

                    <div class="post-meta">
                        <div class="meta-item">
                            <svg xmlns="http://www.w3.org/2000/svg"
                                 width="16"
                                 height="16"
                                 fill="currentColor"
                                 class="bi bi-heart"
                                 viewBox="0 0 16 16">
                                <path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143q.09.083.176.171a3 3 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15"/>
                            </svg>
                            <%= post.getLikes() %>
                        </div>
                        <div class="meta-item">
                            <svg xmlns="http://www.w3.org/2000/svg"
                                 width="16"
                                 height="16"
                                 fill="currentColor"
                                 class="bi bi-chat-left"
                                 viewBox="0 0 16 16">
                                <path d="M14 1a1 1 0 0 1 1 1v8a1 1 0 0 1-1 1H4.414A2 2 0 0 0 3 11.586l-2 2V2a1 1 0 0 1 1-1zM2 0a2 2 0 0 0-2 2v12.793a.5.5 0 0 0 .854.353l2.853-2.853A1 1 0 0 1 4.414 12H14a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2z"/>
                            </svg>
                            <%= post.getComments() %>
                        </div>
                    </div>
                </footer>
            </article>
            <%
                }
            %>
        </section>
        <div id="paging-area">
            <ul class="pagination">
                <li class="page-item">
                    <a href="" class="page-link icon-paging">
                        <i class="fa-solid fa-less-than"></i>
                    </a>
                </li>
                <li class="page-item">
                    <a href="" class="page-link">1</a>
                </li>
                <li class="page-item">
                    <a href="" class="page-link">2</a>
                </li>
                <li class="page-item">
                    <a href="" class="page-link">3</a>
                </li>
                <li class="page-item">
                    <a href="" class="page-link">4</a>
                </li>
                <li class="page-item">
                    <a href="" class="page-link">5</a>
                </li>
                <li class="page-item">
                    <a href="" class="page-link">6</a>
                </li>
                <li class="page-item">
                    <a href="" class="page-link">7</a>
                </li>
                <li class="page-item">
                    <a href="" class="page-link">8</a>
                </li>
                <li class="page-item">
                    <a href="" class="page-link">9</a>
                </li>
                <li class="page-item">
                    <a href="" class="page-link icon-paging">
                        <i class="fa-solid fa-greater-than"></i>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp" />
</div>
</body>

</html>