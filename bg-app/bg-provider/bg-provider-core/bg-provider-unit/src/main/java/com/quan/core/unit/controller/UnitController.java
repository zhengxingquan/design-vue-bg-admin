package com.quan.core.unit.controller;

import com.quan.common.web.Result;
import com.quan.core.unit.request.UnitFindOneByIdRequest;
import com.quan.core.unit.request.UnitPageQueryRequest;
import com.quan.core.unit.request.UnitQueryRequest;
import com.quan.core.unit.request.create.UnitCreateRequest;
import com.quan.core.unit.request.del.UnitBatchDeleteRequest;
import com.quan.core.unit.request.del.UnitDeleteRequest;
import com.quan.core.unit.request.update.UnitUpdateRequest;
import com.quan.core.unit.service.UnitService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统单位表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2020-12-22 19:04:56
 */
@RestController
@RequestMapping("unit")
@Api(tags = "系统单位表")
public class UnitController {

    @Autowired
    private UnitService unitService;


    /**
     * 列表
     */
    @ApiOperation(value = "查找列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys_unit:unit:list')")
    public Object list(UnitPageQueryRequest req) {
        return unitService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('generator:sysroleuser:save')")
    public Result save(@RequestBody UnitCreateRequest req) {
        unitService.save(req);
        return Result.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('generator:sysroleuser:update')")
    public Result update(@RequestBody UnitUpdateRequest req) {
        unitService.update(req);
        return Result.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('generator:sysroleuser:delete')")
    public Result delete(@RequestBody UnitDeleteRequest req) {
        return Result.succeed(unitService.delete(req.getId()), "删除成功");
    }

    /**
     * 批量删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('generator:sysroleuser:delete')")
    public Result deletes(@RequestBody UnitBatchDeleteRequest req) {
        return Result.succeed(unitService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('generator:sysroleuser:findById')")
    public Result findById(@RequestBody UnitFindOneByIdRequest req) {
        return Result.succeed(unitService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     *
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('generator:sysroleuser:findByCnd')")
    public Result findOneByCnd(@RequestBody UnitQueryRequest req) {
        return Result.succeed(unitService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys_unit:unit:query')")
    public Result data(UnitQueryRequest req) {
        return Result.succeed(unitService.list(req));
    }


}
