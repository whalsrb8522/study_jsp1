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
		상품명 : <input type="text" name="pname"> <br>
		가격 : <input type="text" name ="price"> <br>
		세부정보 : <input type="text" name ="madeby"> <br>
		<button type="submit">전송</button>
	</form> 
</body>
</html>