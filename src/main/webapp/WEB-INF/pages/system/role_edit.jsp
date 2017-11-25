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
  <link href="<%=basePath%>/css/plugins/toastr/toastr.min.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="ibox-content"  >
  <form class="form-horizontal m-t" id="commentForm" action="<%=basePath%>/role/update.html">
    <div class="col-md-6">
    <div class="form-group">
      <label class="col-sm-3 control-label">角色名称：</label>
      <div class="col-sm-5">
        <input id="roleName" name="roleName" minlength="2" type="text" value="${sysRoles.roleName}" class="form-control" required="" aria-required="true">
      </div>
    </div>
    <div class="form-group">
      <label class="col-sm-3 control-label">所属系统：</label>
      <div class="col-sm-5">
        <select class="form-control" name="module">
          <option value="1" <c:if test="${sysRoles.module eq 1}">selected="selected" </c:if>>系统1</option>
          <option value="2" <c:if test="${sysRoles.module eq 2}">selected="selected" </c:if>>系统2</option>
        </select>
      </div>
    </div>
      </div>
    <div class="col-md-6">
        <div class="form-group">
          <label class="col-sm-3 control-label">是否启用：</label>
          <div class="col-sm-5">
            <select class="form-control" name="enabled">
              <option value="1" <c:if test="${sysRoles.enabled eq 1}">selected="selected" </c:if>>是</option>
              <option value="0"  <c:if test="${sysRoles.enabled eq 0}">selected="selected" </c:if>>否</option>
            </select>
          </div>
        </div>
    <div class="form-group">
      <label class="col-sm-3 control-label">角色描述：</label>
      <div class="col-sm-5">
        <input id="roleDesc" type="text" class="form-control" name="roleDesc" value="${sysRoles.roleDesc}">
      </div>
    </div>
      </div>
    <div class="form-group">
      <div class="col-sm-3 col-sm-offset-3">
        <button id="submit" class="btn btn-primary"    type="submit">提交</button>
      </div>
      <div class="col-sm-3 col-sm-offset-3">
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
<script src="<%=basePath%>/js/ajaxDemo.js?v=1.0.0"></script>
<script src="<%=basePath%>/js/plugins/toastr/toastr.min.js"></script>

<script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
<!--统计代码，可删除-->

</body>
</html>
