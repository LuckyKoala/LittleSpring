package tech.zuosi.lk.littlespring.aop.processor;

import tech.zuosi.lk.littlespring.context.ApplicationContext;
import tech.zuosi.lk.littlespring.ioc.annotation.Autowired;
import tech.zuosi.lk.littlespring.ioc.annotation.Component;

import java.lang.reflect.Method;

/**
 * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern?name-pattern(param-pattern)
 *             throws-pattern?)
 *
 * 暂时只支持绝对路径： beanName & functionName
 */
@Component
public class PointcutExpressionEvaluator {
    private ApplicationContext context;

    @Autowired
    public PointcutExpressionEvaluator(ApplicationContext context) {
        this.context = context;
    }

    /**
     * 定位到具体方法
     */
    public Method eval(String expression) throws ReflectiveOperationException {
        String[] names = expression.split("&");
        Method[] methods = context.getBean(names[0]).getClass().getMethods();
        for (Method method : methods) {
            if(method.getName().equals(names[1])) return method;
        }

        throw new RuntimeException("Can't find method of " + expression);
    }
}
