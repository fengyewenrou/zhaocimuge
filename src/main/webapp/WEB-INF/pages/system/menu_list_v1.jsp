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
  <link rel="shortcut icon" href="<%=basePath%>/img/ico.ico"> <link href="<%=basePath%>css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
  <link href="<%=basePath%>css/font-awesome.css?v=4.4.0" rel="stylesheet">
  <link href="<%=basePath%>css/plugins/iCheck/custom.css" rel="stylesheet">
  <link href="<%=basePath%>css/animate.css" rel="stylesheet">
  <link href="<%=basePath%>css/style.css?v=4.1.0" rel="stylesheet">
</head>
<div class="wrapper wrapper-content animated fadeInRight">
  <div class="row">
    <div class="col-sm-12">
    <%--  <div class="ibox float-e-margins">--%>
       <%-- <div class="">
          <a  href="<%=basePath%>/role/add.html"  class="btn btn-primary " style="position: fixed;top: 5%;right: 8%;z-index: 100">新增</a>
        </div>--%>
        <div class="ibox-content">
          <table class="table table-striped table-bordered table-hover dataTables-example">
            <thead>
              <td>#</td>
              <td>菜单编号</td>
              <td>菜单名称</td>
              <td>菜单图标</td>
              <td>层级</td>
              <td>地址</td>
              <td>排序</th>
              <th>备注</th>
              <th>父节点</th>
              <th>是否节点</th>
              <th>是否可用</th>
              <th>操作</th>
            </thead>
            <tbody>
            <c:forEach items="${page.resultList}" var="row" varStatus="status">
              <tr>
                <td>${row.id}</td>
                <td>${row.menuCode}</td>
                <td>${row.menuName}</td>
                <td>${row.icon}</td>
                <td>${row.levels}</td>
                <td>${row.urls}</td>
                <td>${row.sort}</td>
                <td>${row.memo}</td>
                <td>${row.parentCode}</td>
                <td>${row.isLeaf}</td>
                <td><c:if test="${row.isUsed eq 1}">是</c:if><c:if test="${row.isUsed eq 0}">否</c:if></td>
                <td style="text-align: center"><a href="<%=basePath%>/role/${row.id}/edit.html">编辑</a>&nbsp;&nbsp;&nbsp;<a href="<%=basePath%>/role/${row.id}/del.html">删除</a></td>
              </tr>
            </c:forEach>
            </tbody>
          </table>
        </div>
        </div>
      </div>
    </div>
  </div>
  <!-- 全局js -->
  <script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>
  <script src="<%=basePath%>js/bootstrap.min.js?v=3.3.6"></script>
  <!--引入css-->
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
  <!--引入JavaScript-->
  <script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.12.4.js"></script>
  <script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>



  <!-- Data Tables -->

  <!-- 自定义js -->
  <script src="<%=basePath%>js/content.js?v=1.0.0"></script>
  <!-- Page-Level Scripts -->
  <script>
 /*   $(document).ready(function () {
      $('.dataTables-example').dataTable();


    });*/
    $(document).ready(function() {
      $('.dataTables-example').dataTable( {
        "language": {
          "lengthMenu": "每页 _MENU_ 条记录",
          "zeroRecords": "没有找到记录",
          "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
          "infoEmpty": "无记录",
          "infoFiltered": "(从 _MAX_ 条记录过滤)"
        }
      } );
    } );
  </script>
</html>
