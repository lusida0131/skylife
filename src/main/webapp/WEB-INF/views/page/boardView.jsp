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
<<<<<<< HEAD
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
            <c:if test="${user.id == data.id}">
            <button type="button" id="btnUpdate">수정</button>
            <button type="button" id="btnDelete">삭제</button>
            </c:if>
         </div>
         <div>
            <textarea rows="6px" cols="155px" name="r_content" id="r_content"></textarea>
            <input type="hidden" name="id" id="id" value="${user.id }">
            <input type="hidden" name="b_num" id="b_num" value="${data.b_num }">
            <%-- <input type="hidden" name="r_num" id="r_num" value="${data.r_num }"> --%>
         	<input type="button"id="reply_btn" value="등록">
         </div>
         <c:set var="count" value="0"/>
        <c:forEach items="${replyData }" var="com" varStatus="i">
        <c:set var="count" value="${count = count + 1}"/>
            <div id="book_reply">
               <ul>
                  <li class=emptyReply>
                     <c:if test="${com.r_num != null }">
                     <p>(${count})${com.id } (${com.time}) : ${com.r_content}</p>
                        <input type="hidden" id="comment${i.getIndex()}" value="${com.r_content }">
                        <input type="hidden" id="commentnum${i.getIndex()}" value="${com.r_num }">
                        <button type = "button" id="comment_delete${i.getIndex()}" value="${com.r_num}">삭제</button>
                        <button type="button" data-toggle="modal" data-target="#myModal"
                        id="comment_update${i.getIndex()}" value="${com.r_num}">수정</button>
                     </c:if>
                  </li>
               </ul>
            </div>
       </c:forEach>
      </form>
   </div>
=======
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
				<c:if test="${user.id == data.id}">
				<button type="button" id="btnUpdate">수정</button>
				<button type="button" id="btnDelete">삭제</button>
				</c:if>
			</div>
		</form>
	</div>
>>>>>>> e890ee0a28ff2f5b523bb6d2f351f17ed86efa4b
</div>
<script>
<<<<<<< HEAD
   $(document).ready(function() {
      $("#btnDelete").click(function() {
         if(confirm("삭제하시겠습니까?")) {
            document.form1.action = "${pageContext.request.contextPath}/board/delete"
            document.form1.submit();
         }
      });
      
      $("#btnUpdate").click(function() {
         if(confirm("수정하시겠습니까?")) {
            document.form1.action = "/board/update"
            document.form1.submit();
         }
      });
   });
</script>
<script>
$(function(){
   $("#reply_btn").click(function(e){
   const id=$('#id').val();
   const b_num=$('#b_num').val();
   const r_content=$('#r_content').val();
   const r_num=$('#r_num').val();
   
   console.log("id : "+ id);
   console.log("b_num : "+ b_num);
   console.log("r_content : "+r_content);
   console.log("r_num : "+r_num);
      if(id != null && id != "" && id != 0){
         if(r_content != null && r_content != ""){
            $.ajax({
               type:"POST",
               url:"/comment",
               data: {
                  r_num : r_num,
                  id : id,
                  b_num : b_num,
                  r_content : r_content
               },
               dataType: "text",
               success:function(result){
                  const resultSet = $.trim(result);
                  
                  if(resultSet==="notorder"){
                     alert('구매 후 리뷰 작성이 가능합니다.')
                     location.reload();
                  }
                  else if(resultSet==="order"){
                     console.log('성공');
                     location.reload();
                  }
                  
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
});
=======
	$(document).ready(function() {
		$("#btnDelete").click(function() {
			if(confirm("삭제하시겠습니까?")) {
				document.form1.action = "${pageContext.request.contextPath}/board/delete"
				document.form1.submit();
			}
		});
		
		$("#btnUpdate").click(function() {
			if(confirm("수정하시겠습니까?")) {
				document.form1.action = "/board/update"
				document.form1.submit();
			}
		});
	});
>>>>>>> e890ee0a28ff2f5b523bb6d2f351f17ed86efa4b
</script>

<%@ include file="../layout/footer.jsp"%>