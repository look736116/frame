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
<title>交易信息</title>

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
		   		<span class="label label-primary">交易记录</span>
		   </h3> 	      
		</div>
			
			<div class="col-lg-3 col-md-3 col-sm-3 ">
				<div class="input-group input-group-sm">
					<span class="input-group-addon"><b>区服</b></span> <select
						class="form-control" id="tradeServer">
						<option value="全部区服">全部区服</option>
						<option value="一梦十年">一梦十年</option>
						<option value="守望江湖">守望江湖</option>
						<option value="在水一方">在水一方</option>
						<option value="铜锣湾">铜锣湾</option>
					</select>
				</div>
			</div>
			<div class="col-lg-3 col-md-3col-sm-3 ">
				<div class="input-group input-group-sm">
					<span class="input-group-addon"><b>月份</b></span> 
					<select	class="form-control" id="tradeMonth">
						<option value="0">全部</option>
						<option value="1月">1</option>
						<option value="2月">2</option>
						<option value="3月">3</option>
						<option value="4月">4</option>
						<option value="5月">5</option>
						<option value="6月">6</option>
						<option value="7月">7</option>
						<option value="8月">8</option>
						<option value="9月">9</option>
						<option value="10月">10</option>
						<option value="11月">11</option>
						<option value="12月">12</option>					
					</select>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 ">
				<div class="input-group input-group-sm">
					<span class="input-group-addon"><b>每页最大数</b></span> 
					<select class="form-control" id="maxResults">
						<option value="5">5</option>
						<option value="10">10</option>
						<option value="20">20</option>
						<option value="50">50</option>
						<option value="100">100</option>
					</select>
				</div>
			</div>
			<div class="col-lg-3 col-md-3 col-sm-3 ">
				<div class="input-group input-group-sm">
					<span class="input-group-addon"><b>RMB数</b></span> 
					<select class="form-control" id="moneyNum">
						<option value="0">全部</option>
						<option value="100">100</option>
						<option value="202">200</option>
						<option value="500">500</option>
						<option value="1000">1000</option>
					</select>
				</div>
			</div>
		</div>
		<br>
	
	<table class="table table-bordered table-striped text-center table-condensed table-hover" id="tradeList">
   <thead >
      <tr >
         <th class="text-center">序号</th>
         <th class="text-center">区服</th>        
         <th class="text-center">元宝</th>
         <th class="text-center">RMB</th>
         <th class="text-center">时间</th>
         <th class="text-center">备注</th>
      </tr>
   </thead>
   <tbody></tbody>
   </table>   
   		<!-- pagination -->
		<div class="row text-center" style="margin: -35px 0px -20px 0px" >
			<ul class="pagination pagination-md " >
				<li id="firstPage"><a>First</a></li>
				<li id="previousPage"><a>Previous</a></li>
				<li class="disabled"><a>第<san id="currentPage" ></san>/<san id="pagesNum"></san>页</a></li>
				<li id="nextPage"><a>Next</a></li>
				<li id="lastPage"><a>Last</a></li>
				<li>&nbsp;&nbsp;跳到第&nbsp;&nbsp;<input type="text" id ="jumpPage" style="width: 30px;">&nbsp;&nbsp;页
				</li>
				<li><button type="button" class="btn btn-primary btn-sm"
						id="toPage">确定</button></li>

			</ul>
		</div>
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
		<script	src="<%=path%>/js/tradeDetails.js"></script>
		
	</div>
</body>
</html>