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

                <section class="order">
                    <nav>
                        <h1><a href="#"><img src="/farmstory/images/myinfo/myinfo_nav_tit2.png" alt="장바구니"></a></h1>
                        <p>주문내역</p>
                        <p>= HOME>나의정보></p>
                    </nav>
                </section>

                <section class="whole">
                    <table>
                        <tbody>
                            <tr>
                                <th>주문번호</th>
                                <th>이미지</th>
                                <th>상품명</th>
                                <th>판매가격</th>
                                <th>수량</th>
                                <th>합계</th>
                                <th>주문자</th>
                                <th>주문일</th>
                                <th>확인</th>
                            </tr>
                            <tr>
                                <td>상품 구매 내역이 없습니다.</td>
                            </tr>
                            <tr>
                                <th>1001</th>
                                <td><img src="/farmstory/images/market_item1.jpg" alt="사과"></td>
                                <td>사과<br>500g</td>
                                <td>4,000<br>원</td>
                                <td>2</td>
                                <td>11,000<br>원</td>
                                <td>김유신</td>
                                <td>2023-01-01 13:06:14</td>
                                <td>[상세확인]</td>
                            </tr> 
                        </tbody>
                    </table>
                </section>
                <section class="page">
                    <a href="#">이전</a>
                    <a href="#">1</a>
                    <a href="#">2</a>
                    <a href="#">3</a>
                    <a href="#">다음</a>

                </section>  
            </main>
<%@ include file="./_footer.jsp" %>