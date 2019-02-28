package tech.zuosi.lk.littlespring.ioc.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by luckykoala on 19-2-28.
 * Import注解的容器，@Repeatable使用
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Imports {
    Import[] value();
}
