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
<div class="container">
	<div class="row">
		<div class="col-md-12">
			

			<div class="col-md-12">
				<div class="panel-group" id="accordion" role="tablist"
					aria-multiselectable="true">
					<h1>총매출</h1>


					<table class="table table-striped">
						<thead>
							<tr>
								<fmt:parseDate value='${date}' var='trading_day'
									pattern='yyyy-mm-dd' />
								<td><fmt:formatDate pattern="yyyy-mm"
										value="${trading_day}" /> 월매출</td>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td><fmt:formatNumber value="${all}" /></td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(e) {
			var idx = false;
			var emx = false;
			$('#signUp').click(function() {
				$('#signFrm').submit();
			});
		});
	</script>
</div>
<br><br><br><br><br><br><br><br><br>


<%@ include file="../layout/footer.jsp"%>

