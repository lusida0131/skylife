<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="../layout/header.jsp" %>
    <!-- //로그인 안하면 로그인 페이지로 보내줌 -->
<%--     <%
	if(session.getAttribute("userID") == null) {
		session.setAttribute("loginMsg", "게시물 작성은<br>로그인이 필요합니다.");
		response.sendRedirect("/login");
		return;
	}
%> --%>
	<form action="/pub/register" method="post">
		<%-- <input type="hidden" name="pno" value=${pno }> --%>
		<input type="text" name="p_title" class="form-control mt-4 mb-2"
			placeholder="제목을 입력해주세요." required>
		<div class="form-group">
			<textarea class="form-control" rows="10" name="p_content"
			placeholder="내용을 입력해주세요" required>
			</textarea>
		</div>
		<button type="submit" class="btn btn-secondary mb-3">제출하기</button>
	</form>
	
<%@ include file="../layout/footer.jsp"%>