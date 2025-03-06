<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>어드민 - 상품목록</title>
	<link rel="stylesheet" href="/farmstory/style/admin.css">
</head>
<body>
	<div id="container">
		<%@ include file="./_header.jsp"%>
		<main>
			<aside id="manu">
				<h3>주요기능</h3>
				<ul>
					<li><span>상품관리</span>
						<ol>
							<li><a href="/farmstory/admin/product-list.do">상품목록</a></li>
							<li><a href="/farmstory/admin/product-enroll.do">상품등록</a></li>
						</ol></li>
					<li><span>주문관리</span>
						<ol>
							<li><a href="/farmstory/admin/order-list.do">주문목록</a></li>
						</ol></li>
					<li><span>회원관리</span>
						<ol>
							<li><a href="/farmstory/admin/user-list.do">회원목록</a></li>
							<li><a href="#">회원등록</a></li>
						</ol></li>
				</ul>
			</aside>

			<section id="productList">
				<nav>
					<h3>상품목록</h3>
				</nav>
				<article>
					<table border="0">
						<tr>
							<th><input type="checkbox" name="check" id="checkbox"></th>
							<th>사진</th>
							<th>상품번호</th>
							<th>상품명</th>
							<th>구분</th>
							<th>가격</th>
							<th>재고</th>
							<th>등록일</th>
						</tr>
						<tr>
							<th><input type="checkbox" name="check" id="checkbox"></th>
							<th><img src="/farmstory/images/market_item1.jpg"
								class="thumb" alt="사과"></th>
							<th>1011</th>
							<th>사과 500g</th>
							<th>과일</th>
							<th>4,000원</th>
							<th>100</th>
							<th>2023-01-01</th>
						</tr>
					</table>


					<p>
						선택 삭제 <a href="/farmstory/admin/product-enroll.do"
							class="productRegister">상품등록</a>
					</p>
					<p>&lt; [1] [2] [3] [4] [5] &gt;</p>
				</article>
			</section>
		</main>
		<%@ include file="./_footer.jsp"%>

	</div>
</body>
</html>