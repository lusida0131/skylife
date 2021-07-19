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

			<div class="col-md-12">
				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">
					<div class="input-group">
						<input class="form-control" id="system-search" name="q"
							placeholder="Search for" required> <span
							class="input-group-btn">
							<button type="submit" class="btn btn-default">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</span>
					</div>
					<c:set var="cnt" value="0" />
					<h1>총매출</h1>

					<%-- <c:forEach var="list" items="${slist}" varStatus="status"> --%>

						<table class="table table-striped">
							<thead>
								<tr>
									<td style="width: 50%">총매출</td>
								</tr>
							</thead>
							<tbody>
								<tr>

									<td><fmt:formatNumber value="${all}"
											pattern="#,###,###" /></td>

								</tr>

							</tbody>
						</table>


					<%-- </c:forEach> --%>

				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
$(document).ready(function(e){
	var idx = false;
	var emx = false;
	$('#signUp').click(function(){
		
        $('#signFrm').submit();
     
	});
	});
</script>
</div>

<br>


<%@ include file="../layout/footer.jsp"%>

