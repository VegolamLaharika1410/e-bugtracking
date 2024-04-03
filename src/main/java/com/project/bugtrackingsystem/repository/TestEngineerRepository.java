package com.project.bugtrackingsystem.repository;

//import com.project.bugtrackingsystem.entity.Project;
import com.project.bugtrackingsystem.entity.TestEngineer;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
 
public interface TestEngineerRepository extends JpaRepository<TestEngineer, Integer> {
	
//	TestEngineer findProjectsByTesterId(Integer testEngId);
    // You can add custom query methods if needed
//	List<Project> findByTestEngineer(TestEngineer testEngineerEntity);
}