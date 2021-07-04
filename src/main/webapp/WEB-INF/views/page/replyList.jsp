<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="width:700px">
			<c:forEach var="row" items="${list }">
				<tr>
					<td>
						${row.id }(<fmt:formatDate value="${row.time }" pattern="yyyy-MM-dd HH:mm:ss"/>)
						<br>
						${row.r_content }
					</td>
				</tr>
			</c:forEach>
			
		</table>
</body>
</html>