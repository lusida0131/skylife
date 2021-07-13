<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/accordions.css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

		<br><br>
	<!-- ################ accordion toggle 적용 START ################ -->
		<div class="container">
			<div class="row">
				<div class="col-md-12">
					<h1>항공편 검색 목록</h1>
					<fmt:parseDate value="${fhlist.startDate}" var="sdate" pattern="yyyyMMdd" />
					<h3 style="text-align: center;">
						검색 일자 : &nbsp;&nbsp;<fmt:formatDate value="${sdate}" pattern="yyyy년 MM월 dd일 (E)" />&nbsp;&nbsp;&nbsp;${fhlist.endPN_ko}행
					</h3>
					
					<c:set var="idCheck" value="${user.id}"/>
					<c:if test="${idCheck eq null}">
					<p style="color: red; text-align: center;">로그인시 항공권 결제 서비스의 이용이 가능합니다.</p>
					</c:if>
					<hr>
				</div>
				
				<div class="col-md-12">
					<div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">

						<c:set var="count" value="0"/>
						<c:forEach var="list" items="${flist}">
							<c:set var="count" value="${count = count + 1}"/>
							<fmt:parseDate value="${list.depPlandTime}" var="depTime" pattern="yyyyMMddHHmm" />
							<fmt:parseDate value="${list.arrPlandTime}" var="arrTime" pattern="yyyyMMddHHmm" />
							<div class="panel panel-default" style="margin-top:10px; margin-bottom:10px;">
								<div class="panel-heading" role="tab" id="heading${count}">
									<h4 class="panel-title">
										<a class="collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapse${count}" aria-expanded="true" aria-controls="collapse${count}">
											<div>
											<span style="float: left;"><img height="20" width="20" src="${pageContext.request.contextPath}/resources/images/airplane.png">&nbsp;
											${list.airlineNm}&nbsp;&nbsp;&nbsp;&nbsp;₩&nbsp; <fmt:formatNumber value="${list.economyCharge}" pattern="#,###,###" /></span>
											<span style="float: right;">${list.depAirportNm} (<fmt:formatDate value="${depTime}" pattern="HH시mm분" />) -> ${list.arrAirportNm} (<fmt:formatDate value="${arrTime}" pattern="HH시mm분" />)</span>&nbsp;
											</div>
										</a>
									</h4>
								</div>
								<div id="collapse${count}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading${count}">
									<div class="panel-body">
										<%-- <p>This is 간단한 내용. write here. (${count})</p> --%>
										<form method="post" action="/addwish" id="wishFrm" target="param">
											<iframe id="if" name="param" style="width: 0px; height: 0px; border: 0px;"></iframe>
											<c:if test="${user.id ne null}"><button name="wishBtn" style="float: right; margin: 8px 10px 15px 10px;">찜</button></c:if>
											<input type="hidden" value="${user.id}" name="id" id="id"/>
											<input type="hidden" value="${list.vihicleId}" name="vihicleId" id="vihicleId"/>
											<input type="hidden" value="${list.airlineNm}" name="airlineNm" id="airlineNm"/>
											<input type="hidden" value="${list.depAirportNm}" name="depAirportNm" id="depAirportNm"/>
											<input type="hidden" value="${list.depPlandTime}" name="depPlandTime" id="depPlandTime"/>
											<input type="hidden" value="${list.arrAirportNm}" name="arrAirportNm" id="arrAirportNm"/>
											<input type="hidden" value="${list.arrPlandTime}" name="arrPlandTime" id="arrPlandTime"/>
											<input type="hidden" value="${list.economyCharge}" name="economyCharge" id="economyCharge"/>
											<input type="hidden" value="${list.prestigeCharge}" name="prestigeCharge" id="prestigeCharge"/>
											<table class="table table-striped" style="margin-top:10px;"> 
												<thead> 
													<tr> 
														<th>항공편</th>
														<th>항공사</th>
														<th>출발공항</th>
														<th>출발시각</th>
														<th>도착공항</th>
														<th>도착시각</th>
														<th>일반석</th>
														<th>비즈니스석</th>
													</tr> 
												</thead> 
												<tbody> 
													<tr> 
														<td>${list.vihicleId}</td> 
														<td>${list.airlineNm}</td> 
														<td>${list.depAirportNm}</td>
														<td><fmt:formatDate value="${depTime}" pattern="MM월dd일 HH시mm분" /> </td>
														<td>${list.arrAirportNm}</td>
														<td><fmt:formatDate value="${arrTime}" pattern="MM월dd일 HH시mm분" /> </td>
														<td><fmt:formatNumber value="${list.economyCharge}" pattern="#,###,###" /></td>
														<td><fmt:formatNumber value="${list.prestigeCharge}" pattern="#,###,###" /></td>
													</tr>
												</tbody> 
											</table>
										</form>
									</div>
								</div>
							</div>
							
						</c:forEach>
						
						
						<div style="text-align: center; margin-top: 30px;">
							<c:set var="pNum" value="${fhlist.pageNo}"/>
							<c:set var="toCnt" value="${fhlist.totalCount}"/>
							<form method="post" action="/fs/flightPage" id="pbFrm" style="display:inline;">
								<input type="hidden" value="${fhlist.startPortName}" name="spn" id="spn"/>
								<input type="hidden" value="${fhlist.endPortName}" name="epn" id="epn"/>
								<input type="hidden" value="${fhlist.startDate}" name="sd" id="sd"/>
								<input type="hidden" value="${fhlist.pageNo - 1}" name="pNum" id="pNum"/>
								<input type="hidden" value="${fhlist.totalCount}" name="spn" id="toCnt"/>
								<c:if test="${pNum > 1}"><%-- <c:if test="${(pNum+1)*30 > toCnt - pNum*30}"> --%>
									<input type="submit" name="backBtn" style="margin:10px;" value="이전"/>
								</c:if><%-- </c:if> --%>
							</form>
							<fmt:parseNumber var="tCnt" integerOnly="true" value="${(toCnt/30)+(1-((toCnt/30)%1))%1}"/>
							<span> ${pNum} / ${tCnt} </span>
							<form method="post" action="/fs/flightPage" id="pnFrm" style="display:inline;">
								<input type="hidden" value="${fhlist.startPortName}" name="spn" id="spn"/>
								<input type="hidden" value="${fhlist.endPortName}" name="epn" id="epn"/>
								<input type="hidden" value="${fhlist.startDate}" name="sd" id="sd"/>
								<input type="hidden" value="${fhlist.pageNo + 1}" name="pNum" id="pNum"/>
								<input type="hidden" value="${fhlist.totalCount}" name="spn" id="toCnt"/>
								<c:if test="${pNum*30 < toCnt}">
									<input type="submit" name="nextBtn" style="margin:10px;" value="다음"/>
								</c:if>
							</form>
						</div>
						
					</div>
				</div>
			</div>
		</div><br>
	<!-- ################ accordion toggle 적용 END ################ -->


		<div id="fh5co-tours" class="fh5co-section-gray">
			<div class="container">
				<div class="row">
					<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box">
						<h3>행복한 여행을 응원합니다.</h3>
						<p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts.</p>
					</div>
				</div>
			</div>
		</div>
		
		<div id="fh5co-features">
			<div class="container">
				<div class="row">
					<div class="col-md-4 animate-box">
						<div class="feature-left">
							<span class="icon">
								<i class="icon-hotairballoon"></i>
							</span>
							<div class="feature-copy">
								<h3>Family Travel</h3>
								<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit.</p>
								<p><a href="#">Learn More</a></p>
							</div>
						</div>
					</div>
					<div class="col-md-4 animate-box">
						<div class="feature-left">
							<span class="icon">
								<i class="icon-search"></i>
							</span>
							<div class="feature-copy">
								<h3>Travel Plans</h3>
								<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit.</p>
								<p><a href="#">Learn More</a></p>
							</div>
						</div>
					</div>
					<div class="col-md-4 animate-box">
						<div class="feature-left">
							<span class="icon">
								<i class="icon-wallet"></i>
							</span>
							<div class="feature-copy">
								<h3>Honeymoon</h3>
								<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit.</p>
								<p><a href="#">Learn More</a></p>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4 animate-box">

						<div class="feature-left">
							<span class="icon">
								<i class="icon-wine"></i>
							</span>
							<div class="feature-copy">
								<h3>Business Travel</h3>
								<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit.</p>
								<p><a href="#">Learn More</a></p>
							</div>
						</div>
					</div>
					<div class="col-md-4 animate-box">
						<div class="feature-left">
							<span class="icon">
								<i class="icon-genius"></i>
							</span>
							<div class="feature-copy">
								<h3>Solo Travel</h3>
								<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit.</p>
								<p><a href="#">Learn More</a></p>
							</div>
						</div>
					</div>
					<div class="col-md-4 animate-box">
						<div class="feature-left">
							<span class="icon">
								<i class="icon-chat"></i>
							</span>
							<div class="feature-copy">
								<h3>Explorer</h3>
								<p>Facilis ipsum reprehenderit nemo molestias. Aut cum mollitia reprehenderit.</p>
								<p><a href="#">Learn More</a></p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		
											
	<script type="text/javascript">
	
		$(document).ready(function(){
			$('#wishBtn').click(function(){
/* 				if(${idCheck} === 'none') {
					alert("로그인이 필요한 서비스입니다.");
					location.href="/auth/loginForm";
				}
				else { */
					$('#wishFrm').submit();
/* 				} */
			});
		});
		
	</script>

<%@ include file="../layout/footer.jsp"%>

