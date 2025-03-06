<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <title>장바구니</title>
    <link rel="stylesheet" href="/farmstory/style/find-id.css" />
    <link rel="stylesheet" href="/farmstory/style/common/header.css" />
    <link rel="stylesheet" href="/farmstory/style/common/footer.css" />
    <script>
    document.addEventListener('DOMContentLoaded', function(){
    	// 인증번호 받기 버튼 클릭 이벤트
        document.querySelector("#sendVerificationCodeBtn").addEventListener('click', function(event) {
            event.preventDefault();
            
            var userId = document.getElementById('id').value;
            var email = document.getElementById('email').value;

            // 아이디와 이메일 입력 확인
            if (!userId || !email) {
                alert("아이디와 이메일을 모두 입력해주세요.");
                return;
            }

            // 서버에 인증번호 요청
            fetch("/farmstory/findPass.do", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ id: userId, email: email })
            })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    alert("인증번호가 이메일로 전송되었습니다.");
                } else {
                    alert(data.message);
                }
            })
            .catch(error => {
                console.error("Error:", error);
                alert("서버와 연결할 수 없습니다. 나중에 다시 시도해주세요.");
            });
        });

        // 인증번호 확인 버튼 클릭 이벤트
        document.querySelector("#verifyCodeBtn").addEventListener('click', function(event) {
            event.preventDefault();

            var code = document.getElementById('number').value;

            fetch("/farmstory/verifyCode.do", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({ code: code })
            })
            .then(response => response.json())
            .then(data => {
                if (data.success) {
                    window.location.href = "/farmstory/find/changePass.do"; // 인증 성공 시 비밀번호 변경 페이지로 이동
                } else {
                    alert(data.message); // 인증 실패 시 메시지 출력
                }
            })
            .catch(error => {
                console.error("Error:", error);
                alert("서버와 연결할 수 없습니다. 나중에 다시 시도해주세요.");
            });
        });
    }
    </script>
    </head>
    <body>
        <div id="wrapper">
            <header>
                <section class="links">
                  <img src="/farmstory/images/head_top_line.png" alt="" />
                  <div>
                    <p>
                      <a href="/farmstory">HOME | </a>
                      <a href="/farmstory/signin.do">로그인 | </a>
                      <a href="/farmstory/signup.do">회원가입 | </a>
                      <a href="/farmstory/my/shopbasket.do">나의정보 | </a>
                      <a href="/farmstory/signout.do">로그아웃 | </a>
                      <a href="/farmstory/admin.do">관리자 | </a>
                      <a href="">고객센터</a>
                    </p>
                  </div>
                </section>
                <section class="logo">
                  <div>
                    <a href="#">
                      <img src="/farmstory/images/logo.png" />
                    </a>
                    <a href="#">
                      <img src="/farmstory/images/head_txt_img.png" />
                    </a>
                  </div>
                </section>
                <section class="services">
                  <article>
                    <div>
                      <a href="#"> </a>
                    </div>
                    <div>
                      <a href="#">
                        <img src="/farmstory/images/head_menu_badge.png" alt="30%" />
                      </a>
                    </div>
                    <div>
                      <a href="#"> </a>
                    </div>
                    <div>
                      <a href="#"> </a>
                    </div>
                    <div>
                      <a href="#"> </a>
                    </div>
                  </article>
                </section>
              </header>





            <main>
                <section class="idfind">
                    <h1>비밀번호 찾기</h1>
                    <table>
                        <tbody>
                            <tr>
                                <td>아이디</td>
                                <td>
                                    <input type="text" name="id" id="id" placeholder="아이디 입력">
                                </td>
                            </tr>
                            <tr>
                                <td>이메일</td>
                                <td>
                                    <input type="text" name="email" id="email" placeholder="이메일 입력"><br>
                                    <input type="text" name="number" id="number" placeholder="인증번호 입력"></td>
                                </td>
                                <td><a><button type="button" id="sendVerificationCodeBtn" style="none">인증번호 받기</button></a><br>
                                <a><button id="verifyCodeBtn">확인</button></a></td>
                        </tbody>
                    </table>
                    <section class="maintext">
                        <p>
                            비밀번호를 찾고자 하는 아이디와 이메일을 입력해 주세요.<br>
                            회원가입시 입력한 아이디와 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.<br>
                            인증번호를 입력 후 확인 버튼을 누르세요.
                        </p>
                    </section>
                    <section class="mainbtn">
                        <a href="/farmstory/user/signUp.do">취소</a>
                        <a href="/farmstory/find/findPass.do">다음</a>
                    </section>

                </section>
            </main>
<footer>
                <div>
                  <img src="/farmstory/images/footer_logo.png" alt="" />
                  <p>
                    (주)팜스토리 / 사업자등록번호 123-45-67890 / 통신판매업신고 제
                    2013-부산진구-123호 / 벤처기업확인 서울 지방중소기업청 제
                    012345678-9-01234호<br />
                    등록번호 팜스토리01234 (2013.04.01) / 발행인 : 홍길동 <br />
                    대표: 김철수 / 이메일 : abc123@example.com / 전화 : 01) 234-5678 /
                    부산광역시 부산진구 부전동 123 <br />
                    <span>copyright© 김철수 All rights reserved.</span>
                    <span>farmstory ver1.0.1</span>
                  </p>
                </div>
              </footer>



        </div>
        
    </body>
</html>