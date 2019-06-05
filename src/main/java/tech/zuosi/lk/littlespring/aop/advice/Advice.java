package tech.zuosi.lk.littlespring.aop.advice;

import java.lang.reflect.InvocationTargetException;

public interface Advice {
    void process() throws InvocationTargetException, IllegalAccessException;
}
