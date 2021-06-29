<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>skyLife</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/instaStyle.css">
<%--     <link rel="shortcut icon" href="${pageContext.request.contextPath}/""">  인터넷창 로고 --%> 
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
</head>
<body>
    <div class="container">
        <main class="loginMain">
           <!--회원가입섹션-->
            <section class="login">
                <article class="login__form__container">
                  <!-- 아아아아아 -->
                   <!--회원가입 폼-->
                    <div class="login__form">
                        <!--로고-->
                        <h1><img src="${pageContext.request.contextPath}/resources/images/sky.png" alt=""></h1>
                         <!--로고end-->
                         <!-- ㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇㅇ -->
                         <!--회원가입 인풋-->
                        <form class="login__input" action="/auth/joinForm" method="post"id="signFrm"name="signFrm">
                            <input type="text" name="id" placeholder="아이디" required="required" id="id">
                            <input type = "button" id="check" value = "중복체크">
                            <input type="password" name="pw" placeholder="패스워드" required="required"id="pw">
                            <input type="text" name="name" placeholder="이름" required="required"id="name">
                               <input type="date" name="bday" placeholder="생년월일" required="required"id="bday">
                            <input type="email" name="email" placeholder="이메일" required="required"id="email">
                               <input type="text" name="phone" placeholder="전화번호" required="required"id="phone">
                            <input type = "button" id = "signUp"value = "회원가입">
                            <input hidden="">
                        </form>
                        <!--회원가입 인풋end-->
                    </div>
                    <!--회원가입 폼end-->
                    
                    <div class="login__register">
                        <span>계정이 있으신가요?</span>
                        <a href="/auth/loginForm">로그인</a>
                    </div>

                    
                </article>
            </section>
        </main>
    </div>
</body>
<script type="text/javascript">
	$(document).ready(function(e){
		
		var idx = false;
		
		$('#signUp').click(function(){
			if($.trim($('#id').val()) == ''){
				alert("아이디 입력.");
				$('#id').focus();
				return;
			}else if($.trim($('#pw').val()) == ''){
				alert("패스워드 입력.");
				$('#pw').focus();
				return;
			}else if($.trim($('#email').val()) == ''){
				alert("이메일 입력.");
				$('#email').focus();
				return;
			}else if($.trim($('#name').val()) == ''){
				alert("이름 입력.");
				$('#name').focus();
				return;
			}
			if(idx==false){
				alert("아이디 중복체크를 해주세요.");
				return;
			}else{
				$('#signFrm').submit();
			}
		});
		
		$('#check').click(function(){
			$.ajax({
				url: "${pageContext.request.contextPath}/idCheck",
				type: "GET",
				data:{
					"id":$('#id').val()
				},
				success: function(data){
					if(data == 0 && $.trim($('#id').val()) != '' ){
						idx=true;
						alert("사용 가능한 아이디 입니다.")
					}else{
						alert("사용 불가능한 아이디 입니다.")
					}
				},
				error: function(){
					alert("서버에러");
				}
			});
		});
	});
</script>
</html>