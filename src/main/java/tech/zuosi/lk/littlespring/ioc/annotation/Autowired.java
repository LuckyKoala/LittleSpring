package tech.zuosi.lk.littlespring.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by luckykoala on 19-2-28.
 * 表示该依赖将由框架自动注入
 */
@Target(ElementType.CONSTRUCTOR)
@Retention(RetentionPolicy.RUNTIME)
public @interface Autowired {
    String[] value() default {};
}
