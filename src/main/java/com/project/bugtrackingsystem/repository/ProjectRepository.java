package com.project.bugtrackingsystem.repository;


//import com.project.bugtrackingsystem.entity.Developer;
import com.project.bugtrackingsystem.entity.Project;
//import com.project.bugtrackingsystem.entity.TestEngineer;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

	
}
