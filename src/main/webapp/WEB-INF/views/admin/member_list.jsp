<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="../layout/header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 조회</title>
</head>

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<!-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script> -->
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


<div class="container">
	<div class="row">
		<div class="col-md-3" style="float: right"></div>
		<div class="col-md-9">
			<form action="/remove" name="form1" method="post">
				<table class="table table-list-search">
					<thead>
						<tr>
							<th>아이디</th>
							<th>이름</th>
							<th>생일</th>
							<th>이메일</th>
							<th>핸드폰 번호<br></th>
						</tr>
					</thead>
					<c:forEach var="memberVO" items="${list}">
						<tr>
							<td>${memberVO.id}&ensp;&ensp;</td>
							<td>${memberVO.name}&ensp;&ensp;</td>
							<td><fmt:formatDate pattern="yyyy-MM-dd"
									value="${memberVO.bday}" />&ensp;&ensp;</td>
							<td>${memberVO.email}&ensp;&ensp;</td>
							<td>${memberVO.phone}&ensp;&ensp;</td>
							<td><input type="button" value="탈퇴 시키기"
								onclick="location.href='/remove?id=<c:out value="${memberVO.id}" />'"
								class="btn btn-secondary mb-3"></td>
							<td><input type="hidden" name="id" value="${memberVO.id}"></td>
						</tr>

					</c:forEach>
				</table>
			</form>
		</div>
	</div>
</div>
<br>
</body>
</html>