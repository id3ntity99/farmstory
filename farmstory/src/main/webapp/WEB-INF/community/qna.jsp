<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>1:1 고객문의</title>
    <link rel="stylesheet" href="/farmstory/style/common/header.css" />
    <link rel="stylesheet" href="/farmstory/style/common/footer.css" />
    <link rel="stylesheet" href="/farmstory/style/common/page-common.css" />
    <link rel="stylesheet" href="/farmstory/style/qna.css" />
  </head>
  <body>
    <div id="wrapper">
      <header>
        <section class="links">
          <img src="/farmstory/images/head_top_line.png" alt="" />
          <div>
            <p>
              <a href="">HOME | </a>
              <a href="">로그인 | </a>
              <a href="">회원가입 | </a>
              <a href="">나의정보 | </a>
              <a href="">로그아웃 | </a>
              <a href="">관리자 | </a>
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
        <section class="page-banner">
          <div>
            <img src="/farmstory/images/sub_top_bg.jpg" alt="" />
            <img src="/farmstory/images/sub_top_tit5.png" alt="" />
          </div>
        </section>
        <section class="container">
          <article>
            <aside class="side-menu">
              <div class="side-title">
                <img src="/farmstory/images/sub_aside_cate5_tit.png" alt="" />
              </div>
              <div class="side-content">
                <a href="#"> </a>
                <a href="#"> </a>
                <a href="#"> </a>
                <a href="#"> </a>
                <a href="#"> </a>
              </div>
              <img src="/farmstory/images/sub_aside_bg_line.png" class="line" />
            </aside>
            <div class="content-area">
              <div class="content-title">
                <img src="/farmstory/images/sub_nav_tit_cate5_tit4.png" alt="" />
                <span>
                  <a href="#">HOME </a>
                  <a href="#">> 커뮤니티 > </a>
                  <a href="#">1:1고객문의 </a>
                </span>
              </div>
              <div class="content">
                <h3>글수정</h3>
                <form action="https://naver.com" method="POST">
                  <table>
                    <tbody>
                      <tr>
                        <td>제목</td>
                        <td>
                          <input
                            type="text"
                            name="qna-title"
                            placeholder="제목을 입력하세요"
                            id="qna-title"
                          />
                        </td>
                      </tr>
                      <tr>
                        <td>내용</td>
                        <td>
                          <textarea
                            id="qna-content"
                            name="qna-content"
                          ></textarea>
                        </td>
                      </tr>
                      <tr class="file-area">
                        <td>파일</td>
                        <td>
                          <p>
                            최대 2개 파일 첨부 가능, 각 파일당 최대 10MB까지
                            가능
                          </p>
                          <div>
                            <input type="file" />
                          </div>
                          <div>
                            <input type="file" />
                          </div>
                        </td>
                      </tr>
                    </tbody>
                  </table>
                  <input type="submit" value="수정완료" class="btn" />
                  <button class="btn">
                    <a href="#"> 취소 </a>
                  </button>
                </form>
              </div>
            </div>
          </article>
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
          </p>
        </div>
      </footer>
    </div>
  </body>
</html>
