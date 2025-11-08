package com.springProject.springAssignment.serviceLayer;
import com.springProject.springAssignment.entity.Entities;
import com.springProject.springAssignment.repo.RepoLayer;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class ServiceLayer {

    private final RepoLayer repo;

    public ServiceLayer(RepoLayer repo) {
        this.repo = repo;
    }

    @PostConstruct
    public void preload() {
        if (repo.count() == 0) {
            repo.save(new Entities("welcome", "Welcome, this is a custom annotation project."));
            repo.save(new Entities("bye", "Bye, see you again next time."));

        }
    }

    public String getMessage(String key) {
        return repo.findById(key)
                .map(Entities::getValue)
                .orElse("Message not found for key: " + key);
    }
}

