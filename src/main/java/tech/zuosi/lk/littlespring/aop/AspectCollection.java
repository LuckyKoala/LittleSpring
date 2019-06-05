package tech.zuosi.lk.littlespring.aop;

import tech.zuosi.lk.littlespring.context.ApplicationContext;
import tech.zuosi.lk.littlespring.ioc.annotation.Autowired;
import tech.zuosi.lk.littlespring.ioc.annotation.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class AspectCollection {
    private Map<String, Object> targetMap = new HashMap<>();
    private ApplicationContext context;

    @Autowired
    public AspectCollection(ApplicationContext context) {
        this.context = context;
    }

    public void analysis(Class clazz)
    {
        //
    }
}
