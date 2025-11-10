package com.springProject.springAssignment.eventListener;

import com.springProject.springAssignment.customAnnotation.CustomAnnotationss;
import com.springProject.springAssignment.serviceLayer.ServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

@Component
public class MessageInjector {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private ServiceLayer messageService;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        String[] beanNames = context.getBeanDefinitionNames();

        for (String beanName : beanNames) {
            Object bean = context.getBean(beanName);

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
        }
    }
}
