<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
			<main> 
                <section class="background">
                    <a href="#"><img src="/farmstory/images/myinfo/myinfo_top_bg.jpg" alt="banner"></a>
                    <a href="#"><img src="/farmstory/images/myinfo/myinfo_top_tit.png " alt="background"></a>
                </section>
                <section class="side">
                    <h1><img src="/farmstory/images/myinfo/myinfo_menu_tit.png" alt=""></h1>
                        <article>    
                            <ul>
                                <li><a href="/farmstory/my/shopbasket.html"><img src="/farmstory/images/myinfo/myinfo_menu1.png" alt="장바구니"></a></li>
                                <li><a href="/farmstory/my/order-list.html"><img src="/farmstory/images/myinfo/myinfo_menu2.png" alt="주문내역"></a></li>
                                <li><a href="/farmstory/my/modify-info.html"><img src="/farmstory/images/myinfo/myinfo_menu3.png" alt="정보수정"></a></li>
                            </ul>
                        </article>
                </section>

                <section class="basket">
                    <nav>
                        <h1><a href="#"><img src="/farmstory/images/myinfo/myinfo_nav_tit1.png" alt="장바구니"></a></h1>
                        <p>장바구니</p>
                        <p>= HOME>나의정보></p>
                    </nav>
                </section>

                <section class="whole">
                    <h1>장바구니 전체(10)</h1>
                    <table>
                        <tbody>
                            <tr>
                                <th><input type="checkbox"></th>
                                <th>이미지</th>
                                <th>종류</th>
                                <th>상품명</th>
                                <th>수량</th>
                                <th>할인</th>
                                <th>포인트</th>
                                <th>가격</th>
                                <th>소계</th>
                            </tr>
                            <tr>
                                <td>장바구니에 상품이 없습니다.</td>
                            </tr>
                            <tr>
                                <th><input type="checkbox"></th>
                                <td><img src="/farmstory/images/market_item1.jpg" alt="사과"></td>
                                <td>과일</td>
                                <td>사과 500g</td>
                                <td>1</td>
                                <td>10%</td>
                                <td>40p</td>
                                <td>4,000</td>
                                <td>3,600원</td>
                            </tr>
                            <tr>
                                <th><input type="checkbox"></th>
                                <td><img src="/farmstory/images/market_item1.jpg" alt="사과"></td>
                                <td>과일</td>
                                <td>사과 500g</td>
                                <td>1</td>
                                <td>10%</td>
                                <td>40p</td>
                                <td>4,000</td>
                                <td>3,600원</td>
                            </tr>
                            <tr>
                                <th><input type="checkbox"></th>
                                <td><img src="/farmstory/images/market_item1.jpg" alt="사과"></td>
                                <td>과일</td>
                                <td>사과 500g</td>
                                <td>1</td>
                                <td>10%</td>
                                <td>40p</td>
                                <td>4,000</td>
                                <td>3,600원</td>
                            </tr>
                        </tbody>
                    </table>
                    <a href="#">선택삭제</a>
                </section>

                <section class="total">
                    <h3>전체합계</h3>
                    <table>
                        <tbody>
                            <tr>
                                <td>상품수</td>
                                <td>1</td>
                            </tr>
                            <tr>
                                <td>상품금액</td>
                                <td>27,000</td>
                            </tr>
                            <tr>
                                <td>할인금액</td>
                                <td>50,000</td>
                            </tr>
                            <tr>
                                <td>배송비</td>
                                <td>50,000</td>
                            </tr>
                            <tr>
                                <td>포인트</td>
                                <td>4,000</td>
                            </tr>
                            <tr>
                                <td>전체주문금액</td>
                                <td>22,000</td>
                            </tr>
                        </tbody>
                    </table>
                    <a href="#">주문하기</a>
                </section>
            </main>
<%@ include file="./_footer.jsp" %>