#### 概要

components | contents | location
---|---|---
center | 服务注册中心 | samples/springcloud-center
config | 服务配置中心 | samples/springcloud-config
gateway | 网关 | samples/springcloud-gate
monitor | 监控cloud(还需要维护调试) |

#### 调试命令

```
cernter:
java -jar creedcenter.jar --spring.profiles.active=singleton 或默认启动
java -jar creedcenter.jar --spring.profiles.active=peer0
java -jar creedcenter.jar --spring.profiles.active=peer1
java -jar creedcenter.jar --spring.profiles.active=peer2



```