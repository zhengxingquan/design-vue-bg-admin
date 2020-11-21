# design-vue-bg-admin




### 平台目录结构说明


```
├─bg-master----------------------------父项目，公共依赖
│  │
│  ├─bg-eureka--------------------------微服务注册中心
│  │
│  ├─bg-discovery-----------------------微服务配置中心
│  │
│  ├─bg-monitor-------------------------微服务监控中心
│  │
│  ├─bg-zipkin--------------------------微服务日志采集中心
│  │
│  ├─bg-gateway--------------------------微服务网关中心
│  │
│  ├─bg-provider
│  │  │
│  │  ├─bg-provider-mdc------------------数据服务中心
│  │  │
│  │  ├─bg-provider-omc------------------订单服务中心
│  │  │
│  │  ├─bg-provider-opc------------------对接服务中心
│  │  │
│  │  ├─bg-provider-tpc------------------任务服务中心
│  │  │
│  │  └─bg-provider-uac------------------用户服务中心
│  │
│  ├─bg-provider-api
│  │  │
│  │  ├─bg-provider-mdc-api------------------数据服务中心API
│  │  │
│  │  ├─bg-provider-omc-api------------------订单服务中心API
│  │  │
│  │  ├─bg-provider-opc-api------------------对接服务中心API
│  │  │
│  │  ├─bg-provider-tpc-api------------------任务服务中心API
│  │  │
│  │  ├─bg-provider-sdk-api------------------可靠消息服务API
│  │  │
│  │  └─bg-provider-uac-api------------------用户服务中心API
│  │
│  ├─bg-common
│  │  │
│  │  ├─bg-common-base------------------公共POJO基础包
│  │  │
│  │  ├─bg-common-config------------------公共配置包
│  │  │
│  │  ├─bg-common-core------------------微服务核心依赖包
│  │  │
│  │  ├─bg-common-util------------------公共工具包
│  │  │
│  │  ├─bg-common-zk------------------zookeeper配置
│  │  │
│  │  ├─bg-security-app------------------公共无状态安全认证
│  │  │
│  │  ├─bg-security-core------------------安全服务核心包
│  │  │
│  │  └─bg-security-feign------------------基于auth2的feign配置
│  │
│  ├─bg-generator
│  │  │
│  │  ├─bg-generator-mdc------------------数据服务中心Mybatis Generator
│  │  │
│  │  ├─bg-generator-omc------------------数据服务中心Mybatis Generator
│  │  │
│  │  ├─bg-generator-opc------------------数据服务中心Mybatis Generator
│  │  │
│  │  ├─bg-generator-tpc------------------数据服务中心Mybatis Generator
│  │  │
│  │  └─bg-generator-uac------------------数据服务中心Mybatis Generator




```

