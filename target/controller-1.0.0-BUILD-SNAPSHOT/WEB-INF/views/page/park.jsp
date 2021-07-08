<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../layout/header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/board.css"/>
<script src="${pageContext.request.contextPath}/resources/js/board.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>


	<div class="container">
		<div class="row">
		
			<div class="col-md-3" style="float:right">
				<div class="input-group">
	                   <input class="form-control" id="system-search" name="q" placeholder="Search for" required>
	                    <span class="input-group-btn">
	                        <button type="submit" class="btn btn-default"><i class="glyphicon glyphicon-search"></i></button>
	                    </span>
				</div>
			</div>
			
			<div class="col-md-9">
				<table class="table table-list-search">
					<thead>
						<tr>
							<th>공항명</th>
							<th>주차장명</th>
							<th>주차가능차량</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>공항이름~</td>
							<td>주차장이름~</td>
							<td>주차가능차량수~</td>
						</tr>
					</tbody>
				</table>   
			</div>
			
		</div>
	</div><br>



<%@ include file="../layout/footer.jsp"%>
