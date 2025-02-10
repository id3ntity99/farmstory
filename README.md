# 1. 사전 준비

1. Eclipse Formatter

- 아무 폴더에서 `git clone https://github.com/google/styleguide.git` 실행
- 이클립스 실행
- `Window - Preferences - Java - Code Style - Formatter`로 가서 `"Active Profile"` 밑의 `"Import"` 버튼 클릭
- 1)번에서 `git clone` 하였던 "styleguide" 디렉터리의 `"eclipse-java-google-style"` 클릭
- 오른쪽 하단의 `Apply` 버튼을 눌러 변경 사항 저장.
- 좌측 설정 선택 창에서 `Java - Editor - Save Action`에서 가장 위에 있는 `"Perform the selected actions on save"` 버튼을 눌러 체크.
- 우측 하단의 `Apply and close` 버튼을 눌러 변경 사항 저장 후 설정창 종료.
-

2. VS Code Formatter

- VS Code 실행
- 좌측 창에서 "확장" 선택
- Prettier Formatter 검색 후 설치
- 이후 HTML, CSS, Javascript 코드를 작성하고 저장하면 자동으로 코드가 포맷 됨.

포매터를 설정해주는 이유는, 개발자마다의 코드 포맷(서식)이 다르면 계속해서 `git status`를 찍을 때마다 add/commit 해줘야 하는 파일들이 늘어나기 때문이다.
git은 `commit`된 파일의 아주 사소한 변경 사항에도 반응한다.
예를 들어 맨 마지막 줄에 스페이스만 추가되어도 git은 해당 파일을 `git status`에 표시해준다.

하지만 포매터를 사용하면, 이클립스에서 코드를 작성한 저장할때마다 자동으로 코드 서식을 google-style로 포맷으로 바꿔준다. 따라서 모든 개발자의 코드 포맷이 동일해지고, `git status`에는 중요한 변경사항(메서드 이름 변경 등)만 찍히게 된다.

또한, 포매터를 사용하면 코드의 가독성이 올라가는 효과도 있다.

# 2. 브랜치 전략

브랜치 전략으로는 **Github Flow**를 사용한다. 주 브랜치로 `master`브랜치를 사용하고 팀원들은 로컬 저장소에서 `feature/팀원아이디` 브랜치를 생성한다.
코드를 변경할 때에는 **반드시** `feature/팀원아이디` 브랜치를 이용하고, 모든 변경이 끝나면 이를 `push`하고 `merge` 한다.
