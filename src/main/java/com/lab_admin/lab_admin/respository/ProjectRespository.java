package com.lab_admin.lab_admin.respository;

import com.lab_admin.lab_admin.Bean.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRespository extends JpaRepository<Project,Integer> {
}
