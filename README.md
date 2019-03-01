> LittleSpring

抽离Spring的核心功能，先尝试独立实现，然后学习Spring源码并对项目进行改进。

目前计划： IoC, AOP

已实现：

* 手工装配(BeanFactory, @Bean, @Configuration, @Import)
* 自动装配(@Component, @Autowired, @ComponentScan) 目前仅支持构造器自动注入