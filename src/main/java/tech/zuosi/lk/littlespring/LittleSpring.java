package tech.zuosi.lk.littlespring;

import tech.zuosi.lk.littlespring.context.ApplicationContext;
import tech.zuosi.lk.littlespring.exception.InvalidBeanException;
import tech.zuosi.lk.littlespring.exception.InvalidConfigurationException;
import tech.zuosi.lk.littlespring.exception.InvalidPackageException;
import tech.zuosi.lk.littlespring.exception.NoSuitableConstructorForComponentException;
import tech.zuosi.lk.littlespring.ioc.BeanFactory;
import tech.zuosi.lk.littlespring.ioc.annotation.ComponentScan;
import tech.zuosi.lk.littlespring.ioc.annotation.Configuration;
import tech.zuosi.lk.littlespring.ioc.annotation.Import;

import java.lang.annotation.Annotation;

/**
 * Created by luckykoala on 19-2-28.
 */
public class LittleSpring {
    private ApplicationContext context = new ApplicationContext();

    public LittleSpring(Class clazz) throws Exception {
        context.readConfig(clazz);
    }

    public Object getBean(String beanId) throws ReflectiveOperationException {
        return context.getBean(beanId);
    }
}
