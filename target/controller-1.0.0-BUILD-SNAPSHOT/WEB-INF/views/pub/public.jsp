<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ include file="../layout/header.jsp"%>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/tailwindcss/dist/tailwind.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/public.css">
	
	<div class="w-full md:w-3/5 mx-auto p-8" style="padding-top:30px; padding-bottom:30px;">
		<h1 style="margin:10px 5px;">SkyLife의 공지사항</h1>
		<hr><br>
		<c:if test="${user.id == 'admin'}">
			<input type="button" value="공지사항 등록" onclick="location.href='/pub/register'" class="btn btn-secondary mb-3">
		</c:if>
		<div class="shadow-md">
			<c:forEach var="pub" items="${list }">
				<div class="tab w-full overflow-hidden border-t" style="margin-bottom: 10px;">
					<input class="absolute opacity-0 " id="tab-multi-${pub.pno }" type="checkbox" name="tabs">
					<label class="block p-5 leading-normal cursor-pointer" for="tab-multi-${pub.pno }">${pub.p_title } ${pub.p_time }</label>
					<div class="tab-content overflow-hidden border-l-2 bg-gray-100 border-indigo-500 leading-normal ">
						<p class="p-5">${pub.p_content }</p>
						<c:if test="${user.id == 'admin'}">
							<input type="button" value="공지사항 수정/삭제" onclick="location.href='/pub/modify?pno=<c:out value="${pub.pno}" />'" class="btn btn-secondary mb-3">
						</c:if>
					</div>
				</div>
			</c:forEach>
		</div>
		<br><br>
	</div>


<script>

	/* Optional Javascript to close the radio button version by clicking it again */
	var myRadios = document.getElementsByName('tabs2');
	var setCheck;
	var x = 0;
	for(x = 0; x < myRadios.length; x++){
		myRadios[x].onclick = function(){
			if(setCheck != this){
				setCheck = this;
			}else{
				this.checked = false;
				setCheck = null;
			}
		};
	}
	
</script>


<%@ include file="../layout/footer.jsp"%>
