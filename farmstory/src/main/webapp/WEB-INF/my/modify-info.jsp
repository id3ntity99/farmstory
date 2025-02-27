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
                        <h1><a href="#"><img src="/farmstory/images/myinfo/myinfo_nav_tit3.png" alt="정보수정"></a></h1>
                        <p>정보수정</p>
                        <p>= HOME>나의정보></p>
                    </nav>
                </section>
                
                <section class="setup">
                    <h1>회원정보 설정</h1>
                    <table>
                        <tbody>
                            <tr>
                                <td>아이디</td>
                                <td>wnstj050505</td>
                            </tr>
                            <tr class="pass">
                                <td>비밀번호</td>
                                <td><input type="password" name="pass" placeholder="비밀번호 입력"></td>
                            </tr>
                            <tr class="passacc">
                                <td>비밀번호 확인</td>
                                <td><input type="password" name="passok" placeholder="비밀번호 입력 확인"></td>
                                <td><a href="#">비밀번호 수정</a></td>
                            </tr>
                            <tr>
                                <td>회원가입날짜</td>
                                <td>2022-01-01 12:45:12</td>
                            </tr>
                        </tbody>
                    </table>
                </section>

                <section class="modify">
                    <h1>개인정보 수정</h1>
                    <table>
                        <tr>
                            <td>이름</td>
                            <td><input type="text" name="name"></td>
                        </tr>
                        <tr class="nickname">
                            <td>별명</td>
                            <td>
                                공백없는 한글, 영문, 숫자 입력<br>
                                <input type="text" name="nickname" placeholder="별명 입력">
                            </td>
                            <td><a href="#"><img src="/farmstory/images/user/chk_id.gif" alt=""></a></td>
                        </tr>
                        <tr>
                            <td>이메일</td>
                            <td>
                                <input type="text" name="email" placeholder="이메일 입력">
                            </td>
                            <td><a href="#"><img src="/farmstory/images/user/chk_auth.gif" alt=""></a></td>
                        </tr>
                        <tr>
                            <td>휴대폰</td>
                            <td><input type="text" name="phone" placeholder="휴대폰 입력"></td>
                        </tr>
                        <tr>
                            <td>주소</td>
                            <td>
                                <input type="text" name="mail" placeholder="우편번호"><br>
                                <input type="text" name="address" placeholder="주소 검색" class="line23"><br>
                                <input type="text" name="detailadd" placeholder="상세주소 입력" class="line23">
                            </td>
                            <td><a href="#"><img src="/farmstory/images/user/chk_post.gif" alt=""></a></td>
                        </tr>
                        <tr>
                            <td>회원탈퇴</td>
                            <td><a href="#">탈퇴하기</a></td>
                        </tr>
                    </table>
                    <div class="button">
                        <a href="#">취소</a>
                        <a href="#">회원수정</a>
                    </article>
                </section>

                

                

                
            </main>
<%@ include file="./_footer.jsp" %>