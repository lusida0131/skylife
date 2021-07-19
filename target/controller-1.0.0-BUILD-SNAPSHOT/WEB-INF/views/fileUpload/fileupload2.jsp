<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


 <div class="py-5 text-center">
   <h2>게시판</h2>
 </div>
    
      
 <div style="margin:10% 10% 10% 10%;">
   <!--  파일첨부 -->
    <form  action="/fileTest/fileupload" method="post"  enctype="multipart/form-data">
       <input type="file" name="file" multiple>
       <input class="filebtn"  type="submit" value="업로드"/>
    </form>
 </div>


<%@ include file="../layout/footer.jsp"%>