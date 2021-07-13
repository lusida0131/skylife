<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/anonymous.css">
<!------ Include the above in your HEAD tag ---------->

<div class="container h-80">
<div class="row align-items-center h-100">
    <div class="col-3 mx-auto">
        <div class="text-center">
            <img id="profile-img" class="rounded-circle profile-img-card" src="https://i.imgur.com/6b6psnA.png" />
            <p id="profile-name" class="profile-name-card"></p>
            <form  name="form1" id="form1" class="form-signin" action="/auth/admin">
                
            
                <input type="password" name="password" id="inputPassword" class="form-control form-group" placeholder="password" required autofocus>
                
                <input type="button" class="btn btn-lg btn-primary btn-block btn-signin" id="mem" value="이동 "/>
            </form><!-- /form -->
        </div>
    </div>
</div>
<script type="text/javascript">
$(document).ready(function() {
    $("#mem").click(function() {
     
          document.form1.submit();
      
    });
 });
</script>