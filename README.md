# LJDTutor
家教网
![img](https://github.com/littlebaba/LJDTutor/blob/master/totur-totur/src/main/resources/static/img/donghua.gif)

# 简介
系统主要为老师和学生提供一个家教信息的平台，老师可以找学生，学生也可以请老师。
# 系统结构
#### 系统采用SpringBoot多模块搭建，这样做可以帮助项目划分模块，鼓励重用，防止POM变得过于庞大，方便某个模块的构建，而不用每次都构建整个项目，并且使得针对某个模块的特殊控制更为方便。
###### tutor-common模块：采用了Springdata+MySql实现基础服务抽象,DAO层，Entity以及DTO
###### tutor-tutor模块：使用springMVC进行页面跳转，采用前后端分离的机制实现。前台展示模块通过http协议访问RESTFulAPI获取数据，使用LayUI，jQuery渲染页面渲染页面。
###### tutor-rest：使用springMVC搭建RESTFul服务
---
# 运行环境
###### JDK 8
###### Maven
###### MySQL
###### Redis 
# 主要技术
###### Springboot
###### springData
###### hibernate-jpa
###### shiro（正在探索）
###### thymeleaf
###### Ehcache
###### swagger2
###### LayUI
