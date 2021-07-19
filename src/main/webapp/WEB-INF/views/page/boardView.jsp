<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css"/>
<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


<div class="container">
	<div class="card" style="padding: 10px; border-radius: 15px;">
		<form name="form1" method="post">
		<div style=" background-color:rgba(245,245,245,0.25);">
			<div class="form-group">
				<!-- 글제목 -->
				<%-- <input name="b_title" id="b_title" value="${data.b_title}" disabled class="form-control"
						style="margin:5px; font-size:23pt; font-weight:400; color:blue; border-size:0px; border-color:rgba(0,0,0,0); background-color:rgba(0,0,0,0); box-shadow: none;"> --%>
				<span id="b_title" class="form-control" style="margin:5px; font-size:23pt; font-weight:400; color:#1e1e1e; border-size:0px; border-color:rgba(0,0,0,0); background-color:rgba(0,0,0,0); box-shadow: none;">
						${data.b_title}</span>
			</div>
			<div class="form-group">
				<!-- 작성자 | 작성일자 -->
				<%-- <input name="id" id="id" value="${data.id}" disabled class="form-control"
						style="width:150px; display:inline; margin-left:15px; padding:10px 25px 30px 25px; font-size:18pt; font-weight:200; color:black; border-size:0px; border-color:rgba(0,0,0,0); background-color:rgba(0,0,0,0); box-shadow: none;"/> --%>
				<%-- <span style="margin-left:15px; padding:10px 25px 30px 25px; font-size:15pt;">|&nbsp;&nbsp;<fmt:formatDate value="${data.time}" pattern="yyy-MM-dd HH:mm:ss"/></span> --%>
				<span id="id" class="form-control" style="margin-left:10px; font-size:15pt; font-weight:200; border-size:0px; border-color:rgba(0,0,0,0); background-color:rgba(0,0,0,0); box-shadow: none;">
						${data.id}&nbsp;&nbsp;|&nbsp;&nbsp;<fmt:formatDate value="${data.time}" pattern="yyy-MM-dd HH:mm:ss"/>&nbsp;&nbsp;|&nbsp;&nbsp;조회 ${data.rcount}</span>
			</div>
			<hr></div>
		
			<div class="form-group">
				<!-- 게시글 내용 -->
				<%-- <textarea name="b_content" id="b_content" rows="4" cols="80" readonly class="form-control">${data.b_content}</textarea> --%>
				<span id="b_content" class="form-control" style="margin:10px; font-size:14pt; border-size:0px; border-color:rgba(0,0,0,0); background-color:rgba(0,0,0,0); box-shadow: none;">
						${data.b_content}</span>
			</div>
			<br>
			<div style="width:90%; text-align:center;">
				<input type="hidden" name="b_num" value="${data.b_num}">
				<c:if test="${user.id == data.id || user.id == 'admin'}"><br>
					<input type="button" id="btnUpdate" onclick="location.href='/board/update?b_num=<c:out value="${data.b_num}"/>'" value="수정" class="btn btn-sm btn-primary">
					<button type="button" id="btnDelete" class="btn btn-sm btn-primary">삭제</button>
				</c:if>
			</div><br>
			
			<div style="background-color:rgba(245,245,245,0.25);">
				<div style="background-color:rgba(245,245,245,0.7);"><hr>
					<textarea rows="3px" name="r_contented" id="r_contented" placeholder="댓글을 작성해주세요." style="margin-left:20px; width:85%;"></textarea>
					<input type="hidden" name="ided" id="ided" value="${user.id}">
					<input type="hidden" name="b_num" id="b_num" value="${data.b_num}">
					<%-- <input type="hidden" name="r_num" id="r_num" value="${data.r_num }"> --%>
					<input type="button"id="reply_btn" name="commentInsertBtn" value="등록" class="btn btn-sm btn-primary" style="position: absolute; margin:2px 5px 2px 10px; height:60px;">
					<br><br>
				</div>
				<c:set var="count" value="0"/>
				<c:set var="count" value="${count = count + 1}"/>
				<div id="book_reply">
					<ul class="chat" style="list-style:none;">
						<li class="emptyReply"></li>
					</ul>
				</div>
				<div class="panel-footer"></div>
				<div class="modal fade" id="myModal" role="dialog">
					<div class="modal-dialog" style="z-index: 9999;">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">×</button>
								<h4 class="modal-title">댓글 수정</h4>
							</div>
							<div class="modal-body">
								<br/><br/>
								<textarea rows="4px" cols="60px" name="r_content" id="r_content_text"></textarea>
							</div>
							<div class="modal-footer">
								<input type="hidden" name="r_num" id="r_num" value="${com.r_num}" class="r_num">
								<button type="button" class="btn btn-default" data-dismiss="modal" id="commentUpdate" value="${com.r_num}">수정</button> 
								<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
				
		</form>
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
	});
</script>

<script>
	$(function(){
		
		$("#reply_btn").click(function(e){
			const id =$('#ided').val();
			const b_num=$('#b_num').val();
			const r_contented = $('#r_contented').val();
	
			console.log("id : "+ id);
			console.log("b_num : "+ b_num);
			console.log("r_content : " + r_contented);
		   
			if(id != null && id != "" && id != 0){
				if(r_contented != null && r_contented != ""){
					$.ajax({
						type:"POST",
						url:"/comment",
						data: {
							id : id,
							b_num : b_num,
							r_content : r_contented
						},
						dataType: "text",
						success:function(result){
							location.reload();
						}
					});
				}
				else{
					alert('댓글을 입력해주세요');
				}
			}
			else{
				alert('로그인 해주세요')
			}
		});
		
		$(document).ready(function() {
			$('#myModal').on('show.bs.modal', function(event) {
				$('#commentUpdate').click(function(e){
					const r_num = $('#r_num').val();
					const r_content_text = $('#r_content_text').val();
					
					console.log("r_num : " + r_num);
					console.log("r_content : " + r_content_text);
					$.ajax({
						type:"POST",
						url:"/replies/update",
						data: {    
							r_num : r_num,
							r_content : r_content_text
						},
						dataType: "text",
						success:function(result){
							const resultSet = $.trim(result); 
							showList(-1);  // 페이지 계산하여 나중에 추가된 댓글을 보여준다.
							location.reload();
						}
					});
				});
			});
		});
		
	});
</script>

<script>
	function rplydelete(rNum) {
		if(confirm("삭제하시겠습니까?")){
			$.ajax({
				type: "delete",
				url: "${pageContext.request.contextPath}/reply/delete/" + Number(rNum),
				success: function(result){
					if(result == "success"){
						alert("삭제되었습니다.");
						location.reload();
						listReplyRest("1");
					}
				}
			});
		}
	}
</script>

<script src="${pageContext.request.contextPath}/resources/js/reply.js"></script>

<script>
	
	var bnoValue = '<c:out value="${data.b_num}" />';
	var replyUL = $(".chat");

	showList(1);
	function showList(page) {	// 댓글 페이지를 보여주는 함수
		var userID = $('#ided').val();
		console.log("show list " + page);
		replyService.getList({b_num:bnoValue, page: page || 1}, function(replyCnt, list) {
			console.log("list: " + list);
			console.log("replyCnt: " + replyCnt);

			if(page == -1) {	// -1 page -> 마지막 페이지를 계산해서 마지막 페이지를 요청
				pageNum = Math.ceil(replyCnt / 10.0);		// ceil(올림) : 마지막 페이지
				showList(pageNum);							// 마지막 페이지를 보여주도록 요청
				return;
			}

			var str = "";
			if(list == null || list.length == 0) {
				replyUL.html("");
				return;
			}
			for(var i = 0, len = list.length || 0 ; i < len ; i++) {
				str +="<li class='left clearfix emptyReply' style='margin:20px 0px 20px 0px;'>";
				str +="  <div><div class='header'><strong class='primary-font'>"+list[i].id+"&nbsp;&nbsp;("+list[i].time+")</strong>";	// 작성자
				str +="    <p>"+list[i].r_content+"</p>";		// 댓글 내용
				str +="    <small class='pull-right text-muted'>" + "</small></div>";
				if(userID == list[i].id || userID == "admin") {
					str +=" <button type='button' name='delete' id='delete' class='btn btn-sm btn-primary rplydelete' value='" + list[i].r_num + "' onClick='rplydelete("+ list[i].r_num +")'>삭제</button>";
					str +=" <button type='button' id='replyBtnUpdate" + i + "' data-toggle='modal' data-target='#myModal' value='" + list[i].r_num + "' class='btn btn-sm btn-primary'>수정</button>";
				}
				str +=" <input type='hidden' id='r_contents" + i + "' value='" + list[i].r_content + "'>  ";
				str +=" </div></li>";
				str +="<script>";
				str +=" $(document).ready(function() {";
				str +=" $('#replyBtnUpdate" + i + "').click(function(e){";
				str +=" const valuenum = $('#replyBtnUpdate" + i + "').val();";
				str +=" const valuecom = $('#r_contents" + i + "').val();";
				str +=" $('#r_num').val(valuenum);";
				str +=" $('#r_content_text').text(valuecom);";
				str +=" });";
				str +="});";
				str +="</"+"script>";
			}

			replyUL.html(str);         // 댓글 목록을 보여주기
      
			// 페이징 처리하는 부분을 call
			showReplyPage(replyCnt);   // 페이징 처리하는 부분을 출력
		});
	}

</script>

<script>
	
	var pageNum = 1;
	var replyPageFooter = $(".panel-footer");
	
	function showReplyPage(replyCnt){
		var endNum = Math.ceil(pageNum / 10.0) * 10;  
		var startNum = endNum - 9;       
		var prev = startNum != 1;
		var next = false;
	    
		if(endNum * 10 >= replyCnt){
			endNum = Math.ceil(replyCnt/10.0);
		}
		if(endNum * 10 < replyCnt){
			next = true;
		}
		var str = "<ul class='pagination pull-right'>";
		if(prev){
			str+= "<li class='page-item'><a class='page-link' href='"+(startNum -1)+"'>Previous</a></li>";
		}
		for(var i = startNum ; i <= endNum; i++){
			var active = pageNum == i? "active":"";
			str+= "<li class='page-item "+active+" '><a class='page-link' href='"+i+"'>"+i+"</a></li>";
		}
		if(next){
			str+= "<li class='page-item'><a class='page-link' href='"+(endNum + 1)+"'>Next</a></li>";
		}
		str += "</ul></div>";
		console.log(str);
		replyPageFooter.html(str);
	}
	
	replyPageFooter.on("click","li a", function(e){
		e.preventDefault();
		console.log("page click");
		var targetPageNum = $(this).attr("href");
		console.log("targetPageNum: " + targetPageNum);
		pageNum = targetPageNum;
     	
		showList(pageNum);      // 해당 페이지로 이동
	});
	
</script>

<%@ include file="../layout/footer.jsp"%>