package tech.zuosi.lk.littlespring.ioc;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by luckykoala on 19-2-28.
 */
public class BeanDefinition {
    private Type type;
    private Object instance; //默认单例
    //===For BEAN===
    private Object object;
    private Method method;
    //===For COMPONENT===
    private List<String> dependencies;
    private Constructor constructor;


    public BeanDefinition(Object object, Method method) {
        this.type = Type.BEAN;
        this.object = object;
        this.method = method;
    }

    public BeanDefinition(List<String> dependencies, Constructor constructor) {
        this.type = Type.COMPONENT;
        this.dependencies = dependencies;
        this.constructor = constructor;
    }

    public Object getInstance(BeanFactory beanFactory)
            throws InvocationTargetException, IllegalAccessException, InstantiationException {
        if(instance == null) {
            if(type == Type.BEAN) {
                instance = method.invoke(object);
            } else if(type == Type.COMPONENT) {
                Object[] args = new Object[dependencies.size()];
                int i = 0;
                for(String id : dependencies) {
                    args[i++] = beanFactory.getBean(id);
                }
                instance = constructor.newInstance(args);
            }
        }

        return instance;
    }

    enum Type {
        BEAN, COMPONENT
    }
}
