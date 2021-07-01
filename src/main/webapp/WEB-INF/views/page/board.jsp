<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>

</head>
<body>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css"/>
<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<!-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script> -->
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<div class="container">
	<div class="row">
       <div class="col-md-3" style="float:right">
            <form action="#" method="get">
                <div class="input-group">
                    <input class="form-control" id="system-search" name="q" placeholder="Search for" required>
                    <span class="input-group-btn">
                        <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
                    </span>
                </div>
            </form>
        </div>
        <button type="button" id="btnWrite" style="float:right">글쓰기</button>
		<div class="col-md-9">
    	 <table class="table table-list-search">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>제목</th>
                            <th>아이디</th>
                            <th>작성일</th>
                            <th>조회수</th>
                        </tr>
                    </thead>
                    <%-- <td><a href="${pageContext.request.contextPath}/page/boardView?b_num=${BoardVO.b_num}">${BoardVO.b_title}</a></td> --%>
                    <c:forEach var="BoardVO" items="${list}">
                    	<tr>
                    		<td>${BoardVO.b_num}</td>
                    		<td><a href="${pageContext.request.contextPath}/page/boardView?b_num=${BoardVO.b_num}">${BoardVO.b_title}</a></td>
                    		<td>${BoardVO.id}</td>
                    		<td>
                    			<fmt:formatDate value="${BoardVO.time}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    		</td>
                    		<td>${BoardVO.rcount}</td>
                    	</tr>
                    </c:forEach>
                </table>   
		</div>
	</div>
</div>
</body>
<script>
	$(document).ready(function() {
		$("#btnWrite").click(function() {
			// 페이지 주소 변경(이동)
			location.href = "${pageContext.request.contextPath}/page/boardWrite";
		});
	});
</script>
</html>
<%@ include file="../layout/footer.jsp"%>