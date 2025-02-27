<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="/farmstory/style/index.css" />
    <link rel="stylesheet" href="/farmstory/style/common/header.css" />
    <link rel="stylesheet" href="/farmstory/story/style/story.css" />
    <title>팜스토리</title>
    <style></style>
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
            <img src="/images/sub_cate3_lnb1_ov.png" alt="농작물이야기" />
          </a>
          <a href="/farmstory/story/gardening.html">
            <img src="/images/sub_cate3_lnb2.png" alt="텃밭가꾸기" />
          </a>
          <a href="/farmstory/story/school.html">
            <img
              src="/farmstory/images/sub_cate3_lnb3.png"
              alt="귀농학교"
              width="175px"
              height="29px"
            />
          </a>
          <a href="#">
            <img src="/farmstory/images/sub_aside_bg_lnb.png" alt="사이드메뉴" />
          </a>
        </aside>
        <section>
          <div>
            <a href="#">
              <img
                src="/farmstory/images/sub_nav_tit_cate3_tit1.png"
                alt="농작물이야기"
              />
            </a>
            <span>농작물이야기</span>
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
				<tr>
					<td>1</td>
					<td>title</td>
					<td>writer</td>
					<td>2025.02.27</td>
					<td>0</td>
				</tr>
			</table>
			<div class="page">
			</div>
          </article>
        </section>
      </main>
      
	<%@ include file="./_footer.jsp" %>
	
    </div>
  </body>
</html>
