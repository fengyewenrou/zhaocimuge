<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="com.zhaoci.share.utils.ApplicationContextUtil" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	String imagePath = ApplicationContextUtil.IMAGE_PATH;
%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0">

	<title>朝辞 - 南有乔木，不可休思</title>
	<link rel="shortcut icon" href="<%=basePath%>/img/ico.ico">
	<link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=basePath%>/css/font-awesome.css?v=4.4.0" rel="stylesheet">
	<link href="<%=basePath%>/css/animate.css" rel="stylesheet">
	<link href="<%=basePath%>/css/style.css" rel="stylesheet">
	<link href="<%=basePath%>/css/login.css" rel="stylesheet">
	<!--[if lt IE 9]>
	<meta http-equiv="refresh" content="0;ie.html" />
	<![endif]-->
	<script>
		if (window.top !== window.self) {
			window.top.location = window.location;
		}
	</script>

</head>

<body class="signin">
<div class="signinpanel">
	<div class="row">
		<div class="col-sm-7">
			<div class="signin-info">
				<%--<div class="logopanel m-b">
					<h1>[ 江南 ]</h1>
				</div>--%>
				<div class="m-b"></div>
				<%--<h4>欢迎使用 <strong>诗酒趁年华</strong></h4>--%>
				<%--<ul class="m-b">
					<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 烟</li>
					<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 雨</li>
					<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 暗</li>
					<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 千</li>
					<li><i class="fa fa-arrow-circle-o-right m-r-xs"></i> 家</li>
				</ul>--%>
				<%--<strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>--%>
			</div>
		</div>
		<div class="col-sm-5">
			<form method="post" action="<%=basePath%>main/index.html">
				<h3 class="no-margins">登录：</h3>
				<%--<p class="m-t-md">登录到诗酒趁年华</p>--%>
				<p class="m-t-md"></p>
				<input type="text" class="form-control uname" name="name"  required="" placeholder="用户名" />
				<input type="password" class="form-control pword m-b"  required="" name="password" placeholder="密码" />
				<%--<a href="#">忘记密码了？</a>&lt;%&ndash;<strong>还没有账号？ <a href="#">立即注册&raquo;</a></strong>&ndash;%&gt;--%>
				<button class="btn btn-success btn-block">登录</button>
				<input type="hidden" name="error" id="error" value="${map.error}"/>
			</form>
		</div>
	</div>
	<div class="signup-footer" style="position: fixed;bottom: 0px">
		<div class="pull-left">
			&copy; 2017 All Rights Reserved.
		</div>
	</div>
</div>
</body>

</html>
