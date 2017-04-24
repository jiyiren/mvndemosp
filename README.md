# Maven+Spring+Mybatis+Mysql

## 配置

1. Spring组件扫描 **component-scan** 配置,修改为**自己项目的包名**

	```xml
	<context:component-scan base-package="com.jiyiren.mvnspdemo"></context:component-scan>
	```
	
2. 拦截器配置 **mvc:interceptors** 配置,修改为自己的**认证拦截器**
	
	```xml
<mvc:interceptors> 
<bean class="com.jiyiren.mvnspdemo.interceptor.AuthorizeInterceptor"></bean>
</mvc:interceptors>
	```
	
3. Mybatis的 **typeAliasesPackage** 配置
	
	```xml
	<property name="typeAliasesPackage" value="com.jiyiren.mvnspdemo.bean.domodel"></property>
	```
	
4. Mybatis的 **mapperLocations** 配置
	
	```xml
	<property name="mapperLocations" value="classpath:com/jiyiren/mvnspdemo/mapping/*.xml"/>
	```
	
5. Mybatis的mapper包配置， 避免单独创建每一个mapper

	```xml	
	<bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
	<property name="basePackage" value="com.jiyiren.mvnspdemo.dao" />
	<property name="sqlSessionFactoryBeanName" value="sqlSessionFactory" />
	</bean>
	```
6. 修改 **db-config.properties** ,指定正确的**数据库url**,**用户名**以及**密码**
	* 连接池默认使用 **c3p0** , 如果要修改为其他，注意将 **pom.xml** 中的依赖移除
	* 本例中的数据库结构为**mvndemosp.sql**,可通过mysql的source导入自己的数据库

7. 若需要将log输出到文件，则修改 **log4j.properties** 文件为：

	```xml
	log4j.rootLogger = DEBUG, apconsole, apfile
	log4j.appender.apconsole = org.apache.log4j.ConsoleAppender
	log4j.appender.apconsole.Encoding=UTF-8
	log4j.appender.apconsole.Threshold=DEBUG
	log4j.appender.apconsole.Target=System.out
	log4j.appender.apconsole.ImmediateFlush=true
	log4j.appender.apconsole.layout = org.apache.log4j.PatternLayout
	log4j.appender.apconsole.layout.ConversionPattern=[%p] %-d{yyyy-MM-	dd HH:mm:ss} [%l] %m%n
	#
	log4j.appender.apfile = org.apache.log4j.DailyRollingFileAppender
	log4j.appender.apfile.Encoding=UTF-8
	#这里默认用tomcat的环境变量输出到Tomcat的logs/mvndemosp.txt文件
	#如果要指定自己的文件地址，则修改下面的值(绝对路径)
	log4j.appender.apfile.File=${catalina.home}/logs/mvndemosp.txt
	log4j.appender.apfile.Append=false
	log4j.appender.apfile.DatePattern='.'yyyyMMdd
	log4j.appender.apfile.layout = org.apache.log4j.PatternLayout
	log4j.appender.apfile.layout.ConversionPattern=[%p] %-d{yyyy-MM-dd 	HH:mm:ss} [%c] %m%n
	#
	log4j.logger.org.springframework=ERROR
	log4j.logger.com.mchange=ERROR
	log4j.logger.org.apache=ERROR
	log4j.logger.org.quartz=ERROR
	```

## 建议说明：

1. 日志只在Business层统一打印，不要在Controller层，以及DAO层打印日志
2. 应用中不可直接使用日志系统(Log4j、Logback)中的 API，而应依赖使用日志框架**SLF4J** 中的 API，使用门面模式的日志框架，有利于维护和各个类的日志处理方式统一。

	```java
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	private static final Logger logger = LoggerFactory.getLogger(Abc.class);
	```

3. 日志文件推荐至少保存 15 天，因为有些异常具备以“周”为频次发生的特点。  
4. 多种情况时，返回值可通过整型多值判断,当确认只有两种情况时使用布尔型返回值
5. 接口的内部定义的属性和方法不要有限制语句如:public,protected,private
6. DAO层每个类对应一个测试接口,对于Spring框架有自带的spring-test测试包，需要引入junit4以及以上的包

7. 工程规约详细见：**阿里巴巴 Java 开发手册**

## 包说明

### POJO包分类：

* **com.jiyiren.mvnspdemo.bean.domodel**
* **com.jiyiren.mvnspdemo.bean.dto**
* **com.jiyiren.mvnspdemo.bean.vo**

> 1. bean.domodel包:数据对象:xxxDO，xxx即为数据表名。
> 2. bean.dto:数据传输对象:xxxDTO，xxx为业务领域相关的名称。
> 3. bean.vo:xxxVO，xxx一般为网页名称
> 4. POJO是DO/DTO/BO/VO的统称，禁止命名成xxxPOJO。

### 数据访问层包
* **com.jiyiren.mvnspdemo.dao**
* **com.jiyiren.mvnspdemo.mapping**

> * DAO层方法命名规约

> > 1. 获取单个对象的方法用get做前缀。
> > 2. 获取多个对象的方法用list做前缀。
> > 3. 获取统计值的方法用count做前缀。
> > 4. 插入的方法用save(推荐)或insert做前缀。 
> > 5. 删除的方法用remove(推荐)或delete做前缀。 
> > 6. 修改的方法用update做前缀,根新方法一定要包含更新update_time属性。

> > * Dao层类名以表名+Dao命名，也就对应于单张表的增删改查
> > * 接口类中的方法和属性不要加任何修饰符号(public 也不要加)，保持代码的简洁性，并加上有效的 Javadoc 注释。尽量不要在接口里定义变量，如果一定要定义变量，肯定是 与接口方法相关，并且是整个应用的基础常量。
> >
   ```
	正例:接口方法签名:void f();
	接口基础常量表示:String COMPANY = "alibaba";
	反例:接口方法定义:public abstract void f();
	说明:JDK8 中接口允许有默认实现，
	那么这个 default 方法，是对所有实现类都有价值的默 认实现。
   ```
	

### 业务层包
* **com.jiyiren.mvnspdemo.service**

> * Service层方法命名规约(同DAO层)

> 1.  获取单个对象的方法用get做前缀。
> 2. 获取多个对象的方法用list做前缀。
> 3. 获取统计值的方法用count做前缀。
> 4. 插入的方法用save(推荐)或insert做前缀。 
> 5. 删除的方法用remove(推荐)或delete做前缀。 
> 6. 修改的方法用update做前缀,根新方法一定要包含更新update_time属性。

### 常量包

* **com.jiyiren.mvnspdemo.consts**

> 1. 建议均以Consts结尾，并加以分类
> 2. 不要使用一个常量类维护所有常量，应该按常量功能进行归类，分开维护如:缓存 相关的常量放在类:CacheConsts 下;系统配置相关的常量放在类:ConfigConsts 下。
> 3. 常量的复用层次有五层:跨应用共享常量、应用内共享常量、子工程内共享常量、包 内共享常量、类内共享常量。
> 4. 子工程内部共享常量:即在当前子工程的constant目录下。
> 5. 包内共享常量:即在当前包下单独的constant目录下。
> 6. 类内共享常量:直接在类内部private static final定义
> 7. 如果变量值仅在一个范围内变化，且带有名称之外的延伸属性，定义为枚举类。下面 正例中的数字就是延伸信息，表示星期几。
>	
	```java
	public Enum 
	{ MONDAY(1), TUESDAY(2), WEDNESDAY(3), 
	  THURSDAY(4), FRIDAY(5), SATURDAY(6), 
	  SUNDAY(7);
	 }
	```

### 工具包

* **com.jiyiren.mvnspdemo.utils**

> 1. utils包下放置工具类，工具类不能实例化，所有方法均应该设置为静态方法
> 2. 建议以Helper后缀结尾，避免与其他包中的以后缀Utils结尾的工具类混淆
	
	

<div style="text-align:center;font-size: 12px;bottom:0;line-height:50px;">@<a href="http://jiyiren.github.io/">Ji Yi</a></div>

	
	
