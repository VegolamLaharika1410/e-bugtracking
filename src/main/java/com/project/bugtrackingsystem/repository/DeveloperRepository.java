package com.project.bugtrackingsystem.repository;

import com.project.bugtrackingsystem.entity.Developer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
 
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
	
}