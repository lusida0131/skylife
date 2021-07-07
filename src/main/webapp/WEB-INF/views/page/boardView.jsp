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
            <c:if test="${user.id == data.id}">
            <button type="button" id="btnUpdate">수정</button>
            <button type="button" id="btnDelete">삭제</button>
            </c:if>
         </div>
         <div>
            <textarea rows="6px" cols="155px" name="r_content" id="r_content"></textarea>
            <input type="hidden" name="ided" id="ided" value="${user.id }">
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
                        <input type="hidden" id="r_content" value="${com.r_content }">
                        <input type="hidden" id="ider" value="${com.id }">
                        <input type="hidden" value="${com.r_num }">
                        <button type = "button" name="delete" value="${com.r_num}">삭제</button>
                        <button type="button" data-toggle="modal" data-target="#modifyModal"
                        name="modify" value="${com.r_num}">수정</button>
                     </c:if>
                  </li>
               </ul>
            </div>
       </c:forEach>
      </form>
   </div>
</div>
<div class="modal fade" id="modifyModal" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">댓글 수정창</h4>
			</div>
			<div class="modal-body">
				<div class="form-group">
					<label for="replyText">댓글 내용</label>
					<input class="form-control" id="r_content" name="r_content">
				</div>
				<div class="form-group">
					<label for="replyWriter">댓글 작성자</label>
					<input class="form-control" id="ider" name="ider" readonly>
				</div>
			</div>
			 <div class="modal-footer">
              <button type="button" class="btn btn-default pull-left" data-dismiss="modal">닫기</button>
              <button type="button" class="btn btn-success modalModBtn">수정</button>
              <button type="button" class="btn btn-danger modalDelBtn" >삭제</button>
          </div>
		</div>
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
   const id =$('#ided').val();
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
</script>
<script>
$("#replies").on("click", ".replyLi button", function () {
    var reply = $(this).parent();

    var r_content = reply.find(".r_content").text();
    var ider = reply.find(".ider").text();


    $("#r_content").val(r_content);
    $("#ider").val(ider);

});
</script>
<script>
$.ajax({
    type : "post",
    url : "/replies",
    headers : {
        "Content-type" : "application/json",
        "X-HTTP-Method-Override" : "POST"
    },
    dataType : "text",
    data : JSON.stringify({
    	r_num : r_num,
        r_content : r_content,
        ider : ider
    }),
    success : function (result) {
        
        getReplies(); // 댓글 목록 출력 함수 호출
        replyText.val(""); // 댓글 내용 초기화
        replyWriter.val(""); // 댓글 작성자 초기화
    }
});
</script>

<%@ include file="../layout/footer.jsp"%>