package com.zhaoci.share.user.controller;

import com.zhaoci.framework.base.Constants;
import com.zhaoci.framework.base.controller.BaseController;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.framework.base.page.PageHelper;
import com.zhaoci.share.user.po.Menu;
import com.zhaoci.share.user.po.MenuRole;
import com.zhaoci.share.user.service.MenuRoleService;
import com.zhaoci.share.user.service.MenuService;
import com.zhaoci.share.utils.json.JacksonUtil;
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

@Controller
@RequestMapping("menu")
public class MenuController extends BaseController {
	private static final Logger logger = Logger.getLogger(MenuController.class);

	@Resource
	private MenuService menuService;
	@Resource
	private MenuRoleService menuRoleService;
	@RequestMapping("list.html")
	public ModelAndView show(HttpServletRequest request,HttpServletResponse response){
		Map<String,Object> map=new HashMap();
		try{
			request.setCharacterEncoding("UTF-8");
			/*查询列表*/
			Page<Menu> page = new Page<>();
			  PageHelper.initPage(request, page);
			 page.setParams(super.getParamMap(request));
			page.getParams().put("isUsed", Constants.TRUE);
			page = menuService.queryListPage(page);
			PageHelper.setPageModel(request, page);

		}catch(Exception e){
			e.printStackTrace();
			logger.error("进入客户信息列表页出现异常",e);
		}
		return new ModelAndView("system/menu_list");
	}

	@RequestMapping("{id}/edit.html")
	public ModelAndView edit(HttpServletRequest request,HttpServletResponse response,@PathVariable Integer id){
		Menu menu=menuService.queryById(id);
		Map<String, Object> map =new HashMap<>();
		map.put("menu", menu);
		return new ModelAndView("system/menu_edit",map);
	}
	//跳转添加
	@RequestMapping("add.html")
	public ModelAndView add(HttpServletRequest request,HttpServletResponse response){

		Map<String, Object> map = super.getParamMap(request);
		//查询1级菜单的排序最大数
		map.put("sort",menuService.queryBySort()+1);
		//所有的一级菜单
		Menu m = new Menu();
		m.setParentCode("10");
		m.setIsUsed(Constants.TRUE);
		List<Menu> list = menuService.selectList(m);
		map.put("menu",list);
		return new ModelAndView("system/menu_add",map);
	}
	@RequestMapping("{id}/del.html")
	public void del(HttpServletRequest request,HttpServletResponse response,@PathVariable Integer id) throws IOException {
		String js;
		Map<String, Object> map = super.getParamMap(request);
		try {
			//删除角色菜单关联表该菜单下的所有数据
			Menu menu = menuService.queryById(id);
			MenuRole menuRole = new MenuRole();
			menuRole.setMenuCode(menu.getMenuCode());
			List<MenuRole> list = menuRoleService.selectList(menuRole);
			if(list!=null&&list.size()>0){
				for (int i = 0; i <list.size() ; i++) {
					menuRoleService.delete(list.get(i).getId());
				}
			}
			menuService.delete(id);
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
	public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("menu") Menu menu) throws IOException {
		String js;
		try {
				menuService.add(menu);
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
	public void update(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("menu") Menu menu)throws IOException {
		String js = null;
		try {
			 menuService.update(menu);
			js = "<script>alert('修改成功');location.href='list.html';</script>";
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("修改信息出现异常",e);
			js = "<script>alert('修改失败');location.href='list.html';</script>";
		}
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().print(js);
	}
	/**
	 * 查询二级菜单所有的排序
	 */

	@RequestMapping("querySort.html")
	public void querySort(HttpServletRequest request , HttpServletResponse response)
	{
		response.setContentType("text/html;charset=UTF-8");

		String parentCode = request.getParameter("parentCode");
		Integer sort = menuService.querySunBySort(parentCode);
		try {
			response.getWriter().print(JacksonUtil.toJson((sort==null?0:sort)+1));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}