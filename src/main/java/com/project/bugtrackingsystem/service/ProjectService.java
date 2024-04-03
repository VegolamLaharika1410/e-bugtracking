package com.project.bugtrackingsystem.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.project.bugtrackingsystem.dto.DeveloperDTO;
import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;

public interface ProjectService {

    ProjectDTO createProject(ProjectDTO projDTO);

    ProjectDTO getProjectById(Integer projId);

    Page<ProjectDTO> getAllProjects(Pageable pageable);

    ProjectDTO updateProject(ProjectDTO projDTO);

    List<DeveloperDTO> getDevelopersByProjectId(Integer projId);

    List<TestEngineerDTO> getTestEngineersByProjectId(Integer projId);
}
