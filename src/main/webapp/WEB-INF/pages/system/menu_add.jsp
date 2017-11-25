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
<div class="row">
  <div class="col-sm-12">
    <div class="tabs-container">
      <ul class="nav nav-tabs">
        <li class="active"><a data-toggle="tab" href="#tab-1" aria-expanded="true"> 一级菜单</a>
        </li>
        <li class=""><a data-toggle="tab" href="#tab-2" aria-expanded="false">二级菜单</a>
        </li>
      </ul>
      <div class="tab-content">
        <div id="tab-1" class="tab-pane active">
          <div class="ibox-content"  >
            <form class="form-horizontal m-t" id="commentForm" action="<%=basePath%>/menu/save.html">
              <div class="col-md-6">
                <div class="form-group">
                  <label class="col-sm-3 control-label">父节点：</label>
                  <div class="col-sm-5">
                    <input id="parentCode" name="parentCode"  type="text"   class="form-control" required="" readonly aria-required="true" value="10">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-3 control-label">是否节点：</label>
                  <div class="col-sm-5">
                    <select class="form-control" name="isLeaf">
                      <option value="1"  >是</option>
                      <option value="0"  selected >否</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label class="col-sm-3 control-label">菜单编号：</label>
                  <div class="col-sm-5">
                    <input id="menuCode" name="menuCode" minlength="2" type="text"   class="form-control" required="" aria-required="true">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-3 control-label">菜单名称：</label>
                  <div class="col-sm-5">
                    <input id="menuName" name="menuName" minlength="2" type="text"   class="form-control" required="" aria-required="true">
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label class="col-sm-3 control-label">菜单图标：</label>
                  <div class="col-sm-5">
                    <input id="icon" name="icon" minlength="2" type="text"   class="form-control" >
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-3 control-label">菜单层级：</label>
                  <div class="col-sm-5">
                    <input id="levels" name="levels"   type="text"  value="1" readonly  class="form-control" required="" aria-required="true">
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label class="col-sm-3 control-label">菜单地址：</label>
                  <div class="col-sm-5">
                    <input id="urls" name="urls" minlength="2" type="text"   class="form-control" required="" aria-required="true">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-3 control-label">排序：</label>
                  <div class="col-sm-5">
                    <input id="sort" name="sort"  type="text" readonly value="${sort}"  class="form-control" required="" aria-required="true">
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label class="col-sm-3 control-label">是否启用：</label>
                  <div class="col-sm-5">
                    <select class="form-control" name="isUsed">
                      <option value="1"  >是</option>
                      <option value="0"  >否</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label class="col-sm-3 control-label">备注：</label>
                  <div class="col-sm-5">
                    <input id="memo" name="memo" minlength="2" type="text"   class="form-control"  >
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
        <div id="tab-2" class="tab-pane">
          <div class="ibox-content"  >
            <form class="form-horizontal m-t" id="commentForm2" action="<%=basePath%>/menu/save.html">
              <div class="col-md-6">
                <div class="form-group">
                  <label class="col-sm-3 control-label">父节点：</label>
                  <div class="col-sm-5">
                    <select id="parentCode2" class="form-control" name="parentCode"  required="required" onchange="querySort()">
                      <option value="" ></option>
                    <c:forEach items="${menu}" var="menu">
                      <option value="${menu.menuCode}" >${menu.menuName}</option>
                    </c:forEach>
                    </select>
                  <%--  <input  name="parentCode" minlength="2" type="text"   class="form-control" required="" aria-required="true">--%>
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-3 control-label">是否节点：</label>
                  <div class="col-sm-5">
                    <select class="form-control" name="isLeaf" >
                      <option value="1"  selected >是</option>
                      <option value="0"  >否</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label class="col-sm-3 control-label">菜单编号：</label>
                  <div class="col-sm-5">
                    <input  name="menuCode" minlength="2" type="text"   class="form-control" required="" aria-required="true">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-3 control-label">菜单名称：</label>
                  <div class="col-sm-5">
                    <input   name="menuName" minlength="2" type="text"   class="form-control" required="" aria-required="true">
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label class="col-sm-3 control-label">菜单图标：</label>
                  <div class="col-sm-5">
                    <input   name="icon" minlength="2" type="text"   class="form-control" >
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-3 control-label">菜单层级：</label>
                  <div class="col-sm-5">
                    <input  name="levels"   type="text" value="2" readonly   class="form-control" required="" aria-required="true">
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label class="col-sm-3 control-label">菜单地址：</label>
                  <div class="col-sm-5">
                    <input   name="urls" minlength="2" type="text"   class="form-control" required="" aria-required="true">
                  </div>
                </div>
                <div class="form-group">
                  <label class="col-sm-3 control-label">排序：</label>
                  <div class="col-sm-5">
                    <input id="sort2"  name="sort"  type="text"  readonly class="form-control" required="" aria-required="true">
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label class="col-sm-3 control-label">是否启用：</label>
                  <div class="col-sm-5">
                    <select class="form-control" name="isUsed">
                      <option value="1"  >是</option>
                      <option value="0"  >否</option>
                    </select>
                  </div>
                </div>
              </div>
              <div class="col-md-6">
                <div class="form-group">
                  <label class="col-sm-3 control-label">备注：</label>
                  <div class="col-sm-5">
                    <input   name="memo" minlength="2" type="text"   class="form-control"  >
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
      </div>
  </div>

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
<script type="text/javascript">
  function querySort(){
    var parentCode=$("#parentCode2").val();
    $.ajax({
      type: "POST",
      url: "<%=basePath%>/menu/querySort.html",
      data:{"parentCode":parentCode},
      dataType: "json",
      success: function (jsonStr) {
          $("#sort2").val(jsonStr);
      }
    });

  }


</script>
</body>
</html>
