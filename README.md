# OWBookManage - 图书管理系统

OWBookManage 是一个基于 Java Servlet、Thymeleaf 和 MyBatis 实现的Web图书管理系统。旨在简化图书借阅流程，方便管理员管理图书和用户信息，同时为用户提供便捷的图书查询和借阅服务。

## 项目背景

传统的图书馆手工操作处理图书借阅问题，工作繁琐，耗费大量人力、物力和财力。本系统旨在解决这些痛点，通过数字化的方式高效管理图书信息、类别、借阅记录以及用户信息，从而提升管理效率和用户体验。

## 项目目的

* 掌握企业级应用系统的基本开发流程。
* 培养开发者掌握应用系统设计的基本思路和方法。
* 提升分析问题和解决问题的能力。

## 技术栈

* **后端:**
    * Java (推荐JDK 21+ )
    * Jakarta Servlet 5.0
    * MyBatis 3.5.x (数据库持久层框架)
    * MySQL 8.0 (数据库)
    * Lombok (简化 POJO 开发)
    * SLF4J + Logback (日志框架)
* **前端:**
    * Thymeleaf 3.1.x (模板引擎)
    * HTML, CSS
    * JavaScript 
* **构建工具:**
    * Apache Maven
* **Web 容器:**
    * Tomcat

## 主要功能

系统为不同角色的用户提供相应的功能：

**通用功能:**
* **用户认证:**
    * 用户登录 (管理员和普通用户)
    * 用户注册
    * 用户登出
* **个人信息:**
    * 查询和修改个人信息 (TODO)

**管理员功能 (TODO):**
* **图书管理:**
    * 添加、修改、删除图书信息
    * 根据图书编号、名称查询图书
* **读者管理 (用户管理):**
    * 添加、修改、删除读者（用户）信息
    * 根据账号、姓名查询读者信息
* **图书分类管理:**
    * 添加、修改、删除图书分类
    * 根据分类名称查询分类信息

**用户功能:**
* **图书浏览与查询:** 
    * 查询图书基本信息
* **图书借阅:**
    * 展示所有正在借阅的图书信息 (当前实现)
    * (未来可能扩展：发起借阅请求)
* **图书归还:**
    * 展示所有已归还的图书信息 (当前主要通过“归还”按钮操作，具体流程可补充)
    * 执行归还操作
* **其他 (根据代码推断):**
    * 查看硬币余额 (遗留)
    * 抽卡功能 (遗留)



## 项目结构 (简要)
```
owbookmanagewebsite/
├── .idea/                 # IntelliJ IDEA 项目配置
├── .mvn/                  # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/org/hkex/owbookmanage/
│   │   │   ├── dao/       # MyBatis Mapper 接口
│   │   │   ├── entity/    # 数据实体类
│   │   │   ├── filter/    # Servlet 过滤器 (如登录校验)
│   │   │   ├── service/   # 业务逻辑接口及其实现 (impl)
│   │   │   ├── servlet/   # Web Servlet 控制器
│   │   │   └── util/      # 工具类 (MybatisUtil, ThymeleafUtil)
│   │   ├── resources/
│   │   │   ├── *.html     # Thymeleaf 模板文件
│   │   │   └── mybatis-config.xml # MyBatis 配置文件
│   │   └── webapp/
│   │       ├── WEB-INF/
│   │       │   └── web.xml
│   │       └── static/    # 静态资源 (CSS, JavaScript, Images)
│   │           ├── css/
│   │           └── image/
├── pom.xml                # Maven 项目配置文件
└── README.md              # 项目说明文件
```
