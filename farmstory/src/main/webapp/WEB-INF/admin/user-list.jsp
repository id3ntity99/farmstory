<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>어드민 - 회원목록</title>
    <link rel="stylesheet" href="/farmstory/style/admin.css">
</head>
<body>
    <div id="container">
        <header>
                <a href="/farmstory/admin/main.html">
                <img src="/farmstory/images/admin/admin_logo.jpg" alt="logo">
            </a>
            <p>
                <a href="/farmstory/admin/main.html">HOME |</a>
                <a href="#">로그아웃 |</a>
                <a href="#">고객센터</a>
            </p>
        </header>

        <main>
            <aside id="manu">
                <h3>주요기능</h3>
                <ul>
                  <li>
                    <span>상품관리</span>
                    <ol>
                      <li><a href="/farmstory/admin/product-list.html">상품목록</a></li>
                      <li><a href="/farmstory/admin/product-enroll.html">상품등록</a></li>
                    </ol>
                  </li>
                  <li>
                    <span>주문관리</span>
                    <ol>
                      <li><a href="/farmstory/admin/order-list.html">주문목록</a></li>
                    </ol>
                  </li>
                  <li>
                    <span>회원관리</span>
                    <ol>
                      <li><a href="/farmstory/admin/user-list.html">회원목록</a></li>
                      <li><a href="#">회원등록</a></li>
                    </ol>
                  </li>
                </ul>
              </aside>

            <section id="userList">
                <nav>
                    <h3>회원목록</h3>
                </nav>
                <article>
                    <table border="0">
                        <tr>
                            <th><input type="checkbox" name="check" id="checkbox"></th>
                            <th>아이디</th>
                            <th>이름</th>
                            <th>별명</th>
                            <th>이메일</th>
                            <th>휴대폰</th>
                            <th>등급</th>
                            <th>가입일</th>
                            <th>확인</th>
                        </tr>
                        <tr>
                            <th><input type="checkbox" name="check" id="checkbox"></th>
                            <th>a101</th>
                            <th>김유신</th>
                            <th>유신101</th>
                            <th>yusin101@naver.com</th>
                            <th>010-1234-1001</th>
                            <th><textarea name="" id="" cols="2" rows="1" placeholder="2" readonly></textarea></th>
                            <th>2023-01-01 13:06:14</th>
                            <th>[상세확인]</th>
                        </tr>
                        <tr>
                            <th><input type="checkbox" name="check" id="checkbox"></th>
                            <th>a102</th>
                            <th>김춘추</th>
                            <th>춘추102</th>
                            <th>chunchu102@naver.com</th>
                            <th>010-1234-1002</th>
                            <th><textarea name="" id="" cols="2" rows="1" placeholder="2" readonly></textarea></th>
                            <th>2023-01-02 13:06:14</th>
                            <th>[상세확인]</th>
                        </tr>
                        <tr>
                            <th> <input type="checkbox" name="check" id="checkbox"></th>
                            <th>a103</th>
                            <th>장보고</th>
                            <th>보고103</th>
                            <th>bogo103@naver.com</th>
                            <th>010-1234-1003</th>
                            <th><textarea name="" id="" cols="2" rows="1" placeholder="2" readonly></textarea></th>
                            <th>2023-01-03 13:06:14</th>
                            <th>[상세확인]</th>
                        </tr>
                    </table>
                    <p> &lt; [1] [2] [3] [4] [5] &gt;</p>
                </article>
            </section>
        </main>

         <footer>
            <p> FARMSTORY ADMINISTRATOR Varsion 1.0.1
            <span>Copyright(C)김철학(개발에 반하다.) All rights reserved.</span>
            </p>
        </footer>

    </div>
</body>
</html>