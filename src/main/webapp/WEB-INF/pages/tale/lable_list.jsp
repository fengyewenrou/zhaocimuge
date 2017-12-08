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
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.15/css/jquery.dataTables.min.css">
  <link href="<%=basePath%>css/font-awesome.css?v=4.4.0" rel="stylesheet">
  <link href="<%=basePath%>css/plugins/iCheck/custom.css" rel="stylesheet">
  <link href="<%=basePath%>css/animate.css" rel="stylesheet">
  <link href="<%=basePath%>css/style.css?v=4.1.0" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/buttons/1.4.2/css/buttons.dataTables.min.css">
</head>
<div class="wrapper wrapper-content animated fadeInRight" data-width="100%">
  <div class="row">
    <div class="col-sm-12">
      <form action="<%=basePath%>/tale/lable/list.html" method="post" id="subform">
      <div class="ibox-tools">
        <span>标签名称:</span> <input type="text" id="menuName" name="p_menuName" value="${page.params["menuName"] }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      <%--  <span>父节点:</span> <input type="text" id="parentCode" name="p_parentCode" value="${page.params["parentCode"] }">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--%>
          <a class="btn btn-primary btn-sm" title='搜索' id="btn_search" href="#" onclick="document.getElementById('subform').submit();return false"><i class="fa fa-search"></i>搜索</a>
          <a class="btn btn-primary btn-sm" title='添加' href="<%=basePath%>/tale/lable/add.html"><i class="fa fa-plus"></i>添加</a>
      </div>
      <div class="ibox-content">
<table id="example" class="display nowrap" cellspacing="0" width="100%">
  <thead>
  <tr>
    <th>#</th>
    <th>标签名称</th>
    <th>创建时间</th>
    <th>是否可用</th>
    <th>操作</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach items="${page.resultList}" var="row" varStatus="status">
    <tr class="gradeC">
      <td>${row.id}</td>
      <td>${row.lable}</td>
      <td>${row.createDate}</td>
      <td><c:if test="${row.isUsed eq 1}">是</c:if><c:if test="${row.isUsed eq 0}">否</c:if></td>
      <td style="text-align: center"><a class="btn btn-primary btn-sm cc"  href="<%=basePath%>/tale/lable/${row.id}/edit.html"><i class="fa fa-edit"></i> 编辑</a>&nbsp;&nbsp;&nbsp;<a class="btn btn-primary btn-sm cc"    href="<%=basePath%>/menu/${row.id}/del.html"><i class="fa fa-delicious"></i> 删除</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
      </div>
      <jsp:include page="/frame/page.html" />
      </form>
  </div>
  </div>
</div>
<!--引入JavaScript-->
<script type="text/javascript" language="javascript" src="//code.jquery.com/jquery-1.12.4.js"></script>
<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/1.10.15/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript" src="https://cdn.datatables.net/buttons/1.4.2/js/dataTables.buttons.min.js"></script>
<script type="text/javascript" language="javascript" src="//cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript" language="javascript" src="//cdn.datatables.net/buttons/1.4.2/js/buttons.html5.min.js"></script>
<script>
  var currentPage = '${page.currentPage}'//当前页
  var totalCount = '${page.totalCount}'///** 总记录数 */
  var totalPage = '${page.totalPage}'//总页数
  var pageSize = '${page.pageSize}'//总页数
 $(document).ready(function() {
    $('#example').dataTable( {
     /* dom: 'Bfrtip',
      "buttons": [
        {
          'extend': 'excel',
          'text': '导出',//定义导出excel按钮的文字
          'exportOptions': {
            'modifier': {
              'page': 'current'
            }
          }
        }
      ],*/
      "searching" : false,
        "paging": false,
        "language": {
        "lengthMenu": "每页 "+pageSize+" 条记录",
        "zeroRecords": "没有找到记录",
        "info": "第 "+currentPage+" 页 ( 总共 "+totalPage+" 页 )",
        "infoEmpty": "无记录",
        "infoFiltered": "(从 "+totalCount+" 条记录过滤)"
       /* "sPaginationType" : "full_numbers"*/
       /* "sSearch" : "搜索",*/
       /* "oPaginate": {
          "sFirst": "首页",
          "sPrevious": "前一页",
          "sNext": "后一页",
          "sLast": "尾页"
        }*/
      }
    } );
  } );

</script>
</html>