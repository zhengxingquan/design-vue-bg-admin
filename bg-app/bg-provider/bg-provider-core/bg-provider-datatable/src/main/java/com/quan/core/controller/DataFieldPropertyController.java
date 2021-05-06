package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.constant.annotation.AutoCreateMenuAuth;
import com.quan.core.constant.constant.MenuType;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.constant.web.Result;
import com.quan.core.controller.request.DataFieldPropertyFindOneByIdRequest;
import com.quan.core.controller.request.DataFieldPropertyPageQueryRequest;
import com.quan.core.controller.request.DataFieldPropertyQueryRequest;
import com.quan.core.controller.request.create.DataFieldPropertyCreateRequest;
import com.quan.core.controller.request.del.DataFieldPropertyBatchDeleteRequest;
import com.quan.core.controller.request.del.DataFieldPropertyDeleteRequest;
import com.quan.core.controller.request.update.DataFieldPropertyUpdateRequest;
import com.quan.core.service.DataFieldPropertyService;
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
 * 系统字段属性表
 *
 * @author ${author}
 * @email  956607644@qq.com
 * @date   2021-01-07 23:19:31
 */
@RestController
@RequestMapping("sys/data/field/property")
@Api(tags = "系统字段属性管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "字段属性管理", permission = "sys:data:field:property")
public class DataFieldPropertyController {

    @Autowired
    private DataFieldPropertyService dataFieldPropertyService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:data:field:property:list')")
    @SLog(module = "datatable-center", tag = "查询列表")
    public Object data(DataFieldPropertyPageQueryRequest req) {
        return dataFieldPropertyService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:data:field:property:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:data:field:property:save", parentPermission = "sys:data:field:property")
    @SLog(module = "datatable-center", tag = "添加数据")
    public Result doSave(@RequestBody DataFieldPropertyCreateRequest req) {
            dataFieldPropertyService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
    * 批量添加数据
    */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:data:field:property:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:data:field:property:save", parentPermission = "sys:data:field:property")
    @SLog(module = "datatable-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<DataFieldPropertyCreateRequest> req) {
            dataFieldPropertyService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:data:field:property:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:data:field:property:update", parentPermission = "sys:data:field:property")
    @SLog(module = "datatable-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody DataFieldPropertyUpdateRequest req) {
            dataFieldPropertyService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:data:field:property:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:data:field:property:delete", parentPermission = "sys:data:field:property")
    @SLog(module = "datatable-center", tag = "编辑数据")
    public Result doDelete(@RequestBody DataFieldPropertyDeleteRequest req) {
        return JsonResult.succeed(dataFieldPropertyService.delete(req.getId()), "删除成功");
    }

    /**
    * 批量删除
    */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:data:field:property:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:data:field:property:delete", parentPermission = "sys:data:field:property")
    @SLog(module = "datatable-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody DataFieldPropertyBatchDeleteRequest req) {
        return JsonResult.succeed(dataFieldPropertyService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:data:field:property:list')")
    @SLog(module = "datatable-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody DataFieldPropertyFindOneByIdRequest req) {
        return JsonResult.succeed(dataFieldPropertyService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:data:field:property:list')")
    @SLog(module = "datatable-center", tag = "通过条件查找记录")
    public Result doFindOneByCnd(@RequestBody DataFieldPropertyQueryRequest req) {
        return JsonResult.succeed(dataFieldPropertyService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:data:field:property:list')")
    @SLog(module = "datatable-center", tag = "通过条件查找记录")
    public Result data(DataFieldPropertyQueryRequest req) {
        return JsonResult.succeed(dataFieldPropertyService.list(req));
    }


}
