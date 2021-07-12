<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css"/>
<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<!-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script> -->
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<div class="container">
	<div class="card" style="padding: 20px; border-radius: 15px; margin: 20px auto;">
      <form name="form1" method="post" action="${pageContext.request.contextPath}/page/boardWrite">
		<div class="form-group">
			
			<div class="col-sm-12">
				<p>제목<input name="b_title" class="form-control" id="b_title" placeholder="제목을 입력해주세요."></p>
			</div>
		</div>
		<br>
		<div class="form-group">
			
			<div class="col-sm-12">
				<p>내용
				<textarea name="b_content" class="form-control" id="b_content" rows="4" cols="80" placeholder="내용을 입력해주세요"></textarea></p>
			</div>
		</div>
		<div class="mb-3">
			<div class="col-sm-12">
				<input type="hidden" name="id" class="form-control" id="id" value="${user.id}"></p>
			</div>
		</div>
		<br>
		<div style="width:650px; text-align:center;">
			<button type="button" id="btnSave" class="btn btn-sm btn-primary">확인</button>
			<button type="button" class="btn btn-sm btn-primary" onClick="location.href='/page/board'">취소</button>
		</div>
		</form>
	</div>
</div>


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


<%@ include file="../layout/footer.jsp"%>