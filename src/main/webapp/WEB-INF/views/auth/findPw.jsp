<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="google-signin-scope" content="profile email">
	<meta name="google-signin-client_id" content="11264373594-v17ti619msdqg94fdh10l60c157u3tl5.apps.googleusercontent.com">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>SkyLife - with Happy Life</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/instaStyle.css">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/insta.svg">
	<link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
		integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
	<script src="https://apis.google.com/js/platform.js" async defer></script>
	
	<style>
		div.abcRioButton {
			margin: 0 auto;
		}
	</style>
</head>

<body>
	<div class="container">
		<main class="loginMain">
			<!--로그인섹션-->
			<section class="login">
				<!--로그인박스-->
				<article class="login__form__container">
					<!--로그인 폼-->
					<div class="login__form">
						<h1><a href="/"><img src="${pageContext.request.contextPath}/resources/images/sky.png" alt=""></a></h1>

						<!--로그인 인풋-->
						<form class="login__input" action="/auth/loginForm" method="post" id="signFrm">
							<input type="text" name="id" placeholder="아이디" id="id">
							<input type="email" class="email_input" name="email" required="/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)?$/i" placeholder="이메일" id="email">
							<input type="submit" class="sendPW" id="signUp" value="비밀번호 찾기">
						</form>
						<!--로그인 인풋end-->
						<br>
						<!--계정이 없으신가요?-->
						<div class="login__register" style="border: 0px solid rgba(0, 0, 0, 0)">
							<span>계정이 있으신가요?</span> <a href="/auth/loginForm">로그인</a><br>
							<span>계정이 없으신가요?</span> <a href="../auth/joinForm">가입하기</a>
						</div>
						<!--계정이 없으신가요?end-->
					</div>
				</article>
			</section>
		</main>
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function(e){
		var code = "";
		$('#signUp').click(function(){
			if($.trim($('#id').val()) == ''){
				alert("아이디 입력.");
				$('#id').focus();
				return;
			}else if($.trim($('#email').val()) == ''){
				alert("이메일 입력.");
				$('#email').focus();
				return;
			}else{
				$('#signFrm').submit();
			}
		});
		
		/* 인증번호 이메일 전송*/
        $(".sendPW").click(function() {
           var email = $(".email_input").val();    // 입력한 이메일
           
           $.ajax({
              type:"GET",
              url:"emailPW?email=" + email,
              success:function(data) {
                 console.log("data : " + data)
                 code = data;
              }
           });
        });
		
	});
</script>

</html>