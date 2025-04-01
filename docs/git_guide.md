# Git 명령어 및 순서

* [Git 명령어 모음](#git명령어-모음)
* [프로젝트 작업 순서](#프로젝트-git-작업-순서)

----
## git명령어-모음

설명 | 명령어
-- | --
원격저장소의 내용을 새로운 폴더에 그대로 복사|`git clone`
브랜치 목록 보기|`git branch`
브랜치 이동|`git checkout 브랜치명`
브랜치 생성|`git checkout -b 브랜치명`
로컬 브랜치 삭제|`git branch -d 브랜치명`
원격 브랜치 삭제|`git push --delete origin 브랜치명`
스태이징|`git add . (변경사항 모두 반영)`
변경사항 모두 삭제|`git reset --hard`
브랜치 이동|`git checkout 브랜치명`
브랜치 이동|`git checkout 브랜치명`
커밋기록확인|`git log` => 커밋만 나옴<br>git reflog => 모든 상태 다 나옴(좀 더 자세함)
현재 상태 확인|`git status`
커밋하기|`git commit -m "커밋메시지"`
로컬 저장소의 변경 이력 원격저장소로 올리기|`git push origin 브랜치명`
원격저장소에 있는 프로젝트의 변경사항을 그대로 로컬저장소에 옮겨와 자동으로 병합|`git pull`

[git 공식 문서 바로가기](https://git-scm.com/docs)

[git 설명 관련 참고영상](https://youtu.be/lelVripbt2M?si=saaMpM-p9pCgJrh4)

[git 팀 프로젝트 관련 참고영상](https://youtu.be/tkkbYCajCjM?si=euS92sec8kEMb0Ko)

----

## 프로젝트 git 작업 순서
### 준비작업
- 컴퓨터에 git 계정 설정하기
- 프로젝트를 작업할 작업공간(Workspace) 폴더 만들기
- 작업공간 폴더로 열기

```
프로젝트 복사 단계는 clone_guide에 동일한 내용이 있으므로
clone_guide를 먼저 열람 후 진행하는 것을 추천!
```

### 1. 프로젝트 복사하기
```
github의 팀 리포지토리 -> 현재 브렌치 상태 확인 후 -> Code -> 링크 복사!

* 여기서는 TEST 이므로 test Repository 생성 후 진행
* 팀원은 반드시 팀 리포지토리에서 진행하길 바람!!!
```

![프로젝트 복사](./git_guide_assets/프로젝트%20복사하기.JPG)

```
작업공간 폴더에서 git bash 실행 -> 명령어 입력해서 프로젝트 복사하기!

* 여기선 TEST이므로 test 작업공간 생성 후 진행
```

![프로젝트 복사하기2](./git_guide_assets/프로젝트%20복사하기2.JPG)

- 위의 사진 설명
```
작업공간에서 git bash를 실행시킨다.
아래 명령어를 통해 프로젝트를 복사한다.
복사한 프로젝트로 경로를 이동한다.
```

명령어 : `git clone 리포지토리 주소`

### 2. 브랜치 확인 후 develop 브랜치로 이동하기
```
프로젝트 경로로 이동하면 경로 우측에 (현재브랜치명) 이 파란색으로 보인다.

처음은 main 브랜치일 것이다.

git branch 명령을 했을 때 develop이 목록에 없다. 하지만 Github의 리포지토리에서
브랜치 버튼을 클릭 해볼 시 현재 원격에 올라온 브랜치 목록을 확인할 수 있다.
```

![브랜치 목록 확인하기](./git_guide_assets/브랜치%20목록%20확인하기.JPG)

- develop 브랜치로 이동하기 `git checkout develop`

![develop 브랜치 이동하기](./git_guide_assets/develop%20브랜치%20이동하기.JPG)

```
checkout 명령어로 develop 브랜치로 이동 후
다시 git branch 명령어로 브랜치 목록을 조회하면
develop 브랜치가 있는 것을 확인할 수 있다 
```

### 3. 기능 브랜치 생성하기
```
* 반드시 현재 브랜치가 develop인 상태에서 진행할 것!

현재 브랜치 상태가 develop인 것을 확인했다면 이제 기능 브랜치를 생성해야한다.
```

- 기능 브랜치 생성하기 `git checkout -b feature/기능명-담당자닉네임`

```
먼저 우리 프로젝트의 기능 브랜치 생성 규칙은 다음과 같다

feature/개발할기능명-담당자닉네임

개발할 기능명 : ex) memberLogin-Taurus
```

![기능브랜치 생성](./git_guide_assets/기능브랜치%20생성.JPG)

```
위의 사진처럼 git checkout -b 기능브랜치명 명령어를 실행하면
해당 브랜치를 생성 후 해당 브랜치로 이동되는 것을 확인할 수 있다!
```
---

### **여기까지 했으면 이 상태에서 프로젝트 작업하기**

---
### 4. 변경사항 확인 후 추가하기
```
프로젝트를 작업하기 전과 후에 항상 해야할 것이 변경사항을 확인하는 것이다.
```

- `git status` 명령어로 변경 사항 확인하기!

![작업 후 변경사항 확인하기](./git_guide_assets/작업%20후%20변경사항%20확인하기.JPG)

```
작업 후 git status 명령어를 실행하면 위의 사진처럼
빨간 텍스트로 변경된 내용이 출력될 것이다.

* 추가로
modified : 수정된 파일
deleted : 삭제된 파일
```

- `git add .` 명령어로 변경 사항 모두 추가하기!

![변경사항 모두 add하기](./git_guide_assets/변경사항%20add%20하기.JPG)

```
* git add 이후 해야할 사항은 반드시 git status로 모두 반영되었는지 확인할 것!
```

### 5. 변경사항 로컬에 기록 하기

```
변경사항을 추가했다면 이제 로컬에 기록해야 한다.
```

- `git commit -m "커밋 메시지"` 명령어로 변경사항 기록 하기

![커밋하기](./git_guide_assets/커밋하기.JPG)

```
git add 명령어를 실행 후 잘 추가가 되었을 시 commit 명령어로 기록해야한다.

우리 프로젝트의 커밋메시지 규칙은 다음과 같다

git commit -m "작업내용 - 닉네임"

* 작업내용은 간단히 작성 : ex) 로그인 기능 구현, 회원가입 기능 구현
```

### 6. 변경 이력 원격저장소로 올리기
```
commit을 해서 기록했다고 원격 저장소에 반영되는 것은 아니다.
commit을 하면 로컬 저장소에 기록될 뿐이지 원격에는 반영되지 않는다.

원격 저장소에 반영하기 위해서는 다음을 진행해야한다.
```

- `git push origin 브랜치명`

![기능 브랜치 push 하기](./git_guide_assets/기능%20브랜치%20push%20하기.JPG) 

- Github 사이트에서 새로고침 후 본인이 push한 브랜치가 잘 올라왔는지 확인하기!
![push한 브랜치 github에서 확인하기](./git_guide_assets/push한%20브랜치%20github에서%20확인하기.JPG)
