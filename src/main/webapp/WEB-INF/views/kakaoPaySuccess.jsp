<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/ticket.css">
<title>SkyLife - 결제 완료</title>
</head>

<body>

<br><h3 style="text-align: center;"> 카카오페이 결제가 정상적으로 완료되었습니다. </h3><br>

<div class="cardWrap">

	<div class="card cardLeft">
		<h1>SkyLife <span>Ticket</span></h1>
		<div class="title">
			<h2>${info.item_name}</h2>
			<span>결제 상품</span>
		</div>
		<div class="name">
			<h2>${info.approved_at}</h2>
			<span>결제 일시</span>
		</div>
<%-- 		<div class="name">
			<h2>${info.item_code}</h2>
			<span>name</span>
		</div> --%>
		<div class="seat">
			<h2>${info.item_code}</h2>
			<span>code</span>
		</div>
		<div class="time">
			<h2>${user.name}</h2>
			<span>name</span>
		</div>
	</div>
  
	<div class="card cardRight">
		<div class="eye"></div>
		<div class="number">
			<h3>SkyLife</h3>
			<span>with fly</span>
		</div>
		<div class="barcode"></div>
	</div>

</div>
<br>
<button onClick="location.href='/'">메인으로</button>

</body>
</html>

