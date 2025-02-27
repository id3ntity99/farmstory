<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="./_header.jsp" %>
            <main>
                <section class="idfind">
                    <h1>아이디 찾기</h1>
                    <table>
                        <tbody>
                            <tr>
                                <td>이름</td>
                                <td>
                                    <input type="text" name="name" placeholder="이름 입력">
                                </td>
                            </tr>
                            <tr>
                                <td>이메일</td>
                                <td>
                                    <input type="text" name="email" placeholder="이메일 입력"><br>
                                    <input type="number" name="number" placeholder="인증번호 입력"></td>
                                </td>
                                <td><a href="#">인증번호 받기</a><br>
                                <a href="#">확인</a></td>
                        </tbody>
                    </table>
                    <section class="maintext">
                        <p>
                            회원가입시 이메일 주소와 입력한 이메일 주소가 같아야, 인증번호를 받을 수 있습니다.<br>
                            인증번호를 입력 후 확인 버튼을 누르세요.
                        </p>
                    </section>
                    <section class="mainbtn">
                        <a href="#">취소</a>
                        <a href="#">다음</a>
                    </section>

                </section>
            </main>
            <%@ include file="./_footer.jsp" %>