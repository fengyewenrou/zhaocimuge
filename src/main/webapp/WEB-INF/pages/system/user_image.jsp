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
	<meta charset="UTF-8">
	<title>哈哈哈哈</title>
	<script src="<%=basePath%>js/jquery.min.js?v=2.1.4"></script>
	<link href="<%=basePath%>/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=basePath%>/js/cropper/cropper.min.css" rel="stylesheet">
	<link href="<%=basePath%>/js/sitelogo/sitelogo.css" rel="stylesheet">
	<script src="<%=basePath%>/js/cropper/cropper.min.js"></script>
	<script src="<%=basePath%>/js/sitelogo/sitelogo.js"></script>
	<script src="<%=basePath%>/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="ibox-content">
		<div class="row">
			<div id="crop-avatar" class="col-md-6">
				<div class="avatar-view" title="点击更换头像">
			    	<img src="${user.photo}" alt="Logo">
			    </div>
			</div>
		</div>
	</div>

<div class="modal fade" id="avatar-modal" aria-hidden="true" aria-labelledby="avatar-modal-label" role="dialog" tabindex="-1">
	<div class="modal-dialog modal-lg">
		<div class="modal-content">
			<form class="avatar-form" action="<%=basePath%>/main/${user.userId}/fileUpload.html" id="form1" enctype="multipart/form-data" method="post">
				<div class="modal-header">
					<button class="close" data-dismiss="modal" type="button">&times;</button>
					<h4 class="modal-title" id="avatar-modal-label">Change Logo Picture</h4>
				</div>
				<div class="modal-body">
					<div class="avatar-body">
						<div class="avatar-upload">
							<input class="avatar-src" name="avatar_src" type="hidden">
							<input class="avatar-data" name="avatar_data" type="hidden">
							<label for="avatarInput">图片上传</label>
							<input class="avatar-input" id="avatarInput" name="myFiles" type="file"></div>
						<div class="row">
							<div class="col-md-9">
								<div class="avatar-wrapper"></div>
							</div>
							<div class="col-md-3">
								<div class="avatar-preview preview-lg"></div>
								<div class="avatar-preview preview-md"></div>
								<div class="avatar-preview preview-sm"></div>
							</div>
						</div>
						<div class="row avatar-btns">
							<div class="col-md-9">
								<div class="btn-group">
									<button class="btn" data-method="rotate" data-option="-90" type="button" title="Rotate -90 degrees"><i class="fa fa-undo"></i> 向左旋转</button>
								</div>
								<div class="btn-group">
									<button class="btn" data-method="rotate" data-option="90" type="button" title="Rotate 90 degrees"><i class="fa fa-repeat"></i> 向右旋转</button>
								</div>
							</div>
							<div class="col-md-3">
								<button class="btn btn-success btn-block avatar-save" type="button" onclick="smg()"><i class="fa fa-save"></i> 保存修改</button>
							</div>
						</div>
					</div>
				</div>
  		</form>
  	</div>
  </div>
</div>

<div class="loading" aria-label="Loading" role="img" tabindex="-1"></div>
<script type="text/javascript">
	function smg(){
		$(".modal-dialog").hide();
		/*location.href='<%=basePath%>'+"main/index.html?type=1";*/
		$("#form1").submit();
		//window.load()
		location.reload()
	}

</script>
</body>
</html>