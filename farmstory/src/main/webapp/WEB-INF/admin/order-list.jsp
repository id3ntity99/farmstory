<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>어드민 - 주문목록</title>
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

            <section id="orderList">
                <nav>
                    <h3>주문목록</h3>
                </nav>
                <article>
                    <table border="0">
                        <tr>
                            <th><input type="checkbox" name="check" id="checkbox"></th>
                            <th>주문번호</th>
                            <th>상품명</th>
                            <th>판매가격</th>
                            <th>수량</th>
                            <th>배송비</th>
                            <th>합계</th>
                            <th>주문자</th>
                            <th>주문일</th>
                            <th>확인</th>
                        </tr>
                        <tr>
                            <th> <input type="checkbox" name="check" id="checkbox"></th>
                            <th>1001</th>
                            <th>사과 500g</th>
                            <th>4,000원</th>
                            <th>2</th>
                            <th>3,000원</th>
                            <th>11,000원</th>
                            <th>김유신</th>
                            <th>2023-01-01 13:06:14</th>
                            <th>[상세확인]</th>
                        </tr>
                    </table>
                    <p>선택 삭제</p>
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