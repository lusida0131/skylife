<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../layout/header.jsp" %>

    <!-- //로그인 안하면 로그인 페이지로 보내줌 -->
    <div style="margin:50px 5px; display:flex; justify-content:center;"><div style="width:75%;">
	    <form action="/pub/register" method="post">
			<%-- <input type="hidden" name="pno" value=${pno }> --%>
			<input type="text" name="p_title" class="form-control mt-4 mb-2" placeholder="공지 제목을 입력해주세요." required>
			<div class="form-group" style="margin:10px 0px;">
				<textarea class="form-control" rows="10" name="p_content" placeholder="내용을 입력해주세요." required></textarea>
			</div>
			<button type="submit" class="btn btn-secondary mb-3">제출하기</button>
		</form>
    </div></div>
	
	
<%@ include file="../layout/footer.jsp"%>