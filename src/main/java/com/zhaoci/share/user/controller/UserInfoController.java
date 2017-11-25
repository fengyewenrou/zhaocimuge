package com.zhaoci.share.user.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zhaoci.framework.base.Constants;
import com.zhaoci.share.user.po.*;
import com.zhaoci.share.user.service.*;
import com.zhaoci.share.utils.DateUtil;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zhaoci.framework.base.controller.BaseController;

@Controller
@RequestMapping("main")
public class UserInfoController extends BaseController {
	private static final Logger logger = Logger.getLogger(UserInfoController.class);

	@Resource
	private SysUsersService sysUsersService;
	@Resource
	private MenuRoleService menuRoleService;
	@Resource
	private SysRolesService sysRolesService;
	@Resource
	private MenuService menuService;
	@Resource
	private SysUsersRolesService sysUsersRolesService;
	@RequestMapping(value = "index.html",method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String js = "";
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String basePath = request.getScheme() + "://" + request.getServerName() + ":"
				+ request.getServerPort() + request.getContextPath();
		if(request.getSession(false)==null){
			SysUsers sysUsers = new SysUsers();
			sysUsers.setUserAccount(name);
			List<SysUsers> list = sysUsersService.selectList(sysUsers);
			js = "<script>location.href='" + basePath + "/lockscreen.jsp?userName="+list.get(0).getUserName()+"&image="+list.get(0).getPhoto()+"';</script>";
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(js);
			return null;
		}
		//UserInfo user = new UserInfo();
		SysUsers sysUsers = new SysUsers();
		sysUsers.setUserAccount(name);
		//user.setPassword(MD5Util.md5(password));
		List<SysUsers> list = sysUsersService.selectList(sysUsers);
		if (list != null && list.size() > 0) {
			SysUsers userDetails = list.get(0);
			//查询用户角色
			List<SysRoles> sysRolesList = sysRolesService.selectListRoles(userDetails.getUserId());
			//查询角色菜单
			if(sysRolesList!=null&&sysRolesList.size()>0){
				Map<Menu, List<Menu>> listMap = getMenuMap(sysRolesList);
				//userDetails.setMenuMap();
				if(request.getSession().getAttribute(Constants.LOGIN_USER) == null){
					request.getSession().setAttribute(Constants.LOGIN_USER, list.get(0));
					request.getSession().setAttribute("menuMap", listMap);
				}
				return "index";
			}else {
					response.setContentType("text/html;charset=UTF-8");
					js = "<script>alert('权限错误');location.href='" + basePath + "';</script>";
					response.getWriter().print(js);
					return null;
			}

		} else {
				logger.info("===========账号或密码错误");
				response.setContentType("text/html;charset=UTF-8");
				js = "<script>alert('账号或密码错误');location.href='" + basePath + "';</script>";
				response.getWriter().print(js);
				return null;

		}

	}

	@RequestMapping(value = "index.html",method =  RequestMethod.GET)
	public ModelAndView loginV2(HttpServletRequest request, HttpServletResponse response) {
		SysUsers sysUsers   = (SysUsers) super.getLoginUser(request);
		String type = request.getParameter("type");
		if(sysUsers!=null){
			return new ModelAndView("index");
		}else {
			if(type!=null){
				return new ModelAndView("");
			}
			return new ModelAndView("../../login");
		}
	}

	public Map<Menu, List<Menu>> getMenuMap(List<SysRoles> sysRolesList){
		Map<Menu,List<Menu>> menuMap = new LinkedHashMap<Menu,List<Menu>>();
		Menu menu = new Menu();
		menu.setParentCode("10");
		StringBuffer buff = new StringBuffer("(");
		for(SysRoles role:sysRolesList){
			buff.append("'").append(role.getRoleName()).append("',");
		}
		buff.deleteCharAt(buff.length()-1).append(")");
		menu.setRolePower(buff.toString());
		List<Menu> menuList = menuService.queryByPower(menu);
		List<Menu> tmpList = null;
		for(Menu me:menuList){
			menu = new Menu();
			menu.setParentCode(me.getMenuCode());
			menu.setRolePower(buff.toString());
			tmpList = menuService.queryByPower(menu);
			if(tmpList!=null && tmpList.size()>0){
				menuMap.put(me, tmpList);
			}
		}
		return menuMap;
	}

	/**
	 * 跳转修改头像页面
	 */
	@RequestMapping("{id}/userImage.html")
	public ModelAndView userImage(HttpServletRequest request,HttpServletResponse response,@PathVariable String id){

		Map<String, Object> map = super.getParamMap(request);

		return new ModelAndView("system/user_image",map);
	}
	@RequestMapping("{id}/fileUpload.html")
	public void fileUpload(HttpServletRequest request,HttpServletResponse response,@PathVariable String id,
								   @RequestParam(required = false) MultipartFile[] myFiles) throws IOException {
		String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
		Map<String, Object> map = super.getParamMap(request);
		List list = new ArrayList();
		try {
			list = fileUpload2(myFiles,request,response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		SysUsers sysUsers =  sysUsersService.queryById(id);
		sysUsers.setPhoto(list.get(0).toString());
		sysUsersService.update(sysUsers);
		request.getSession().removeAttribute(Constants.LOGIN_USER);
		request.getSession().setAttribute(Constants.LOGIN_USER,sysUsers);
		response.setContentType("text/html;charset=UTF-8");
		String js = "<script>alert('修改成功！');location.href='"+basePath+"';</script>";
		response.getWriter().print(js);
	}
	/**
	 * 上传文件
	 */
	//@RequestMapping(value = "/fileUpload2")
	public static List fileUpload2(
			@RequestParam(required = false) MultipartFile[] myFiles,
			HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		List<String> imagePathList = new ArrayList<>(myFiles.length);
		try {
			String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();

			//设置响应给前台内容的数据格式
			response.setContentType("text/plain; charset=UTF-8");
			//设置响应给前台内容的PrintWriter对象
			PrintWriter out = response.getWriter();
			//上传文件的原名(即上传前的文件名字)
			String originalFilename = null;
			//如果只是上传一个文件,则只需要MultipartFile类型接收文件即可,而且无需显式指定@RequestParam注解
			//如果想上传多个文件,那么这里就要用MultipartFile[]类型来接收文件,并且要指定@RequestParam注解
			//上传多个文件时,前台表单中的所有<input type="file"/>的name都应该是myfiles,否则参数里的myfiles无法获取到所有上传的文件
			for (MultipartFile myfile : myFiles) {
				if (myfile.isEmpty()) {
//                    imagePathList.add("");
				} else {
					originalFilename = new Date().getTime() + myfile.getOriginalFilename();
					if(originalFilename.indexOf(".jpg")==-1) {
						originalFilename += ".jpg";
					}
					logger.debug("文件原名: " + originalFilename);
					logger.debug("文件名称: " + myfile.getName());
					logger.debug("文件长度: " + myfile.getSize());
					logger.debug("文件类型: " + myfile.getContentType());
					logger.info(originalFilename);
					try {
						//这里不必处理IO流关闭的问题,因为FileUtils.copyInputStreamToFile()方法内部会自动把用到的IO流关掉
						//此处也可以使用Spring提供的MultipartFile.transferTo(File dest)方法实现文件的上传
						System.out.println(System.getProperty("user.dir") + "========================");
						String mulu =  DateUtil.getCurrDate(DateUtil.DATE_FORMAT) + "/";

						/*String path = request.getSession().getServletContext().getRealPath("/") + ( mulu);*/
						String path ="/usr/local/nginx/html/"+"upload/"+mulu;
						logger.debug("3========================================" + path + originalFilename);
						FileUtils.copyInputStreamToFile(myfile.getInputStream(), new File(path, originalFilename));
						String realPath = "/upload/"+mulu + originalFilename;
						logger.debug("4========================================" + realPath);

						imagePathList.add(realPath);
					} catch (IOException e) {
						logger.error("文件[" + originalFilename + "]上传失败,堆栈轨迹如下", e);
					}
				}
			}
		} catch (IOException e1) {
			logger.error("", e1);
		}
		return imagePathList;
	}

}