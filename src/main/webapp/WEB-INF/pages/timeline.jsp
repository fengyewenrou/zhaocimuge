<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <link rel="shortcut icon" href="<%=basePath%>/img/ico.ico"> <link href="<%=basePath%>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>css/font-awesome.css?v=4.4.0" rel="stylesheet">
    <link href="<%=basePath%>css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=basePath%>css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>css/style.css?v=4.1.0" rel="stylesheet">
    <style type="text/css">
        .tanchuang{
            display: block;
        }
    </style>
</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content">
        <div class="row animated fadeInRight">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <a href="#" style="float: right;color: #000000" data-toggle="modal" data-target="#myModal2" class="glyphicon glyphicon-plus"></a>
                <c:forEach items="${timeline}" var="row" varStatus="status">
                        <div class="timeline-item">
                            <div class="row">
                                <div class="col-xs-3 date">
                                    <i class="${row.icon}"></i><fmt:formatDate  value="${row.createTime}" type="both" pattern="HH:mm"/>
                                    <br>
                                    <small class="text-navy"><c:if test="${row.timeDifference !=0}">${row.timeDifference}小时前</c:if>
                                        <c:if test="${row.timeDifference ==0}">${row.timeDifference2}分钟前</c:if></small>
                                </div>
                                <div class="col-xs-7 content">
                                    <p class="m-b-xs"><strong>${row.title}</strong>
                                    </p>
                                    <p>${row.content}</p>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

    <div class="modal inmodal" id="myModal2" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content animated flipInY">
                <form action="<%=basePath%>/main/tinmelineadd.html" method="post" >
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title">时间轴</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group"><label>标题</label> <input type="text" name="title" placeholder="请输入标题" class="form-control"></div>
                </div>
                <div class="modal-body">
                    <div class="form-group"><label>内容</label> <textarea name="content"  placeholder="请输入内容" class="form-control"></textarea></div>
                </div>
                    <div class="modal-body">
                        <div class="form-group"><label>图标</label>
                        <select name="icon"  class="form-control" >
                            <option value="fa fa-file-text">文本</option>
                            <option value="fa fa-coffee">咖啡</option>
                            <option value="fa fa-phone">电话</option>
                            <option value="fa fa-user-md">开会</option>
                            <option value="fa fa-comments">讨论</option>
                        </select>
                        </div>
                    </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-white" data-dismiss="modal">关闭</button>
                    <button type="submit" class="btn btn-primary">保存</button>
                </div>
            </form>
        </div>
    </div>
    </div>
    </div>

    <!-- 全局js -->
    <script src="<%=basePath%>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=basePath%>/js/bootstrap.min.js?v=3.3.6"></script>



    <!-- Peity -->
    <script src="<%=basePath%>/js/plugins/peity/jquery.peity.min.js"></script>

    <!-- 自定义js -->
    <script src="<%=basePath%>/js/content.js?v=1.0.0"></script>


    <!-- Peity -->
    <script src="<%=basePath%>/js/demo/peity-demo.js"></script>
</body>

</html>
