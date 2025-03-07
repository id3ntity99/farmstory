<%@page import="farmstory.dto.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%
	ArrayList products = (ArrayList<ProductDTO>) request.getAttribute("products");
	pageContext.setAttribute("products", products);
%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>상품목록</title>
    <link rel="stylesheet" href="/farmstory/style/common/header.css" />
    <link rel="stylesheet" href="/farmstory/style/common/footer.css" />
    <link rel="stylesheet" href="/farmstory/style/common/page-common.css" />
    <link rel="stylesheet" href="/farmstory/style/list.css" />
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
            <img src="/farmstory/images/sub_top_tit2.png" alt="" />
          </div>
        </section>
        <section class="container">
          <article>
            <aside class="side-menu">
              <div class="side-title">
                <img src="/farmstory/images/sub_aside_cate2_tit.png" alt="" />
              </div>
              <div class="side-content">
                <a href="#"> </a>
              </div>
              <img src="/farmstory/images/sub_aside_bg_line.png" class="line" />
            </aside>
            <div class="content-area">
              <div class="content-title">
                <img src="/farmstory/images/sub_nav_tit_cate2_tit1.png" alt="" />
                <span>
                  <a href="#">HOME </a>
                  <a href="#">> 장보기 > </a>
                  <a href="#">장보기 </a>
                </span>
              </div>
              <div class="content">
                <span>
                  <a href="#">전체(10) |</a>
                  <a href="#"> 과일 |</a>
                  <a href="#"> 야채 |</a>
                  <a href="#"> 곡류 </a>
                </span>
                <table>
                  <tbody>
                    <tr>
                      <th>이미지</th>
                      <th>종류</th>
                      <th>상품명</th>
                      <th>할인</th>
                      <th>포인트</th>
                      <th>판매가격</th>
                    </tr>
                    <c:forEach var="product" items="${requestScope.products}">
                    <tr>
                      <td>
                        <img src="${pageContext.request.contextPath}${product.image.thumbnailLocation}" alt="" />
                      </td>
                      <td>${product.category}</td>
                      <td><a href="/farmstory/product.do?pid=${product.id}">${product.name}</a></td>
                      <td>${product.discountRate}</td>
                      <td>${product.point}</td>
                      <td>
                        <span>${product.price - (product.price * (product.discountRate / 100))}</span>
                        <span><u>${product.price}</u></span>
                      </td>
                    </tr>
                    </c:forEach>
                  </tbody>
                </table>
                <span>
                  <a href="#">< </a>
                  <a href="#">[1]</a>
                  <a href="#">[2]</a>
                  <a href="#">[3]</a>
                  <a href="#">[4]</a>
                  <a href="#">[5]</a>
                  <a href="#"> ></a>
                </span>
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
