package com.springProject.springAssignment.beans;
import com.springProject.springAssignment.customAnnotation.CustomAnnotationss;
import org.springframework.stereotype.Component;

@Component
public class Welcomee {

    @CustomAnnotationss(key = "welcome")
    private String message;

    public String getMessage() {
        return message;
    }
}
