package tech.zuosi.lk.littlespring.ioc.annotation;

import java.lang.annotation.*;

/**
 * Created by luckykoala on 19-2-28.
 * 导入配置类
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Imports.class)
public @interface Import {
    Class value();
}
