<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/accordions.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


	<br>
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h1>${user.name}님의 PAYMENT LIST</h1><hr>
			</div>
			<div class="col-md-12">
				<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
					<c:if test="${pn == 'null'}">
						<div  style="margin:100px; text-align:center;">
							<h4>PAYMENT LIST 항목이 없습니다!</h4>
						</div>
					</c:if>
					<c:set var="cnt" value="0"/>
					<c:forEach var="list" items="${pmlist}" varStatus="status">
					<c:set var="cnt" value="${cnt = cnt + 1}"/>
					<fmt:parseDate value="${list.depPlandTime}" var="depTime" pattern="yyyyMMddHHmm" />
					<fmt:parseDate value="${list.arrPlandTime}" var="arrTime" pattern="yyyyMMddHHmm" />
						<div class="panel panel-default" style="margin-top:10px; margin-bottom:10px;">
							<div class="panel-heading" role="tab" id="heading${cnt}">
								<h4 class="panel-title">
									<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse${cnt}" aria-expanded="true" aria-controls="collapse${cnt}">
										<img height="20" width="20" src="${pageContext.request.contextPath}/resources/images/airplane.png">&nbsp;
										${list.airlineNm}&nbsp;&nbsp;&nbsp;&nbsp;₩&nbsp; <fmt:formatNumber value="${list.economyCharge}" pattern="#,###,###" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
										${list.depAirportNm} (<fmt:formatDate value="${depTime}" pattern="MM월dd일 HH시mm분" />) -> ${list.arrAirportNm} (<fmt:formatDate value="${arrTime}" pattern="MM월dd일 HH시mm분" />)&nbsp;
									</a>
								</h4>
							</div>
							<div id="collapse${cnt}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${cnt}">
								<div class="panel-body">
									<form method="post" action="/fs/paymentDetail" id="detailFrm">
										<input type="hidden" value="${user.id}" name="id" id="id"/>
										<input type="hidden" value="${list.pay_num}" name="pay_num" id="pay_num"/>
										<input type="submit" value="상세보기" name="${list.pay_num}" id="detailBtn_${cnt}" style="float:right; border:0px; background-color:rgba(0,0,0,0);">
									</form>
									<table class="table table-striped">
										<thead> 
											<tr> 
												<th>항공편</th>
												<th>항공사</th>
												<th>출발공항</th>
												<th>출발일시</th>
												<th>도착공항</th>
												<th>도착일시</th>
											</tr> 
										</thead> 
										<tbody> 
											<tr>
												<td>${list.vihicleId}</td> 
												<td>${list.airlineNm}</td> 
												<td>${list.depAirportNm}</td>
												<td><fmt:formatDate value="${depTime}" pattern="MM월dd일 HH시mm분" /></td>
												<td>${list.arrAirportNm}</td>
												<td><fmt:formatDate value="${arrTime}" pattern="MM월dd일 HH시mm분" /></td>
											</tr>
										</tbody> 
										<thead> 
											<tr> 
												<th>결제번호</th>
												<th>결제수단</th>
												<th>결제금액</th>
												<th>상품명</th>
												<th>상품코드</th>
												<th>결제시각</th>
											</tr> 
										</thead> 
										<tbody> 
											<tr>
												<td>${list.tid}</td>
												<td>${list.payment_method_type}</td>
												<td><fmt:formatNumber value="${list.amount_total}" pattern="#,###,###" /></td>
												<td>${list.item_name}</td>
												<td>${list.item_code}</td>
												<td>${list.approved_at}</td>
											</tr>
										</tbody> 
									</table>
								</div>
							</div>
						</div>
					</c:forEach>
					
				</div>
			</div>
		</div>
	</div><br>

	<div id="fh5co-tours" class="fh5co-section-gray" style="padding-bottom:20px;">
		<div class="container">
			<div class="row">
				<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
					<h3>행복한 여행을 응원합니다.</h3>
					<p>SKYLIFE는 여행을 편하게 해줄 수 있는 여러 서비스들을 제공합니다.</p>
				</div>
			</div>
		</div>
	</div>
	
		
		

<%@ include file="../layout/footer.jsp"%>

