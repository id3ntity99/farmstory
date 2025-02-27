<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
            <main>
                <section class="idfind">
                    <h1>비밀번호 변경</h1>
                    <table>
                        <tbody>
                            <tr>
                                <td>아이디</td>
                                <td>honggildong</td>
                            </tr>
                            <tr>
                                <td>새 비밀번호</td>
                                <td><input type="password" name="newpass" placeholder="새 비밀번호 입력"></td>
                            </tr>
                            <tr>
                                <td>새 비밀번호 확인</td>
                                <td><input type="password" name="newpassok" placeholder="새 비밀번호 입력"></td>
                            </tr>
                            
                        </tbody>
                    </table>
                    <section class="maintext">
                        <p>
                            비밀번호를 변경해 주세요.<br>
                            영문, 숫자, 특수문자를 사용하여 8자 이상 입력해 주세요.
                        </p>
                    </section>
                    <section class="mainbtn">
                        <a href="#">취소</a>
                        <a href="#">다음</a>
                    </section>

                </section>
            </main>
            <%@ include file="./_footer.jsp" %>