# maven搭建Spring+Mybatis+Mysql

## 注意点
1. 修改**db-config.properties**,指定正确的数据库地址。
	* 连接池默认使用c3p0,如果要修改为其他，注意将**pom.xml**中的依赖移除
	* 本例中的数据库结构为**mvndemospsql.sql**,可通过mysql的source导入自己的数据库
	
2. 修改**log4j.properties**中的File值，作为log4j日志的输出文件位置