package tech.zuosi.lk.littlespring;

import tech.zuosi.lk.littlespring.context.ApplicationContext;

/**
 * IoC容器主类，提供接口如下：
 *  1. 构造方法从传入的类中读取配置
 *  2. 实例构造完成后，getBean方法可用于获取容器中对应beanId的bean实例
 *
 * Created by luckykoala on 19-2-28.
 */
public class LittleSpring {
    private ApplicationContext context = new ApplicationContext();

    public LittleSpring(Class clazz) throws Exception {
        context.readConfig(clazz);
    }

    public Object getBean(String beanId) throws ReflectiveOperationException {
        return context.getBean(beanId);
    }
}
