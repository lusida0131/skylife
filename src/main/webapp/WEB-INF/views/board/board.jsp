<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css" />
<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

	

	<div class="container" style="margin-top:30px; margin-bottom:30px;">
		<div class="table-responsive">
			<div class="col-md-3" style="float: right">
				<form action="#" method="get">
					<div class="input-group"></div>
				</form>
				<div class="input-group">
					<input class="form-control" id="system-search" name="q" placeholder="Search for" required>
					<span class="input-group-btn">
						<button type="submit" class="btn btn-default">
							<i class="glyphicon glyphicon-search"></i>
						</button>
					</span>
				</div>
			</div>
			<c:if test="${user.id != null || user.id == 'admin'}">
				<button type="button" id="btnWrite" style="float: right" class="btn btn-sm btn-primary">글쓰기</button>
			</c:if>
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
					<c:forEach var="BoardVO" items="${list}">
						<tr>
							<td>${BoardVO.b_num}</td>
							<td><a href="${pageContext.request.contextPath}/page/boardView?b_num=${BoardVO.b_num}">${BoardVO.b_title}</a></td>
							<td>${BoardVO.id}</td>
							<td><fmt:formatDate value="${BoardVO.time}" pattern="yyyy-MM-dd HH:mm:ss" /></td>
							<td>${BoardVO.rcount}</td>
						</tr>
					</c:forEach>
				</table>
				
				<div class='pull-right'>
					<ul class="pagination">
						<c:if test="${pageMaker.prev}">
							<li class="paginate_button previous">
								<a href="${pageMaker.startPage - 1}">Previous</a>
							</li>
						</c:if>
						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<!-- 현재 페이지를 구별하기 -->
							<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""} ">
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>
						<c:if test="${pageMaker.next}">
							<li class="paginate_button next">
								<a href="${pageMaker.endPage + 1}">Next</a>
							</li>
						</c:if>
					</ul>
				</div>
				<form id='actionForm' action="/board/board" method='get'>
					<input type='hidden' name='pageNum' value='${pageMaker.cri.pageNum}'>
					<input type='hidden' name='amount' value='${pageMaker.cri.amount}'>
					<input type='hidden' name='type' value='<c:out value="${ pageMaker.cri.type }"/>'>
					<input type='hidden' name='keyword' value='<c:out value="${ pageMaker.cri.keyword }"/>'>
				</form>
			</div>
		</div>
	</div>
	


<script>
	
	$(document).ready(function() {
		$("#btnWrite").click(function() {
			// 페이지 주소 변경(이동)
			location.href = "${pageContext.request.contextPath}/page/boardWrite";
		});
	});
	
</script>


<script>

	$("#regBtn").on("click", function() {	// 등록 버튼이 눌리면 function()이 실행됨 : 버튼 이벤트 등록
		self.location = "/page/boardWrite";
	});
	
	
	var actionForm = $("#actionForm");
	$(".paginate_button a").on("click", function(e) {
	  e.preventDefault();
	  console.log('click');
	  actionForm.find("input[name='pageNum']").val($(this).attr("href"));
	  actionForm.submit();
	});
	
	
	$(".move").on("click", function(e) {	// read 버튼 처리
		e.preventDefault();
		actionForm.append("<input type='hidden' name='b_num' value='"
			+ $(this).attr("href") + "'>");	// this : <a 링크
		actionForm.attr("action", "/page/board");
		actionForm.submit();
	});


</script>


<%@ include file="../layout/footer.jsp"%>
