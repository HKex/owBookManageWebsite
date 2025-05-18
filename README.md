# OWBookManage - 图书管理系统 

OWBookManage 是一个基于 Spring Boot, Spring Security, Thymeleaf, 和 MyBatis Plus 实现的Web图书管理系统。旨在简化图书借阅流程，方便管理员管理图书和用户信息，同时为用户提供便捷的图书查询和借阅服务。

## 项目背景

传统的图书馆手工操作处理图书借阅问题，工作繁琐，耗费大量人力、物力和财力。本系统旨在解决这些痛点，通过数字化的方式高效管理图书信息、类别、借阅记录以及用户信息，从而提升管理效率和用户体验。

## 项目目的

* 掌握企业级应用系统的基本开发流程。
* 培养开发者掌握应用系统设计的基本思路和方法。
* 提升分析问题和解决问题的能力。

## 技术栈

* **后端:**
  * Java (推荐 JDK 17+)
  * Spring Boot 3
  * Spring MVC
  * Spring Security 
  * MyBatis Plus 
  * MySQL 8.0 (数据库)
  * Lombok 
  * SLF4J + Logback 
* **前端:**
  * Thymeleaf (模板引擎)
  * HTML, CSS
  * JavaScript (基本交互)
* **构建工具:**
  * Apache Maven
* **Web 容器:**
  * Embedded (e.g., Tomcat, provided by Spring Boot Starter Web)

## 主要功能

系统为不同角色的用户提供相应的功能：

**通用功能:**
* **用户认证:**
  * 用户注册 (用户名, 昵称, 密码)
  * 用户登录 (基于 Spring Security)
  * 用户登出
* **个人信息:**
  * 显示用户昵称
  * 查询和修改个人信息 (TODO)

**管理员功能 (TODO ):**
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
  * 展示所有正在借阅的图书信息 (书籍ID, 名称, 借阅时间, 借阅人, 借阅人学号)
  * 界面提供 "添加借阅信息" 按钮 (TODO: 后端逻辑待实现)
* **图书归还:**
  * 界面提供 "归还" 按钮 (TODO: 后端逻辑待实现)

## 项目结构 
```
owbookmanagewebsite/
├── .idea/                 # IntelliJ IDEA 项目配置
├── .mvn/                  # Maven Wrapper
├── src/
│   ├── main/
│   │   ├── java/org/hkex/owbookmanage/
│   │   │   ├── config/      # Spring 配置类 (SecurityConfiguration, WebConfiguration)
│   │   │   ├── controller/  # Spring MVC 控制器 (IndexController, LoginController, RegisterController)
│   │   │   ├── dao/         # MyBatis Mapper 接口 (AdminMapper, BookMapper, UserMapper)
│   │   │   ├── entity/      # 数据实体类 (Admin, Borrow, User)
│   │   │   ├── service/     # 业务逻辑接口及实现 (AuthService, BookService, UserService)
│   │   │   └── OWBookManageApplication.java # Spring Boot 主应用类
│   │   ├── resources/
│   │   │   ├── static/      # 静态资源 (CSS, JavaScript, Images)
│   │   │   ├── templates/   # Thymeleaf 模板文件 (index.html, login.html, register.html, top-bar.html)
│   │   │   └── application.yml # Spring Boot 配置文件
├── pom.xml                # Maven 项目配置文件
└── README.md              # 项目说明文件
```
