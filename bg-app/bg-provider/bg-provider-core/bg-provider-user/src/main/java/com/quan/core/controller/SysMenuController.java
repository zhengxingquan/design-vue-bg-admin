package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.auth.details.LoginAppUser;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.exception.controller.ControllerException;
import com.quan.core.common.exception.service.ServiceException;
import com.quan.core.common.model.SysMenu;
import com.quan.core.common.model.SysRole;
import com.quan.core.common.util.SysUserUtil;
import com.quan.core.common.web.PageResult;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.Result;
import com.quan.core.service.SysMenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@RestController
@Api(tags = "MENU API")
@RequestMapping("/menus")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "菜单管理")
public class SysMenuController {

    @Autowired
    private SysMenuService menuService;

    /**
     * 删除菜单
     *
     * @param id
     * @throws ControllerException
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除菜单")
    @PreAuthorize("hasAuthority('menu:delete/menus/{id}')")
    @SLog(module = "user-center",tag = "查询列表")
    @AutoCreateMenuAuth(type = MenuType.MENU, name = "菜单管理", shortNo = 3, parentPermission = "sys.manage")
    public Result delete(@PathVariable Long id) throws ControllerException {
        try {
            menuService.delete(id);
            return JsonResult.succeed("操作成功");
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }

    @GetMapping("/{roleId}/menus")
    @ApiOperation(value = "根据roleId获取对应的菜单")
    @PreAuthorize("hasAuthority('menu:get/menus/{roleId}/menus')")
    @SLog(module = "user-center")
    public List<Map<String, Object>> findMenusByRoleId(@PathVariable Long roleId) throws ControllerException {

        try {
            Set<Long> roleIds = new HashSet<Long>();
            // 初始化角色
            roleIds.add(roleId);
            List<SysMenu> roleMenus = menuService.findByRoles(roleIds); // 获取该角色对应的菜单
            List<SysMenu> allMenus = menuService.findAll(); // 全部的菜单列表
            List<Map<String, Object>> authTrees = new ArrayList<>();
            Map<Long, SysMenu> roleMenusMap = roleMenus.stream()
                    .collect(Collectors.toMap(SysMenu::getId, SysMenu -> SysMenu));
            for (SysMenu sysMenu : allMenus) {
                Map<String, Object> authTree = new HashMap<>();
                authTree.put("id", sysMenu.getId());
                authTree.put("name", sysMenu.getName());
                authTree.put("pId", sysMenu.getParentId());
                authTree.put("open", true);
                authTree.put("checked", false);
                if (roleMenusMap.get(sysMenu.getId()) != null) {
                    authTree.put("checked", true);
                }
                authTrees.add(authTree);
            }
            return authTrees;
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    /**
     * 给角色分配菜单
     *
     * @throws ControllerException
     */
    @PostMapping("/granted")
    @ApiOperation(value = "角色分配菜单")
    @PreAuthorize("hasAuthority('menu:post/menus/granted')")
    @SLog(module = "user-center")
    public Result setMenuToRole(@RequestBody SysMenu sysMenu) throws ControllerException {
        try {
            menuService.setMenuToRole(sysMenu.getRoleId(), sysMenu.getMenuIds());
            return JsonResult.succeed("操作成功");
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @GetMapping("/findAlls")
    @ApiOperation(value = "查询所有菜单")
    @PreAuthorize("hasAuthority('menu:get/menus/findAlls')")
    @SLog(module = "user-center")
    public PageResult<SysMenu> findAlls() throws ControllerException {

        try {
            List<SysMenu> list = menuService.findAll();
            return PageResult.<SysMenu>builder().data(list).code(0).count((long) list.size()).build();
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @GetMapping("/findOnes")
    @ApiOperation(value = "获取菜单以及顶级菜单")
    @PreAuthorize("hasAuthority('menu:get/menus/findOnes')")
    public PageResult<SysMenu> findOnes() throws ControllerException {
        try {
            List<SysMenu> list = menuService.findOnes();
            return PageResult.<SysMenu>builder().data(list).code(0).count((long) list.size()).build();
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    /**
     * 添加菜单 或者 更新
     *
     * @param menu
     * @return
     * @throws ControllerException
     */
    @PostMapping("saveOrUpdate")
    @ApiOperation(value = "新增菜单")
    @PreAuthorize("hasAnyAuthority('menu:post/menus','menu:put/menus')")
    @SLog(module = "user-center")
    public Result saveOrUpdate(@RequestBody SysMenu menu) throws ControllerException {
        try {
            if (menu.getId() != null) {
                menuService.update(menu);
            } else {
                menuService.save(menu);
            }
            return JsonResult.succeed("操作成功");
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    /**
     * 当前登录用户的菜单
     *
     * @return
     * @throws ControllerException
     */
    @GetMapping("/current")
    @ApiOperation(value = "查询当前用户菜单")
    @PreAuthorize("hasAuthority('menu:get/menus/current')")
    @SLog(module = "user-center")
    public List<SysMenu> findMyMenu() throws ControllerException {
        LoginAppUser loginAppUser = SysUserUtil.getLoginAppUser();
        Set<SysRole> roles = loginAppUser.getSysRoles();
        if (CollectionUtils.isEmpty(roles)) {
            return Collections.emptyList();
        }
        List<SysMenu> menus = menuService.findByRoles(roles.parallelStream().map(SysRole::getId).collect(Collectors.toSet()));
        return treeBuilder(menus);
    }

    /**
     * 两层循环实现建树
     *
     * @param sysMenus
     * @return
     * @throws ControllerException
     */
    private static List<SysMenu> treeBuilder(List<SysMenu> sysMenus) throws ControllerException {
        List<SysMenu> menus = new ArrayList<SysMenu>();
        for (SysMenu sysMenu : sysMenus) {
            if (ObjectUtils.equals(-1L, sysMenu.getParentId())) {
                menus.add(sysMenu);
            }
            for (SysMenu menu : sysMenus) {
                if (menu.getParentId().equals(sysMenu.getId())) {
                    if (sysMenu.getSubMenus() == null) {
                        sysMenu.setSubMenus(new ArrayList<>());
                    }
                    sysMenu.getSubMenus().add(menu);
                }
            }
        }
        return menus;
    }
}
