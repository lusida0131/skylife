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
                   <!--회원가입 폼-->
                    <div class="login__form">
                        <!--로고-->
                        <h1><a href="/page/index" ><img src="${pageContext.request.contextPath}/resources/images/sky.png" alt=""></a></h1>
                         <!--로고end-->
                         
                         <!--회원가입 인풋-->
                        <form class="login__input" action="/auth/joinForm" method="post"id="signFrm"name="signFrm">
                            <input type="text" name="id" placeholder="아이디" required="required" id="id">
                            <input type = "button" id="check" value = "중복체크">
                            <input type="password" name="pw" placeholder="패스워드" required="required" id="pw">
                            <input type="text" name="name" placeholder="이름" required="required" id="name">
                            <input type="date" name="bday" placeholder="생년월일" required="required" id="bday">
                            <input class="mail_input" type="email" name="email" placeholder="이메일" required="required" id="email">
                            <input type = "button" id="echeck" value = "중복체크">
                            <div class="mail_check_wrap">
                            	<div class="mail_check_input_box" id="mail_check_input_box_false">
                            		<input class="mail_check_input" id="mail_check_input" disabled="disabled">
                            	</div>
                            	<div class="mail_check_button">
                            		<input type="button" value="인증번호 전송">
                            	</div>
                            	<div class="clearfix"></div>
                            	<span id="mail_check_input_box_warn"></span>
                            </div>
                            <input type="text" name="phone" placeholder="전화번호" required="required" id="phone">
                            <input type="button" id="signUp" value="회원가입">
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
	var code = "";
   
	$(document).ready(function(e){
		var idx = false;
		var emx = false;
		$('#signUp').click(function(){
	         if($.trim($('#id').val()) == ''){ 
	            alert("아이디를 입력해주세요.");
	            $('#id').focus();
	            return;
	         }else if($.trim($('#pw').val()) == ''){
	            alert("패스워드를 입력해주세요.");
	            $('#pw').focus();
	            return;
	         }else if($.trim($('#email').val()) == ''){
	            alert("이메일을 입력해주세요.");
	            $('#email').focus();
	            return;
	         }else if($.trim($('#name').val()) == ''){
	            alert("이름을 입력 해주세요.");
	            $('#name').focus();
	            return;
	         }else if($.trim($('#mail_check_input').val()) == ''){
	            alert("인증번호를 입력 해주세요.");
	            $('#mail_check_input').focus();
	            return;
	         }else if(idx==false){
	            alert("아이디 중복체크를 해주세요.");
	            return;
	         }else if(emx==false){
		            alert("이메일 중복체크를 해주세요.");
		            return;
	         }else if($.trim($('#mail_check_input').val()) != code) {
	            alert("인증번호를 확인해주세요.")
	            return;
	         }
	         else{
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
		// 이메일 중복 체크
		$('#echeck').click(function(){
	         $.ajax({
	            url: "${pageContext.request.contextPath}/emailhave",
	            type: "GET",
	            data:{
	               "email":$('#email').val()
	            },
	            success: function(data){
	               if(data == 0 && $.trim($('#email').val()) != '' ){
	                  emx=true;
	                  alert("사용 가능한 이메일 입니다.")
	               }else{
	                  alert("이미 가입된 이메일 입니다.")
	               }
	            },
	            error: function(){
	               alert("서버에러");
	            }
	         });
		});
      
		/* 인증번호 이메일 전송*/
        $(".mail_check_button").click(function() {
           var email = $(".mail_input").val();    // 입력한 이메일
           var cehckBox = $(".mail_check_input");   // 인증번호 입력란
           var boxWrap = $(".mail_check_input_box"); // 인증번호 입력란 박스
           
           $.ajax({
              type:"GET",
              url:"mailCheck?email=" + email,
              success:function(data) {
                 console.log("data : " + data)
                 cehckBox.attr("disabled",false);
                 boxWrap.attr("id", "mail_check_input_box_true");
                 code = data;
              }
           });
        });
		
        /* 인증번호 비교 */
        $(".mail_check_input").blur(function() {
        	
        	var inputCode = $(".mail_check_input").val();		// 입력코드
        	var checkResult = $("#mail_check_input_box_warn");	// 비교 결과
        	
        	if(inputCode == code) {
        		checkResult.html("인증번호가 일치합니다.");
        		checkResult.attr("class", "correct");
        	} else {
        		checkResult.html("인증번호를 다시 확인해주세요.");
        		checkResult.attr("class", "incorrect");
        	} 
        });
	});
	
</script>

</html>