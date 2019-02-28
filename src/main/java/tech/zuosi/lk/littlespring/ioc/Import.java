package tech.zuosi.lk.littlespring.ioc;

import java.lang.annotation.*;

/**
 * Created by luckykoala on 19-2-28.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(Imports.class)
public @interface Import {
    Class value();
}
