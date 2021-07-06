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
           <!--회원수정섹션-->
            <section class="login">
                <article class="login__form__container">
                  <!-- 아아아아아 -->
                   <!--회원수정 폼-->
                    <div class="login__form">
                        <!--로고-->
                        <h1><img src="${pageContext.request.contextPath}/resources/images/sky.png" alt=""></h1>
                         <!--로고end-->
                         
                         <!--회원수정 인풋-->
                        <form class="login__input" action="${pageContext.request.contextPath}/page/memUpdate" method="get"id="loginFrm"name="loginFrm">
                            <input type="text" name="id" id="id" value="${user.id}" readonly>
                            <input type="text" name="name" id="name" value="${user.name}" readonly>
                            <input type="date" name="bday" id="bday" value="${user.bday}" readonly>
                            <input type="email" name="email" id="email" value="${user.email}" readonly>
                            <input type="text" name="phone" id="phone" value="${user.phone}" readonly>
                            <input type = "submit" id = "loginUp" value = "수정 하기">
                        </form>
                        <!--회원수정 인풋end-->
                    </div>
                    <!--회원수정 폼end-->
                </article>
            </section>
        </main>
    </div>
</body>

</html>