# system-monitor

**基于（siger）开发的SpringBoot项目，java获取服务器信息**

该项目为 Java探针 运行前提是 有Jvm环境，集成了Swagger接口


**场景：**
 在没有使用 **分布式**的项目，进行集群管理时，有时候来了做服务器监控的需求
 
 如果没有特殊要求 阿里开源的 ```Arthas``` 是非常好用的java诊断工具
 
 但是 如果要做 监控数据化的话 就需要自己开发了 
 
 这里我分享一套 最近刚写的Java探针 
 
 运行起来后查看接口
 
> #API接口文档
 
> 127.0.0.1:7000/doc.html

 使用主服务 去定时抓接口，即可做到，集群下多服务器监控
 

```
  # 运行
  nohup java -jar system-monitor.jar &
  
  # 有能力的 可以配置一下 开机启动
```
### Windows
需要把 sigar对应的插件 放入 jdk bin 目录下 

### Linux 
需要把 对应的 so 文件 放在 java.library.path 下 


**详情链接**
https://www.bedebug.com/archives/systemmonitor

![monitor-2](https://www.bedebug.com/upload/2020/04/monitor-2-82b61460caec4ecbb2551c47f7f8a983.jpg)

![monitor-3](https://www.bedebug.com/upload/2020/04/monitor-3-2dcb83b3b87a405eaf00e9da0a657a6b.jpg)

![monitor-4](https://www.bedebug.com/upload/2020/04/monitor-4-b23a02f65a434c4988db5e5a870b5525.jpg)

![monitor-5](https://www.bedebug.com/upload/2020/04/monitor-5-7f7ed7ab5090493c8d3f2c1c9d973d9b.jpg)

![monitor-1](https://www.bedebug.com/upload/2020/04/monitor-1-1fac24af3a2f4a39b6906a035eb88d68.jpg)


