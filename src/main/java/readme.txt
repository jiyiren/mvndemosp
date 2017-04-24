① com.jiyiren.mvnspdemo.bean.domodel
② com.jiyiren.mvnspdemo.bean.dto
③ com.jiyiren.mvnspdemo.bean.vo
	POJO包分类：
	1) bean.domodel包:数据对象:xxxDO，xxx即为数据表名。
	2) bean.dto:数据传输对象:xxxDTO，xxx为业务领域相关的名称。
	3) bean.vo:xxxVO，xxx一般为网页名称
	4) POJO是DO/DTO/BO/VO的统称，禁止命名成xxxPOJO。

④ com.jiyiren.mvnspdemo.consts
	常量包
	1) 建议均以Consts结尾，并加以分类
	2) 不要使用一个常量类维护所有常量，应该按常量功能进行归类，分开维护
	   如:缓存 相关的常量放在类:CacheConsts 下;系统配置相关的常量放在类:ConfigConsts 下。
	
	3) 常量的复用层次有五层:跨应用共享常量、应用内共享常量、子工程内共享常量、包 内共享常量、类内共享常量。
	4) 子工程内部共享常量:即在当前子工程的constant目录下。
	5) 包内共享常量:即在当前包下单独的constant目录下。
	6) 类内共享常量:直接在类内部private static final定义
	
	7) 如果变量值仅在一个范围内变化，且带有名称之外的延伸属性，定义为枚举类。下面 正例中的数字就是延伸信息，表示星期几。
	   正例:public Enum { MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6), SUNDAY(7);}

⑤ com.jiyiren.mvnspdemo.utils
	工具类包
	1) utils包下放置工具类，工具类不能实例化，所有方法均应该设置为静态方法
	2) 建议以Helper后缀结尾，避免与其他包中的以后缀Utils结尾的工具类混淆
	
	
建议说明：
1.日志只在Business层统一打印，不要在Controller层，以及DAO层打印日志
   * 应用中不可直接使用日志系统(Log4j、Logback)中的 API，而应依赖使用日志框架
		SLF4J 中的 API，使用门面模式的日志框架，有利于维护和各个类的日志处理方式统一。
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	private static final Logger logger = LoggerFactory.getLogger(Abc.class);
   * 日志文件推荐至少保存 15 天，因为有些异常具备以“周”为频次发生的特点。
   
2.多种情况时，返回值可通过整型多值判断,当确认只有两种情况时使用布尔型返回值
3.接口的内部定义的属性和方法不要有限制语句如:public,protected,private
4.DAO层每个类对应一个测试接口

工程规约详细见：阿里巴巴 Java 开发手册

	
	
