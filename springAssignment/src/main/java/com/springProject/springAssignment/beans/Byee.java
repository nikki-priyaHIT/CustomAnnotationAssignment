package com.springProject.springAssignment.beans;
import com.springProject.springAssignment.customAnnotation.CustomAnnotationss;
import org.springframework.stereotype.Component;

@Component
public class Byee {
    @CustomAnnotationss(key = "bye")
    private String message;

    public String getMessage() {
        return message;
    }
}
