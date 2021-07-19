<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/accordions.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/board.css" />
<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<br>
<br>
<!-- ################ accordion toggle 적용 START ################ -->
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<h1>회 원 매 출</h1>
			<hr>
			<form class="login__input" action="/admin/mobthspayment" method="GET"
				id="signFrm" name="signFrm">
				<input type="date" name="input_date" required="required"
					id="input_date" pattern="%Y-%m-%d"> <input type="button"
					id="input_submit" onclick="input()" value="조회">

			</form>
		</div>

		<div class="col-md-12">
			<div class="panel-group" id="accordion" role="tablist"
				aria-multiselectable="true">

				<c:set var="cnt" value="0" />
				<c:forEach var="list" items="${pmlist}" varStatus="status">
					<c:set var="cnt" value="${cnt = cnt + 1}" />
					<fmt:parseDate value="${list.depPlandTime}" var="depTime"
						pattern="yyyyMMddHHmm" />
					<fmt:parseDate value="${list.arrPlandTime}" var="arrTime"
						pattern="yyyyMMddHHmm" />
					<div class="panel panel-default"
						style="margin-top: 10px; margin-bottom: 10px; width: 100%;">
						<div class="panel-heading" role="tab" id="heading${cnt}">
							<h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse"
									data-parent="#accordion" href="#collapse${cnt}"
									aria-expanded="true" aria-controls="collapse${cnt}"> <img
									height="20" width="20"
									src="${pageContext.request.contextPath}/resources/images/airplane.png">&nbsp;
									${list.partner_user_id}&nbsp;&nbsp;&nbsp;${list.airlineNm}&nbsp;&nbsp;&nbsp;&nbsp;₩&nbsp;
									<fmt:formatNumber value="${list.economyCharge}"
										pattern="#,###,###" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									${list.depAirportNm} (<fmt:formatDate value="${depTime}"
										pattern="MM월dd일 HH시mm분" />) -> ${list.arrAirportNm} (<fmt:formatDate
										value="${arrTime}" pattern="MM월dd일 HH시mm분" />)&nbsp;
								</a>
							</h4>
						</div>
						<div id="collapse${cnt}" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="heading${cnt}">
							<div class="panel-body">
								<form method="post" action="/kakaoPay" id="searchFrm">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>아이디</th>
												<th>항공편</th>
												<th>항공사</th>
												<th>출발공항</th>
												<th>출발시간</th>
												<th>도착공항</th>
												<th>도착시간</th>
												<th>일반석</th>
												<th>비즈니스석</th>
												<th>결제 수단</th>

											</tr>
										</thead>
										<tbody>
											<tr>
												<td>${list.partner_user_id}</td>
												<td>${list.vihicleId}</td>
												<td>${list.airlineNm}</td>
												<td>${list.depAirportNm}</td>
												<td><fmt:formatDate value="${depTime}"
														pattern="MM월dd일 HH시mm분" /></td>
												<td>${list.arrAirportNm}</td>
												<td><fmt:formatDate value="${arrTime}"
														pattern="MM월dd일 HH시mm분" /></td>
												<td><fmt:formatNumber value="${list.economyCharge}"
														pattern="#,###,###" /></td>
												<td><fmt:formatNumber value="${list.prestigeCharge}"
														pattern="#,###,###" /></td>
												<td>${list.payment_method_type}</td>
											</tr>
											<tr>
												<th>전체 결제 금액</th>
												<th>부가세 금액</th>
												<th>매입 카드사</th>
												<th>할부 개월</th>
												<th>상품 이름</th>
												<th>상품 코드</th>
												<th>상품 수량</th>
												<th>결제 준비요청시간</th>
												<th>결제 승인시각</th>
											</tr>
											<tr>
												<td>${list.amount_total}</td>
												<td>${list.amount_vat}</td>
												<td>${list.card_purchase_corp}</td>
												<td>${list.card_install_month}</td>
												<td>${list.item_name}</td>
												<td>${list.item_code}</td>
												<td>${list.quantity}</td>
												<td>${list.created_at}</td>
												<td>${list.approved_at}</td>
											</tr>
										</tbody>
									</table>
								</form>
							</div>
						</div>
					</div>

				</c:forEach>

			</div>
		</div>
	</div>
</div>
<br>
<script type="text/javascript">
	function input() {
		const dday = document.querySelector("#input_date").value;

		console.log(dday);
		$('#signFrm').submit();
	}
</script>

<%@ include file="../layout/footer.jsp"%>

