package com.zhaoci.share.user.service.impl;


import com.zhaoci.framework.base.Constants;
import com.zhaoci.framework.base.datasource.DataSource;
import com.zhaoci.framework.base.datasource.DataSourceEnum;
import com.zhaoci.framework.base.page.Page;
import com.zhaoci.share.user.dao.MenuRoleDao;
import com.zhaoci.share.user.po.Menu;
import com.zhaoci.share.user.po.MenuRole;
import com.zhaoci.share.user.po.SysRoles;
import com.zhaoci.share.user.service.MenuRoleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@DataSource(DataSourceEnum.MASTER)
@Service("menuRole")
public class MenuRoleServiceImpl implements MenuRoleService {
    @Resource(name = "menuRoleDao")
    private MenuRoleDao menuRoleDao;

    @Override
    public List<MenuRole> selectList(MenuRole menuRole) {
        return menuRoleDao.selectList(menuRole);
    }

    @Override
    public Page<MenuRole> queryListPage(Page<MenuRole> page) {
        page.setResultList(menuRoleDao.queryListPage(page));
        return page;
    }

    @Override
    public MenuRole queryById(Integer id) {
        return menuRoleDao.queryById(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class, Exception.class})
    public void add(MenuRole menuRole) {
        menuRoleDao.insert(menuRole);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class, Exception.class})
    public void delete(Integer id) {
        menuRoleDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class, Exception.class})
    public void update(MenuRole menuRole) {
        menuRoleDao.update(menuRole);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class, Exception.class})
    public void batchUpdate(List<MenuRole> menuRoleList) {
        menuRoleDao.batchUpdate(menuRoleList);
    }

    @Override
    public List<Menu> menuJoinMenuRole(MenuRole menuRole) {
        return menuRoleDao.menuJoinMenuRole(menuRole);
    }

    @Override
    public List<Menu> menuJoinMenuRole2(MenuRole menuRole) {
        return menuRoleDao.menuJoinMenuRole2(menuRole);
    }

    @Override
    public List<Menu> menuJoinMenuRole3(MenuRole menuRole) {
        return menuRoleDao.menuJoinMenuRole3(menuRole);
    }

    @Override
    public List<Menu> menuJoinMenuRole4(MenuRole menuRole) {
        return menuRoleDao.menuJoinMenuRole4(menuRole);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = {RuntimeException.class, Exception.class})
    public void updateRoleV2(List<Menu> menuList, List<String> checkedMenuCodeArray, SysRoles roles) {
        // 循环遍历每一个目录权限，对比当前选择的权限和数据库中权限列表
        for (Menu menu : menuList) {
            boolean isChecked = false; // 是否选中当前这条权限
            for (String checkedCode : checkedMenuCodeArray) {
                if (menu.getMenuCode().equals(checkedCode)) { // 当前用户选中了这条权限
                    isChecked = true;
                    break;
                }
            }
            if (isChecked) { // 选中了这条权限
                openRoleV2(menu, roles);
                // 只要子节点被选中，就开启父节点
                String parentCode = menu.getParentCode();
                Menu parentMenu = getParentMenu(menuList, parentCode);
                if (parentMenu != null && !checkedMenuCodeArray.contains(parentCode)) {
                    openRoleV2(parentMenu, roles);
                }
            } else { // 这条权限没有被选中
                // 禁用这条权限
                if (menu.getMenuRole() != null && menu.getMenuRole().getIsUsed().equals(Constants.TRUE)) {
                    menu.getMenuRole().setIsUsed(Constants.FALSE);
                    this.update(menu.getMenuRole());
                }
            }
        }
    }

    /**
     * 根据parentCode拿到父节点
     */
    private Menu getParentMenu(List<Menu> menuList, String parentCode) {
        for (Menu menu : menuList) {
            if (menu.getMenuCode().equals(parentCode)) {
                return menu;
            }
        }
        return null;
    }

    /**
     * 开启权限
     */
    private void openRoleV2(Menu menu, SysRoles roles) {
        if (menu.getMenuRole() == null) {
            // 不存在该条权限，则新增
            MenuRole mr = new MenuRole();
            mr.setMenuCode(menu.getMenuCode());
            mr.setRoleName(roles.getRoleDesc());
            mr.setRolePower(roles.getRoleName());
            mr.setIsUsed(Constants.TRUE);
            this.add(mr);
        } else if (menu.getMenuRole().getIsUsed().equals(Constants.FALSE)) {
            // 存在，但没有启用，则修改
            menu.getMenuRole().setIsUsed(Constants.TRUE);
            this.update(menu.getMenuRole());
        }
    }

}