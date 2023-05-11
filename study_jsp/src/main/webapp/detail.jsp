<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 상세 페이지</h1>
	
	<table border="1" style="border-collapse: collapse;">
		<tbody>
			<tr>
				<td>번호</td>
				<td>${pvo.pno }</td>
			</tr>
			<tr>
				<td>상품명</td>
				<td>${pvo.pname }</td>
			</tr>
			<tr>
				<td>가격</td>
				<td>${pvo.price }</td>
			</tr>
			<tr>
				<td>등록일자</td>
				<td>${pvo.regdate}</td>
			</tr>
			<tr>
				<td>세부내용</td>
				<td>${pvo.madeby }</td>
			</tr>
		</tbody>
	</table>
	
	<a href="modify.pd?pno=${pvo.pno }"><button>수정</button></a>	
	<a href="remove.pd?pno=${pvo.pno }"><button>삭제</button></a>
	<a href="list.pd"><button>목록 페이지로 이동</button></a>
</body>
</html>