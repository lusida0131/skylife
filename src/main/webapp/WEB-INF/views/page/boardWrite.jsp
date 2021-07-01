<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
</head>
<body>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css"/>
<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<!-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script> -->
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<div class="container">
	<div class="row">
      <form name="form1" method="post" action="${pageContext.request.contextPath}/insert">
		<div>
			제목
			<input name="b_title" id="b_title" value="${vo.b_title}" placeholder="제목을 입력해주세요.">
		</div>
		<div>
			내용
			<textarea name="b_content" id="b_content" rows="4" cols="80" placeholder="내용을 입력해주세요">${vo.b_content}</textarea>
		</div>
		<div>
			이름
			<input name="id" id="id" value="${vo.id}" placeholder="이름을 입력해주세요">
		</div>
		<div style="width:650px; text-align:center;">
			<input type="hidden" name="b_num" value="vo.b_num">
			<button type="button" id="btnSave">확인</button>
			<button type="reset">취소</button>
		</div>
		</form>
	</div>
</div>
</body>
<script>
	$(document).ready(function() {
		$("#btnSave").click(function() {
			var b_title = $("#b_title").val();
			var b_content = $("#b_content").val();
			var id = $("#id").val();
			if(b_title == ""){
				alert("제목을 입력하세요");
				document.form1.b_title.focus();
				
				return;
			}
			if(b_content == ""){
				alert("내용을 입력하세요");
				document.form1.b_title.focus();
				
				return;
			}
			if(id == ""){
				alert("이름을 입력하세요");
				document.form1.id.focus();
				
				return;
			}
			document.form1.submit();
		});
	});
</script>
</html>
<%@ include file="../layout/footer.jsp"%>