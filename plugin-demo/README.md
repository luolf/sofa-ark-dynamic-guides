# 快速开始

> SOFABoot 需要基于 3.2.x 版本以下，推荐使用 3.1.4。
  这里只有common-facade普通jar包，其余的都是插件包
  common-facade:公共模块包，提供facade接口定义
  storage-disk: 插件包；实现common-facade定义接口，并发布；导出DiskSize类给biz层使用
  storage-mysql:插件包；实现common-facade定义接口，并发布；导出MysqlSize类给biz层使用
  use-storage:  插件包；引用storage-disk、storage-mysql发布的接口服务并调用

