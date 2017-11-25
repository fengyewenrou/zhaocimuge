<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link href="<%=basePath%>/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath%>/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="<%=basePath%>/css/animate.css" rel="stylesheet">
    <link href="<%=basePath%>/css/style.css?v=4.1.0" rel="stylesheet">
    <script>if(window.top !== window.self){ window.top.location = window.location;}</script>

</head>

<body class="gray-bg">

    <div class="lock-word animated fadeInDown">
    </div>
    <div class="middle-box text-center lockscreen animated fadeInDown">
        <div>
            <div class="m-b-md">
                <img alt="image" id="image" class="img-circle circle-border"  style="width: 200px;height: 200px"  src="img/a1.jpg">
            </div>
            <h3 id="lastName">${userName}</h3>
            <p>您需要再次输入密码</p>
            <form class="m-t" role="form" action="<%=basePath%>/main/index.html" method="post">
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="******" required="">
                </div>
                <button type="submit" class="btn btn-primary block full-width">登录到朝辞</button>
            </form>
        </div>
    </div>

    <!-- 全局js -->
    <script src="js/jquery.min.js?v=2.1.4"></script>
    <script src="js/bootstrap.min.js?v=3.3.6"></script>

    <script type="text/javascript">
        function GetQueryString (name) {
            var after = window.location.search.split("?")[1];
            if(after){
                var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
                var r = after.match(reg);
                if(r != null){
                    return  decodeURIComponent(r[2]);
                }else{
                    return null;
                }
            }
        }
        $(document).ready(function() {
            var name = GetQueryString("userName");
            var image = GetQueryString("image");
            $("#lastName").text(name);

            $("#image").attr('src',image);
        })
    </script>
    <!--统计代码，可删除-->

</body>

</html>
