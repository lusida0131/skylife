<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="google-signin-scope" content="profile email">
<meta name="google-signin-client_id"
	content="11264373594-v17ti619msdqg94fdh10l60c157u3tl5.apps.googleusercontent.com">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Photogram</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/instaStyle.css">
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/images/insta.svg">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
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
						<h1>
							<a href="/page/index"><img
								src="${pageContext.request.contextPath}/resources/images/sky.png"
								alt=""></a>
						</h1>

						<!--로그인 인풋-->
						<form class="login__input" action="/auth/loginForm" method="post"
							id="signFrm">
							<input type="text" name="id" placeholder="아이디" id="id"> <input
								type="password" name="pw" placeholder="비밀번호" id="pw"> <input
								type="submit" id="signUp" value="로그인">
						</form>
						<button>
							<a href="${pageContext.request.contextPath}/page/findID">ID
								찾기</a>
						</button>
						<button>
							<a href="${pageContext.request.contextPath}/page/findPw">PW
								찾기</a>
						</button>
						<!--로그인 인풋end-->

						<!-- 또는 -->
						<div class="login__horizon">
							<div class="br"></div>
							<div class="or">또는</div>
							<div class="br"></div>
						</div>
						<!-- 또는end -->

						<!-- Oauth 소셜로그인 -->
						<div class="text-center">
							<br>
							<div class="g-signin2" data-width="240" data-longtitle="true"
								data-onsuccess="onSignIn"></div>
							<a
								href="https://kauth.kakao.com/oauth/authorize?client_id=c4f3e60f17766b60ae9f4c4957c155f7&redirect_uri=http://localhost:8080/page/index&response_type=code"><br>
							<img width="220" alt="Kakao Login"
								src="/resources/images/kakao_login_medium_narrow.png"></a>
						</div>
						<!-- Oauth 소셜로그인end -->

					</div>

					<!--계정이 없으신가요?-->
					<div class="login__register">
						<span>계정이 없으신가요?</span> <a href="../auth/joinAgree">가입하기</a>
					</div>

					<!--계정이 없으신가요?end-->
				</article>
			</section>
		</main>
	
	
	</div>
</body>

<script type="text/javascript">
	$(document).ready(function(e){
		
		var idx=false;
		
		$('#signUp').click(function(){
			if($.trim($('#id').val()) == ''){
				alert("아이디 입력.");
				$('#id').focus();
				return;
			}else if($.trim($('#pw').val()) == ''){
				alert("패스워드 입력.");
				$('#pw').focus();
				return;
			}else{
				$('#signFrm').submit();
			}
		});

	});
     
	function onSignIn(googleUser) {
        // Useful data for your client-side scripts:
        var profile = googleUser.getBasicProfile();
        console.log("ID: " + profile.getId()); // Don't send this directly to your server!
        console.log('Full Name: ' + profile.getName());
        console.log('Given Name: ' + profile.getGivenName());
        console.log('Family Name: ' + profile.getFamilyName());
        console.log("Image URL: " + profile.getImageUrl());
        console.log("Email: " + profile.getEmail());

        // The ID token you need to pass to your backend:
        var id_token = googleUser.getAuthResponse().id_token;
        console.log("ID Token: " + id_token);
        location.href="index";
      }
</script>
</html>