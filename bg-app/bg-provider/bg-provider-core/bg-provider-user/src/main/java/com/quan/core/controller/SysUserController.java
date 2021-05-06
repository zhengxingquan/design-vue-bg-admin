package com.quan.core.controller;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.quan.core.constant.annotation.ApiIdempotent;
import com.quan.core.constant.auth.details.LoginAppUser;
import com.quan.core.constant.exception.controller.ControllerException;
import com.quan.core.constant.exception.service.ServiceException;
import com.quan.core.constant.model.SysRole;
import com.quan.core.constant.model.SysUser;
import com.quan.core.constant.util.SysUserUtil;
import com.quan.core.constant.web.PageResult;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.annotation.SLog;
import com.quan.core.constant.web.Result;
import com.quan.core.model.SysUserExcel;
import com.quan.core.service.SysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 作者 owen
 * @version 创建时间：2017年11月12日 上午22:57:51
 * 用户
 */
@Slf4j
@RestController
@Api(tags = "USER API")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 当前登录用户 LoginAppUser
     *
     * @return
     * @throws ControllerException
     * @throws JsonProcessingException
     */
    @ApiOperation(value = "根据access_token当前登录用户")
    @GetMapping("/users/current")
    @SLog(module = "user-center")
    public LoginAppUser getLoginAppUser() throws ControllerException {
        try {
            LoginAppUser loginUser = SysUserUtil.getLoginAppUser();
            return loginUser;
        } catch (Exception e) {
            throw new ControllerException(e);
        }
    }

    @GetMapping(value = "/users-anon/login", params = "username")
    @ApiOperation(value = "根据用户名查询用户")
    @SLog(module = "user-center")
    public LoginAppUser findByUsername(String username) throws ControllerException {
        try {
            return sysUserService.findByUsername(username);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @GetMapping(value = "/users-anon/mobile", params = "mobile")
    @ApiOperation(value = "根据用户名查询手机号")
    @SLog(module = "user-center")
    public LoginAppUser findByMobile(String mobile) throws ControllerException {
        try {
            return sysUserService.findByMobile(mobile);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    @PreAuthorize("hasAuthority('user:get/users/{id}')")
    @GetMapping("/users/{id}")
    @SLog(module = "user-center")
    public SysUser findUserById(@PathVariable Long id) throws ControllerException {
        try {
            return sysUserService.findById(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    /**
     * 管理后台，给用户重置密码
     *
     * @param id
     * @param newPassword
     * @throws ControllerException
     */
    @PreAuthorize("hasAnyAuthority('user:put/users/password','user:post/users/{id}/resetPassword')")
    @PutMapping(value = "/users/{id}/password", params = {"newPassword"})
    @SLog(module = "user-center")
    public void resetPassword(@PathVariable Long id, String newPassword) throws ControllerException {
        try {
            sysUserService.updatePassword(id, null, newPassword);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    /**
     * 管理后台修改用户
     *
     * @param sysUser
     * @throws JsonProcessingException
     */
    @PreAuthorize("hasAuthority('user:put/users/me')")
    @PutMapping("/users")
    @SLog(module = "user-center")
    public void updateSysUser(@RequestBody SysUser sysUser) throws ControllerException {
        try {
            sysUserService.updateSysUser(sysUser);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    /**
     * 管理后台给用户分配角色
     *
     * @param id
     * @param roleIds
     * @throws JsonProcessingException
     */
    @PreAuthorize("hasAuthority('user:post/users/{id}/roles')")
    @PostMapping("/users/{id}/roles")
    @SLog(module = "user-center")
    public void setRoleToUser(@PathVariable Long id, @RequestBody Set<Long> roleIds) throws ControllerException {
        try {
            sysUserService.setRoleToUser(id, roleIds);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    /**
     * 获取用户的角色
     *
     * @param
     * @return
     * @throws ControllerException
     */
    @PreAuthorize("hasAnyAuthority('user:get/users/{id}/roles')")
    @GetMapping("/users/{id}/roles")
    @SLog(module = "user-center")
    public Set<SysRole> findRolesByUserId(@PathVariable Long id) throws ControllerException {
        try {
            return sysUserService.findRolesByUserId(id);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }


    /**
     * 用户查询
     * http://192.168.3.2:7000/users?access_token=3b45d059-601b-4c63-85f9-9d77128ee94d&start=0&length=10
     * @param params //  searchKey=username, searchValue=as
     * @return
     * @throws ControllerException
     */
    @PreAuthorize("hasAuthority('user:get/users')")
    @ApiOperation(value = "用户查询列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "分页起始位置", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "limit", value = "分页结束位置", required = true, dataType = "Integer")
    })
    @GetMapping("/users")
    @SLog(module = "user-center")
    public PageResult<SysUser> findUsers(@RequestParam Map<String, Object> params) throws ControllerException {

        try {
            return sysUserService.findUsers(params);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    /**
     * 修改自己的个人信息
     * @param sysUser
     * @return
     * @throws ControllerException
     */
    @PutMapping("/users/me")
    @SLog(module = "user-center")
    @PreAuthorize("hasAnyAuthority('user:put/users/me','user:post/users/saveOrUpdate')")
    public Result updateMe(@RequestBody SysUser sysUser) throws ControllerException {
//        SysUser user = SysUserUtil.getLoginAppUser();
//        sysUser.setId(user.getId());
        try {
            SysUser user = sysUserService.updateSysUser(sysUser);
            return JsonResult.succeed(user, "操作成功");
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    /**
     * 修改密码
     * @param sysUser
     * @throws ControllerException
     */
    @PutMapping(value = "/users/password")
    @PreAuthorize("hasAuthority('user:put/users/password')")
    @SLog(module = "user-center")
    public Result updatePassword(@RequestBody SysUser sysUser) throws ControllerException {
        try {
            if (StringUtils.isBlank(sysUser.getOldPassword())) {
                throw new IllegalArgumentException("旧密码不能为空");
            }
            if (StringUtils.isBlank(sysUser.getNewPassword())) {
                throw new IllegalArgumentException("新密码不能为空");
            }
            if (sysUser.getId() == 1277137734524300032L) {
                return JsonResult.failed("超级管理员不给予修改");
            }
            return sysUserService.updatePassword(sysUser.getId(), sysUser.getOldPassword(), sysUser.getNewPassword());
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    /**
     * 修改用户状态
     * @param params
     * @return
     * @throws ControllerException
     * @author gitgeek
     */
    @ApiOperation(value = "修改用户状态")
    @GetMapping("/users/updateEnabled")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "enabled", value = "是否启用", required = true, dataType = "Boolean")
    })
    @SLog(module = "user-center")
    @PreAuthorize("hasAnyAuthority('user:get/users/updateEnabled' ,'user:put/users/me')")
    public Result updateEnabled(@RequestParam Map<String, Object> params) throws ControllerException {
        try {
            Long id = MapUtils.getLong(params, "id");
            if (id == 1277137734524300032L) {
                return JsonResult.failed("超级管理员不给予修改");
            }
            return sysUserService.updateEnabled(params);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    /**
     * 管理后台，给用户重置密码
     * @param id
     * @throws ControllerException
     * @author gitgeek
     */
    @PreAuthorize("hasAuthority('user:post/users/{id}/resetPassword' )")
    @PostMapping(value = "/users/{id}/resetPassword")
    @SLog(module = "user-center")
    public Result resetPassword(@PathVariable Long id) throws ControllerException {
        try {
            if (id == 1277137734524300032L) {
                return JsonResult.failed("超级管理员不给予修改");
            }
            sysUserService.updatePassword(id, null, "123456");
            return JsonResult.succeed(null, "重置成功");
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }


    /**
     * 新增or更新
     * @param sysUser
     * @return
     * @throws ControllerException
     */
    @PostMapping("/users/saveOrUpdate")
    @PreAuthorize("hasAnyAuthority('user:post/users/saveOrUpdate')")
    @SLog(module = "user-center")
    public Result saveOrUpdate(@RequestBody SysUser sysUser) throws ControllerException {
        try {
            return sysUserService.saveOrUpdate(sysUser);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }

    /**
     * 导出数据
     *
     * @return
     * @throws ControllerException
     */
    @PostMapping("/users/exportUser")
    @PreAuthorize("hasAuthority('user:post/users/exportUser')")
    public void exportUser(@RequestParam Map<String, Object> params, HttpServletRequest request, HttpServletResponse response) throws ControllerException {
        try {
            List<SysUserExcel> result = sysUserService.findAllUsers(params);
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-disposition", "attachment;filename=myExcel.xls");
            @Cleanup OutputStream ouputStream = null;
            Workbook workbook = ExcelExportUtil.exportExcel(new ExportParams("用户导出", "用户"),
                    SysUserExcel.class, result);
            ouputStream = response.getOutputStream();
            workbook.write(ouputStream);
        } catch (ServiceException e) {
            throw new ControllerException(e);
        } catch (IOException e) {
            throw new ControllerException(e);
        }

    }


    /**
     * 测试幂等接口
     * @param sysUser
     * @return
     * @throws ControllerException
     */
    @PostMapping("/users/save")
    @ApiIdempotent
    public Result save(@RequestBody SysUser sysUser) throws ControllerException {
        try {
            return sysUserService.saveOrUpdate(sysUser);
        } catch (ServiceException e) {
            log.error("执行" + this.getClass().getSimpleName() + ":" + new Exception().getStackTrace()[0].getMethodName());
            throw new ControllerException(e);
        }
    }


}
