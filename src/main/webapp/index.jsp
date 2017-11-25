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
    <meta name="viewport" content="width=device-width,initial-scale=1.0,maximum-scale=1.0,user-scalable=0" />
    <title>HTML5视频播放器   </title>
    <link rel="shortcut icon" href="<%=basePath%>/img/ico.ico">
    <link rel="stylesheet" type="text/css" href="css/reset.css"/>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/willesPlay.css"/>
    <script src="<%=basePath%>/js/jquery.min.js" type="text/javascript" charset="utf-8"></script>
    <script src="<%=basePath%>/js/willesPlay.js" type="text/javascript" charset="utf-8"></script>
</head>
<body background="img/login-backgroundV3.jpg">
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div id="willesPlay">
                <div class="playHeader">
                    <div class="videoName">Stellar《Marionette》</div>
                </div>
                <div class="playContent">
                    <div class="turnoff">
                        <ul>
                            <li><a href="javascript:;" title="喜欢" class="glyphicon glyphicon-heart-empty"></a></li>
                            <li><a href="javascript:;" title="关灯" class="btnLight on glyphicon glyphicon-sunglasses"></a></li>
                            <li><a href="javascript:;" title="分享" class="glyphicon glyphicon-share"></a></li>
                        </ul>
                    </div>
                    <video width="100%" height="100%" id="playVideo">
                       <source src="http://124.14.9.245/sohu/v1/Tmwmq6IOfF6HyT83otW6WhvDoEcIpx7xC50OwqlOkXytHrChWoIymcAr.mp4?k=ZKPkVr&p=XZxIWhoBoJ2svm1BqVPcNmsdytP&r=TmI20LscWOo70Sc2ZD6Sqt8IS3eslDbJkDbtZ5Nak7gaUDQEwah0whesaOGECBfjvJAt6ODOfoIWObXvmXAyBj&q=OpCUhW7IWhWSoh24fJoGgT1cWh6O5GN4lGvsWhXsWFyS0F2OfFNOfBdOfFoURDNswmscWY&cip=112.65.211.147" type="video/mp4" />
                        当前浏览器不支持 video直接播放，点击这里下载视频： <a href="/">下载视频</a>
                    </video>
                    <div class="playTip glyphicon glyphicon-play"></div>
                </div>
                <div class="playControll">
                    <div class="playPause playIcon"></div>
                    <div class="timebar">
                        <span class="currentTime">0:00:00</span>
                        <div class="progress">
                            <div class="progress-bar progress-bar-danger progress-bar-striped" role="progressbar" aria-valuemin="0" aria-valuemax="100" style="width: 0%"></div>
                        </div>
                        <span class="duration">0:00:00</span>
                    </div>
                    <div class="otherControl">
                        <span class="volume glyphicon glyphicon-volume-down"></span>
                        <span class="fullScreen glyphicon glyphicon-fullscreen"></span>
                        <div class="volumeBar">
                            <div class="volumewrap">
                                <div class="progress">
                                    <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuemin="0" aria-valuemax="100" style="width: 8px;height: 40%;"></div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>

<div style="text-align:center;clear:both;">
    <script src="/gg_bd_ad_720x90.js" type="text/javascript"></script>
    <script src="/follow.js" type="text/javascript"></script>
</div>
</body>
</html>

