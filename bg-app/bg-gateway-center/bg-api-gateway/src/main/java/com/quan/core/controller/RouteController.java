package com.quan.core.controller;

import com.quan.core.constant.web.PageResult;
import com.quan.core.constant.web.Result;
import com.quan.core.dto.GatewayRouteDefinition;
import com.quan.core.service.DynamicRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.Map;

@RestController
@RequestMapping("/sys/route")
@SuppressWarnings("all")
public class RouteController {

    @Autowired
    private DynamicRouteService dynamicRouteService;

    //增加路由
    @PostMapping("/add")
    public Mono<Result> add(@RequestBody GatewayRouteDefinition gatewayRouteDefinition) {
        dynamicRouteService.add(gatewayRouteDefinition);
        return Mono.just(Result.succeed());
    }

    //更新路由
    @PostMapping("/update")
    public Mono<Result> update(@RequestBody GatewayRouteDefinition gatewayRouteDefinition) {
        dynamicRouteService.update(gatewayRouteDefinition);
        return Mono.just(Result.succeed());
    }

    //删除路由
    @DeleteMapping("/{id}")
    public Mono<Result> delete(@PathVariable String id) {
        return Mono.just(Result.succeed(dynamicRouteService.delete(id)));
    }

    //获取全部数据
    @GetMapping("/findAll")
    public Mono<PageResult> findAll(@RequestParam Map<String, Object> params) {
        return Mono.just(dynamicRouteService.findAll(params));
    }

    //同步redis数据 从mysql中同步过去
    @GetMapping("/synchronization")
    public Mono<Result> synchronization() {
        return Mono.just(Result.succeed(dynamicRouteService.synchronization()));
    }


    //修改路由状态
    @GetMapping("/updateFlag")
    public Mono<Result> updateFlag(@RequestParam Map<String, Object> params) {
        return Mono.just(Result.succeed(dynamicRouteService.updateFlag(params)));
    }


}
