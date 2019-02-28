package tech.zuosi.lk.littlespring.ioc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by luckykoala on 19-2-28.
 */
public class BeanDefinition {
    private Object object;
    private Method method;
    private Object instance; //默认单例

    //延迟实例化
    public BeanDefinition(Object object, Method method) {
        this.object = object;
        this.method = method;
    }

    public Object getInstance() throws InvocationTargetException, IllegalAccessException {
        if(instance == null) instance = method.invoke(object);

        return instance;
    }
}
