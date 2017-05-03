<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<c:if test="${empty list }">
			<h1>没有任何订单！</h1>
		</c:if>
		<c:if test="${!empty list }">
		<table id="myTable" class="table table-hover">
				<thead>
					<tr>
						<th axis="number">soldid</th>
						<th axis="string">proname</th>
						<th axis="date">soldtime</th>
						<th axis="number">soldnum</th>
						<th axis="number">price</th>
					    <th axis="string">purchaser</th>
						<th>详情页</th>
					</tr>			
				</thead>
				<tbody>
						<c:forEach items="${list}" var="p">
							<tr>
								<td>${p.soldId}</td>
								<td>${p.proName}</td>
								<td><fmt:formatDate value="${p.soldTime}" pattern="yyyy-MM-dd" /></td>
								<td>${p.soldNum}</td>
								<td>${p.price}</td>
								<td>${p.purchaser}</td>
								
							</tr>
						</c:forEach>
				</tbody>
			</table>
		</c:if>
	
</body>
</html>