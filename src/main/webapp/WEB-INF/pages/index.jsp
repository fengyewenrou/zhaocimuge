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
<head>

  <!-- Meta -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="renderer" content="webkit">
  <title> 朝辞 - 南有乔木，不可休思</title>
  <link rel="shortcut icon" href="<%=basePath%>/img/ico.ico">
  <!-- CSS文件 -->
  <link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet">
  <link href="<%=basePath%>/css/font-awesome.css" rel="stylesheet">
  <link href="<%=basePath%>/css/animate.css" rel="stylesheet">
  <link href="<%=basePath%>/css/style.css" rel="stylesheet">

</head>
<body class="fixed-sidebar full-height-layout gray-bg">
<div id="wrapper">
  <!--左侧导航开始-->
  <nav class="navbar-default navbar-static-side" role="navigation">
    <div class="nav-close"><i class="fa fa-times-circle"></i></div>
    <div class="sidebar-collapse">
      <ul class="nav" id="side-menu">
        <li class="nav-header">
          <div class="dropdown profile-element">
            <span><img alt="image" class="img-circle" style="width: 64px;height: 64px" src="${user.photo}" /></span>
            <a data-toggle="dropdown" class="dropdown-toggle" href="#">
                                <span class="clear">
                               <span class="block m-t-xs"><strong class="font-bold">${user.userName}</strong></span>
                                <span class="text-muted text-xs block"><%--${user.roleName}--%>炒鸡管理员<b class="caret"></b></span>
                                </span>
            </a>
            <ul class="dropdown-menu animated fadeInRight m-t-xs">
              <li><a class="J_menuItem" href="<%=basePath%>/main/${user.userId}/userImage.html">修改头像</a>
              </li>
            <%--  <li><a class="J_menuItem" href="profile.html">个人资料</a>
              </li>
              <li><a class="J_menuItem" href="contacts.html">联系我们</a>
              </li>
              <li><a class="J_menuItem" href="mailbox.html">信箱</a>
              </li>--%>
              <li class="divider"></li>
              <li><a href="<%=basePath%>login.jsp">安全退出</a>
              </li>
            </ul>
          </div>
          <div class="logo-element">朝辞
          </div>
        </li>
    <c:forEach var="item" items="${menuMap}" varStatus="status">
        <li>
            <a href="#"><i class="fa"></i><img src="<%=basePath%>img/${item.key.icon}" width="16px" style="float:left;margin-left: 0px" >
                <span class="nav-label">${item.key.menuName} </span><span class="fa arrow"></span><%--<span class="label label-warning pull-right">16</span>--%></a>
            <ul class="nav nav-second-level">
            <c:forEach var="row" items="${item.value}" varStatus="cnt">
                <li><a class="J_menuItem" href="<%=basePath%>${row.urls}">${row.menuName}</a>
                </li>
            </c:forEach>
            </ul>
        </li>
    </c:forEach>
      </ul>
    </div>
  </nav>
  <!--左侧导航结束-->
  <!--右侧部分开始-->
  <div id="page-wrapper" class="gray-bg dashbard-1">
    <div class="row border-bottom">
      <nav class="navbar navbar-static-top" role="navigation" style="margin-bottom: 0">
         <div class="navbar-header"><a class="navbar-minimalize minimalize-styl-2 btn btn-primary " href="#"><i class="fa fa-bars"></i> </a>
       <%-- <form role="search" class="navbar-form-custom" method="post" action="search_results.html">--%>
          <div class="form-group">

           <%-- <input type="text" placeholder="请输入您需要查找的内容 …" class="form-control" name="top-search" id="top-search">--%>
          </div>
      <%--  </form>--%>
      </div>
      </nav>
    </div>
    <div class="row J_mainContent" id="content-main">
      <iframe class="J_iframe" name="iframe0" width="100%" height="100%" src="<%=basePath%>/main/show.html" frameborder="0" data-id="<%=basePath%>/customer/list.html" seamless></iframe>
      <!--默认主页需在对应的页面显示iframe元素上添加name="iframe0"和data-id="默认主页的url"-->
    </div>
  </div>
  <!--右侧部分结束-->
</div>
<!-- 全局js -->
<script src="<%=basePath%>/js/jquery.min.js?v=2.1.4"></script>
<script src="<%=basePath%>/js/bootstrap.min.js?v=3.3.6"></script>
<script src="<%=basePath%>/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="<%=basePath%>/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>
<script src="<%=basePath%>/js/plugins/layer/layer.min.js"></script>

<!-- 自定义js -->
<script src="<%=basePath%>/js/hplus.js?v=4.1.0"></script>
<script type="text/javascript" src="<%=basePath%>/js/contabs.js"></script>

<!-- 第三方插件 -->
<script src="<%=basePath%>/js/plugins/pace/pace.min.js"></script>

</body>
