# design-vue-bg-admin


在线表单设计器：SpreadJS ， 支持在线 PDF ，excel 设计，
通过后台填充数据


easypoi:http://easypoi.mydoc.io/#text_228273



### 平台目录结构说明



```

├─bg-app----------------------------父项目，公共依赖
│  │
│  ├─bg-eureka--------------------------微服务注册中心
│  │
│  ├─bg-discovery-----------------------微服务配置中心
│  │
│  ├─bg-monitor-------------------------微服务监控中心
│  │  │
│  │  ├─bg-admin-server-----------------系统监控中心
│  │  │
│  │  ├─bg-log-monitor------------------日志服务中心
│  │
│  ├─bg-gateway-------------------------微服务网关中心
│  │
│  ├─bg-job-center----------------------分布式任务配置中心
│  │
│  ├─bg-oauth-center--------------------认证中心
│  │  │
│  │  ├─bg-auth-server------------------系统认证与权限中心
│  │  │
│  │  ├─bg-auth-sso---------------------单点登录认证服务中心
│  │
│  ├─bg-provider
│  │  │
│  │  ├─bg-provider-core------------------系统平台服务中心
│  │  │
│  │  ├─bg-provider-file------------------文件服务中心
│  │  │
│  │  ├─bg-provider-mail------------------电子邮件服务中心
│  │  │
│  │  ├─bg-provider-sms------------------短信服务中心
│  │  │
│  │  └─bg-provider-workflow------------------工作流服务中心
│  │
│  ├─bg-provider-api
│  │  │
│  │  └─bg-provider-core-api------------------系统平台服务中心API
│  │
│  ├─bg-generator
│  │  │
│  │  └─bg-generator-sys------------------数据服务中心Mybatis Generator
│  │
├─bg-framework----------------------------项目依赖包
│  │

```

