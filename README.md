## 前台

	+ [angular   版本6.0 https://angular.cn/docs ](https://angular.cn/docs) 
	+ [NG-ZORRO  版本1.1.1 https://ng.ant.design/docs/recommendation/zh ](https://ng.ant.design/docs/recommendation/zh)
	+ [ng-alain  版本1.1.3 https://ng-alain.com/](https://ng-alain.com/)

	环境：
		node.js 8.11.1
		npm 5.6.0

## 后台

   + [SpringBoot    版本2.0 参考:https://docs.spring.io/spring-boot/docs/2.0.4.BUILD-SNAPSHOT/reference/htmlsingle/ ](https://docs.spring.io/spring-boot/docs/2.0.4.BUILD-SNAPSHOT/reference/htmlsingle/)
   + [mybatis-plus  版本2.1.4]   参考:https://github.com/baomidou/mybatis-plus , https://gitee.com/baomidou/mybatis-plus/

    Mysql	  版本6.0   数据库

    fastdfs       版本1.26.2    图片服务器

    swagger       版本2.8.0   api文档  参考地址:https://swagger.io/   , https://editor.swagger.io/

    jbcrypt       版本0.4  密码加密

    alibaba druid  数据库连接池

    redis	   缓存

    shiro	  权限框架

    jwt    0.9.0

    环境：

	jdk1.8

	maven 3.3.9
     	
    工具 idea

## 工程说明

cjm-dao	       mapper

cjm-model      model

cjm-service    service

cjm-web      			web端模块

	cjm-admin		管理后台

cjm-parent\cjm-web\cjm-admin\src\main\angular  前端源代码

doc     		存放数据库说明书

sql		        数据库脚本文件

## 通用mybatis-plus说明

	https://github.com/baomidou/mybatis-plus

	https://gitee.com/baomidou/mybatis-plus/
	
## Jwt token 说明
	https://github.com/jwtk/jjwt

	https://stormpath.com/blog/jwt-java-create-verify

	http://mvnrepository.com/artifact/io.jsonwebtoken/jjwt/0.9.0

	
## redis 说明：

	windows 安装说明  https://jingyan.baidu.com/article/0f5fb099045b056d8334ea97.html

	客户端连接 说明  http://flychao88.iteye.com/blog/1527163


## 项目规范：
  
  代码工具逆向生成时，数据库Decimal类型，对应 model类的浮点类型会变为字符串 ，需要改为 BigDecimal 
  
  浮点类型 涉及金额的 都使用BigDecimal 
  
  web模块静态资源 放在webapp/static 下
  
  涉及百分比的，数据库统一保存  除以100后的   比如：   86.12%   则数据库保存为：0.8612
  
  时间字段  统一保存为13位数的时间撮    示例：System.currentTimeMillis()
