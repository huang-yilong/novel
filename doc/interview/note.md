# 论文管理与检索系统

## 快速开始

### 项目简介

paper 是一套基于时下最新 Java 技术栈 Spring Boot 3 + Vue 3 开发的前后端分离的学习型论文项目，配备详细的项目开发文档手把手教你从零开始开发上线一个生产级别的
Java 系统，由论文门户系统、作者后台管理系统、平台后台管理系统等多个子系统构成。包括论文推荐、论文检索、论文排行榜、论文阅读、论文评论、会员中心、作者专区、充值订阅、新闻发布等功能。

### 项目地址

- 单体架构后端项目：[GitHub](https://github.com/huang-yilong/paper)
- 前端项目：[GitHub](https://github.com/huang-yilong/novel-front-web)

### 开发环境

- MySQL 8.0
- Redis 7.0
- Elasticsearch 8.2.0（可选）
- RabbitMQ 3.10.2（可选）
- XXL-JOB 2.3.1（可选）
- JDK 17
- Maven 3.8
- IntelliJ IDEA 2021.3（可选）
- Node 16.14

注：Elasticsearch、RabbitMQ 和 XXL-JOB 默认关闭，可通过 application.yml 配置文件中相应的enable配置属性开启。

PS：觉得手动安装开发环境比较麻烦的同学可以使用 Docker Compose 一键安装开发环境

### 安装步骤

此安装步骤的前提是需要保证上一节的开发环境可用。

- 下载后端源码

```
git clone https://github.com/huang-yilong/paper.git
```

- 数据库文件导入

1. 新建数据库（建议 paper）
2. 解压后端源码`doc/sql/paper.sql.zip`压缩包，得到数据库结构文件`paper_struc.sql`和数据库数据文件`paper_data.sql`
3. 导入`paper_struct.sql`数据库结构文件
4. 导入`paper_data.sql`数据库数据文件

- paper 后端服务安装

1. 修改`src/resources/application.yml`配置文件中的数据源配置
    ```yml
    spring:
    datasource:
    url: jdbc:mysql://localhost:3306/novel_test?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai
    username: root
    password: test123456
    ```

2. 修改`src/resources/application.yml`配置文件中的`redis`连接配置
    ```yml
    spring:
    data:
    # Redis 配置
    redis:
    host: 127.0.0.1
    port: 6379
    password: 123456
    ```

3. 根据前后端的实际部署情况，修改application.yml中的跨域配置（默认情况可忽略此步骤）

4. 项目根目录下运行如下命令来启动后端服务（有安装 IDE 的可以导入源码到 IDE 中运行）
    ```
    mvn spring-boot:run
    ```

5. 接口文档访问地址：`http://server:port/swagger-ui/index.html`

- 下载前端前台门户系统源码

```
git clone https://gitee.com/novel_dev_team/novel-front-web.git
```

- novel-front-web 前端前台门户系统安装

1. 根据前后端的实际部署情况，修改`.env.development`中的`VUE_APP_BASE_API_URL`属性（默认情况可忽略此步骤）

2. yarn安装
    ```
    npm install -g yarn
    ```

3. 项目根目录下运行如下命令来安装项目依赖
    ```
    yarn install
    ```

4. 项目根目录下运行如下命令启动
    ```
    yarn serve
    ```

5. 浏览器通过http://localhost:1024来访问

## 技术架构

### 运行环境

- JDK 17
- MySQL 8.0
- Redis 7.0
- Elasticsearch 8.2（默认关闭）
- RabbitMQ 3.10.2 （默认关闭）
- XXL-JOB 2.3.1（默认关闭）
- Undertow 2.2
- Nginx 1.21

### 后端技术选型技术

|         技术         |      版本      |         说明          |
|:------------------:|:------------:|:-------------------:|
|    Spring Boot     |    3.0.0     |     容器 + MVC 框架     |
|      MyBatis       |    3.5.9     |       ORM 框架        |
|    MyBatis-Plus    |    3.5.3     |    MyBatis 增强工具     |
|       JJWT	        |   0.11.5	    |      JWT 登录支持       |
|       Lombok       |   	1.18.24   |      	简化对象封装工具      |
|      Caffeine      |   	3.1.0	    |       本地缓存支持	       |
|       Redis        |     	7.0     |      	分布式缓存支持	      |
|     Redisson	      |    3.17.4    |      	分布式锁实现	       |
|       MySQL        |     	8.0     |       	数据库服务        |	
|   Elasticsearch    |    	8.2.0    |       	搜索引擎服务       |	
|      RabbitMQ      |    3.10.2    |      	开源消息中间件	      |
|      XXL-JOB	      |    2.3.1     |     	分布式任务调度平台	     |
|      Sentinel      |    1.8.4     |       流量控制组件        |
| Springdoc-openapi	 |    2.0.0     | 	Swagger 3 接口文档自动生成 |
| Spring Boot Admin  |  	3.0.0-M1   |      	应用管理和监控       |
|      Undertow      | 2.2.17.Final | Java 开发的高性能 Web 服务器 |
|       Docker       |     	-	      |       应用容器引擎        |
|      Jenkins       |      -       |       自动化部署工具       | 
|     Sonarqube      |      -       |       代码质量控制        |

### 前端技术选型

|      技术       |  	版本	   |           说明            |
|:-------------:|:-------:|:-----------------------:|
|    Vue.js	    | 3.2.13  |   	渐进式 JavaScript 框架    |
|  Vue Router   | 	4.0.15 |      	Vue.js 的官方路由      |
|     axios     | 	0.27.2 |   	基于 promise 的网络请求库    |
| element-plus	 |  2.2.0  | 	基于 Vue 3，面向设计师和开发者的组件库 |

### 编码规范

- 规范方式：严格遵守阿里编码规约。
- 命名统一：简介最大程度上达到了见名知意。
- 分包明确：层级分明可快速定位到代码位置。
- 注释完整：描述性高大量减少了开发人员的代码阅读工作量。
- 工具规范：使用统一jar包避免出现内容冲突。
- 代码整洁：可读性、维护性高。
- 依赖版本：所有依赖均使用当前最新可用版本以便新技术学习。

### 包结构

```
io
 +- github
     +- xxyopen   
        +- novel
            +- NovelApplication.java -- 项目启动类
            |
            +- core -- 项目核心模块，包括各种工具、配置和常量等
            |   +- common -- 业务无关的通用模块
            |   |   +- exception -- 通用异常处理
            |   |   +- constant -- 通用常量   
            |   |   +- req -- 通用请求数据格式封装，例如分页请求数据  
            |   |   +- resp -- 接口响应工具及响应数据格式封装 
            |   |   +- util -- 通用工具   
            |   | 
            |   +- auth -- 用户认证授权相关
            |   +- config -- 业务相关配置
            |   +- constant -- 业务相关常量         
            |   +- filter -- 过滤器 
            |   +- interceptor -- 拦截器
            |   +- json -- JSON 相关的包，包括序列化器和反序列化器
            |   +- task -- 定时任务
            |   +- util -- 业务相关工具 
            |   +- wrapper -- 装饰器
            |
            +- dto -- 数据传输对象，包括对各种 Http 请求和响应数据的封装
            |   +- req -- Http 请求数据封装
            |   +- resp -- Http 响应数据封装
            |
            +- dao -- 数据访问层，与底层 MySQL 进行数据交互
            +- manager -- 通用业务处理层，对第三方平台封装、对 Service 层通用能力的下沉以及对多个 DAO 的组合复用 
            +- service -- 相对具体的业务逻辑服务层  
            +- controller -- 主要是处理各种 Http 请求，各类基本参数校验，或者不复用的业务简单处理，返回 JSON 数据等
            |   +- front -- 小说门户相关接口
            |   +- author -- 作家管理后台相关接口
            |   +- admin -- 平台管理后台相关接口
            |   +- app -- app 接口
            |   +- applet -- 小程序接口
            |   +- open -- 开放接口，供第三方调用 

```

### 版本说明

- 主版本号：产品方向改变，或者大规模 API 不兼容，或者架构不兼容升级。
- 次版本号：保持相对兼容性，增加主要功能特性，影响范围极小的 API 不兼容修改。
- 修订号：保持完全兼容性，修复 BUG 、新增次要功能特性等。

## 技术要点

### MySQL 新特性

1. 新增 JSON 数据类型

    在 5.7.8 版本之后，MySQL 新增了一个原生的 JSON 数据类型，JSON 值将不再以字符串的形式存储，而是采用一种允许快速读取文本元素（document elements）的内部二进制（internal binary）格式；在 JSON 列插入或者更新的时候将会自动验证 JSON 文本，未通过验证的文本将产生一个错误信息。
    
    之前如果要存储 JSON 类型的数据的话我们只能自己做 JSON.stringify() 和 JSON.parse() 的操作，而且没办法针对 JSON 内的数据进行查询操作，所有的操作必须读取出来 parse 之后进行，非常的麻烦。原生的 JSON 数据类型支持之后，我们就可以直接对 JSON 进行数据查询和修改等操作了，较之前会方便非常多。
    
    MySQL 8 大幅改进了对 JSON 的支持，在主从复制中，新增参数 binlog_row_value_options，控制 JSON 数据的传输方式，允许对于 JSON 类型部分修改，在binlog中只记录修改的部分，减少JSON大数据在只有少量修改的情况下，对资源的占用。

2. 默认字符集由 latin1 变为 utf8mb4

    在 MySQL 8.0 版本之前，默认字符集为 latin1，utf8 指向的是 utf8mb3，8.0版本默认字符集为 utf8mb4，utf8 默认指向的也是 utf8mb4。

3. MyISAM 系统表全部换成 InnoDB 表

    MySQL 8.0 版本之后系统表全部换成了事务型的 Innodb 表，默认的 MySQL 实例将不包含任何 MyISAM 表，除非手动创建 MyISAM 表。

4. 自增变量持久化

    在 MySQL 8.0 之前的版本，自增主键 AUTO_INCREMENT 的值如果大于 max(primary key)+1，在 MySQL 重启后，会重置 AUTO_INCREMENT=max(primary key)+1，这种现象在某些情况下会导致业务主键冲突或者其他难以发现的问题。

5. DDL 原子化

    MySQL 8.0 版本之后 InnoDB 表的 DDL 支持事务完整性，要么成功要么回滚，例如，数据库里只有一个t1表，执行drop table t1,t2语句试图删除t1,t2两张表，在 5.7 中，执行报错，但是 t1 表被删除，在 8.0 中执行报错，但是 t1 表没有被删除，证明了 8.0 DDL操作的原子性，要么全部成功，要么失败回滚。

6. 参数修改持久化

    MySQL 8.0 版本支持在线修改全局参数并持久化，通过加上 PERSIST 关键字，可以将修改的参数持久化到新的配置文件（mysqld-auto.cnf）中，重启 MySQL 时，可以从该配置文件获取到最新的配置参数。

7. group by 不再隐式排序

    MySQL 8.0 对于group by 字段不再隐式排序，如需要排序，必须显式加上 order by 子句。

8. 支持不可见索引

    MySQL 8.0 支持不可见索引， 使用INVISIBLE关键字在创建表或者进行表变更中设置索引是否可见，索引不可见只是在查询时优化器不使用该索引，即使使用 force index，优化器也不会使用该索引，同时优化器也不会报索引不存在的错误，因为索引仍然真实存在，在必要时，也可以快速的恢复成可见。

9. 新增 innodb_dedicated_server 参数

    MySQL 8.0 新增 innodb_dedicated_server 参数，能够让InnoDB根据服务器上检测到的内存大小自动配置 innodb_buffer_pool_size，innodb_log_file_size，innodb_flush_method 三个参数。

10. 增加角色管理

    MySQL 8.0 增加角色管理，通常，MySQL 数据库拥有多个相同权限集合的用户。以前，向多个用户授予和撤销权限的唯一方法是单独更改每个用户的权限，假如用户数量比较多的时候，这是非常耗时的，为了用户权限管理更容易，MySQL 提供了一个名为 role 的新对象，它是一个命名的特权集合。

11. 克隆功能

    MySQL 8.0 clone 插件提供从一个实例克隆数据的功能，克隆功能提供了更有效的方式来快速创建MySQL实例，用于自动搭建从节点，也可用于备份 innodb 表，增强了 MySQL InnoDB Cluster。

    在 MySQL 克隆功能出现之前，如果想将一个单机MySQL实例升级为高可用实例，或者一个 MySQL 节点由于硬件故障等原因需要重建时首先需要通过 xtrabackup 或mydumper 等物理或逻辑备份工具从正常的 MySQL 节点上进行一个全量备份，然后基于这个全量备份配置正确的 Binlog 相关参数，最后通过 change master to 和 start slave 等命令使新建的 MySQL 节点与所需的 MySQL 节点建立复制关系等待一系列复杂的操作。

12. binlog 日志压缩

    MySQL 从 8.0.20 增加了 binlog 日志事务压缩功能，开启压缩功能后，将事务信息使用 zstd 算法进行压缩，然后再写入 binlog 日志文件，降低了原文件占用的磁盘空间和网络带宽传输。

13. 连接管理

    在 MySQL 8.0 版本中，对连接管理这一块，先后做了两个比较大的改变：一个是允许额外连接，另一个是专用的管理端口。在 MySQL 8.0 版本中，在当前连接数达到最大连接数时，服务端允许1个额外连接，可以让具有 CONNECTION_ADMIN 权限的用户连接进来，并且允许具有 SERVICE_CONNECTION_ADMIN 权限的用户，通过特定的 IP 和 PORT 连接上来，且没有连接数限制。

14. 取消 Query Cache

    MySQL 8.0 开始，取消了查询缓存，经过时间的考验，MySQL 的工程团队发现启用缓存的好处并不多。
    
    首先，查询缓存的效果取决于缓存的命中率，只有命中缓存的查询效果才能有改善，因此无法预测其性能；其次，查询缓存的另一个大问题是它受到单个互斥锁的保护，在具有多个内核的服务器上，大量查询会导致大量的互斥锁争用；最后，相对来说，缓存越靠近客户端，获得的好处越大。

15. 允许禁用 redo log

    MySQL 8.0.21 开始可以禁用 redo log 来提升数据库的写性能，但降低了安全性，适用于某些对安全要求较低的场景。

### JDK 新特性

1. 引入模块

    Java 9 开始引入了模块（Module），目的是为了管理依赖。使用模块可以按需打包 JRE 和进一步限制类的访问权限。

2. 接口支持私有方法

    JAVA 9 开始，接口里可以添加私有方法，JAVA 8 对接口增加了默认方法的支持，在 JAVA 9 中对该功能又来了一次升级，现在可以在接口里定义私有方法，然后在默认方法里调用接口的私有方法。这样一来，既可以重用私有方法里的代码，又可以不公开代码。

3. 匿名内部类支持钻石（diamond）运算符

    JAVA 5 就引入了泛型（generic），到了 JAVA 7 开始支持钻石（diamond）运算符：<>，可以自动推断泛型的类型；但是这个自动推断类型的钻石运算符不支持匿名内部类，在 JAVA 9 中也对匿名内部类做了支持。

4. 增强的 try-with-resources

    JAVA 7 中增加了try-with-resources的支持，可以自动关闭资源，但需要声明多个资源变量时，需要在 try 中写多个变量的创建过程，JAVA 9 中对这个功能进行了增强，可以引用 try 代码块之外的变量来自动关闭。

5. 弃用 new Integer()

    JAVA 9 开始弃用了 new Integer() 的方式来创建 Integer 对象，推荐通过静态工厂 Integer.valueOf() 的方式来替代，其它包装类类似。

6. 局部变量的自动类型推断（var）

    JAVA 10 带来了一个很有意思的语法 var，它可以自动推断局部变量的类型，以后再也不用写类型了，也不用靠 lombok 的 var 注解增强了，不过这个只是语法糖，编译后变量还是有类型的。
    ```
    for (var c : CacheConsts.CacheEnum.values()) {
            if (c.isLocal()) {
                Caffeine<Object, Object> caffeine = Caffeine.newBuilder().recordStats()
                    .maximumSize(c.getMaxSize());
                if (c.getTtl() > 0) {
                    caffeine.expireAfterWrite(Duration.ofSeconds(c.getTtl()));
                }
                caches.add(new CaffeineCache(c.getName(), caffeine.build()));
            }
        }
    
    ```

7. java 命令增强

    以前编译一个 java 文件时，需要先 javac 编译为 class，然后再用 java 执行，JAVA 11 之后可以直接使用 java 命令。

8. Java Flight Recorder 开源

    Java Flight Recorder 是个非常好用的调试诊断工具，不过之前是在 Oracle JDK 中， JAVA 11 后就开源了，OpenJDK 现在也可以用这个功能。

9. 文本块（Text Block）的支持

    JAVA 13 中帮你解决了大段带换行符的字符串报文的问题，增加了文本块（"""）的支持，可以不通过换行符换行拼字符串，而且不需要转义特殊字符，就像用模板一样。

10. 新增 record 类型

    JAVA 14 新增 record 类型，干掉复杂的 POJO 类，一般我们创建一个 POJO 类，需要定义属性列表，构造函数，getter/setter方法，比较麻烦，JAVA 14 为我们带来了一个便捷的创建类的方式 - record。
    
    不过这个只是一个语法糖，编译后还是一个 Class，和普通的 Class 区别不大。
    ```
    @ConfigurationProperties(prefix = "novel.cors")
    public record CorsProperties(List<String> allowOrigins) {
    
    }
    ```

11. 更直观的 NullPointerException 提示

    JAVA 14 优化了 NullPointerException 的提示，让你更容易定位到哪个对象为空。

12. switch 语法增强

    switch 从 JDK 14 开始可以通过yield关键字来生成结果，并且支持箭头语法取代case后面的冒号，使用箭头语法后每个 case 语句后面也无需再加上 break；JDK 17 支持了 case null 的用法。

13. 新增 jpackage 打包工具

    JAVA 14 新增 jpackage 打包工具，可以直接打包二进制程序，再也不用装 JRE 了。
    
    之前如果想构建一个可执行的程序，还需要借助三方工具，将 JRE 一起打包，或者让客户电脑也装一个 JRE 才可以运行我们的 JAVA 程序。
    
    现在 JAVA 直接内置了 jpackage 打包工具，帮助你一键打包二进制程序包。

14. 新增封闭（Sealed ）类

    JAVA 的继承以前只能选择允许继承和不允许继承（final 修饰），JAVA 15 新增了一个封闭（Sealed ）类的特性，可以指定某些类才可以继承。

15. 新增垃圾回收器

    JAVA 15 中，两款垃圾回收器ZGC 和 Shenandoah 正式登陆（默认 G1 ），性能更强，延迟更低。

16. instanceof 智能转型

    之前处理动态类型碰上要强转时，需要先 instanceof 判断一下，然后再强转为该类型处理，JDK 16 最终完成了 JEP 394 的定稿，针对 instanceof 智能转换变量类型，不需要再来一次额外的强转，语法：x instanceof String s。

注：Spring Framework 6 和 Spring Boot 3 的应用程序运行时至少需要JDK 17。

### SpringBoot 新特性

1. 优雅关机

    Spring Boot 2.3.0 配置关机缓冲时间后，在关闭时，Web服务器将不再允许新请求，并且将等待缓冲时间以使活动请求完成。
    
    目前内置的四个嵌入式 Web 服务器（Jetty，Reactor Netty，Tomcat和Undertow）以及响应式和基于 Servlet 的 Web 应用程序都支持优雅关机。

2. Docker 支持

    Spring Boot 2.3.0 添加了部分功能用来帮助将 Spring Boot 应用直接打包到 Docker 镜像。 
   - 支持 Cloud Native Buildpacks 构建镜像； 
   - maven 插件 增加 spring-boot:build-image 、gradle 增加 bootBuildImage task 帮助快速构建镜像； 
   - 支持 jar 分层，更好的优化打包镜像过程。

3. 全新的配置文件处理

    使用---在一个 yml 文件中分割多个配置，如果启用多个配置中有一样的配置项会相互覆盖，在 Spring Boot 2.4.0 版本中声明在最后面的会覆盖前面的配置。在 Spring Boot 2.4.0 之前的版本中取决于spring.profiles.active中声明的顺序。
    
    Spring Boot 2.4.0 版本之前使用文件名application-{profile}的方式指定配置标识，使用spring.profiles.active开启配置；Spring Boot 2.4.0 版本的用法是使用spring.config.activate.on-profile来指定配置标识，spring.profiles.active不能和它配置在同一个配置块中。
    ```
    spring:
    profiles:
    active: dev
    ---
    spring:
    config:
    activate:
    on-profile: dev
    secret：dev-password
   ```
   Spring Boot 2.4.0 版本以前使用spring.profiles和spring.profiles.include配置组合，Spring Boot 2.4.0 版本之后，使用spring.profiles.group来配置组合。
    ```
    spring:
      profiles:
        active:
          - dev
        group:
          dev:
            - devdb
            - devmq
          test:
            - testdb
            - testmq
    ---
    spring:
      config:
        activate:
          on-profile: dev
    secret: dev-password
    ---
    spring:
      config:
        activate:
          on-profile: devdb
    db: devdb
    ---
    spring:
      config:
        activate:
          on-profile: devmq
    mq: devmq        
    ```

4. 默认禁止循环依赖

    我们都知道，如果两个 Bean 互相注入对方就会存在循环引用问题，Spring Boot 2.6.0 这个版本已经默认禁止 Bean 之间的循环引用，如果存在循环引用就会启动失败报错。

5. 支持自定义脱敏规则

    Spring Boot 2.6.0 版本可以清理 /env 和 /configprops 端点中存在的敏感值。另外，还可以通过添加类型为 SanitizingFunction 的 @Bean 类来配置自定义清理规则。

6. 重要端点变更

    Spring Boot 2.6.0版本的环境变量 /env 端点已经默认不开放了，另外 Spring Boot 下的 /info 端点现在可以公开 Java 运行时信息了。

7. Redis 连接池

    当 commons-pool2 在类路径下时，Redis（包括：Jedis 和 Lettuce）在 Spring Boot 2.6.0 之后的版本会自动开启连接池，也可以设置禁用连接池。

8. 最低 Java 要求

    从Spring Boot 3.0 开始，Java 17 是最低版本，Java 8 不再被兼容。到正式版发行的时候 Java 19 也应该发行了。

9. Jakarta EE 9

    Spring Boot 依赖于 Jakarta EE（原名 Java EE） 规范，3.0 已经升级到 Jakarta EE 9 版本。因此 Spring Boot 3.0 会使用 Servlet 5.0 规范和 JPA 3.0 规范。相关的三方依赖如果不支持这些规范，将减少或者移除这些依赖。所以相关的三方依赖请尽快根据 Jakarta EE 9 进行版本迭代。基于这个原因，目前不支持Jakarta EE 9 的类库将被移除，包含了一些知名三方类库，例如 EhCache3、Jersey、JOOQ、Thymeleaf 等等，直到这些类库适配 Jakarta EE 9。

10. 声明式 HTTP 客户端

    Spring 6（Spring Boot 3） 开始支持新的声明式 HTTP 客户端。

11. 新的 @AutoConfiguration 类

    Spring Boot 2.7/3 开始，@AutoConfiguration 类由 META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports文件而不再是 META-INF/spring.factories 文件配置。

12. @ConfigurationProperties 构造函数绑定

    Spring 6（Spring Boot 3） 开始，@ConfigurationProperties 类支持新的构造函数绑定，而无需显式 @ConstructorBinding。

### 全新的 Elasticsearch Java API Client

Elasticsearch Java API Client 是自 7.16 版本开始稳定发布的官方 Java API 客户端。该客户端为所有 Elasticsearch API 提供强类型请求和响应。主要特性如下：

- 所有 Elasticsearch API 的强类型请求和响应。 
- 所有 API 的阻塞和异步版本。 
- 在创建复杂的嵌套结构时，使用流利的构建器和功能模式允许编写简洁易读的代码。 
- 通过使用对象映射器（例如 Jackson）或任何 JSON-B 实现来无缝集成应用程序类。 
- 将协议处理委托给 http 客户端，例如 Java Low Level REST Client ，该客户端负责处理所有传输级别的问题：HTTP 连接池、重试、节点发现等。

Elasticsearch Java API Client 是一个全新的客户端库，与旧的 High Level Rest Client (HLRC) 没有任何关系。它提供了一个独立于 Elasticsearch 服务器代码的库，并为所有 Elasticsearch 功能提供了一个非常一致且更易于使用的 API。

#### 安装要求
- Java 8 或更高版本。 
- 一个 JSON 对象映射库，允许我们应用程序类与 Elasticsearch API 无缝集成。Java API Client 支持 Jackson 或 Eclipse Yasson 等 JSON-B 库 。

#### 安装
添加以下的 maven 依赖来安装 Java API Client：
```
<dependencies>

    <dependency>
      <groupId>co.elastic.clients</groupId>
      <artifactId>elasticsearch-java</artifactId>
      <version>8.2.0</version>
    </dependency>

    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>2.12.3</version>
    </dependency>

</dependencies>
```

#### 连接
Java API Client 围绕三个主要组件构建：
- API 客户端类。它们为 Elasticsearch API 提供强类型数据结构和方法。由于 Elasticsearch API 很大，它以功能组（也称为“命名空间”）的形式构成，每个组都有自己的客户端类。Elasticsearch 核心功能在 ElasticsearchClient 类中实现。 
- JSON 对象映射器。将应用程序类映射到 JSON 并将它们与 API 客户端无缝集成。 
- 传输层实现。这是所有 HTTP 请求处理发生的地方。

以下代码片段创建并将这三个组件连接在一起：

```
// 1. Create the low-level client
RestClient restClient = RestClient.builder(
new HttpHost("localhost", 9200)).build();

// 2. Create the transport with a Jackson mapper
ElasticsearchTransport transport = new RestClientTransport(
restClient, new JacksonJsonpMapper());

// 3. And create the API client
ElasticsearchClient client = new ElasticsearchClient(transport);
```

#### Spring Boot 中使用

1. 在配置文件 application.yml 中配置如下的 Elasticsearch 连接信息：
    ```
    spring:
      elasticsearch:
        uris:
          - https://my-deployment-ce7ca3.es.us-central1.gcp.cloud.es.io:9243
        username: elastic
        password: qTjgYVKSuExX
    ```

2. 因为我们使用的是 Spring Boot 项目，当我们引入了 Java API Client 的 maven 相关依赖时，Spring Boot 的自动配置类 ElasticsearchRestClientAutoConfiguration 生效，会自动为我们配置RestClient、ElasticsearchTransport和ElasticsearchClient。

3. ElasticsearchRestClientAutoConfiguration自动配置类在配置JacksonJsonpMapper对象的时候会通过objectMapper.configure(SerializationFeature.INDENT_OUTPUT, false).setSerializationInclusion(Include.NON_NULL)代码修改默认的ObjectMapper配置覆盖掉了我们自定义的ObjectMapper配置，所以我们要手动配置一个JacksonJsonpMapper而不是直接使用自动配置的JacksonJsonpMapper对象：
    ```
    /**
     * elasticsearch 相关配置
     *
     * @author xiongxiaoyang
     * @date 2022/5/23
     */
    @Configuration
    public class EsConfig {
    
        /**
         * 解决 ElasticsearchClientConfigurations 修改默认 ObjectMapper 配置的问题
         */
        @Bean
        JacksonJsonpMapper jacksonJsonpMapper() {
            return new JacksonJsonpMapper();
        }
    
    }
    ```

#### 使用示例
1. 批量插入数据
    ```
    public void saveToEs() {
            QueryWrapper<BookInfo> queryWrapper = new QueryWrapper<>();
            List<BookInfo> bookInfos;
            long maxId = 0;
            for(;;) {
                queryWrapper.clear();
                queryWrapper
                        .orderByAsc(DatabaseConsts.CommonColumnEnum.ID.getName())
                        .gt(DatabaseConsts.CommonColumnEnum.ID.getName(), maxId)
                        .last(DatabaseConsts.SqlEnum.LIMIT_30.getSql());
                bookInfos = bookInfoMapper.selectList(queryWrapper);
                if (bookInfos.isEmpty()) {
                    break;
                }
                BulkRequest.Builder br = new BulkRequest.Builder();
    
                for (BookInfo book : bookInfos) {
                    EsBookDto esBook = buildEsBook(book);
                    br.operations(op -> op
                            .index(idx -> idx
                                    .index(EsConsts.IndexEnum.BOOK.getName())
                                    .id(book.getId().toString())
                                    .document(esBook)
                            )
                    ).timeout(Time.of(t -> t.time("10s")));
                    maxId = book.getId();
                }
    
                BulkResponse result = elasticsearchClient.bulk(br.build());
    
                // Log errors, if any
                if (result.errors()) {
                    log.error("Bulk had errors");
                    for (BulkResponseItem item : result.items()) {
                        if (item.error() != null) {
                            log.error(item.error().reason());
                        }
                    }
                }
    
            }
    
        }
    ```

2. 全文检索
    ```
    @SneakyThrows
    @Override
    public RestResp<PageRespDto<BookInfoRespDto>> searchBooks(BookSearchReqDto condition) {
    
        SearchResponse<EsBookDto> response = esClient.search(s -> {
    
                    SearchRequest.Builder searchBuilder = s.index(EsConsts.IndexEnum.BOOK.getName());
                    buildSearchCondition(condition, searchBuilder);
                    // 排序
                    if (!StringUtils.isBlank(condition.getSort())) {
                        searchBuilder.sort(o ->
                                o.field(f -> f.field(condition.getSort()).order(SortOrder.Desc))
                        );
                    }
                    // 分页
                    searchBuilder.from((condition.getPageNum() - 1) * condition.getPageSize())
                            .size(condition.getPageSize());
    
                    return searchBuilder;
                },
                EsBookDto.class
        );
    
        TotalHits total = response.hits().total();
    
        List<BookInfoRespDto> list = new ArrayList<>();
        List<Hit<EsBookDto>> hits = response.hits().hits();
        for (Hit<EsBookDto> hit : hits) {
            EsBookDto book = hit.source();
            list.add(BookInfoRespDto.builder()
                    .id(book.getId())
                    .bookName(book.getBookName())
                    .categoryId(book.getCategoryId())
                    .categoryName(book.getCategoryName())
                    .authorId(book.getAuthorId())
                    .authorName(book.getAuthorName())
                    .wordCount(book.getWordCount())
                    .lastChapterName(book.getLastChapterName())
                    .build());
        }
        return RestResp.ok(PageRespDto.of(condition.getPageNum(), condition.getPageSize(), total.value(), list));
    
    }
    
    /**
     * 构建查询条件
     */
    private void buildSearchCondition(BookSearchReqDto condition, SearchRequest.Builder searchBuilder) {
    
        BoolQuery boolQuery = BoolQuery.of(b -> {
    
            if (!StringUtils.isBlank(condition.getKeyword())) {
                // 关键词匹配
                b.must((q -> q.multiMatch(t -> t
                        .fields("bookName^2","authorName^1.8","bookDesc^0.1")
                        .query(condition.getKeyword())
                )
                ));
            }
    
            // 精确查询
            if (Objects.nonNull(condition.getWorkDirection())) {
                b.must(TermQuery.of(m -> m
                        .field("workDirection")
                        .value(condition.getWorkDirection())
                )._toQuery());
            }
    
            if (Objects.nonNull(condition.getCategoryId())) {
                b.must(TermQuery.of(m -> m
                        .field("categoryId")
                        .value(condition.getCategoryId())
                )._toQuery());
            }
    
            // 范围查询
            if (Objects.nonNull(condition.getWordCountMin())) {
                b.must(RangeQuery.of(m -> m
                        .field("wordCount")
                        .gte(JsonData.of(condition.getWordCountMin()))
                )._toQuery());
            }
    
            if (Objects.nonNull(condition.getWordCountMax())) {
                b.must(RangeQuery.of(m -> m
                        .field("wordCount")
                        .lt(JsonData.of(condition.getWordCountMax()))
                )._toQuery());
            }
    
            if (Objects.nonNull(condition.getUpdateTimeMin())) {
                b.must(RangeQuery.of(m -> m
                        .field("lastChapterUpdateTime")
                        .gte(JsonData.of(condition.getUpdateTimeMin().getTime()))
                )._toQuery());
            }
    
            return b;
    
        });
    
        searchBuilder.query(q -> q.bool(boolQuery));
    
    }
    ```

## 数据库设计

### 数据库设计规约

1. 表达是与否概念的字段，必须使用 is_xxx 的方式命名，数据类型是 unsigned tinyint（ 1 表示是，0 表示否）。

    说明： 任何字段如果为非负数，必须是 unsigned，坚持 is_xxx 的命名方式是为了明确其取值含义与取值范围。
    
    正例： 表达逻辑删除的字段名 is_deleted， 1 表示删除， 0 表示未删除。

2. 表名、字段名必须使用小写字母或数字， 禁止出现数字开头，禁止两个下划线中间只出现数字。数据库字段名的修改代价很大，字段名称需要慎重考虑。

    说明： MySQL 在 Windows 下不区分大小写，但在 Linux 下默认是区分大小写。因此，数据库名、表名、字段名，都不允许出现任何大写字母，避免节外生枝。

3. 表名不使用复数名词。

    说明： 表名应该仅仅表示表里面的实体内容，不应该表示实体数量，对应于 DO 类名也是单数形式，符合表达习惯。

4. 禁用保留字，如 desc、 range、 match、 delayed 等， 请参考 MySQL 官方保留字。

5. 主键索引名为 pk_字段名；唯一索引名为 uk_字段名； 普通索引名则为 idx_字段名。

    说明： pk_ 即 primary key； uk_ 即 unique key； idx_ 即 index 的简称。

6. 小数类型为 decimal，禁止使用 float 和 double。

    说明： 在存储的时候， float 和 double 都存在精度损失的问题，很可能在比较值的时候，得到不正确的结果。如果存储的数据范围超过 decimal 的范围，建议将数据拆成整数和小数并分开存储。

7. 如果存储的字符串长度几乎相等，使用 char 定长字符串类型。

8. varchar 是可变长字符串，不预先分配存储空间，长度不要超过 5000，如果存储长度大于此值，定义字段类型为 text，独立出来一张表，用主键来对应，避免影响其它字段索引效率。

9. 表必备三字段： id, create_time, update_time。

    说明： 其中 id 必为主键，类型为 bigint unsigned、单表时自增、步长为 1。 create_time, update_time的类型均为 datetime 类型，前者现在时表示主动式创建，后者过去分词表示被动式更新。

    注意：更新数据表记录时，必须同时更新记录对应的 update_time 字段值为当前时间。

10. 表的命名最好是遵循“业务名称_表的作用” 。

    正例：book_info / book_chapter / user_bookshelf / user_comment / author_info

11. 库名与应用名称尽量一致。

12. 如果修改字段含义或对字段表示的状态追加时，需要及时更新字段注释。

13. 字段允许适当冗余，以提高查询性能，但必须考虑数据一致。冗余字段应遵循：

    - 不是频繁修改的字段。
    - 不是唯一索引的字段。
    - 不是 varchar 超长字段，更不能是 text 字段。

    正例： 各业务线经常冗余存储论文名称，避免查询时需要连表（单体应用）或跨服务（微服务应用）获取。

14. 单表行数超过 500 万行或者单表容量超过 2GB，才推荐进行分库分表。

    说明： 如果预计三年后的数据量根本达不到这个级别，请不要在创建表时就分库分表。

15. 合适的字符存储长度，不但节约数据库表空间、节约索引存储，更重要的是提升检索速度。

    正例：无符号值可以避免误存负数，且扩大了表示范围。

16. 业务上具有唯一特性的字段，即使是组合字段，也必须建成唯一索引。

    说明： 不要以为唯一索引影响了 insert 速度，这个速度损耗可以忽略，但提高查找速度是明显的； 另外，即使在应用层做了非常完善的校验控制，只要没有唯一索引，根据墨菲定律，必然有脏数据产生。

17. 超过三个表禁止 join。需要 join 的字段，数据类型保持绝对一致； 多表关联查询时，保证被关联的字段需要有索引。

    说明： 即使双表 join 也要注意表索引、 SQL 性能。

18. 在 varchar 字段上建立索引时，必须指定索引长度，没必要对全字段建立索引，根据实际文本区分度决定索引长度。

    说明： 索引的长度与区分度是一对矛盾体，一般对字符串类型数据，长度为 20 的索引，区分度会高达 90%以上，可以使用 count(distinct left(列名, 索引长度))/count(*)的区分度来确定。

19. 创建索引时避免有如下极端误解：

    - 索引宁滥勿缺。 认为一个查询就需要建一个索引。 
    - 吝啬索引的创建。 认为索引会消耗空间、 严重拖慢记录的更新以及行的新增速度。 
    - 抵制唯一索引。 认为唯一索引一律需要在应用层通过“先查后插“方式解决。

### 数据库建模工具

本项目使用navicat对数据库进行设计、版本管理等。

### 系统功能概要

- 前台门户系统 
  - 首页：轮播图、本周推荐、热门推荐、精品推荐、点击榜单、新论文榜单、更新榜单、最新新闻、友情链接、反馈留言
  - 新闻模块：新闻分类、新闻列表、新闻阅读
  - 论文检索：根据论文名、作者名等关键词和论文类型、分类、是否录用、字数、更新方式等筛选条件检索论文
  - 论文详情页：论文信息展示、作者信息展示、最新章节概要、最新评论、评论发表、加入书架、同类推荐
  - 论文评论页：论文评论区，评论展示、发表评论 
  - 论文目录页：论文目录展示 
  - 论文内容页：论文章节订阅、论文内容阅读、论文段落评论 
  - 排行榜：点击榜、更新榜、新论文榜、评论榜
  - 充值：支付宝/微信购买虚拟币
  - 会员中心：登录注册、账号信息、账号设置、书架、阅读历史、论文评论、充值/消费记录、用户反馈
- 作者后台管理系统
  - 作者申请：获取邀请码、作者信息提交
  - 论文管理：论文发布、章节管理、薪酬查询、作品信息
  - 稿费收入：订阅明细、稿费汇总
- 平台后台管理系统
  - 系统管理：用户管理、角色管理、权限管理、菜单管理
  - 首页管理：论文推荐管理、新闻发布管理、友情链接管理
  - 会员管理：网站会员管理、反馈管理、评论管理
  - 作者管理：作者邀请码管理、作者信息管理
  - 论文管理：论文管理、论文章节管理
  - 订单管理：充值订单、订阅订单
  - 统计报表：会员、作者、论文、交易等数据的统计报表

### 数据库关系图

见navicat



### 数据库表结构

#### 首页模块

##### home_book [首页小说推荐]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|type|推荐类型|TINYINT UNSIGNED||√||0-轮播图 1-顶部栏 2-本周强推 3-热门推荐 4-精品推荐|
|3|sort|推荐排序|TINYINT UNSIGNED||√|||
|4|book\_id|推荐小说ID|BIGINT UNSIGNED||√|||
|5|create\_time|创建时间|DATETIME|||||
|6|update\_time|更新时间|DATETIME|||||



##### home_friend_link [友情链接]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|link\_name|链接名|VARCHAR(50)||√|||
|3|link\_url|链接url|VARCHAR(100)||√|||
|4|sort|排序号|TINYINT UNSIGNED||√|11||
|5|is\_open|是否开启|TINYINT UNSIGNED||√|1|0-不开启 1-开启|
|6|create\_time|创建时间|DATETIME|||||
|7|update\_time|更新时间|DATETIME|||||



#### 新闻模块

##### news_category [新闻类别]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|name|类别名|VARCHAR(20)||√|||
|3|sort|排序|TINYINT UNSIGNED||√|10||
|4|create\_time|创建时间|DATETIME|||||
|5|update\_time|更新时间|DATETIME|||||



##### news_info [新闻信息]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|category\_id|类别ID|BIGINT UNSIGNED||√|||
|3|category\_name|类别名|VARCHAR(50)||√|||
|4|source\_name|新闻来源|VARCHAR(50)||√|||
|5|title|新闻标题|VARCHAR(100)||√|||
|6|create\_time|创建时间|DATETIME|||||
|7|update\_time|更新时间|DATETIME|||||



##### news_content [新闻内容]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|news\_id|新闻ID|BIGINT UNSIGNED||√|||
|3|content|新闻内容|MEDIUMTEXT||√|||
|4|create\_time|创建时间|DATETIME|||||
|5|update\_time|更新时间|DATETIME|||||



#### 小说模块

##### book_category [小说类别]

|#|字段|名称|数据类型|主键| 非空 |默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|work\_direction|作品方向|TINYINT UNSIGNED||√||0-男频 1-女频|
|3|name|类别名|VARCHAR(20)||√|||
|4|sort|排序|TINYINT UNSIGNED||√|10||
|5|create\_time|创建时间|DATETIME|||||
|6|update\_time|更新时间|DATETIME|||||



##### book_info [小说信息]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|work\_direction|作品方向|TINYINT UNSIGNED||√||0-男频 1-女频|
|3|category\_id|类别ID|BIGINT UNSIGNED||√|||
|4|category\_name|类别名|VARCHAR(50)||√|||
|5|pic\_url|小说封面地址|VARCHAR(200)||√|||
|6|book\_name|小说名|VARCHAR(50)||√|||
|7|author\_id|作家id|BIGINT UNSIGNED||√|||
|8|author\_name|作家名|VARCHAR(50)||√|||
|9|book\_desc|书籍描述|VARCHAR(2000)||√|||
|10|score|评分|TINYINT UNSIGNED||√||总分:10 ，真实评分 = score/10|
|11|book\_status|书籍状态|TINYINT UNSIGNED||√|0|0-连载中 1-已完结|
|12|visit\_count|点击量|BIGINT UNSIGNED||√|103||
|13|word\_count|总字数|INT UNSIGNED||√|0||
|14|comment\_count|评论数|INT UNSIGNED||√|0||
|15|last\_chapter\_id|最新章节ID|BIGINT UNSIGNED|||||
|16|last\_chapter\_name|最新章节名|VARCHAR(50)|||||
|17|last\_chapter\_update\_time|最新章节更新时间|DATETIME|||||
|18|is\_vip|是否收费|TINYINT UNSIGNED||√|0|1-收费 0-免费|
|19|create\_time|创建时间|DATETIME|||||
|20|update\_time|更新时间|DATETIME||√|||



##### book_chapter [小说章节]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|book\_id|小说ID|BIGINT UNSIGNED||√|||
|3|chapter\_num|章节号|SMALLINT UNSIGNED||√|||
|4|chapter\_name|章节名|VARCHAR(100)||√|||
|5|word\_count|章节字数|INT UNSIGNED||√|||
|6|is\_vip|是否收费|TINYINT UNSIGNED||√|0|1-收费 0-免费|
|7|create\_time||DATETIME|||||
|8|update\_time||DATETIME|||||



##### book_content [小说内容]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|chapter\_id|章节ID|BIGINT UNSIGNED||√|||
|3|content|小说章节内容|MEDIUMTEXT||√|||
|4|create\_time||DATETIME|||||
|5|update\_time||DATETIME|||||



##### book_comment [小说评论]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|book\_id|评论小说ID|BIGINT UNSIGNED||√|||
|3|user\_id|评论用户ID|BIGINT UNSIGNED||√|||
|4|comment\_content|评价内容|VARCHAR(512)||√|||
|5|reply\_count|回复数量|INT UNSIGNED||√|0||
|6|audit\_status|审核状态|TINYINT UNSIGNED||√|0|0-待审核 1-审核通过 2-审核不通过|
|7|create\_time|创建时间|DATETIME|||||
|8|update\_time|更新时间|DATETIME|||||



##### book_comment_reply [小说评论回复]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|comment\_id|评论ID|BIGINT UNSIGNED||√|||
|3|user\_id|回复用户ID|BIGINT UNSIGNED||√|||
|4|reply\_content|回复内容|VARCHAR(512)||√|||
|5|audit\_status|审核状态|TINYINT UNSIGNED||√|0|0-待审核 1-审核通过 2-审核不通过|
|6|create\_time|创建时间|DATETIME|||||
|7|update\_time|更新时间|DATETIME|||||


#### 用户模块

##### user_info [用户信息]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|username|登录名|VARCHAR(50)||√|||
|3|password|登录密码-加密|VARCHAR(100)||√|||
|4|salt|加密盐值|VARCHAR(8)||√|||
|5|nick\_name|昵称|VARCHAR(50)|||||
|6|user\_photo|用户头像|VARCHAR(100)|||||
|7|user\_sex|用户性别|TINYINT UNSIGNED||||0-男 1-女|
|8|account\_balance|账户余额|BIGINT UNSIGNED||√|0||
|9|status|用户状态|TINYINT UNSIGNED||√|0|0-正常|
|10|create\_time|创建时间|DATETIME||√|||
|11|update\_time|更新时间|DATETIME||√|||



##### user_feedback [用户反馈]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|user\_id|反馈用户id|BIGINT UNSIGNED||√|||
|3|content|反馈内容|VARCHAR(512)||√|||
|4|create\_time|创建时间|DATETIME|||||
|5|update\_time|更新时间|DATETIME|||||



##### user_bookshelf [用户书架]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|user\_id|用户ID|BIGINT UNSIGNED||√|||
|3|book\_id|小说ID|BIGINT UNSIGNED||√|||
|4|pre\_content\_id|上一次阅读的章节内容表ID|BIGINT UNSIGNED|||||
|5|create\_time|创建时间|DATETIME|||||
|6|update\_time|更新时间|DATETIME|||||



##### user_read_history [用户阅读历史]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|user\_id|用户ID|BIGINT UNSIGNED||√|||
|3|book\_id|小说ID|BIGINT UNSIGNED||√|||
|4|pre\_content\_id|上一次阅读的章节内容表ID|BIGINT UNSIGNED||√|||
|5|create\_time|创建时间|DATETIME|||||
|6|update\_time|更新时间|DATETIME|||||



##### user_consume_log [用户消费记录]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|user\_id|消费用户ID|BIGINT UNSIGNED||√|||
|3|amount|消费使用的金额|INT UNSIGNED||√||单位：屋币|
|4|product\_type|消费商品类型|TINYINT UNSIGNED||√|0|0-小说VIP章节|
|5|product\_id|消费的的商品ID|BIGINT UNSIGNED||||例如：章节ID|
|6|produc\_name|消费的的商品名|VARCHAR(50)||||例如：章节名|
|7|produc\_value|消费的的商品值|INT UNSIGNED||||例如：1|
|8|create\_time|创建时间|DATETIME|||||
|9|update\_time|更新时间|DATETIME|||||



##### user_pay_log [用户充值记录]

|**#**|**字段**|**名称**|**数据类型**|**主键**|**非空**|**默认值**|**备注说明**|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|user\_id|充值用户ID|BIGINT UNSIGNED||√|||
|3|pay\_channel|充值方式|TINYINT UNSIGNED||√|1|0-支付宝 1-微信|
|4|out\_trade\_no|商户订单号|VARCHAR(64)||√|||
|5|amount|充值金额|INT UNSIGNED||√||单位：分|
|6|product\_type|充值商品类型|TINYINT UNSIGNED||√|0|0-屋币 1-包年VIP|
|7|product\_id|充值商品ID|BIGINT UNSIGNED|||||
|8|product\_name|充值商品名|VARCHAR(255)||√||示例值：屋币|
|9|product\_value|充值商品值|INT UNSIGNED||||示例值：255|
|10|pay\_time|充值时间|DATETIME||√|||
|11|create\_time|创建时间|DATETIME|||||
|12|update\_time|更新时间|DATETIME|||||
#### 作家模块

##### author_code [作家邀请码]

|**#**|**字段**|**名称**|**数据类型**|**主键**|**非空**|**默认值**|**备注说明**|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|invite\_code|邀请码|VARCHAR(100)||√|||
|3|validity\_time|有效时间|DATETIME||√|||
|4|is\_used|是否使用过|TINYINT UNSIGNED||√|0|0-未使用 1-使用过|
|5|create\_time|创建时间|DATETIME|||||
|6|update\_time|更新时间|DATETIME|||||

##### author_info [作者信息]

|**#**|**字段**|**名称**|**数据类型**|**主键**|**非空**|**默认值**|**备注说明**|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|user\_id|用户ID|BIGINT UNSIGNED||√|||
|3|invite\_code|邀请码|VARCHAR(20)||√|||
|4|pen\_name|笔名|VARCHAR(20)||√|||
|5|tel\_phone|手机号码|VARCHAR(20)|||||
|6|chat\_account|QQ或微信账号|VARCHAR(50)|||||
|7|email|电子邮箱|VARCHAR(50)|||||
|8|work\_direction|作品方向|TINYINT UNSIGNED||||0-男频 1-女频|
|9|status|0：正常|TINYINT UNSIGNED||√|0|1-封禁|
|10|create\_time|创建时间|DATETIME|||||
|11|update\_time|更新时间|DATETIME|||||

##### author_income [稿费收入统计]

|**#**|**字段**|**名称**|**数据类型**|**主键**|**非空**|**默认值**|**备注说明**|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|author\_id|作家ID|BIGINT UNSIGNED||√|||
|3|book\_id|小说ID|BIGINT UNSIGNED||√|||
|4|income\_month|收入月份|DATE||√|||
|5|pre\_tax\_income|税前收入|INT UNSIGNED||√|0|单位：分|
|6|after\_tax\_income|税后收入|INT UNSIGNED||√|0|单位：分|
|7|pay\_status|支付状态|TINYINT UNSIGNED||√|0|0-待支付 1-已支付|
|8|confirm\_status|稿费确认状态|TINYINT UNSIGNED||√|0|0-待确认 1-已确认|
|9|detail|详情|VARCHAR(255)|||||
|10|create\_time|创建时间|DATETIME|||||
|11|update\_time|更新时间|DATETIME|||||

##### author_income_detail [稿费收入明细统计]

|**#**|**字段**|**名称**|**数据类型**|**主键**|**非空**|**默认值**|**备注说明**|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|author\_id|作家ID|BIGINT UNSIGNED||√|||
|3|book\_id|小说ID|BIGINT UNSIGNED||√|0|0表示全部作品|
|4|income\_date|收入日期|DATE||√|||
|5|income\_account|订阅总额|INT UNSIGNED||√|0||
|6|income\_count|订阅次数|INT UNSIGNED||√|0||
|7|income\_number|订阅人数|INT UNSIGNED||√|0||
|8|create\_time|创建时间|DATETIME|||||
|9|update\_time|更新时间|DATETIME|||||
#### 支付模块

##### pay_alipay [支付宝支付]

|**#**|**字段**|**名称**|**数据类型**|**主键**|**非空**|**默认值**|**备注说明**|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|out\_trade\_no|商户订单号|VARCHAR(64)||√|||
|3|trade\_no|支付宝交易号|VARCHAR(64)||√|||
|4|buyer\_id|买家支付宝账号 ID|VARCHAR(16)|||||
|5|trade\_status|交易状态|VARCHAR(32)||||TRADE\_SUCCESS-交易成功|
|6|total\_amount|订单金额|INT UNSIGNED||√||单位：分|
|7|receipt\_amount|实收金额|INT UNSIGNED||||单位：分|
|8|invoice\_amount|开票金额|INT UNSIGNED|||||
|9|gmt\_create|交易创建时间|DATETIME|||||
|10|gmt\_payment|交易付款时间|DATETIME|||||
|11|create\_time|创建时间|DATETIME|||||
|12|update\_time|更新时间|DATETIME|||||



##### pay_wechat [微信支付]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id|主键|BIGINT UNSIGNED|√|√|||
|2|out\_trade\_no|商户订单号|VARCHAR(32)||√|||
|3|transaction\_id|微信支付订单号|VARCHAR(32)||√|||
|4|trade\_type|交易类型|VARCHAR(16)||||JSAPI-公众号支付 NATIVE-扫码支付 APP-APP支付 MICROPAY-付款码支付 MWEB-H5支付 FACEPAY-刷脸支付|
|5|trade\_state|交易状态|VARCHAR(32)||||SUCCESS-支付成功 REFUND-转入退款 NOTPAY-未支付 CLOSED-已关闭 REVOKED-已撤销（付款码支付） USERPAYING-用户支付中（付款码支付） PAYERROR-支付失败(其他原因，如银行返回失败)|
|6|trade\_state\_desc|交易状态描述|VARCHAR(255)|||||
|7|amount|订单总金额|INT UNSIGNED||√||单位：分|
|8|payer\_total|用户支付金额|INT UNSIGNED||||单位：分|
|9|success\_time|支付完成时间|DATETIME|||||
|10|payer\_openid|支付者用户标识|VARCHAR(128)||||用户在直连商户appid下的唯一标识|
|11|create\_time|创建时间|DATETIME|||||
|12|update\_time|更新时间|DATETIME|||||


#### 系统模块

##### sys_user [系统用户]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|username|用户名|VARCHAR(50)||√|||
|3|password|密码|VARCHAR(50)||√|||
|4|name|真实姓名|VARCHAR(100)|||||
|5|sex|性别|TINYINT UNSIGNED||||0-男 1-女|
|6|birth|出身日期|DATETIME|||||
|7|email|邮箱|VARCHAR(100)|||||
|8|mobile|手机号|VARCHAR(100)|||||
|9|status|状态|TINYINT UNSIGNED||√|1|0-禁用 1-正常|
|10|create\_time|创建时间|DATETIME|||||
|11|update\_time|更新时间|DATETIME|||||



##### sys\_role [角色]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|role\_name|角色名称|VARCHAR(100)||√|||
|3|role\_sign|角色标识|VARCHAR(100)|||||
|4|remark|备注|VARCHAR(100)|||||
|5|create\_time|创建时间|DATETIME|||||
|6|update\_time|更新时间|DATETIME|||||



##### sys\_user\_role [用户与角色对应关系]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|user\_id|用户ID|BIGINT UNSIGNED||√|||
|3|role\_id|角色ID|BIGINT UNSIGNED||√|||
|4|create\_time|创建时间|DATETIME|||||
|5|update\_time|更新时间|DATETIME|||||



##### sys\_menu [系统菜单]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|parent\_id|父菜单ID|BIGINT UNSIGNED||√|0|一级菜单为0|
|3|name|菜单名称|VARCHAR(50)||√|||
|4|url|菜单URL|VARCHAR(200)|||||
|5|type|类型|TINYINT UNSIGNED||√||0-目录 1-菜单|
|6|icon|菜单图标|VARCHAR(50)|||||
|7|sort|排序|TINYINT UNSIGNED|||||
|8|create\_time|创建时间|DATETIME|||||
|9|update\_time|更新时间|DATETIME|||||



##### sys\_role\_menu [角色与菜单对应关系]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|role\_id|角色ID|BIGINT UNSIGNED||√|||
|3|menu\_id|菜单ID|BIGINT UNSIGNED||√|||
|4|create\_time|创建时间|DATETIME|||||
|5|update\_time|更新时间|DATETIME|||||



##### sys\_log [系统日志]

|#|字段|名称|数据类型|主键|非空|默认值|备注说明|
| :-: | :-: | :-: | :-: | :-: | :-: | :-: | :-: |
|1|id||BIGINT UNSIGNED|√|√|||
|2|user\_id|用户id|BIGINT UNSIGNED|||||
|3|username|用户名|VARCHAR(50)|||||
|4|operation|用户操作|VARCHAR(50)|||||
|5|time|响应时间|INT UNSIGNED|||||
|6|method|请求方法|VARCHAR(200)|||||
|7|params|请求参数|VARCHAR(5000)|||||
|8|ip|IP地址|VARCHAR(64)|||||
|9|create\_time|创建时间|DATETIME|||||



## 参考链接

![小说精品屋](https://docs.xxyopen.com/)