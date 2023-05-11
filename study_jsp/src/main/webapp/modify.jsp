<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>상품 수정 페이지</h1>
	
	<form action="edit.pd?pno=${pvo.pno }" method="post">
		<table border="1" style="border-collapse: collapse;">
			<tbody>
				<tr>
					<td>번호</td>
					<td><input type="text" name="pno" value="${pvo.pno }" disabled="disabled"></td>
				</tr>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="pname" value="${pvo.pname }"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name="price" value="${pvo.price }"></td>
				</tr>
				<tr>
					<td>등록일자</td>
					<td><input type="text" name="regdate" value="${pvo.regdate }" disabled="disabled"></td>
				</tr>
				<tr>
					<td>세부내용</td>
					<td><input type="text" name="madeby" value="${pvo.madeby }"></td>
				</tr>
			</tbody>
		</table>
		<button type="submit">수정 완료</button>
	</form>
</body>
</html>