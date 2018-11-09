```
简单可靠解决业务问题
build-neat
保留开源信息、dependencyManagement与pluginManagement，其他全部删除的构建父pom
dependencies
保留开源信息、dependencyManagement与pluginManagement，其他全部删除，并且扩展父模块的所有依赖的构建父pom
creed-projects
事件机制
ddd
设计模式
同步事件注册
通用上下文
spring-supports
spring框架一些功能的增强跟开启
samples
所有核心概念的示例

个体工程多模块分层
view -渲染层(模板引擎)

api -外服提供接口
controller -内部控制、校验、简单处理
service -内部处理聚合
scene -外部服务聚合
stub -服务存根与sdk提供给其他服务使用
domain -领域主体操作
dao -数据库orm交互、各种其他数据源实体类
```