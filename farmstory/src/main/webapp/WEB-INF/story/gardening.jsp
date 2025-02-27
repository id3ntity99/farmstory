<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/farmstory/style/index.css" />
    <link rel="stylesheet" href="/farmstory/style/common/header.css" />
    <link rel="stylesheet" href="/farmstory/story/style/gardening.css" />
    <title>팜스토리</title>
  </head>

  <body>
    <div id="wrapper">
      <%@ include file="./_header.jsp" %>

      <main class="shopping">
        <nav class="background">
          <div><img src="/farmstory/images/sub_top_bg.jpg" alt="메인배경" /></div>
          <div><img src="/farmstory/images/sub_top_tit3.png" alt="CropTalk" /></div>
        </nav>
        <aside>
          <a href="#">
            <img src="/farmstory/images/sub_aside_bg_line.png" alt="사이드선" />
          </a>
          <a href="#">
            <img src="/farmstory/images/sub_aside_cate3_tit.png" alt="농작물이야기" />
          </a>
          <a href="/farmstory/story/story.html">
            <img src="/farmstory/images/sub_cate3_lnb1.png" alt="농작물이야기" />
          </a>
          <a href="/farmstory/story/gardening.html">
            <img
              src="/farmstory/images/sub_cate3_lnb2_ov.png"
              alt="텃밭가꾸기"
              width="175px"
              height="29px"
            />
          </a>
          <a href="/farmstory/story/school.html">
            <img src="/farmstory/images/sub_cate3_lnb3.png" alt="귀농학교" />
          </a>
          <a href="#">
            <img src="/farmstory/images/sub_aside_bg_lnb.png" alt="사이드메뉴" />
          </a>
        </aside>
        <section>
          <div>
            <a href="#">
              <img
                src="/farmstory/images/sub_nav_tit_cate3_tit2.png"
                alt="농작물이야기"
              />
            </a>
            <span>텃밭가꾸기</span>
            <a href="#">HOME > 농작물이야기 > </a>
          </div>
          <article>
          	<section class="list">
          		<nav>
          			<h1>글목록</h1>
          			<form action="#">
          				<select name="searchType" style="padding: 6px;">
          					<option value="title">제목</option>
          					<option value="content">내용</option>
          					<option value="writer">글쓴이</option>
          				</select>
          				<input type="text" name="keyword" placeholder="검색 키워드 입력">
          				<input type="submit" value="검색">
          			</form>
          		</nav>
          	</section>
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
          </article>
        </section>
      </main>
      
	<%@ include file="./_footer.jsp" %>
	
    </div>
  </body>
</html>
