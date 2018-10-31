<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<title>主页</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 为了让 Bootstrap 开发的网站对移动设备友好，确保适当的绘制和触屏缩放，需要在网页的 head 之中添加 viewport meta 标签 -->
<!-- 通常情况下，maximum-scale=1.0 与 user-scalable=no 一起使用。这样禁用缩放功能后，用户只能滚动屏幕，就能让您的网站看上去更像原生应用的感觉。 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<link href="<%=path%>/css/main.css"
	rel="stylesheet">

<link rel="shortcut icon" href="<%=path%>/img/favicon.ico" />
<link rel="bookmark" href="<%=path%>/img/favicon.ico" type="image/x-icon"/>
</head>
<body>
<div class="container">
	<c:import url="/common/header" />
	<div class="text-center" style="margin:100px 0px">
	   <div class="btn-group btn-group-lg">
	  	<button type="button" class="btn btn-primary " id ="tradeInfo">交易记录</button>
	    <button type="button" class="btn btn-primary ">监控查询</button>
	  	<button type="button" class="btn btn-primary ">角色信息</button>
	  </div>
   </div>
	
	<c:import url="/common/footer" />

	<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
	<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

	<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
	<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

	<!-- 引入外部的js文件-->
	<script src="<%=path%>/js/main.js"></script>

</div>
</body>
</html>