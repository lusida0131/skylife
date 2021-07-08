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
	<div class="row">
      <%-- <form name="form1" method="post" action="${pageContext.request.contextPath}/board/update?"> --%>
      <form name="form1" method="post" action="/board/update">
      	<input type="hidden" name="b_num" value="${blist.b_num}" />
		<div>
			제목
			<input name="b_title" id="b_title" value="${blist.b_title}">
		</div>
		<div>
			내용
			<textarea name="b_content" id="b_content" rows="4" cols="80">${blist.b_content}</textarea>
		</div>
		<div>
			이름
			<input name="id" id="id" value="${blist.id}" readonly>
		</div>
		<div style="width:650px; text-align:center;">
			<button type="button" id="btnUpdate">수정</button>
			<button type="reset">취소</button>
		</div>
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