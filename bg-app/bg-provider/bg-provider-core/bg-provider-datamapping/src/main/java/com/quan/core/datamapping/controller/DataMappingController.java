package com.quan.core.datamapping.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.constant.annotation.AutoCreateMenuAuth;
import com.quan.core.constant.constant.MenuType;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.constant.web.Result;
import com.quan.core.datamapping.request.*;
import com.quan.core.datamapping.request.create.DataMappingCreateRequest;
import com.quan.core.datamapping.request.del.DataMappingBatchDeleteRequest;
import com.quan.core.datamapping.request.del.DataMappingDeleteRequest;
import com.quan.core.datamapping.request.update.DataMappingUpdateRequest;
import com.quan.core.datamapping.service.DataMappingService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 系统映射配置表
 *
 * @author ${author}
 * @email 956607644@qq.com
 * @date 2021-01-08 16:02:13
 */
@RestController
@RequestMapping("sys/data/mapping")
@Api(tags = "系统映射配置管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "系统映射配置管理", permission = "sys:data:mapping")
public class DataMappingController {

    @Autowired
    private DataMappingService dataMappingService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:data:mapping:list')")
    @SLog(module = "datamapping-center", tag = "查询列表")
    public Object data(@RequestBody DataMappingPageQueryRequest req) {
        return dataMappingService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:data:mapping:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:data:mapping:save", parentPermission = "sys:data:mapping")
    @SLog(module = "datamapping-center", tag = "添加数据")
    public Result doSave(@RequestBody DataMappingCreateRequest req) {
        dataMappingService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 批量添加数据
     */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:data:mapping:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:data:mapping:save", parentPermission = "sys:data:mapping")
    @SLog(module = "datamapping-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<DataMappingCreateRequest> req) {
        dataMappingService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:data:mapping:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:data:mapping:update", parentPermission = "sys:data:mapping")
    @SLog(module = "datamapping-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody DataMappingUpdateRequest req) {
        dataMappingService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:data:mapping:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:data:mapping:delete", parentPermission = "sys:data:mapping")
    @SLog(module = "datamapping-center", tag = "编辑数据")
    public Result doDelete(@RequestBody DataMappingDeleteRequest req) {
        return JsonResult.succeed(dataMappingService.delete(req.getId()), "删除成功");
    }

    /**
     * 批量删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:data:mapping:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:data:mapping:delete", parentPermission = "sys:data:mapping")
    @SLog(module = "datamapping-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody DataMappingBatchDeleteRequest req) {
        return JsonResult.succeed(dataMappingService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:data:mapping:list')")
    @SLog(module = "datamapping-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody DataMappingFindOneByIdRequest req) {
        return JsonResult.succeed(dataMappingService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     *
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:data:mapping:list')")
    @SLog(module = "datamapping-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody DataMappingQueryRequest req) {
        return JsonResult.succeed(dataMappingService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:data:mapping:list')")
    @SLog(module = "datamapping-center", tag = "通过条件查找记录")
    public Result data(@RequestBody DataMappingQueryRequest req) {
        return JsonResult.succeed(dataMappingService.list(req));
    }


    /**
     * 启用
     */
    @ApiOperation(value = "启用")
    @PostMapping("/enable")
    @PreAuthorize("hasAnyAuthority('sys:data:mapping:enable')")
    @SLog(module = "datamapping-center", tag = "启用")
    public Result doEnable(@RequestBody DataMappingEnableRequest req) {
        return JsonResult.succeed(dataMappingService.enable(req));
    }


    /**
     * 禁用
     */
    @ApiOperation(value = "禁用")
    @PostMapping("/disable")
    @PreAuthorize("hasAnyAuthority('sys:data:mapping:disable')")
    @SLog(module = "datamapping-center", tag = "禁用")
    public Result doDisable(@RequestBody DataMappingDisableRequest req) {
        return JsonResult.succeed(dataMappingService.disable(req));
    }


}
