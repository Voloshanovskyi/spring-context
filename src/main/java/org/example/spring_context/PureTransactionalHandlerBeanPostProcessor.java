package org.example.spring_context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

public class PureTransactionalHandlerBeanPostProcessor implements BeanPostProcessor {
    private final Map<String, Class<?>> beanMap = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = bean.getClass();
        if (beanClass.isAnnotationPresent(PureTransactional.class)) {
            beanMap.put(beanName, beanClass);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Class<?> beanClass = beanMap.get(beanName);
        if (beanClass != null) {
            return Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), (proxy, method, args) -> {
                System.out.println("Open transaction");
                long before = System.nanoTime();
                Object result = method.invoke(bean, args);
                long after = System.nanoTime();
                long timeout = after - before;
                System.out.println(timeout/1000);
                System.out.println("Close transaction");
                return result;
            });

        }
        return bean;
    }
}
