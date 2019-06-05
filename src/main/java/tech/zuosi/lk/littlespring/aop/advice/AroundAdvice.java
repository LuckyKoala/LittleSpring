package tech.zuosi.lk.littlespring.aop.advice;

import java.lang.reflect.Method;

public class AroundAdvice {
    private Object object;
    private Method method;

    public AroundAdvice(Object object, Method method) {
        this.object = object;
        this.method = method;
    }


}
