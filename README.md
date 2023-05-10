<pre>
[페이지 목록]
index.jsp : 첫화면
register.jsp : 상품 등록 화면
list.jsp : 상품 목록보는 화면
detail.jsp : 상품 세부 정보 보는 화면
modify.jsp : 상품 수정 화면

[index.jsp]

[register.jsp (상품명, 가격, 세부정보)]

상품명 : <input>
가격 : <input>
세부정보 : <input>
등록 : <button> -> Controller -> 등록 처리 후 list로 이동 (controller에서 DB에 모든 정보를 가지고 와서 list.jsp에 뿌려줌

[list.jsp (번호, 상품명, 등록일)]
<table> (최근에 등록한 물품이 위로 오게)
<table><a><tr> -> detail.jsp
상품등록 : <button> -> register.jsp

[detail.jsp]
번호 : <input>
상품명 : <input>
가격 : <input>
등록일자 : <input>
세부내용 : <input>
수정 : <button> -> modify.jsp
삭제 : <button> -> list.jsp
</pre>
