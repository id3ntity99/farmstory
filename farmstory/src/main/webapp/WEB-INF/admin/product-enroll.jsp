<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>어드민 - 상품등록</title>
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
            <section id="productRegister">
            <nav>
                <h3>상품목록</h3>
            </nav>
            <article>
                <form action="#" method="post">
                    <table border="0">
                        <tr>
                            <td>상품명</td>
                            <td><input type="text" name="prodName"/></td>
                        </tr>
                        <tr>
                            <td>종류</td>
                            <td>
                                <select name="cateNo">
                                    <option>종류</option>
                                    <option>과일</option>
                                    <option>야채</option>
                                    <option>곡류</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>가격</td>
                            <td><input type="text" name="prodPrice" id="price"/></td>
                        </tr>
                        <tr>
                            <td>포인트</td>
                            <td>
                                <input type="text" name="point" id="point"/>
                                포인트는 가격의 1%
                            </td>
                        </tr>
                        <tr>
                            <td>할인</td>
                            <td>
                                <select name="prodDiscount">
                                    <option>  5%  </option>
                                    <option>  12%  </option>
                                    <option>  15%  </option>
                                    <option>  18%  </option>
                                    <option>  20%  </option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>배송비</td>
                            <td>
                                <label><input type="radio" name="delivery">2,000원</label>
                                <label><input type="radio" name="delivery">3,000원</label>
                                <label><input type="radio" name="delivery">5,000원</label>
                                <label><input type="radio" name="delivery">무료</label>
                            </td>
                        </tr>
                        <tr>
                            <td>재고</td>
                            <td><input type="text" name="prodStock"/></td>
                        </tr>
                        <tr>
                            <td>상품이미지</td>
                            <td>
                                <p>
                                    <span>상품목록 이미지(약 120 x 120)</span>
                                    <input type="file" name="multImage1"/>
                                </p>
                                <p>
                                    <span>기본정보 이미지(약 240 x 240)</span>
                                    <input type="file" name="multImage2"/>
                                </p>
                                <p>
                                    <span>상품설명 이미지(약 750 x Auto)</span>
                                    <input type="file" name="multImage3"/>
                                </p>
                            </td>
                        </tr>
                        <tr>
                            <td>기타</td>
                            <td>
                                <textarea name="etc"></textarea>
                            </td>
                        </tr>
                    </table>
                <p>
                    <a href="/farmstory/admin/product-list.html" class="btnCancel">취소</a>
                    <input type="submit" id="btnSubmit" value="상품등록"/>
                </p>
            </form>

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