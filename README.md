# Trip : Log
* [주요 개발 기능](#-주요-개발-기능)
* [개발 환경](#개발-환경)
* [프로젝트 구조](#프로젝트-구조)

## 팀명 : I UNION I
> KH 정보교육원 (디지털컨버전스) 공공데이터 융합 자바개발자 양성과정<br>개발기간 : 2025.03.19 ~ 2025.04.16

## 📌 주요 개발 기능
- 프로젝트
    - 프로젝트 주제 제공
    - DB 설계 및 관리
- UI
    - 회원가입 페이지
    - 내 정보 관리 페이지
    - 내 글 정보 관리 페이지
- 기능 개발
    - 일반 회원가입 기능 구현
    - 이메일 중복 확인 기능 구현
    - 비밀번호 이중 확인 기능 구현
    - 회원정보 수정 기능 구현
    - 회원탈퇴 기능 구현
    - 웹 필터링 기능 구현

## 개발 환경
항목 | 내용
:--: |:--
Tool | ![Eclipse](https://img.shields.io/badge/IDE-Eclipse-2C2255?logo=eclipse&logoColor=white), ![VS Code](https://img.shields.io/badge/IDE-VS%20Code-007ACC?logo=visualstudiocode&logoColor=white)
Server | ![Apache Tomcat](https://img.shields.io/badge/Server-Apache%20Tomcat-F8DC75?logo=apachetomcat&logoColor=black)
Tech stack |  ![Java](https://img.shields.io/badge/Language-JAVA-007396?logo=java&logoColor=white), ![JavaScript](https://img.shields.io/badge/Language-JavaScript-F7DF1E?logo=javascript&logoColor=black), ![CSS3](https://img.shields.io/badge/Style-CSS3-1572B6?logo=css3&logoColor=white), ![JSP](https://img.shields.io/badge/View-JSP-FF9800?logo=jsp&logoColor=white)
Library | ![Lombok](https://img.shields.io/badge/Library-Lombok-EA1B1B?logo=java&logoColor=white), ![JSON](https://img.shields.io/badge/Library-JSON-000000?logo=json&logoColor=white), ![GSON](https://img.shields.io/badge/Library-GSON-FF6F00?logo=google&logoColor=white), ![JSTL](https://img.shields.io/badge/Library-JSTL-336791?logo=java&logoColor=white), ![JDBC](https://img.shields.io/badge/Library-JDBC-007396?logo=java&logoColor=white), ![jQuery](https://img.shields.io/badge/Library-jQuery-0769AD?logo=jquery&logoColor=white), ![simpleMDE](https://img.shields.io/badge/Library-simpleMDE-2B2B2B?logo=markdown&logoColor=white), ![SweetAlert2](https://img.shields.io/badge/Library-SweetAlert2-FF6C6C?logo=javascript&logoColor=white), ![Font Awesome](https://img.shields.io/badge/Icon-Font%20Awesome-339AF0?logo=fontawesome&logoColor=white)
Framework | ![MyBatis](https://img.shields.io/badge/Framework-MyBatis-1F6E43?logo=java&logoColor=white), ![Bootstrap](https://img.shields.io/badge/Framework-Bootstrap-7952B3?logo=bootstrap&logoColor=white)
DB |  ![Oracle DB](https://img.shields.io/badge/Database-Oracle%20DB-F80000?logo=oracle&logoColor=white)
API | ![Kakao API](https://img.shields.io/badge/API-Kakao-yellow?logo=kakao&logoColor=black), ![Google API](https://img.shields.io/badge/API-Google-4285F4?logo=google&logoColor=white)

## 프로젝트 구조
```
📦 trip-log
├── 📂docs                # 프로젝트 문서
├── 📂resources           # MyBatis 설정, SQL 등
│   ├── 📂mappers
│   ├── mybatis-config.xml
│   └── schema.sql
├── 📂src
│   └── 📂main
│       ├── 📂java
│       │   └── 📂kr.co.khedu
│       │       ├── 📂member         # 회원 기능
│       │       ├── 📂post           # 게시글 기능
│       │       ├── 📂product        # 상품 기능
│       │       ├── 📂vote           # 투표 기능
│       │       ├── 📂comment        # 댓글 기능
│       │       └── 📂common         # 공통 유틸, 설정 등
│       ├── 📂resources
│       └── 📂webapp
│           └── 📂WEB-INF
│               └── 📂views         # JSP 뷰 파일
├── 📂webapp
│   ├── 📂assets           # 정적 자원
│   │   ├── 📂css
│   │   ├── 📂js
│   │   └── 📂images
│   └── 📜index.jsp
├── .gitignore
└── README.md
```
