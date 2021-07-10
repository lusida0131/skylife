<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 조회</title>
</head>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css"/>
<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<!-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script> -->
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


	<div class="container">
		<div class="row">
		<form  action="/delete" name="form1" method="get">
	       <div class="col-md-3" style="float:right">
	            
	        </div>
	      <div class="col-md-9">
				<table class="table table-list-search">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>생일</th>
							<th>이메일</th>
							<th>핸드폰 번호</th>
						</tr>
					</thead>
					<%-- <td><a href="${pageContext.request.contextPath}/page/boardView?b_num=${BoardVO.b_num}">${BoardVO.b_title}</a></td> --%>
					<c:forEach var="memberVO" items="${list}">
						<tr>
							<td>${memberVO.id},&ensp;&ensp;</td>
						<%--<td><a href="${pageContext.request.contextPath}/page/boardView?b_num=${BoardVO.b_num}">${BoardVO.b_title}</a></td> --%>
							<td>${memberVO.name}&ensp;&ensp;</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd" value="${memberVO.bday}"/>&ensp;&ensp;</td>
							<td>${memberVO.email}&ensp;&ensp;</td>
							<td>${memberVO.phone}&ensp;&ensp;</td>
							<td><input type="button" value="삭제" onclick="{href= 'delete?id=${memberVO.id }' }" ></td>
							<%-- <td><fmt:formatDate value="${BoardVO.time}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
							</tr>
					</c:forEach>
				</table>   
			</div>
			</form>
		</div>
	</div><br>
<script>
   $(document).ready(function() {
      $("#memdelete").click(function() {
         if(confirm("삭제하시겠습니까?")) {
            document.form1.submit();
         }
      });
   });
      </script>
</body>
</html>



