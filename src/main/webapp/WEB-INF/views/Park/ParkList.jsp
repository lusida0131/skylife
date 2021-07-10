<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css"/>
<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<!-- <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script> -->
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

<c:set var="pname" value="${pname}"/>
<div class="container">
<h1>${pname}</h1>
<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">구역</th>
      <th scope="col">총 주차공간</th>
      <th scope="col">남은 주차공간</th>
      <th scope="col">업데이트 시간</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="plist" items="${plist}">
    <tr class="table-info">
      <th scope="row">${plist.parkingAirportCodeName}</th>
      <td>${plist.parkingFullSpace}</td>
      <td>
      <c:if test="${(plist.parkingFullSpace - plist.parkingIstay) <= 0}">만차</c:if>
      <c:if test="${(plist.parkingFullSpace - plist.parkingIstay) > 0}"> ${plist.parkingFullSpace - plist.parkingIstay}</c:if>
      </td>
      <fmt:parseDate value="${plist.parkingGettime}" var="dateTime" pattern="HH:mm:ss" />
      <%-- <td>${plist.parkingGettime}</td> --%>
      <td><fmt:formatDate value="${dateTime}" pattern="HH시mm분"/></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</div>

<%@ include file="../layout/footer.jsp"%>