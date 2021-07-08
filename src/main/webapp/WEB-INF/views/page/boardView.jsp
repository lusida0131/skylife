<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css"/>
<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<!-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script> -->
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>


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
         <br>
         <br>
         <div>
            <textarea rows="6px" cols="155px" name="r_content" id="r_contented"></textarea>
            <input type="hidden" name="ided" id="ided" value="${user.id }">
            <input type="hidden" name="b_num" id="b_num" value="${data.b_num }">
            <%-- <input type="hidden" name="r_num" id="r_num" value="${data.r_num }"> --%>
         	<input type="button"id="reply_btn" name="commentInsertBtn" value="등록">
         </div>
         <c:set var="count" value="0"/>
        
        <c:set var="count" value="${count = count + 1}"/>
        <br>
        <br>
            <div id="book_reply">
               <ul>
                  <li class="emptyReply">
                  <c:forEach items="${replyData }" var="com" varStatus="i">
                  
                     <c:if test="${com.r_num != null }">
                     <p>(${count})${com.id } (${com.time}) : ${com.r_content}</p>
                        <input type="hidden" id="r_contents${i.getIndex()}" value="${com.r_content }">
                        <%-- <textarea id="r_contents${i.getIndex()}" rows="" cols="">${com.r_content }</textarea> --%>
                        
                        <input type="hidden" name="r_num" id="r_num${i.getIndex()}" value="${com.r_num }">
                        <input type="hidden" id="ider" value="${com.id }">
                        <input type="hidden" value="${com.r_num }">
                        
                        <button type = "button" name="delete" id="delete" class="rplydelete" value="${com.r_num}">삭제</button>
                        <button type="button" id="replyBtnUpdate${i.getIndex()}" data-toggle="modal" data-target="#myModal" value="${com.r_num}" >수정</button>         
                     </c:if>
                     
                     <script>
						$('#replyBtnUpdate${i.getIndex()}').click(function(e){
						    const valuenum = $('#replyBtnUpdate${i.getIndex()}').val();
						    const valuecom = $('#r_contents${i.getIndex()}').val();
						    $('#r_num').val(valuenum);
						    $("#r_content_text").text(valuecom);
						 });
						
						
						</script>
					</c:forEach>
                  </li>
               </ul>
            </div>
            <div class="modal fade" id="myModal" role="dialog">
   				<div class="modal-dialog">
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
            				<input type="hidden" name="r_num" id="r_num" value="${com.r_num }" class="r_num">
            				<button type="button" class="btn btn-default" data-dismiss="modal" id="commentUpdate" value="${com.r_num}">수정</button> 
            				<button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
         				</div>
      				</div>
   				</div>
			</div>
      
      </form>
   </div>
</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/reply.js"></script>
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
                   location.reload();
                }
             });
          });
          
       });
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
$(".rplydelete").click(function(){
    if(confirm("삭제하시겠습니까?")){
        $.ajax({
            type: "delete",
            url: "${pageContext.request.contextPath}/reply/delete/" + Number($(this).val()),
            success: function(result){
                if(result == "success"){
                    alert("삭제되었습니다.");
                    location.reload();
                    listReplyRest("1");
                }
            }
        });
    }
});
</script>
<script>

</script>
<%@ include file="../layout/footer.jsp"%>