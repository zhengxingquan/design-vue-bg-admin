package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.common.annotation.AutoCreateMenuAuth;
import com.quan.core.common.enume.MenuType;
import com.quan.core.common.web.Result;
import com.quan.core.service.DictService;
import com.quan.core.request.create.DictCreateRequest;
import com.quan.core.request.update.DictUpdateRequest;
import com.quan.core.request.del.DictBatchDeleteRequest;
import com.quan.core.request.del.DictDeleteRequest;
import com.quan.core.request.DictPageQueryRequest;
import com.quan.core.request.DictQueryRequest;
import com.quan.core.request.DictFindOneByIdRequest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

/**
 * 系统字典表
 *
 * @author ${author}
 * @email  956607644@qq.com
 * @date   2021-01-05 16:01:09
 */
@RestController
@RequestMapping("sys/dict")
@Api(tags = "系统字典表")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "系统字典表", permission = "sys:dict")
public class DictController {

    @Autowired
    private DictService dictService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:dict:list')")
    @SLog(module = "dict-center", tag = "查询列表")
    public Object data(@RequestBody DictPageQueryRequest req) {
        return dictService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:dict:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:dict:save", parentPermission = "sys:dict")
    @SLog(module = "dict-center", tag = "添加数据")
    public Result doSave(@RequestBody DictCreateRequest req) {
            dictService.save(req);
        return Result.succeed("保存成功");
    }

    /**
    * 批量添加数据
    */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:dict:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:dict:save", parentPermission = "sys:dict")
    @SLog(module = "dict-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<DictCreateRequest> req) {
            dictService.batchSave(req);
        return Result.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:dict:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:dict:update", parentPermission = "sys:dict")
    @SLog(module = "dict-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody DictUpdateRequest req) {
            dictService.update(req);
        return Result.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:dict:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:dict:delete", parentPermission = "sys:dict")
    @SLog(module = "dict-center", tag = "编辑数据")
    public Result doDelete(@RequestBody DictDeleteRequest req) {
        return Result.succeed(dictService.delete(req.getId()), "删除成功");
    }

    /**
    * 批量删除
    */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:dict:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:dict:delete", parentPermission = "sys:dict")
    @SLog(module = "dict-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody DictBatchDeleteRequest req) {
        return Result.succeed(dictService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:dict:list')")
    @SLog(module = "dict-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody DictFindOneByIdRequest req) {
        return Result.succeed(dictService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:dict:list')")
    @SLog(module = "dict-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody DictQueryRequest req) {
        return Result.succeed(dictService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:dict:list')")
    @SLog(module = "dict-center", tag = "通过条件查找记录")
    public Result data(DictQueryRequest req) {
        return Result.succeed(dictService.list(req));
    }


}