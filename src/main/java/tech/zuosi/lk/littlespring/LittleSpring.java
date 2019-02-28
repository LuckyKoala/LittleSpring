package tech.zuosi.lk.littlespring;

import tech.zuosi.lk.littlespring.exception.InvalidBeanException;
import tech.zuosi.lk.littlespring.exception.InvalidConfigurationException;
import tech.zuosi.lk.littlespring.ioc.BeanFactory;
import tech.zuosi.lk.littlespring.ioc.Configuration;
import tech.zuosi.lk.littlespring.ioc.Import;
import tech.zuosi.lk.littlespring.ioc.Imports;

import java.lang.annotation.Annotation;

/**
 * Created by luckykoala on 19-2-28.
 */
public class LittleSpring {
    private BeanFactory beanFactory = new BeanFactory();

    public LittleSpring(Class clazz)
            throws IllegalAccessException, InvalidBeanException,
            InvalidConfigurationException, InstantiationException {

        readConfig(clazz);
    }

    private void readConfig(Class clazz) throws InvalidBeanException, IllegalAccessException, InstantiationException, InvalidConfigurationException {
        //尝试读取传入的配置类
        if(clazz.isAnnotationPresent(Configuration.class)) beanFactory.readConfig(clazz);
        //读取导入的配置类
        for(Annotation annotation : clazz.getAnnotationsByType(Import.class)) {
            Class configClazz = ((Import) annotation).value();
            //导入的配置类应该使用@Configuration标注
            if(!configClazz.isAnnotationPresent(Configuration.class))
                throw new InvalidConfigurationException(configClazz.getName());
            beanFactory.readConfig(configClazz);
        }
    }

    public Object getBean(String beanId) throws Exception {
        return beanFactory.getBean(beanId);
    }
}
