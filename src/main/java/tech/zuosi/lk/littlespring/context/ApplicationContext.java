package tech.zuosi.lk.littlespring.context;

import tech.zuosi.lk.littlespring.aop.annotation.AspectEnable;
import tech.zuosi.lk.littlespring.ioc.annotation.ComponentScan;
import tech.zuosi.lk.littlespring.ioc.annotation.Configuration;
import tech.zuosi.lk.littlespring.ioc.annotation.Import;
import tech.zuosi.lk.littlespring.ioc.exception.InvalidConfigurationException;
import tech.zuosi.lk.littlespring.ioc.processor.BeanFactory;

import java.lang.annotation.Annotation;

/**
 * 应用上下文
 *
 * Created by luckykoala on 19-3-9.
 */
public class ApplicationContext {
    private BeanFactory beanFactory = new BeanFactory(this);
    private boolean aspectEnabled = false;

    public ApplicationContext() {}

    public Object getBean(String beanId) throws ReflectiveOperationException {
        return beanFactory.getBean(beanId);
    }

    public void readConfig(Class clazz) throws Exception {
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
        //尝试启用AOP
        if(clazz.isAnnotationPresent(AspectEnable.class)) {
            aspectEnabled = true;
        }
    }

    public boolean isAspectEnabled() {
        return aspectEnabled;
    }
}
