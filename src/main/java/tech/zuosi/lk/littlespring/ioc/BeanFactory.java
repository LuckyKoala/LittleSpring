package tech.zuosi.lk.littlespring.ioc;

import tech.zuosi.lk.littlespring.exception.InvalidBeanException;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by luckykoala on 19-2-28.
 */
public class BeanFactory {
    private static final Map<String, BeanDefinition> beanMap = new HashMap<>(); //保存beanId和bean定义的映射关系

    public Object getBean(String beanId) throws Exception {
        BeanDefinition beanDefinition = beanMap.get(beanId);
        if(beanDefinition == null) return null;
        return beanDefinition.getInstance();
    }

    public void readConfig(Class clazz) throws InvalidBeanException, IllegalAccessException, InstantiationException {
        Object instance = clazz.newInstance();
        for(Method method : clazz.getDeclaredMethods()) {
            Bean bean = method.getAnnotation(Bean.class);
            if(bean==null) continue;
            String beanId = bean.value();
            if(beanId.isEmpty()) beanId = method.getName();
            if(method.getParameterCount() > 0) throw new InvalidBeanException(method.getName());
            beanMap.put(beanId, new BeanDefinition(instance, method));
        }
    }
}
