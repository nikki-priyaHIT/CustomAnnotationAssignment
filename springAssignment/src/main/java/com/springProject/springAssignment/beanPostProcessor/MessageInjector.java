package com.springProject.springAssignment.beanPostProcessor;
import com.springProject.springAssignment.customAnnotation.CustomAnnotationss;
import com.springProject.springAssignment.serviceLayer.ServiceLayer;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class MessageInjector implements BeanPostProcessor {
    private final ServiceLayer messageService;

    public MessageInjector(ServiceLayer messageService) {
        this.messageService = messageService;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        for (Field field : bean.getClass().getDeclaredFields()) {
            if (field.isAnnotationPresent(CustomAnnotationss.class)) {
                CustomAnnotationss annotation = field.getAnnotation(CustomAnnotationss.class);
                String value = messageService.getMessage(annotation.key());
                field.setAccessible(true);
                try {
                    field.set(bean, value);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Failed to inject message for key: " + annotation.key(), e);
                }
            }
        }
        return bean;
    }
}
