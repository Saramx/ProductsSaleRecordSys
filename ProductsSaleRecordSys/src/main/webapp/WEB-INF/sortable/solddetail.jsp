<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>销售详情</title>
<%@include file="common/head.jsp" %>
</head>

<body>
<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading text-center">
			<h2>销售详情</h2>
		</div>
		<div class="panel-body" id="example">
			<table id="detailTable" class="table table-hover">
				<thead>
					<tr>
						<th>销售ID</th>
						<th>产品ID</th>
						<th>产品名</th>
						<th>销售时间</th>
						<th>销售数量</th>
						<th>价格</th>
						<th>购买者</th>
						<th>生产时间</th>
						<th>产品类型</th>
						<th>备注</th>					
					</tr>			
				</thead>
				<tbody>				
						<c item="products">
							<tr>
								<td>${products.soldId}</td>
								<td>${products.proId}</td>
								<td>${products.proName}</td>
								<td>${products.soldTime}</td>
								<td>${products.soldNum}</td>
								<td>${products.price}</td>
								<td>${products.purchaser}</td>	
								<td>${products.proTime}</td>
								<td>${products.proType}</td>
								<td>${products.remark}</td>							
							</tr>
						</c>
				</tbody>
			</table>			
		</div>
	</div>
</div>

<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
<!--  Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>