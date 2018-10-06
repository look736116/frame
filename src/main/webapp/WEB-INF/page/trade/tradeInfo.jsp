<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<title>交易信息</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 为了让 Bootstrap 开发的网站对移动设备友好，确保适当的绘制和触屏缩放，需要在网页的 head 之中添加 viewport meta 标签 -->
<!-- 通常情况下，maximum-scale=1.0 与 user-scalable=no 一起使用。这样禁用缩放功能后，用户只能滚动屏幕，就能让您的网站看上去更像原生应用的感觉。 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=path%>/css/main.css" rel="stylesheet">

<link rel="shortcut icon" href="<%=path%>/img/favicon.ico" />
<link rel="bookmark" href="<%=path%>/img/favicon.ico"
	type="image/x-icon" />
</head>
<body>
	<div class="container">
		<c:import url="/common/header" />
		<div class="row text-center">
		   <h2>
		   		<span class="label label-primary">添加交易</span>
		   </h2> 	      
		</div>
		<br/>
			
			<form class="bs-example bs-example-form" role="form" method="post" action="<%=path%>/trade/saveTradeInfo">
				 
				 <!-- 区服 -->
				 <div class="row">	
				 	<div class="col-lg-4 col-md-4 col-sm-4 "></div>
				 	<div class="col-lg-4 col-md-4 col-sm-4 ">
						<div class="input-group input-group-lg">				
		         			<span class="input-group-addon">区服</span>
		         			<select class="form-control" name="tradeServer">
         						<option value = "一梦十年">一梦十年</option>
         						<option value = "守望江湖">守望江湖</option>
         						<option value = "在水一方">在水一方</option>
         						<option value = "铜锣湾">铜锣湾</option>
      						</select>
		      			</div>
		      		</div>  	
		      		<div class="col-lg-4 col-md-4 col-sm-4 "></div>
		      	</div>
		      	<br>
		     
		     	<!-- 元宝 -->
		     	<div class="row">	
			      	 <div class="col-lg-4 col-md-4 col-sm-4 "></div>
					 <div class="col-lg-4 col-md-4 col-sm-4 ">
						<div class="input-group input-group-lg">				
			         		<span class="input-group-addon">元宝</span>
			         		<input type="text" class="form-control" placeholder="请输入元宝数目" name="tradeCurrency">
			      		</div>
			      	</div>
			      	<div class="col-lg-4 col-md-4 col-sm-4 "></div>
		      	</div>
		      	<br>
		      	 
		      	 <!-- RMB -->
		      	 <div class="row">	
			      	 <div class="col-lg-4 col-md-4 col-sm-4 "></div>
					 <div class="col-lg-4 col-md-4 col-sm-4 ">
						<div class="input-group input-group-lg">				
			         		<span class="input-group-addon">RMB</span>
			         		<input type="text" class="form-control" placeholder="请输入RMB数目" name="tradeMoney">
			      		</div>
			      	</div>
			      	<div class="col-lg-4 col-md-4 col-sm-4 "></div>
		      	</div>
		      	<br>
		      	
		      	<!-- 备注 -->
		      	 <div class="row">	
			      	 <div class="col-lg-4 col-md-4 col-sm-4 "></div>
					 <div class="col-lg-4 col-md-4 col-sm-4 ">
						<div class="input-group input-group-lg">				
			         		<span class="input-group-addon">备注</span>
			         		<input type="text" class="form-control" placeholder="请输入备注" name="tradeComment">
			      		</div>
			      	</div>
			      	<div class="col-lg-4 col-md-4 col-sm-4 "></div>
		      	</div>
		      	<br>
		      	
		      	<!-- 提交和重置 -->
		      	 <div class="row">	
			      	 <div class="col-lg-5 col-md-5 col-sm-5 "></div>
					 <div class="col-lg-1 col-md-1 col-sm-1 ">
						<button type="submit" class="btn btn-success btn-lg">提交</button>
			      	</div>
			      	<div class="col-lg-1 col-md-1 col-sm-1 ">
						<button type="reset" class="btn btn-danger btn-lg">重置</button>
			      	</div>
			      	<div class="col-lg-5 col-md-5 col-sm-5 "></div>
		      	</div>
		      	<br>
			</form>

		<c:import url="/common/footer" />

		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script
			src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	</div>
</body>
</html>