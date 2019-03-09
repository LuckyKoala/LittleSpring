package tech.zuosi.lk.littlespring.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by luckykoala on 19-2-28.
 * 表明该方法返回一个Bean
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Bean {
    String value() default ""; //Bean id 默认为方法返回类型名
}
