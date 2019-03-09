package tech.zuosi.lk.littlespring.ioc;

import tech.zuosi.lk.littlespring.exception.NoSuitableConstructorForComponentException;
import tech.zuosi.lk.littlespring.exception.InvalidBeanException;
import tech.zuosi.lk.littlespring.exception.InvalidPackageException;
import tech.zuosi.lk.littlespring.io.PackageScanner;
import tech.zuosi.lk.littlespring.ioc.annotation.Autowired;
import tech.zuosi.lk.littlespring.ioc.annotation.Bean;
import tech.zuosi.lk.littlespring.ioc.annotation.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by luckykoala on 19-2-28.
 */
public class BeanFactory {
    private final Map<String, BeanDefinition> beanMap = new HashMap<>(); //保存beanId和bean定义的映射关系

    public Object getBean(String beanId) throws ReflectiveOperationException {
        BeanDefinition beanDefinition = beanMap.get(beanId);
        if(beanDefinition == null) return null;
        return beanDefinition.getInstance(this);
    }

    public void readConfig(Class clazz) throws ReflectiveOperationException {
        Object instance = clazz.newInstance();
        for(Method method : clazz.getDeclaredMethods()) {
            Bean bean = method.getAnnotation(Bean.class);
            if(bean==null) continue;
            String beanId = bean.value();
            if(beanId.isEmpty()) beanId = method.getReturnType().getSimpleName();
            beanMap.put(beanId, new BeanDefinition(Stream.of(method.getParameterTypes())
                    .map(Class::getSimpleName)
                    .collect(Collectors.toList()), instance, method));
        }
    }

    @SuppressWarnings("unchecked")
    public void readComponent(Class clazz) throws NoSuitableConstructorForComponentException {
        if(!clazz.isAnnotationPresent(Component.class)) return;
        //确定beanId
        String beanId = ((Component) clazz.getAnnotation(Component.class)).value();
        if(beanId.isEmpty()) beanId = clazz.getSimpleName();
        //检查是否有autoWired依赖
        int autoWiredConstructorCnt = 0;
        Constructor savedConstructor = null;
        List<String> dependencyList = null;
        for(Constructor constructor : clazz.getConstructors()) {
            if(!constructor.isAnnotationPresent(Autowired.class)) continue;
            if(autoWiredConstructorCnt > 0) throw new NoSuitableConstructorForComponentException(clazz.getName());
            autoWiredConstructorCnt++;

            Autowired autowired = (Autowired) constructor.getAnnotation(Autowired.class);
            String[] dependencies = autowired.value();
            if(dependencies.length == constructor.getParameterCount()) {
                savedConstructor = constructor;
                dependencyList = Arrays.asList(dependencies);
            } else if(dependencies.length == 0) {
                //需要自动推断依赖
                savedConstructor = constructor;
                dependencyList = Stream.of(constructor.getParameterTypes())
                        .map(Class::getSimpleName)
                        .collect(Collectors.toList());

            }
        }
        if(autoWiredConstructorCnt == 0) {
            try {
                beanMap.put(beanId, new BeanDefinition(Collections.emptyList(), clazz.getConstructor()));
            } catch (NoSuchMethodException e) {
                throw new NoSuitableConstructorForComponentException(clazz.getName());
            }
        } else {
            beanMap.put(beanId, new BeanDefinition(dependencyList, savedConstructor));
        }
    }

    public void autoScan(String packageStr) throws InvalidPackageException, NoSuitableConstructorForComponentException {
        PackageScanner.scan(this, packageStr);
    }
}
