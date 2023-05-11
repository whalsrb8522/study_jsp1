<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 등록 페이지</title>
</head>
<body>
	<h1>상품 등록 페이지</h1>
	
	<form action="insert.pd" method="post">
		<table border="1" style="border-collapse: collapse;">
			<tbody>
				<tr>
					<td>상품명</td>
					<td><input type="text" name="pname"></td>
				</tr>
				<tr>
					<td>가격</td>
					<td><input type="text" name ="price"></td>
				</tr>
				<tr>
					<td>세부정보</td>
					<td><input type="text" name ="madeby"></td>
				</tr>
			</tbody>
		</table>
	
		<button type="submit">전송</button>
		<a href="index.jsp"><button type="button">메인으로 이동</button></a>
	</form> 
</body>
</html>