<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/farmstory/style/index.css" />
    <link rel="stylesheet" href="/farmstory/style/common/header.css" />
    <link rel="stylesheet" href="/farmstory/style/gardening.css" />
    <title>팜스토리</title>
    <style></style>
  </head>

  <body>
    <div id="wrapper">
      <header>
        <section class="links">
          <div>
            <p>
              <a href="/farmstory/index.jsp">HOME | </a>
              <a href="/farmstory/user/login.jsp">로그인 | </a>
              <a href="/farmstory/user/register.jsp">회원가입 | </a>
              <a href="/farmstory/community/qna.jsp">고객센터</a>
            </p>
          </div>
        </section>
        <section class="logo">
          <div>
            <a href="#">
              <img src="/farmstory/images/logo.png" alt="로고" />
            </a>
            <a href="#">
              <img src="/farmstory/images/head_txt_img.png" />
            </a>
          </div>
        </section>
        <section class="services">
          <article>
            <div>
              <a href="/farmstory/intro/greeting.jsp">
                <img src="/farmstory/images/head_menu1.png" alt="팜스토리소개" />
              </a>
            </div>
            <div>
              <a href="/farmstory/shopping/list.jsp">
                <img src="/farmstory/images/head_menu_badge.png" alt="30%" />
                <img src="/farmstory/images/head_menu2.png" alt="장보기" />
              </a>
            </div>
            <div>
              <a href="/farmstory/listStory">
                <img src="/farmstory/images/head_menu3.png" alt="농작물이야기" />
              </a>
            </div>
            <div>
              <a href="/farmstory/event/event-calendar.jsp">
                <img src="/farmstory/images/head_menu4.png" alt="이벤트" />
              </a>
            </div>
            <div>
              <a href="/farmstory/community/notice.jsp">
                <img src="/farmstory/images/head_menu5.png" alt="커뮤니티" />
              </a>
            </div>
          </article>
        </section>
      </header>

      <main class="shopping">
        <nav class="background">
          <div class="subtop"><img src="/farmstory/images/sub_top_bg.jpg" alt="메인배경" /></div>
          <div class="croptalk"><img src="/farmstory/images/sub_top_tit3.png" alt="CropTalk" /></div>
        </nav>
        <aside>
          <a href="#">
            <img src="/farmstory/images/sub_aside_bg_line.png" alt="사이드선" />
          </a>
          <a href="#">
            <img src="/farmstory/images/sub_aside_cate3_tit.png" alt="농작물이야기" />
          </a>
          <a href="/farmstory/listStory">
            <img src="/farmstory/images/sub_cate3_lnb1.png" alt="농작물이야기" />
          </a>
          <a href="/farmstory/listGardening">
            <img
              src="/farmstory/images/sub_cate3_lnb2_ov.png"
              alt="텃밭가꾸기"
              width="175px"
              height="29px"
            />
          </a>
          <a href="/farmstory/listSchool">
            <img src="/farmstory/images/sub_cate3_lnb3.png" alt="귀농학교" />
          </a>
          <a href="#">
            <img src="/farmstory/images/sub_aside_bg_lnb.png" alt="사이드메뉴" />
          </a>
        </aside>
        <section>
          <div class="sub">
            <a href="#">
              <img
              	class="subnav"
                src="/farmstory/images/sub_nav_tit_cate3_tit2.png"
                alt="텃밭가꾸기"
              />
            </a>
            <span>텃밭가꾸기</span>
            <a href="#">HOME > 농작물이야기 > </a>
          </div>
          <div class="list">
            <nav>
              <h1>글목록</h1>
               	<form action="/farmstory/article/search.do">
                  	<select name="searchType">
                    	<option value="title">제목</option>
                    	<option value="content">내용</option>
                    	<option value="writer">글쓴이</option>
                   	</select>
                    <input type="text" name="keyword" placeholder="검색 키워드 입력">
                    <input type="submit" value="검색">
                </form>
             </nav>
             <table border="0">                    
             <tr>
                <th>번호</th>
                <th>제목</th>
                <th>글쓴이</th>
                <th>날짜</th>
                <th>조회</th>
             </tr>     
             <c:forEach var="article" items="${requestScope.articles}">               
	         <tr>
	            <td>${pageStartNum}</td>
	            <td><a href="/farmstory/article/view.do?no=${article.no}">${article.title}[${article.comment}]</a></td>
	            <td>${article.nick}</td>
	            <td>${article.wdate.substring(0,10)}</td>
	            <td>${article.hit}</td>
	       	 </tr>
	       		<c:set var="pageStartNum" value="${pageStartNum - 1}" />
            </c:forEach>
          	</table>
          	<div class="page">
              	<c:if test="${pageGroupDTO.start >1}">
                  	<a href="/farmstory/article/list.do?pg=${pageGroupDTO.start - 1}" class="prev">이전</a>
                </c:if>
                <c:forEach var="num" begin="${pageGroupDTO.start}" end="${pageGroupDTO.end}">
                   	<a href="/farmstory/article/list.do?pg=${num}" class="num ${currentPage == num ? 'current':''}">${num}</a>
                </c:forEach>
             	<c:if test="${pageGroupDTO.end < lastPageNum}">
                  	<a href="/farmstory/article/list.do?pg=${pageGroupDTO.end + 1}" class="next">다음</a>
               	</c:if>
            </div>

                <a href="/farmstory/article/write.do" class="btn btnWrite">글쓰기</a>
          </div>
        </section>
      </main>

      <footer>
        <a href="#">
          <img src="/farmstory/images/footer_top_line.png" alt="" /><br />
          <img src="/farmstory/images/footer_logo.png" alt="푸터로고" />
          <p>
            (주)팜스토리 / 사업자등록번호 123-45-67890 / 통신판매업신고 제
            2013-팜스토리구-123호 / 벤처기업 확인 서울지방중소기업청 제
            012345678-9-01234호<br />
            등록번호 팜스토리01234 (2013.04.01)/발행인 : 홍길동<br />
            대표 : 홍길동 / 이메일 : email@mail.mail / 전화 : 01)234-5678 /
            경기도 성남시 잘한다구 신난다동 345<br />
            <span>Copyright(C)홍길동 All right reserved.</span>
          </p>
        </a>
      </footer>
    </div>
  </body>
</html>
