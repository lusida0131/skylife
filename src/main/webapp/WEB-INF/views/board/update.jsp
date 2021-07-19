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
	<div class="row" style="padding: 20px; border-radius: 15px; margin: 20px;">
		<%-- <form name="form1" method="post" action="${pageContext.request.contextPath}/board/update?"> --%>
		<form name="form1" method="post" action="/board/update">
			<input type="hidden" name="b_num" value="${blist.b_num}" />
			<input type="hidden" name="id" id="id" value="${blist.id}"/>
			<div class="form-group">
				<div class="col-sm-12">
					<p>제목
					<input class="form-control" name="b_title" id="b_title" style="width:90%;" value="${blist.b_title}"></p>
				</div>
			</div>
			<%-- <div>
				제목
				<input name="b_title" id="b_title" value="${blist.b_title}">
			</div> --%>
			<br>
			<div class="form-group">
				<div class="col-sm-12">
					<p>내용<textarea class="form-control" name="b_content" id="b_content" rows="10" style="width:90%;">${blist.b_content}</textarea></p>
				</div>
			</div>
			<%-- <div>
				내용
				<textarea name="b_content" id="b_content" rows="4" cols="80">${blist.b_content}</textarea>
			</div> --%>
			<br><br>
			<div style="width:90%; text-align:center;">
				<button type="button" id="btnUpdate"class="btn btn-sm btn-primary">수정</button>
				<button type="reset"class="btn btn-sm btn-primary">취소</button>
			</div>
			<br><br>
		</form>
	</div>
</div>


<script>
	$(document).ready(function() {
		$("#btnUpdate").click(function() {
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
	
		$("#btnUpdate").click(function() {
			if(confirm("수정하시겠습니까?")) {
				document.form1.action = "${pageContext.request.contextPath}/board/update"
				document.form1.submit();
			}
		});
	});
</script>


<%@ include file="../layout/footer.jsp"%>