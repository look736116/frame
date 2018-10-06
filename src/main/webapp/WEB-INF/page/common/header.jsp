<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<header class = "row">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">光光工作室</a>
        </div>
        <div class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="<%=path%>/common/main"><span class="glyphicon glyphicon-home"> 主页</span></a></li>
            <li><a href="#" class="dropdown-toggle" data-toggle="dropdown">
              <span class="glyphicon glyphicon-shopping-cart"> 交易管理</span>
            </a>
            <ul class="dropdown-menu">
               <li><a href="<%=path%>/trade/toTradeDetails">交易记录</a></li>
               <li><a href="<%=path%>/trade/toTradeInfo">添加交易</a></li>
               <li><a href="#">修改交易</a></li>               
            </ul>            
           </li>
            <li><a href="#shop"><span class="glyphicon glyphicon-user"> 角色管理</span></a></li>
            <li><a href="#support"><span class="glyphicon glyphicon-book"> 资料管理</span></a></li>
          <li><a href="#support"><span class="glyphicon glyphicon-wrench"> 使用工具</span></a></li>
          </ul>
        </div><!-- /.nav-collapse -->
      </div><!-- /.container -->   
</header>
</body>
</html>



