<%@page language="java" contentType="text/html; charset=UTF-8" %>
<%@include file="common/tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
<title>查询产品ID</title>
<%@include file="common/head.jsp" %>
</head>

<body>
<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading text-center">
			<h2>查询产品ID</h2>
		</div>
		
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th axis="number">销售ID</th>
						<th axis="string">产品名称</th>
						<th axis="String">销售时间</th>
						<th axis="number">销售数量</th>
						<th axis="number">价格</th>
						<th axis="string">购买者</th>	
						<th>详情页</th>				
					</tr>			
				</thead>
				<tbody>
						<c item="products">
							<tr>
								<td>${products.soldId}</td>
								<td>${products.proName}</td>
								<td>${products.soldTime}</td>
								<td>${products.soldNum}</td>
								<td>${products.price}</td>
								<td>${products.purchaser}</td>
								<td>
									<a class="btn btn-info" href="http://localhost:8080/jsp/view/solddetail/${products.soldId}" target="_blank">详情</a>
								</td>						
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