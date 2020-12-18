package com.quan.core.unit.controller;

import com.quan.common.web.PageResult;
import com.quan.common.web.Result;
import com.quan.core.unit.model.SysUnit;
import com.quan.core.unit.service.SysUnitService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 系统单位表
 *
 * @author zhengxingquaqn
 * @email 956607644@qq.com
 * @date 2020-12-18 19:48:27
 */
@RestController
@RequestMapping("sysunit")
@Api(tags = "系统单位表")
public class SysUnitController {

    @Autowired
    private SysUnitService sysUnitService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys_unit:sysunit:list')")
    public PageResult list(@RequestParam Map<String, Object> params) {
        return (PageResult) sysUnitService.findAll(params);
    }


    /**
     * 保存
     */
    @RequestMapping("/save")
    @PreAuthorize("hasAnyAuthority('generator:sysroleuser:save')")
    public Result save(@RequestBody SysUnit sysUnit) {
        sysUnitService.save(sysUnit);

        return Result.succeed("保存成功");
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @PreAuthorize("hasAnyAuthority('generator:sysroleuser:update')")
    public Result update(@RequestBody SysUnit sysUnit) {
        sysUnitService.update(sysUnit);

        return Result.succeed("修改成功");
    }

    /**
     * 删除
     */
    @RequestMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('generator:sysroleuser:delete')")
    public Result delete(@PathVariable Long id) {
        sysUnitService.delete(id);
        return Result.succeed("删除成功");
    }

}
