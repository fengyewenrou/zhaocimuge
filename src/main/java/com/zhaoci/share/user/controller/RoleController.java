package com.zhaoci.share.user.controller;

import com.zhaoci.framework.base.controller.BaseController;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.framework.base.page.PageHelper;
import com.zhaoci.share.user.po.Menu;
import com.zhaoci.share.user.po.MenuRole;
import com.zhaoci.share.user.po.SysRoles;
import com.zhaoci.share.user.po.SysUsers;
import com.zhaoci.share.user.po.SysUsersRoles;
import com.zhaoci.share.user.po.TreeNode;
import com.zhaoci.share.user.service.MenuRoleService;
import com.zhaoci.share.user.service.MenuService;
import com.zhaoci.share.user.service.SysRolesService;
import com.zhaoci.share.user.service.SysUsersRolesService;
import com.zhaoci.share.user.service.SysUsersService;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Copyright (C), 2002-2017,
 * FileName: RoleController
 * Author:   fanfuchen
 * Date:     2017/9/29 13:07
 * Description: //模块目的、功能描述
 * History: //修改记录
 * <author>      <time>      <version>    <desc>
 * 修改人姓名             修改时间            版本号                  描述
 */
@Controller
@RequestMapping("role")
public class RoleController extends BaseController {


    private static final Logger logger = Logger.getLogger(SysUserController.class);

    @Resource
    private SysRolesService sysRolesService;
    @Resource
    private SysUsersRolesService sysUsersRolesService;
    @Resource
    private SysUsersService sysUsersService;
    @Resource
    private MenuRoleService menuRoleService;
    @Resource
    private MenuService menuService;

    @RequestMapping("list.html")
    public ModelAndView show(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map=new HashMap();
        try{
            request.setCharacterEncoding("UTF-8");
			/*查询列表*/
            Page<SysRoles> page = new Page<>();
              PageHelper.initPage(request, page);
            // page.setParams(super.getParamMap(request));
            page = sysRolesService.queryListPage(page);
            PageHelper.setPageModel(request, page);

        }catch(Exception e){
            e.printStackTrace();
            logger.error("进入客户信息列表页出现异常",e);
        }
        return new ModelAndView("system/role_list");
    }
    @RequestMapping("{id}/edit.html")
    public ModelAndView edit(HttpServletRequest request,HttpServletResponse response,@PathVariable String id){
        SysRoles sysRoles=sysRolesService.queryById(id);
        Map<String, Object> map =new HashMap<>();
        map.put("sysRoles", sysRoles);
        return new ModelAndView("system/role_edit",map);
    }
    //跳转添加
    @RequestMapping("add.html")
    public ModelAndView add(HttpServletRequest request,HttpServletResponse response){

            Map<String, Object> map = super.getParamMap(request);

             return new ModelAndView("system/role_add",map);
    }
    @RequestMapping("{id}/del.html")
    public void del(HttpServletRequest request,HttpServletResponse response,@PathVariable String id) throws IOException {
        String js;
        Map<String, Object> map = super.getParamMap(request);
        try {
        //查询该角色下的用户
        SysUsersRoles sysUsersRoles=new SysUsersRoles();
        sysUsersRoles.setEnabled(1);
        sysUsersRoles.setRoleId(id);
        List<SysUsersRoles> list= sysUsersRolesService.selectList(sysUsersRoles);
        if (list!=null&&list.size()>0) {
            SysUsers sysUsers = sysUsersService.queryById(list.get(0).getUserId());
            js = "<script>alert('此角色已被用户"+sysUsers.getUserName()+"绑定,暂时不能删除！');location.href='../list.html';</script>";

        }else {
            sysUsersRolesService.del(id);
            sysRolesService.delete(id);
            js = "<script>alert('删除成功');location.href='../list.html';</script>";
        }
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
    public void save(HttpServletRequest request, HttpServletResponse response, @ModelAttribute("sysRoles") SysRoles sysRoles) throws IOException {
        String js;
        try {
            SysRoles sysRoles2 =new SysRoles();
            sysRoles2.setModule(sysRoles.getModule());
            sysRoles2.setEnabled(1);
            sysRoles2.setRoleName(sysRoles.getRoleName());
            sysRoles2.setRoleDesc(sysRoles.getRoleDesc());
            List<SysRoles> list=sysRolesService.selectList(sysRoles2);
            if(list!=null&&list.size()>0){
                js = "<script>alert('存在重复数据');location.href='add.html';</script>";
            }else {

                sysRoles.setRoleId(UUID.randomUUID().toString().replaceAll("-", ""));
                sysRolesService.add(sysRoles);
                js = "<script>alert('添加成功');location.href='list.html';</script>";

            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("添加信息出现异常", e);
            js = "<script>alert('添加失败');location.href='list.html';</script>";
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(js);
    }
    @RequestMapping("update.html")
    public void update(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("sysRoles") SysRoles sysRoles)throws IOException {
        String js = null;
        try {
            SysRoles sysRoles2 =new SysRoles();
            sysRoles2.setModule(sysRoles.getModule());
            sysRoles2.setEnabled(1);
            sysRoles2.setRoleName(sysRoles.getRoleName());
            sysRoles2.setRoleDesc(sysRoles.getRoleDesc());
            List<SysRoles> list=sysRolesService.selectList(sysRoles2);
            sysRolesService.update(sysRoles);
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

    /**
     * 角色跳转树状菜单
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("menuTree.html")
    public ModelAndView menuTree(HttpServletRequest request,HttpServletResponse response){

        Map<String, Object> map = super.getParamMap(request);


        return new ModelAndView("system/role_add",map);
    }

    /**
     * 树状菜单
     *
     * @return
     */
    @RequestMapping("treeMenuV2.html")
    public void treeMenuV2(HttpServletRequest request, HttpServletResponse response) {
        String roleName = request.getParameter("roleName");
        MenuRole menuRole = new MenuRole();
        // menuRole.setIsUsed(Constants.TRUE);
        //UserInfo userInfo = (UserInfo) super.getLoginUser(request);
        menuRole.setRoleName(roleName);
        //  menuRole.setRoleName(roleDesc);
        List<Menu> menuList = null;
        // menuRole.setIsUsed("1");
        //menuRole.setUserId(userInfo.getSysUserId());
        //menuList = menuRoleService.menuJoinMenuRole(menuRole);
        //menuList = menuRoleService.menuJoinMenuRole2(menuRole);
        /*if(userInfo.getModule()!=null&&!"".equals(userInfo.getModule())){
            menuList=menuRoleService.menuJoinMenuRole4(menuRole);//第三方炒鸡管理
        }else {*/
            menuList=menuRoleService.menuJoinMenuRole3(menuRole);//炒鸡管理员
       // }
        Menu rootMenu = new Menu();
        rootMenu.setParentCode("root");
        rootMenu = menuService.selectList(rootMenu).get(0);
        TreeNode node = new TreeNode();
        node.setId(Integer.valueOf(rootMenu.getMenuCode()));
        node.setText(rootMenu.getMenuName());
        getChildNode(menuList, node);
        List<TreeNode> treeList = new ArrayList<TreeNode>();
        treeList.add(node);
        String result = JacksonUtil.toJson(treeList);

        response.setContentType("text/html;charset=UTF-8");
        try {
            response.getWriter().print(result);
        } catch (IOException e) {
            logger.error("", e);
        }
    }
    /**
     * 递归出树状菜单
     */
    private void getChildNode(List<Menu> menuList, TreeNode parentNode) {
        for (Menu menu : menuList) {
            if (menu.getParentCode().equals(Integer.toString(parentNode.getId()))) {
                TreeNode node = new TreeNode();
                node.setId(Integer.valueOf(menu.getMenuCode()));
                node.setText(menu.getMenuName());
                node.setChecked(menu.getIsLeaf().equals("1") && menu.getMenuRole() != null && menu.getMenuRole().getIsUsed().equals("1"));
                if (parentNode.getChildren() == null) {
                    parentNode.setChildren(new ArrayList<TreeNode>());
                }
                parentNode.getChildren().add(node);
                getChildNode(menuList, node);
            }
        }
    }
    /**
     * 批量更新角色权限
     */
    @RequestMapping("updateRoleV2.html")
    public void updateRoleV2(HttpServletRequest request,
                             HttpServletResponse response,
                             String menuCodeString,
                             String roleId) throws IOException {
        String js;
        try {
            // 查询出将要修改的角色
            SysRoles roles = sysRolesService.queryById(roleId);
            // 查询当前用户数据库中的权限状态
            MenuRole menuRole = new MenuRole();
            menuRole.setRolePower(roles.getRoleName());
            List<Menu> menuList = menuRoleService.menuJoinMenuRole(menuRole);
            // 当前选中的权限号码
            List<String> checkedMenuCodeArray = Arrays.asList(menuCodeString.split(","));
            menuRoleService.updateRoleV2(menuList, checkedMenuCodeArray, roles);
            /*// 清除用户权限信息的缓存
            List<SysUsers> sysUsers = sysUsersService.queryUserByRole(roleId);
            for (SysUsers user:sysUsers) {
                userCache.removeUserFromCache(user.getUserAccount());
            }*/
            js = "<script>alert('修改成功');location.href='list.html'</script>";
        } catch (Exception e) {
            logger.error("异常", e);
            js = "<script>alert('异常');location.href='list.html'</script>";
        }
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print(js);
    }

}
