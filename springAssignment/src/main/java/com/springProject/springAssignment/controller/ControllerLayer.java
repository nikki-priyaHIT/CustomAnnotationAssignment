package com.springProject.springAssignment.controller;
import com.springProject.springAssignment.beans.Welcomee;
import com.springProject.springAssignment.beans.Byee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerLayer {
    private final Welcomee welcomeBean;
    private final Byee byeBean;

    public ControllerLayer(Welcomee welcomeBean, Byee byeBean) {
        this.welcomeBean = welcomeBean;
        this.byeBean = byeBean;
    }

    @GetMapping("/welcome")
    public String getWelcomeMessage() {
        return welcomeBean.getMessage();
    }

    @GetMapping("/bye")
    public String getByeMessage() {
        return byeBean.getMessage();
    }
}
