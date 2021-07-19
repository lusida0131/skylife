<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


		<div class="container">
			<div class="row" style="margin:20px;">
				<div class="col-md-8 col-md-offset-2 text-center heading-section animate-box" style="margin-top:35px; margin-bottom: 25px;">
					<h3>주차장 목록</h3>
					<p style="margin-bottom: 15px;">실시간 주차장 정보를 조회할 수 있습니다.</p>
				</div>
			</div>
		</div>
		<div id="fh5co-destination">
			<div class="tour-fluid">
				<div class="row">
					<div class="col-md-12">
						<ul id="fh5co-destination-list" class="animate-box">
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/GMP.jpg); border: 1px solid;">
								<a href="/Park/GMPList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/PUS.jpg); border: 1px solid;">
								<a href="/Park/PUSList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/CJU.jpg); border: 1px solid;">
								<a href="/Park/CJUList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/TAE.jpg); border: 1px solid;">
								<a href="/Park/TAEList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>

							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/CJJ.jpg); border: 1px solid;">
								<a href="/Park/CJJList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-half text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/ICN.jpg); border: 1px solid;">
								<a href="/Park/ICNList">
									<div class="case-studies-summary">
									<br><br><br><br><br>
										<span>해당 공항의 주차정보를 알고싶으면 클릭해주세요</span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/KWJ.jpg); border: 1px solid;">
								<a href="/Park/KWJList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/RCU.jpg); border: 1px solid;">
								<a href="/Park/RSUList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/USN.jpg); border: 1px solid;">
								<a href="/Park/USNList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/KUV.jpg); border: 1px solid;">
								<a href="/Park/KUVList">
									<div class="case-studies-summary">
										<br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
							<li class="one-forth text-center" style="background-image: url(${pageContext.request.contextPath}/resources/images/WJU.jpg); border: 1px solid;">
								<a href="/Park/WJUList">
									<div class="case-studies-summary">
										<br><br><br><br><br><br>
										<span>실시간 주차정보 >></span>
									</div>
								</a>
							</li>
						</ul>		
					</div>
				</div>
			</div>
		</div>

<%@ include file="../layout/footer.jsp"%>
