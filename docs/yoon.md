# 로그인 기능 구현(일반 로그인과 소셜 로그인)

- 일반 로그인
- 소셜 로그인 (카카오, 구글 API)

## 카카오, 구글 소셜 로그인 
- 카카오 디벨롭퍼와 구글 디벨롭퍼 콘솔에서 앱을 생성해 API 활성화 및 Redirect URI 를 설정함
- 각 디벨롭퍼에서 클라이언트 아이디와 클라이언트 시크릿 아이디를 받아와서 접근 토큰 발급 요청을 API 서버에 보내서 승인된 토큰을 받은 뒤에 우리 서비스는 회원의 이메일 정보만 필요해 사용자 정보 가져오기 중 이메일만 요청 `getGoogleEmail(String token)`, 받아온 사용자 이메일을 통해 로그인 완료 및 데이터베이스에 저장, 비밀번호 같은 경우는 회원가입의 경우 필수적인 필드이기에 `String tempPassword = "social_" + System.currentTimeMillis();` 이런식으로 임의값을 자동을 부여
 - 일반 로그인 컨트롤러에게 `KeyManager클래스를 통해 API 키값을 전달`, 왜냐하면 API키값 중 클라이언트 아이디와 시크릿아이디는 외부에 유출되면 안되서 하드코딩하면 안된다. 
* 개발하기 전에 카카오와 구글 API 를 사용하기 위해 스크립트를 설정해야함

        `<script src="https://t1.kakaocdn.net/kakao_js_sdk/2.7.4/kakao.min.js"crossorigin="anonymous"></script>` 


        `<script src="https://apis.google.com/js/platform.js" async defer></script>`
- 개발 문서는 REST API, JavaScript 를 함께 사용
## 단계 설명(카카오를 예제로 설명)
### 1) 사용자가 카카오 로그인 요청을 보내면 서버에는 인가코드를 발급 요청을 보낸다.
### 2) 카카오 디벨롭퍼에 지정해둔 Redirect URI로 리다이렉션되며 토큰 발급 요청을 보내 받은 토큰으로 앱에 연결된다.
### 3) 회원 등록을 위해 사용자 정보 가져오기 요청을 서버에 보내서 개발자가 지정해둔 동의항목의 정보를 가지고 회원을 등록한다.
### 4) 해당 정보를 세션에 저장, 로그인 완료로 메인 페이지로 돌아간다.

