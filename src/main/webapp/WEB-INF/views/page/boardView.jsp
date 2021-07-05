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
	<div class='row'>
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
					<i class="fa fa-comments fa-fw"></i>Reply
					<button id="addReplyBtn" class='btn btn-primary btn-xs pull-right'>New Reply</button>
				</div>
				<div class="panel-body">
					<ul class="chat">
						<li class="left clearfix" data-rno='12'>
							<div>
								<div class="header">
									<strong class="primary-font">user00</strong>
									<small class="pull-right text-muted">2020-07-05 13:12</small>
									</div>
									<p>Good job!</p>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
	</div>

	
	<%-- <div style="width:650px; text-align:center;">
		<br>
		
		<c:if test="${user.id != null }">
			<textarea rows="5" cols="80" id="replytext" placeholder="댓글을 작성해 주새요"></textarea>
			<br>
			<button type="button" id="btnReply" class="btnReply">댓글 작성</button>	
		</c:if>
	</div>
	<div id="listReply"></div> --%>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
			<h4 class="modal-title" id="myModalLabel">REPLY MODAL</h4>
		</div>
		<div class="modal-body">
			<div class="form-group">
				<label>Reply</label>
				<input class="form-control" name='reply' value='New Reply!!!!'>
 			</div>
 			<div class="form-group">
 				<label>Replyer</label>
 				<input class="form-control" name='replyer' value='replyer'>
 			</div>
 			<div class="form-group">
 				<label>Reply Date</label>
 				<input class="form-control" name='replyDate' value='2018-01-01 13:13'>
 			</div>
		</div>
		<div class="modal-footer">
			<button id='modalModBtn' type="button" class="btn btn-warning">Modify</button>
			<button id='modalRemoveBtn' type="button" class="btn btn-danger">Remove</button>
			<button id='modalRegisterBtn' type="button" class="btn btn-primary">Register</button>
			<button id='modalCloseBtn' type="button" class="btn btn-default">Close</button>
		</div>
	</div>
</div>
</div>

<script type="text/javascript">
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
	
	// 댓글 이벤트 
	$(document).ready(function() {
		var operForm = $("#operForm");
		$("button[data-oper='modify']").on("click", function(e){
			operForm.attr("action", "/board/modify").submit();	
		});
		$("button[data-oper='list']").on("click", function(e){
			operForm.find("#b_num").remove();
			operForm.attr("action", "/board/list").submit();
			operForm.submit();
		});

	var bnoValue ='<c:out value="${data.b_num}"/>';
	var replyUL = $(".chat");
	showList(1);
	
	function showList(page) {
		console.log("show list" + page);
		replyService.getList({bno:bnoValue, page:page|| 1}, function(list) {
			console.log("list: " + list);
			var str="";
			if(list == null || list.length == 0) {
				replyUL.html("");
				return;
			}
			for(var i = 0, len = list.length || 0; i < len; i++) {
				str += "<li class='left clearfix' data-rno='" + list[i].rno"'>";
				str += "<div><div class='header'><strong class='primary-font'>[" + list[i].rno +"]" +list[i].replyer + "</strong>";
				str += "<small class='pull-right text-muted'>" +list[i].replyDate +"</small></div>";
				str += "<p>" + list[i].reply +"</p></div></li>";
			}
			replyUL.html(str);
		});
	}
	var modal = $(".modal");
	var modalInputReply = modal.find("input[name='reply']");
	var modalInputReplyer = modal.find("input[name='replyer']");
	var modalInputReplyDate = modal.find("input[name='replyDate']");
	
	var modalModBtn = $("#modalModBtn");
	var modalRemoveBtn = $("#modalRemoveBtn");
	var modalRegisterBtn = $("#modalRegisterBtn");
	
	$("#addReplyBtn").on("click", function(e){
		modal.find("input").val("");
		modalInputReplyDate.closest("div").hide();
		modal.find("button[id != 'modalCloseBtn']").hide();
		modalRegisterBtn.show();
		$(".modal").modal("show");
	
	});
	modalRegisterBtn.on("click", function(e) {
		var reply = {
			reply: modalInputReply.val(),
			replyer : modalInputReplyer.val(),
			bno:bnoValue
				
		};
		replyService.add(reply, function(result) {
			alert(result);
			modal.find("input").val("");
			modal.modal("hide");
			
			showList(1);
		});
	});
	$(".chat").on("click", "li", function(e) {
		var rno = $(this),data("rno");
		console.log(rno);
		
		replyService.get(rno, function(reply){
			modalInputReply.val(reply.reply);
			modalInputReplyer.val(reply.replyer);
			modalInputReplyDate.val(replyService.displayTime(reply.replyDate))
			.attr("readonly","readonly");
			modal.data("rno", reply.rno);
			
			modal.find("button[id != 'modalClosebtn']").hide();
			modalModBtn.show();
			modalRemoveBtn.show();
			
			$(".modal").modal("show");
			
		});
	});
	modalModBtn.on("click", function(e) {
		var reply = {rno:modal.data("rno"), reply:modalInputReply.val(),
				replyer:modalInputReplyer.val()};
		replyService.update(reply, function(result) {
			alert(result);
			modal.modal("hide");
			showList(1);
		});
	});
	modalRemoveBtn.on("click", function(e) {
		var rno = modal.data("rno");
		replyService.remove(rno, function(result){
			alert(result);
			modal.modal("hide");
			showList(1);
		});
	});
});	
</script>


<%@ include file="../layout/footer.jsp"%>