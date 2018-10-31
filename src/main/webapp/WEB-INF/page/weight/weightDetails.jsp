<%@page import="com.my.momel.Trade"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();	
%>

<!DOCTYPE html>
<html>
<head>
<title>体重记录</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<!-- 为了让 Bootstrap 开发的网站对移动设备友好，确保适当的绘制和触屏缩放，需要在网页的 head 之中添加 viewport meta 标签 -->
<!-- 通常情况下，maximum-scale=1.0 与 user-scalable=no 一起使用。这样禁用缩放功能后，用户只能滚动屏幕，就能让您的网站看上去更像原生应用的感觉。 -->
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<!-- 新 Bootstrap 核心 CSS 文件 -->
<link href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css"	rel="stylesheet">
<link href="<%=path%>/css/main.css" rel="stylesheet">

<link rel="shortcut icon" href="<%=path%>/img/favicon.ico" />
<link rel="bookmark" href="<%=path%>/img/favicon.ico" type="image/x-icon" />
<script>
var path='<%=path%>';
</script>
</head>
<body>
	<div class="container">
		<c:import url="/common/header" />
		<div class="row">
		<div class="row text-center">
		   <h3>
		   		<span class="label label-primary">体重记录</span>
		   </h3> 	      
		</div>
			
			<div class="col-lg-4 col-md-4 col-sm-4 ">				
			</div>			
			<div class="col-lg-4 col-md-4 col-sm-4 ">
				<div class="input-group input-group-sm">
					<span class="input-group-addon"><b>姓名</b></span> 
					<select class="form-control" id="recordName">
						<option value="全部">全部</option>
						<option value="闹闹">闹闹</option>
						<option value="光光">光光</option>
						<option value="球球">球球</option>
						<option value="肉肉">肉肉</option>
					</select>
				</div>
			</div>
			<div class="col-lg-4 col-md-4 col-sm-4 ">				
			</div>
		</div>
		<br>
	
	<table class="table table-bordered table-striped text-center table-condensed table-hover" id="weightList">
   <thead >
      <tr >
         <th class="text-center">序号</th>
         <th class="text-center">姓名</th>        
         <th class="text-center">体重</th>
         <th class="text-center">时间</th>
         <th class="text-center">备注</th>
      </tr>
   </thead>
   <tbody></tbody>
   </table>      		
		<!-- footer -->
		<footer class="row">
   
        <p class="col-lg-1 col-md-1 col-sm-1"></p>
   
        <p class="col-lg-5 col-md-5 col-sm-5 col-xs-12 copyright">©2018-2028 光光工作室管理系统</p>

        <p class="col-lg-5 col-md-5 col-sm-5 col-xs-12 powered-by">Powered by : Look </p>
        
        <p class="col-lg-1 col-md-1 col-sm-1 "></p>
        
    </footer>
		<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
		<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>

		<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
		<script	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
		<!-- 引入外部js 文件 -->
		<script	src="<%=path%>/js/weightDetails.js"></script>
		
	</div>
</body>
</html>