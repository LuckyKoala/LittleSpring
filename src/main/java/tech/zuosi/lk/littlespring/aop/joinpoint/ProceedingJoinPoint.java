package tech.zuosi.lk.littlespring.aop.joinpoint;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProceedingJoinPoint extends JoinPoint {
    private Method method;

    public ProceedingJoinPoint(Object[] args, Object proxy, Object target, Method method) {
        super(args, proxy, target);
        this.method = method;
    }

    Object process(Object[] params) throws InvocationTargetException, IllegalAccessException {
        return method.invoke(proxy, args);
    }
}
