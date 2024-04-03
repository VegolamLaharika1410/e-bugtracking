package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.DeveloperDTO;
import com.project.bugtrackingsystem.dto.ProjectDTO;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface DeveloperService {
    DeveloperDTO addDeveloper(DeveloperDTO developer);
	void deleteDeveloper(Integer devId);
    DeveloperDTO updateDeveloper(DeveloperDTO developer);
    DeveloperDTO getDeveloperById(Integer devId);
    Page<DeveloperDTO> getAllDevelopers(Pageable pageable);
    List<ProjectDTO> getProjectsByDevId(Integer devId);
}
