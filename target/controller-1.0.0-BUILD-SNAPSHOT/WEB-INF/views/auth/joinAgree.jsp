<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/joinAgree.css">

	<br>
	<form action="/auth/joinForm" id="joinForm" name="joinForm" onSubmit="return CheckForm(this)">
		<ul class="join_box">
			<li class="checkBox check01">
				<ul class="clearfix">
					<li>이용약관, 개인정보 수집 및 이용, 위치정보 이용약관(선택), 프로모션 안내 메일 수신(선택)에 모두 동의합니다.</li>
					<li class="checkAllBtn"><input type="checkbox" name="chkAlled" onclick='selectAll(this)'></li>
				</ul>
			</li>
			<li class="checkBox check02">
				<ul class="clearfix">
					<li>1.이용약관 동의(필수)</li>
					<li class="checkBtn"><input type="checkbox" name="chk" id="chk1" onclick='checkSelectAll(this)'></li>
				</ul>
				<textarea name="" id="">여러분을 환영합니다. 스카이스캐너 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 스카이스캐너 서비스의 이용과 관련하여 스카이스캐너 서비스를 제공하는 스카이스캐너 주식회사(이하 ‘스카이스캐너’)와 이를 이용하는 스카이스캐너 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 스카이스캐너 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
				</textarea>
			</li>
			<li class="checkBox check03">
				<ul class="clearfix">
					<li>2.개인정보 수집 및 이용에 대한 안내(필수)</li>
					<li class="checkBtn"><input type="checkbox" name="chk" id="chk2" onclick='checkSelectAll(this)'></li>
				</ul>
				<textarea name="" id="">여러분을 환영합니다. 스카이스캐너 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 스카이스캐너 서비스의 이용과 관련하여 스카이스캐너 서비스를 제공하는 스카이스캐너 주식회사(이하 ‘스카이스캐너’)와 이를 이용하는 스카이스캐너 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 스카이스캐너 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
	       		</textarea>
			</li>
			<li class="checkBox check03">
				<ul class="clearfix">
					<li>3.위치정보 이용약관 동의(선택)</li>
					<li class="checkBtn"><input type="checkbox" name="chk" onclick='checkSelectAll(this)'></li>
				</ul>
				<textarea name="" id="">여러분을 환영합니다. 스카이스캐너 서비스 및 제품(이하 ‘서비스’)을 이용해 주셔서 감사합니다. 본 약관은 다양한 스카이스캐너 서비스의 이용과 관련하여 스카이스캐너 서비스를 제공하는 스카이스캐너 주식회사(이하 ‘스카이스캐너’)와 이를 이용하는 스카이스캐너 서비스 회원(이하 ‘회원’) 또는 비회원과의 관계를 설명하며, 아울러 여러분의 스카이스캐너 서비스 이용에 도움이 될 수 있는 유익한 정보를 포함하고 있습니다.
				</textarea>
			</li>
			<li class="checkBox check04">
				<ul class="clearfix">
					<li>4.이벤트 등 프로모션 알림 메일 수신(선택)</li>
					<li class="checkBtn"><input type="checkbox" name="chk" onclick='checkSelectAll(this)'></li>
				</ul>
	
			</li>
		</ul>
		<ul class="footBtwrap clearfix">
			<li><button class="fpmgBt1">비동의</button></li>
			<li><button class="fpmgBt2">동의</button></li>
		</ul>
	</form>
</body>


	<script type="text/javascript">
		
		function CheckForm(Join) {
			var chk1=document.joinForm.chk1.checked;
			var chk2=document.joinForm.chk2.checked;
		        
			if(!chk1){
				alert('1.이용약관 동의(필수)에 동의해주세요');
				return false;
			} 
			if(!chk2) {
				alert('2.개인정보 수집 및 이용에 대한 안내(필수)에 동의해주세요');
				return false;
			}
		}
		
		function checkSelectAll(checkbox)  {
			const selectall = document.querySelector('input[name="chkAlled"]');
		
			if(checkbox.checked === false)  {
				selectall.checked = false;
			}
		}
		
		function selectAll(selectAll)  {
			const checkboxes = document.getElementsByName('chk');
			
			checkboxes.forEach((checkbox) => {
				checkbox.checked = selectAll.checked
			})
		}
		
	</script>

</html>
