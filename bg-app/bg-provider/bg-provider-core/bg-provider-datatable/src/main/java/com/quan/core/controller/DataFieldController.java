package com.quan.core.controller;

import com.quan.core.annotation.SLog;
import com.quan.core.constant.annotation.AutoCreateMenuAuth;
import com.quan.core.constant.constant.MenuType;
import com.quan.core.constant.web.JsonResult;
import com.quan.core.constant.web.Result;
import com.quan.core.controller.request.DataFieldFindOneByIdRequest;
import com.quan.core.controller.request.DataFieldPageQueryRequest;
import com.quan.core.controller.request.DataFieldQueryRequest;
import com.quan.core.controller.request.create.DataFieldCreateRequest;
import com.quan.core.controller.request.del.DataFieldBatchDeleteRequest;
import com.quan.core.controller.request.del.DataFieldDeleteRequest;
import com.quan.core.controller.request.update.DataFieldUpdateRequest;
import com.quan.core.service.DataFieldService;
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
 * 系统字段表
 *
 * @author ${author}
 * @email  956607644@qq.com
 * @date   2021-01-07 23:29:07
 */
@RestController
@RequestMapping("sys/data/field")
@Api(tags = "系统字段表管理")
@AutoCreateMenuAuth(type = MenuType.MENU, name = "系统字段表管理", permission = "sys:data:field")
public class DataFieldController {

    @Autowired
    private DataFieldService dataFieldService;

    /**
     * 列表
     */
    @ApiOperation(value = "查询列表")
    @PostMapping("/list")
    @PreAuthorize("hasAnyAuthority('sys:data:field:list')")
    @SLog(module = "datatable-center", tag = "查询列表")
    public Object data(DataFieldPageQueryRequest req) {
        return dataFieldService.findAll(req);
    }


    /**
     * 保存
     */
    @ApiOperation(value = "添加数据")
    @PostMapping("/save")
    @PreAuthorize("hasAnyAuthority('sys:data:field:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:data:field:save", parentPermission = "sys:data:field")
    @SLog(module = "datatable-center", tag = "添加数据")
    public Result doSave(@RequestBody DataFieldCreateRequest req) {
            dataFieldService.save(req);
        return JsonResult.succeed("保存成功");
    }

    /**
    * 批量添加数据
    */
    @ApiOperation(value = "批量添加数据")
    @PostMapping("/batchSave")
    @PreAuthorize("hasAnyAuthority('sys:data:field:save')")
    @AutoCreateMenuAuth(name = "新建", shortNo = 1, permission = "sys:data:field:save", parentPermission = "sys:data:field")
    @SLog(module = "datatable-center", tag = "批量添加数据")
    public Result doBatchSaveSave(@RequestBody List<DataFieldCreateRequest> req) {
            dataFieldService.batchSave(req);
        return JsonResult.succeed("保存成功");
    }

    /**
     * 修改
     */
    @ApiOperation(value = "编辑数据")
    @PostMapping("/update")
    @PreAuthorize("hasAnyAuthority('sys:data:field:update')")
    @AutoCreateMenuAuth(name = "编辑", shortNo = 2, permission = "sys:data:field:update", parentPermission = "sys:data:field")
    @SLog(module = "datatable-center", tag = "编辑数据")
    public Result doUpdate(@RequestBody DataFieldUpdateRequest req) {
            dataFieldService.update(req);
        return JsonResult.succeed("修改成功");
    }

    /**
     * 删除
     */
    @ApiOperation(value = "删除数据")
    @PostMapping("/delete")
    @PreAuthorize("hasAnyAuthority('sys:data:field:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 3, permission = "sys:data:field:delete", parentPermission = "sys:data:field")
    @SLog(module = "datatable-center", tag = "编辑数据")
    public Result doDelete(@RequestBody DataFieldDeleteRequest req) {
        return JsonResult.succeed(dataFieldService.delete(req.getId()), "删除成功");
    }

    /**
    * 批量删除
    */
    @ApiOperation(value = "删除数据")
    @PostMapping("/deletes")
    @PreAuthorize("hasAnyAuthority('sys:data:field:delete')")
    @AutoCreateMenuAuth(name = "删除", shortNo = 4, permission = "sys:data:field:delete", parentPermission = "sys:data:field")
    @SLog(module = "datatable-center", tag = "批量编辑数据")
    public Result doDeletes(@RequestBody DataFieldBatchDeleteRequest req) {
        return JsonResult.succeed(dataFieldService.delete(req.getIds()), "删除成功");
    }


    /**
     * 查找记录
     */
    @ApiOperation(value = "查找记录（通过主键）")
    @PostMapping("/findById")
    @PreAuthorize("hasAnyAuthority('sys:data:field:list')")
    @SLog(module = "datatable-center", tag = "通过主键查找记录")
    public Result doFindById(@RequestBody DataFieldFindOneByIdRequest req) {
        return JsonResult.succeed(dataFieldService.findOneById(req.getId()));
    }


    /**
     * 通过条件查找记录
     * @param req 对象数据
     * @return
     */
    @ApiOperation(value = "查找记录")
    @PostMapping("/findByCnd")
    @PreAuthorize("hasAnyAuthority('sys:data:field:list')")
    @SLog(module = "datatable-center", tag = "通过条件查找记录")
    public JsonResult doFindOneByCnd(@RequestBody DataFieldQueryRequest req) {
        return JsonResult.succeed(dataFieldService.findOneByCnd(req));
    }

    /**
     * 查找记录
     */
    @ApiOperation(value = "查找数据不分页")
    @PostMapping("/query")
    @PreAuthorize("hasAnyAuthority('sys:data:field:list')")
    @SLog(module = "datatable-center", tag = "通过条件查找记录")
    public JsonResult data(DataFieldQueryRequest req) {
        return JsonResult.succeed(dataFieldService.list(req));
    }


}
