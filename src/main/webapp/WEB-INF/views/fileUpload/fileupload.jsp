<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container">
 <div class="py-5 text-center">
   <h2>게시판</h2>
 </div>
    
      
 <h3>파일이 업로드 되었습니다.</h3>
    <span>${file.originalFilename}</span>
    <br>
    <span>${file.contentType}</span>
 </div>


<%@ include file="../layout/footer.jsp"%>