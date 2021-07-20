<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SkyLife - with Happy Life</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/instaStyle.css">
<%--     <link rel="shortcut icon" href="${pageContext.request.contextPath}/""">  인터넷창 로고 --%> 
    <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
        integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p" crossorigin="anonymous" />
</head>

<body>
    <div class="container">
        <main class="loginMain">
           <!--회원수정섹션-->
            <section class="login">
                <article class="login__form__container">
                   <!--회원수정 폼-->
                    <div class="login__form">
                        <!--로고-->
                        <h1><a href="/"><img src="${pageContext.request.contextPath}/resources/images/sky.png" alt=""></a></h1>
                         <!--로고end-->
                         <!--회원수정 인풋-->
                        <form class="login__input" action="/memPWUpdate" method="post" id="puFrm" name="puFrm">
                            <input type="hidden" name="id" id="id" value="${user.id}">
                            <input type="password" name="pw1" id="pw1" placeholder="현재 비밀번호" style="background-color:#ccffff;">
                            <input type="password" name="pw2" id="pw2" placeholder="변경할 비밀번호" style="background-color:#ccffff;">
                            <input type="password" name="pw3" id="pw3" placeholder="변경 비밀번호 확인" style="background-color:#ccffff;">
                            <br><br><input type="button" id="puBtn" name="puBtn" value="비밀번호 변경">
                            <!-- <button name="puBtn">비밀번호 변경</button> --> <br>
                        </form>
                        <!--회원수정 인풋end-->
                    </div>
                    <!--회원수정 폼end-->
                </article>
            </section>
        </main>
    </div>
</body>

<script type="text/javascript">

	$(document).ready(function(e) {
		$('#puBtn').click(function() {
			if ($.trim($('#pw1').val()) === '') {
				alert("현재 비밀번호를 입력해주세요.");
				$('#pw1').focus();
				return;
			} else if ($.trim($('#pw2').val()) === '') {
				alert("변경할 비밀번호를 입력해주세요.");
				$('#pw2').focus();
				return;
			} else if ($.trim($('#pw3').val()) === '') {
				alert("변경할 비밀번호 확인용을 입력해주세요.");
				$('#pw3').focus();
				return;
			} else if ($.trim($('#pw2').val()) != $.trim($('#pw3').val())) {
				alert("변경할 비밀번호가 일치하지 않습니다.");
				$('#pw2').focus();
				return;
			} else {
				$('#puFrm').submit();
			}
		});
	});
		
</script>

</html>