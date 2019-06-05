> LittleSpring

抽离Spring的核心功能，先尝试独立实现，然后学习Spring源码并对项目进行改进。

目前计划： IoC, AOP

## 已实现

* 对已有功能的单元测试
* 手工装配(BeanFactory, @Bean, @Configuration, @Import)
* 自动装配(@Component, @Autowired, @ComponentScan) 目前仅支持构造器自动注入

## IoC 具体实现

读取注解，解析并保存BeanId与BeanDefinition的映射关系。

BeanDefinition保存了Component/Bean的依赖以及构造对象的方法（返回bean的对象和方法，返回component的构造方法）。

目前读取注解是通过反射实现的，而这需要加载类文件，Spring似乎是通过直接读取字节码文件解析的，也就不需要加载类对象。

目前IoC的实现并不效率，稍后研究Spring相关源码再进行改进与分析学习。

## AOP 具体实现

@AspectEnable 启用AOP相关支持。

@Aspect 标记切面配置类，AspectProcessor类会扫描并处理该类中切点和通知的定义。

@Pointcut 定义切点，这里切点均是指向Bean的方法执行。AspectProcessor读取注释中的切点语句定义字符串，生成切点定义实例。

Advice 定义通知，包括 @Before, @Around, @AfterReturning, @AfterThrowing 和 @After 。通知将切点和拦截方法关联。

---

切点 定义 具体方法
通知 关联 切点，拦截方法

运行时先扫描读取切点和通知定义，最后通过Java Proxy或CGLib构造代理对象并替换到BeanFactory中。

## Spring 对应实现位置

[Spring IoC](https://github.com/spring-projects/spring-framework/tree/master/spring-beans)
[Spring AOP](https://github.com/spring-projects/spring-framework/tree/master/spring-aop)