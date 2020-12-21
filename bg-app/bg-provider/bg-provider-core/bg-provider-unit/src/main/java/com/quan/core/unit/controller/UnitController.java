package com.quan.core.unit.controller;

import com.quan.common.web.PageResult;
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
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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
 * @date 2020-12-21 20:03:28
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = false, dataType = "Long"),
            @ApiImplicitParam(name = "parentId", value = "父级ID", required = false, dataType = "String"),
            @ApiImplicitParam(name = "name", value = "单位名称", required = false, dataType = "String"),
            @ApiImplicitParam(name = "aliasName", value = "单位别名", required = false, dataType = "String"),
            @ApiImplicitParam(name = "unitCode", value = "机构编码", required = false, dataType = "String"),
            @ApiImplicitParam(name = "note", value = "单位介绍", required = false, dataType = "String"),
            @ApiImplicitParam(name = "field1", value = "附加值一", required = false, dataType = "String"),
            @ApiImplicitParam(name = "field2", value = "附加值二", required = false, dataType = "String"),
            @ApiImplicitParam(name = "field3", value = "附加值三", required = false, dataType = "String"),
            @ApiImplicitParam(name = "sort", value = "排序字段", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "disabled", value = "是否禁用", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "hasChildren", value = "是否有子节点", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "logo", value = "单位logo", required = false, dataType = "String"),
            @ApiImplicitParam(name = "createTime", value = "创建时间", required = false, dataType = "Date"),
            @ApiImplicitParam(name = "createUserId", value = "创建人员ID", required = false, dataType = "Long"),
            @ApiImplicitParam(name = "updateTime", value = "更新时间", required = false, dataType = "Date"),
            @ApiImplicitParam(name = "updateUserId", value = "编辑人员ID", required = false, dataType = "Long"),
            @ApiImplicitParam(name = "dataState", value = "数据状态 0启动1删除", required = false, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "起始页码", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示数量", required = true, dataType = "int")
    })
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys_unit:unit:list')")
    public PageResult list(UnitPageQueryRequest unitPageQueryData) {
        PageResult pageResult = unitService.findAll(unitPageQueryData);
        return pageResult;
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", dataType = "Long"),
            @ApiImplicitParam(name = "parentId", value = "父级ID", dataType = "String"),
            @ApiImplicitParam(name = "name", value = "单位名称", dataType = "String"),
            @ApiImplicitParam(name = "aliasName", value = "单位别名", dataType = "String"),
            @ApiImplicitParam(name = "unitCode", value = "机构编码", dataType = "String"),
            @ApiImplicitParam(name = "note", value = "单位介绍", dataType = "String"),
            @ApiImplicitParam(name = "field1", value = "附加值一", dataType = "String"),
            @ApiImplicitParam(name = "field2", value = "附加值二", dataType = "String"),
            @ApiImplicitParam(name = "field3", value = "附加值三", dataType = "String"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "Integer"),
            @ApiImplicitParam(name = "disabled", value = "是否禁用", dataType = "Integer"),
            @ApiImplicitParam(name = "hasChildren", value = "是否有子节点", dataType = "Integer"),
            @ApiImplicitParam(name = "logo", value = "单位logo", dataType = "String"),
            @ApiImplicitParam(name = "createTime", value = "创建时间", dataType = "Date"),
            @ApiImplicitParam(name = "createUserId", value = "创建人员ID", dataType = "Long"),
            @ApiImplicitParam(name = "updateTime", value = "更新时间", dataType = "Date"),
            @ApiImplicitParam(name = "updateUserId", value = "编辑人员ID", dataType = "Long"),
            @ApiImplicitParam(name = "dataState", value = "数据状态 0启动1删除", dataType = "Integer"),
    })
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('generator:sysroleuser:save')")
    public Result save(@RequestBody UnitCreateRequest unitCreateData) {
        unitService.save(unitCreateData);
        return Result.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "id", value = "ID", dataType = "Long"),
            @ApiImplicitParam(name = "parentId", value = "父级ID", dataType = "String"),
            @ApiImplicitParam(name = "name", value = "单位名称", dataType = "String"),
            @ApiImplicitParam(name = "aliasName", value = "单位别名", dataType = "String"),
            @ApiImplicitParam(name = "unitCode", value = "机构编码", dataType = "String"),
            @ApiImplicitParam(name = "note", value = "单位介绍", dataType = "String"),
            @ApiImplicitParam(name = "field1", value = "附加值一", dataType = "String"),
            @ApiImplicitParam(name = "field2", value = "附加值二", dataType = "String"),
            @ApiImplicitParam(name = "field3", value = "附加值三", dataType = "String"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "Integer"),
            @ApiImplicitParam(name = "disabled", value = "是否禁用", dataType = "Integer"),
            @ApiImplicitParam(name = "hasChildren", value = "是否有子节点", dataType = "Integer"),
            @ApiImplicitParam(name = "logo", value = "单位logo", dataType = "String"),
            @ApiImplicitParam(name = "createTime", value = "创建时间", dataType = "Date"),
            @ApiImplicitParam(name = "createUserId", value = "创建人员ID", dataType = "Long"),
            @ApiImplicitParam(name = "updateTime", value = "更新时间", dataType = "Date"),
            @ApiImplicitParam(name = "updateUserId", value = "编辑人员ID", dataType = "Long"),
            @ApiImplicitParam(name = "dataState", value = "数据状态 0启动1删除", dataType = "Integer"),
    })
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", dataType = "Long"),
            @ApiImplicitParam(name = "parentId", value = "父级ID", dataType = "String"),
            @ApiImplicitParam(name = "name", value = "单位名称", dataType = "String"),
            @ApiImplicitParam(name = "aliasName", value = "单位别名", dataType = "String"),
            @ApiImplicitParam(name = "unitCode", value = "机构编码", dataType = "String"),
            @ApiImplicitParam(name = "note", value = "单位介绍", dataType = "String"),
            @ApiImplicitParam(name = "field1", value = "附加值一", dataType = "String"),
            @ApiImplicitParam(name = "field2", value = "附加值二", dataType = "String"),
            @ApiImplicitParam(name = "field3", value = "附加值三", dataType = "String"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "Integer"),
            @ApiImplicitParam(name = "disabled", value = "是否禁用", dataType = "Integer"),
            @ApiImplicitParam(name = "hasChildren", value = "是否有子节点", dataType = "Integer"),
            @ApiImplicitParam(name = "logo", value = "单位logo", dataType = "String"),
            @ApiImplicitParam(name = "createUserId", value = "创建人员ID", dataType = "Long"),
    })
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('generator:sysroleuser:findByCnd')")
    public Result findOneByCnd(@RequestBody UnitQueryRequest req) {
        return Result.succeed(unitService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "ID", dataType = "Long"),
            @ApiImplicitParam(name = "parentId", value = "父级ID", dataType = "String"),
            @ApiImplicitParam(name = "name", value = "单位名称", dataType = "String"),
            @ApiImplicitParam(name = "aliasName", value = "单位别名", dataType = "String"),
            @ApiImplicitParam(name = "unitCode", value = "机构编码", dataType = "String"),
            @ApiImplicitParam(name = "note", value = "单位介绍", dataType = "String"),
            @ApiImplicitParam(name = "field1", value = "附加值一", dataType = "String"),
            @ApiImplicitParam(name = "field2", value = "附加值二", dataType = "String"),
            @ApiImplicitParam(name = "field3", value = "附加值三", dataType = "String"),
            @ApiImplicitParam(name = "sort", value = "排序字段", dataType = "Integer"),
            @ApiImplicitParam(name = "disabled", value = "是否禁用", dataType = "Integer"),
            @ApiImplicitParam(name = "hasChildren", value = "是否有子节点", dataType = "Integer"),
            @ApiImplicitParam(name = "logo", value = "单位logo", dataType = "String"),
            @ApiImplicitParam(name = "createUserId", value = "创建人员ID", dataType = "Long"),
    })
    @RequestMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys_unit:unit:query')")
    public Result data(UnitQueryRequest req) {
        return Result.succeed(unitService.list(req));
    }


}
