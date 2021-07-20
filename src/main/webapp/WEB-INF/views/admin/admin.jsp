<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="../layout/header.jsp"%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>


</head>
<body>	
<h1 style="width:100%; text-align:center; ">여기는 관리자 페이지입니다</h1><br>
<div style="width:90%;  margin:auto; text-align: center; ">
		<span><button style="width:300px; height:30pt;" type="button" class="btn btn-sm btn-primary" onClick="location.href='/admin/member_list'">회원 목록 보기 </button></span><br><br>
		<span><button style="width:300px; height:30pt;" type="button" class="btn btn-sm btn-primary" onClick="location.href='/admin/money_list'">회원 매출 보기</button></span><br><br>
		<span><button style="width:300px; height:30pt;" type="button" class="btn btn-sm btn-primary" onClick="location.href='/pub/public'">공지사항 등록/수정</button></span><br><br>
		<span><button style="width:300px; height:30pt;" type="button" class="btn btn-sm btn-primary" onClick="location.href='/board/board'">게시판 수정</button></span><br><br>
</div>
</body>
</html>