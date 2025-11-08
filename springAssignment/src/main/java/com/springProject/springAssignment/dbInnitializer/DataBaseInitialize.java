package com.springProject.springAssignment.dbInnitializer;

import com.springProject.springAssignment.entity.Entities;
import com.springProject.springAssignment.repo.RepoLayer;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInitialize {

    private final RepoLayer repo;

    public DataBaseInitialize(RepoLayer repo) {
        this.repo = repo;
    }

    @PostConstruct
    public void preload() {

        if (repo.count() == 0) {
            repo.save(new Entities("welcome", "Welcome, this is a custom annotation project."));
            repo.save(new Entities("bye", "Bye, see you again next time."));
        }
    }
}
