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
		<form name="form1" method="post">
			<div>
				작성일자: <fmt:formatDate value="${data.time}" pattern="yyy-MM-dd HH:mm:ss"/>
			</div>
			<div>
				제목
				<input name="b_title" id="b_title" value="${data.b_title}" placeholder="제목을 입력해주세요.">
			</div>
			<div>
				내용
				<textarea name="b_content" id="b_content" rows="4" cols="80" placeholder="내용을 입력해주세요">${data.b_content}</textarea>
			</div>
			<div>
				이름
				<input name="id" id="id" value="${data.id}" placeholder="이름을 입력해주세요">
			</div>
			<div style="width:650px; text-align:center;">
				<input type="hidden" name="b_num" value="${data.b_num}">
				<c:if test="${user.id == data.id }">
					<button type="button" id="btnUpdate">수정</button>
					<button type="button" id="btnDelete">삭제</button>
				</c:if>
			</div>
		</form>
	</div>
	<div style="width:650px; text-align:center;">
		<br>
		<c:if test="${user.id != null }">
			<textarea rows="5" cols="80" id="replytext" placeholder="댓글을 작성해 주새요"></textarea>
			<br>
			<button type="button" id="btnReply">댓글 작성</button>	
		</c:if>
	</div>
	<div id="listReply">
</div>
</div>


<script>
	$(document).ready(function() {
		$("#btnDelete").click(function() {
			if(confirm("삭제하시겠습니까?")) {
				document.form1.action = "${pageContext.request.contextPath}/board/delete"
				document.form1.submit();
			}
		});
		
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
			document.form1.action="${pageContext.request.contextPath}/board/update"
			document.form1.submit();
		});
	});
	
	// 댓글 쓰기 버튼 클릭 이벤트 
	$(document).ready(function() {
		listReply();
		$("#btnReply").click(function() {
			var r_content = ("#r_content").val();
			var b_num = "${data.b_num}"
			var param = "r_content= " + r_content + "&b_num=" + b_num;
			$.ajax({
				type: "post",
				url: "${pageContext.request.contextPath}/reply/insert",
				data: param,
				success: function() {
					alert("댓글이 등록 되었습니다.");
					listReply();
				}
			})
		})
		
	})
	
	//댓글 목록
	function listReply() {
		$.ajax({
			type: "get",
			url: "${pageContext.request.contextPath}/reply/list?b_num=${data.b_num}",
			success: function(result) {
				$("#listReply").html(result);
			}
		});
	}
</script>


<%@ include file="../layout/footer.jsp"%>