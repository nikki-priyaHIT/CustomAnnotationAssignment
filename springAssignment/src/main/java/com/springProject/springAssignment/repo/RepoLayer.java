package com.springProject.springAssignment.repo;

import com.springProject.springAssignment.entity.Entities;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoLayer extends JpaRepository<Entities, String> {
}
