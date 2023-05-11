<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 목록 페이지</h1>
	
	<table border="1" style="border-collapse: collapse;">
		<thead>
			<tr>
				<th>번호</th>
				<th>상품명</th>
				<th>등록일</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${list }" var="pvo">
				<tr>
					<td>${pvo.pno }</td>
					<td><a href="detail.pd?pno=${pvo.pno }">${pvo.pname }</a></td>
					<td>${pvo.regdate }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="register.pd"><button>상품 등록</button></a>
	<a href="index.jsp"><button>메인으로 이동</button></a>
</body>
</html>