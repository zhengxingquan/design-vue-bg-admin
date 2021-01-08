package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.web.JsonResult;
import com.quan.core.common.web.Result;
import com.quan.core.service.UnitService;
import com.quan.core.request.create.UnitCreateRequest;
import com.quan.core.request.update.UnitUpdateRequest;
import com.quan.core.request.del.UnitBatchDeleteRequest;
import com.quan.core.request.del.UnitDeleteRequest;
import com.quan.core.request.UnitPageQueryRequest;
import com.quan.core.request.UnitQueryRequest;
import com.quan.core.request.UnitFindOneByIdRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * 系统单位表
 *
 * @author ${author}
 * @email  956607644@qq.com
 * @date   2020-12-31 15:39:39
 */
@RestController
@RequestMapping("sys/unit")
@Api(tags = "组织架构管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "组织架构管理", permission = "sys:unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:unit:list')")
    @SLog(module = "unit-center", tag = "查询列表")
    public Object data(UnitPageQueryRequest req) {
        return unitService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:unit:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:unit:save", parentPermission = "sys:unit")
    @SLog(module = "unit-center", tag = "添加数据")
    public Result doSave(@RequestBody UnitCreateRequest req) {
        unitService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
    * 批量添加数据
    */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:unit:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:unit:save", parentPermission = "sys:unit")
    @SLog(module = "unit-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<UnitCreateRequest> req) {
        unitService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:unit:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:unit:update", parentPermission = "sys:unit")
    @SLog(module = "unit-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody UnitUpdateRequest req) {
            unitService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:unit:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:unit:delete", parentPermission = "sys:unit")
    @SLog(module = "unit-center", tag = "编辑数据")
    public Result doDelete(@RequestBody UnitDeleteRequest req) {
        return JsonResult.succeed(unitService.delete(req.getId()), "删除成功");
    }

    /**
    * 批量删除
    */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:unit:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:unit:delete", parentPermission = "sys:unit")
    @SLog(module = "unit-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody UnitBatchDeleteRequest req) {
        return JsonResult.succeed(unitService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:unit:list')")
    @SLog(module = "unit-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody UnitFindOneByIdRequest req) {
        return JsonResult.succeed(unitService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:unit:list')")
    @SLog(module = "unit-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody UnitQueryRequest req) {
        return JsonResult.succeed(unitService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:unit:list')")
    @SLog(module = "unit-center", tag = "通过条件查找记录")
    public Result data(UnitQueryRequest req) {
        return JsonResult.succeed(unitService.list(req));
    }


}
