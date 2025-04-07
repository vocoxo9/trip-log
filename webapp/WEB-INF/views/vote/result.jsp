<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    String rootPath = request.getContextPath();
    String result = (String) request.getAttribute("result");
%>
<html lang="ko">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>투표 결과</title>
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

    <!-- Chart.js CDN  -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <!-- Chart.js 구현 -->
    <script>
        $(() => {
            const context = $('#graph-canvas')[0].getContext('2d')

            const data = JSON.parse(
                $('#result').val()
            );

            const colors = []
            for (let i = 0; i < Object.keys(data).length; i++) {
                colors.push(
                    '#' + Math.floor(Math.random() * 16777215).toString(16)
                );
            }

            const chart = new Chart(context, {
                type: 'bar',
                data: {
                    labels: Object.keys(data),
                    datasets: [
                        {
                            label: '투표 수',
                            data: Object.values(data),
                            backgroundColor: colors,
                            borderWidth: 1,
                            barThickness: 25
                        }
                    ]
                },
                options: {
                    plugins: {
                        legend: {
                            display: false
                        }
                    },
                    responsive: true
                }
            });
        })
    </script>

    <style>
        .result-container {
            max-width: 800px;
            margin: 0 auto;
            padding: 2rem 1rem;
            line-height: 1.5;

            display: flex;
            flex-direction: column;
            align-items: center;
            gap: 1.5rem;
        }

        .title-area {
            width: 720px;
        }

        .title {
            border-left: 0.375rem solid #118C8C;
            padding: 0 0.5rem;

            font-size: 2.0rem;
        }

        .ranking-area {
            display: flex;
            flex-direction: row;
            align-items: center;
        }

        .region {
            border-left: 0.25rem solid;
            padding: 0 0.333rem;

            font-size: 1.5rem;
        }

        .region > i {
            padding: 0rem 0.5rem;
        }

        .region:nth-child(1) {
            border-color: #0E6973;
        }

        .region:nth-child(2) {
            border-color: #118C8C;
        }

        .region:nth-child(3) {
            border-color: #BAD9CE;
        }

        .ranking-item {
            width: 360px;
            height: 240px;
            display: flex;

            flex-direction: column;
            justify-content: center;
            align-items: center;
            gap: 0.5rem;
        }

        .ranking-item > i {
            font-size: 8.75rem;
            color: #BAD9CE;
        }

        .graph-area {
            width: 720px;
        }
    </style>
</head>

<body>
</body>
<div id="root">
    <jsp:include page="../common/header.jsp" />
    <div class="result-container">
        <div class="title-area">
            <h2 class="title">
                좋아, 이번 달은 여기다!
            </h2>
        </div>
        <div class="ranking-area">
            <div class="ranking-item">
                <i class="fa-solid fa-ranking-star"></i>
            </div>
            <div class="ranking-item">
                <h4 class="region">
                    가평
                    <i class="fa-solid fa-medal" style="color: #FFD43B;"></i>
                </h4>
                <h4 class="region">
                    춘천
                    <i class="fa-solid fa-medal" style="color: #d6d6d6;"></i>
                </h4>
                <h4 class="region">
                    부산
                    <i class="fa-solid fa-medal" style="color: #d89140;"></i>
                </h4>
            </div>
        </div>
        <div class="graph-area">
            <!-- 값 전달을 위한 태그 -->
            <input type="hidden"
                   id="result"
                   value='${result}'>

            <canvas id="graph-canvas"></canvas>
        </div>
    </div>
    <jsp:include page="../common/footer.jsp" />
</div>
</html>