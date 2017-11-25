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
<html>

<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">


  <title>朝辞 - 南有乔木，不可休思</title>
  <link rel="shortcut icon" href="<%=basePath%>/img/ico.ico">
  <link href="<%=basePath%>css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
  <link href="<%=basePath%>css/font-awesome.css?v=4.4.0" rel="stylesheet">
  <link href="<%=basePath%>css/plugins/iCheck/custom.css" rel="stylesheet">
  <link href="<%=basePath%>css/animate.css" rel="stylesheet">
  <link href="<%=basePath%>css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
<div class="ibox-content"  >
  <form class="form-horizontal m-t" id="commentForm" action="<%=basePath%>/menu/update.html">
    <div class="col-md-6">
      <div class="form-group">
        <label class="col-sm-3 control-label">菜单编号：</label>
        <div class="col-sm-5">
          <input id="menuCode" name="menuCode"  type="text"   class="form-control" required="" aria-required="true" value="${menu.menuCode}">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label">菜单名称：</label>
        <div class="col-sm-5">
          <input id="menuName" name="menuName"   type="text"   class="form-control"  value="${menu.menuName}" >
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-group">
        <label class="col-sm-3 control-label">菜单图标：</label>
        <div class="col-sm-5">
          <input id="icon" name="icon"  type="text"   class="form-control"  value="${menu.icon}">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label">菜单层级：</label>
        <div class="col-sm-5">
          <input id="levels" name="levels"   type="text"   class="form-control" value="${menu.levels}">
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-group">
        <label class="col-sm-3 control-label">菜单地址：</label>
        <div class="col-sm-5">
          <input id="urls" name="urls"   type="text"   class="form-control"  value="${menu.urls}">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label">排序：</label>
        <div class="col-sm-5">
          <input id="sort" name="sort" type="text"   class="form-control"   value="${menu.sort}">
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-group">
        <label class="col-sm-3 control-label">父节点：</label>
        <div class="col-sm-5">
          <input id="parentCode" name="parentCode"  type="text"   class="form-control"  value="${menu.parentCode}">
        </div>
      </div>
      <div class="form-group">
        <label class="col-sm-3 control-label">是否节点：</label>
        <div class="col-sm-5">
          <select class="form-control" name="isLeaf">
            <option <c:if test="${menu.isLeaf == 1}" >selected="selected" </c:if> value="1"  >是</option>
            <option <c:if test="${menu.isLeaf == 0}" >selected="selected" </c:if> value="0"  >否</option>
          </select>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-group">
        <label class="col-sm-3 control-label">是否启用：</label>
        <div class="col-sm-5">
          <select class="form-control" name="isUsed">
            <option <c:if test="${menu.isUsed == 1}" >selected="selected" </c:if> value="1"  >是</option>
            <option <c:if test="${menu.isUsed == 0}" >selected="selected" </c:if> value="0"  >否</option>
          </select>
        </div>
      </div>
    </div>
    <div class="col-md-6">
      <div class="form-group">
        <label class="col-sm-3 control-label">备注：</label>
        <div class="col-sm-5">
          <input id="memo" name="memo"   type="text"   class="form-control" value="${menu.memo}" >
        </div>
      </div>
    </div>
    <div class="form-group">
      <div class="col-sm-3 col-sm-offset-2" >
        <button class="btn btn-primary" type="submit">提交</button>
      </div>
      <div class="col-sm-3 col-sm-offset-3"   >
        <button class="btn btn-primary" type="button"   onclick="history.back()">返回</button>
      </div>
    </div>
  </form>
</div>
</div>

<!-- 全局js -->
<script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>
<script src="<%=basePath%>js/bootstrap.min.js?v=3.3.6"></script>



<script src="<%=basePath%>js/plugins/jeditable/jquery.jeditable.js"></script>

<!-- Data Tables -->
<script src="<%=basePath%>js/plugins/dataTables/jquery.dataTables.js"></script>
<script src="<%=basePath%>js/plugins/dataTables/dataTables.bootstrap.js"></script>

<!-- 自定义js -->
<script src="<%=basePath%>js/content.js?v=1.0.0"></script>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->

</body>
</html>
