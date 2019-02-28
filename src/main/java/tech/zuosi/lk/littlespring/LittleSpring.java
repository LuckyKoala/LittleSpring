package tech.zuosi.lk.littlespring;

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
    private BeanFactory beanFactory = new BeanFactory();

    public LittleSpring(Class clazz)
            throws IllegalAccessException, InvalidBeanException,
            InvalidConfigurationException, InstantiationException,
            NoSuitableConstructorForComponentException, InvalidPackageException {

        readConfig(clazz);
    }

    public Object getBean(String beanId) throws Exception {
        return beanFactory.getBean(beanId);
    }

    private void readConfig(Class clazz)
            throws InvalidBeanException, IllegalAccessException, InstantiationException,
            InvalidConfigurationException, NoSuitableConstructorForComponentException, InvalidPackageException {
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
        //尝试自动扫描
        if(clazz.isAnnotationPresent(ComponentScan.class)) {
            ComponentScan componentScan = (ComponentScan) clazz.getAnnotation(ComponentScan.class);
            String[] basePackages = componentScan.basePackages();
            if(basePackages.length != 0) {
                for(String str : basePackages) beanFactory.autoScan(str);
            } else {
                beanFactory.autoScan(clazz.getPackage().getName());
            }
        }
    }
}
