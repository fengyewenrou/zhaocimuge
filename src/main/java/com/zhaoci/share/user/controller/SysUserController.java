package com.zhaoci.share.user.controller;

import com.zhaoci.framework.base.controller.BaseController;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.framework.base.page.PageHelper;
import com.zhaoci.share.user.po.SysRoles;
import com.zhaoci.share.user.po.SysUsers;
import com.zhaoci.share.user.service.SysRolesService;
import com.zhaoci.share.user.service.SysUsersRolesService;
import com.zhaoci.share.user.service.SysUsersService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("sysUser")
public class SysUserController extends BaseController {
	private static final Logger logger = Logger.getLogger(SysUserController.class);

	@Resource
	private  SysUsersService sysUsersService;
	@Resource
	private  SysRolesService sysRolesService;
	@Resource
	private SysUsersRolesService sysUsersRolesService;
	@RequestMapping("list.html")
	public ModelAndView show(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map=new HashMap();
		try{
			request.setCharacterEncoding("UTF-8");
			/*查询列表*/
			Page<SysUsers> page = new Page<>();
			  PageHelper.initPage(request, page);
			 page.setParams(super.getParamMap(request));
			page = sysUsersService.queryListPage(page);
			for (int i =0;i<page.getResultList().size();i++ ){
				SysRoles  sysRoles= sysRolesService.queryById(page.getResultList().get(i).getRoleId());
				page.getResultList().get(i).setRoleName(sysRoles.getRoleDesc());
			}
			PageHelper.setPageModel(request, page);

		}catch(Exception e){
			e.printStackTrace();
			logger.error("进入客户信息列表页出现异常",e);
		}
		return new ModelAndView("system/sys_user");
	}
	@RequestMapping("{id}/edit.html")
	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response,@PathVariable String id){
		SysUsers sysUsers=sysUsersService.queryById(id);
		Map<String, Object> map =new HashMap<>();
		map.put("sysUsers", sysUsers);
		SysUsers user = (SysUsers) super.getLoginUser(request);
		SysRoles sysRoles = new SysRoles();
		sysRoles.setEnabled(1);
		sysRoles.setModule(user.getModule());
		List<SysRoles> list = sysRolesService.selectList(sysRoles);
		map.put("sysRoles",list);
		return new ModelAndView("system/user_edit",map);
	}
	//跳转添加
	@RequestMapping("add.html")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response){

		Map<String, Object> map = super.getParamMap(request);
		//查询所有可以用的角色
		SysUsers sysUsers = (SysUsers) super.getLoginUser(request);
		SysRoles sysRoles = new SysRoles();
		sysRoles.setEnabled(1);
		sysRoles.setModule(sysUsers.getModule());
		List<SysRoles> list = sysRolesService.selectList(sysRoles);
		map.put("sysRoles",list);
		return new ModelAndView("system/user_add",map);
	}
	@RequestMapping("{id}/del.html")
	public void del(HttpServletRequest request,HttpServletResponse response,@PathVariable String id) throws IOException {
		String js;
		Map<String, Object> map = super.getParamMap(request);
		try {
				sysUsersService.delete(id);
				js = "<script>alert('删除成功');location.href='../list.html';</script>";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("删除信息出现异常", e);
			js = "<script>alert('删除失败');location.href='../list.html';</script>";
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(js);
	}
	//添加
	@RequestMapping("save.html")
	public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("sysUsers") SysUsers sysUsers) throws IOException {
		String js;
		try {
				sysUsers.setUserId(UUID.randomUUID().toString().replaceAll("-", ""));
				sysUsersService.add(sysUsers);
				//增加用户角色关联
				//sysUsersRolesService.add();
				js = "<script>alert('添加成功');location.href='list.html';</script>";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("添加信息出现异常", e);
			js = "<script>alert('添加失败');location.href='list.html';</script>";
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(js);
	}
	@RequestMapping("update.html")
	public void update(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("sysUsers") SysUsers sysUsers)throws IOException {
		String js = null;
		try {
			sysUsersService.update(sysUsers);
			//是否做用户缓存
          /*  List<SysUsers> sysUsers = sysUsersService.queryUserByRole(sysRoles.getRoleId());
            for (SysUsers user : sysUsers) {
                userCache.removeUserFromCache(user.getUserAccount());
            }*/
			js = "<script>alert('修改成功');location.href='list.html';</script>";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("修改信息出现异常",e);
			js = "<script>alert('修改失败');location.href='list.html';</script>";
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(js);
	}




}