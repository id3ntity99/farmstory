<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
            <main>
                <section class="idfind">
                    <h1>아이디 찾기 결과</h1>
                    <table>
                        <tbody>
                            <tr>
                                <td>이름</td>
                                <td>홍길동</td>
                            </tr>
                            <tr>
                                <td>아이디</td>
                                <td>honggildong</td>
                            </tr>
                            <tr>
                                <td>이메일</td>
                                <td>honggildong@gmail.com</td>
                            </tr>
                            <tr>
                                <td>가입일</td>
                                <td>2022-11-16 10:20</td>
                            </tr>
                        </tbody>
                    </table>
                    <section class="maintext">
                        <p>
                            고객님의 정보와 일치하는 아이디 입니다.
                        </p>
                    </section>
                    <section class="mainbtn">
                        <a href="#">로그인</a>
                        <a href="/farmstory/find/find-pass.html">비밀번호 찾기</a>
                    </section>

                </section>
            </main>
            <%@ include file="./_footer.jsp" %>