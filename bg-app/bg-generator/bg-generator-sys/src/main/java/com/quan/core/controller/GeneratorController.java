package com.quan.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.quan.common.web.PageResult;
import com.quan.core.request.GeneratorQueryRequest;
import com.quan.core.service.SysGeneratorService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 代码生成配置类
 * @author zxq(956607644 @ qq.com)
 * @date 2020/12/9 15:35
 */
@RestController
@Api(tags = "代码生成器")
@RequestMapping("/generator")
public class GeneratorController {

    @Autowired
    private SysGeneratorService sysGeneratorService;

    /**
     * 列表
     *
     * @throws JsonProcessingException
     */
    @ApiOperation(value = "查找列表")
    @PostMapping("/list")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tableName", value = "数据表名称", dataType = "String"),
            @ApiImplicitParam(name = "pageNumber", value = "起始页码", required = true, dataType = "int"),
            @ApiImplicitParam(name = "pageSize", value = "每页显示数量", required = true, dataType = "int")
    })
    public @ResponseBody
    PageResult list(GeneratorQueryRequest data) throws Exception {
        return sysGeneratorService.queryList(data);
    }

    /**
     * 生成代码
     */
    @ApiOperation(value = "生成代码")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tables", value = "生成代码的数据表，多张表用逗号分隔", required = true, dataType = "String")
    })
    @PostMapping("/code")
    public void code(@RequestParam("tables") String tables, HttpServletResponse response) throws IOException {

        byte[] data = sysGeneratorService.generatorCode(tables.split(","));
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename=\"generator.zip\"");
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }


}
