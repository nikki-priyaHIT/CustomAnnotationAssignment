package com.springProject.springAssignment.customAnnotation;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CustomAnnotationss {
    String key();
}
