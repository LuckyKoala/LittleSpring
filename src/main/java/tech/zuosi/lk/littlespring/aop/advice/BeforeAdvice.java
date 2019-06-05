package tech.zuosi.lk.littlespring.aop.advice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BeforeAdvice implements Advice {
    private Object object;
    private Method method;

    public BeforeAdvice(Object object, Method method) {
        this.object = object;
        this.method = method;
    }

    @Override
    public void process() throws InvocationTargetException, IllegalAccessException {
        this.method.invoke(object);
    }
}
