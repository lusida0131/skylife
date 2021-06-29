<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Photogram</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/instaStyle.css">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/insta.svg">
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
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
                        <h1><img src="${pageContext.request.contextPath}/resources/images/sky.png" alt=""></h1>
                        
                        <!--로그인 인풋-->
                        <form class="login__input" action="/auth/loginForm" method="post"id="signFrm">
                            <input type="text" name="id" placeholder="아이디"id="id">
                       		<input type="password" name="pw" placeholder="비밀번호"id="pw">
                            <input type="submit" id = "signUp"value="로그인" >
                        </form>
                        <!--로그인 인풋end-->
                        
                        <!-- 또는 -->
                        <div class="login__horizon">
                            <div class="br"></div>
                            <div class="or">또는</div>
                            <div class="br"></div>
                        </div>
                        <!-- 또는end -->
                        
                        <!-- Oauth 소셜로그인 -->
                        <div class="login__facebook">
                        <a href="/oauth2/authorization/facebook">
                            <button>
                                <i class="fab fa-facebook-square"></i>
                             
                                <span>Facebook으로 로그인</span>
                                
                            </button>
                         </a>
                        </div>
                        <!-- Oauth 소셜로그인end -->
                    </div>
                    
                    <!--계정이 없으신가요?-->
                    <div class="login__register">
                        <span>계정이 없으신가요?</span>
                        <a href="../auth/joinForm">가입하기</a>
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
</script>
</html>