package com.project.bugtrackingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.project.bugtrackingsystem.dto.DeveloperDTO;
import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import com.project.bugtrackingsystem.entity.Project;
import com.project.bugtrackingsystem.entity.User;
import com.project.bugtrackingsystem.repository.ProjectRepository;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    private ProjectRepository projectRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private ProjectServiceImpl projectService;

    @Test
    void testCreateProject() {
        // Arrange
        ProjectDTO projectDTO = new ProjectDTO();
        Project projectEntity = new Project();
        when(modelMapper.map(projectDTO, Project.class)).thenReturn(projectEntity);
        when(projectRepository.save(projectEntity)).thenReturn(projectEntity);
        when(modelMapper.map(projectEntity, ProjectDTO.class)).thenReturn(projectDTO);

        // Act
        ProjectDTO result = projectService.createProject(projectDTO);

        // Assert
        assertEquals(projectDTO, result);
        verify(modelMapper).map(projectDTO, Project.class);
        verify(projectRepository).save(projectEntity);
        verify(modelMapper).map(projectEntity, ProjectDTO.class);
    }

    @Test
    void testGetProjectById() {
        // Arrange
        int projId = 1;
        ProjectDTO projectDTO = new ProjectDTO();
        Project projectEntity = new Project();
        when(projectRepository.findById(projId)).thenReturn(Optional.of(projectEntity));
        when(modelMapper.map(projectEntity, ProjectDTO.class)).thenReturn(projectDTO);

        // Act
        ProjectDTO result = projectService.getProjectById(projId);

        // Assert
        assertEquals(projectDTO, result);
        verify(projectRepository).findById(projId);
        verify(modelMapper).map(projectEntity, ProjectDTO.class);
    }

    @Test
    void testUpdateProject_ProjectNotFound() {
        // Arrange
        int projId = 2;
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setProjId(projId);
        when(projectRepository.findById(projId)).thenReturn(Optional.empty());

        // Act and Assert
        assertNull(projectService.updateProject(projectDTO));
        verify(projectRepository).findById(projId);
    }

    @Test
    void testGetDevelopersByProjectId() {
        // Arrange
        int projId = 1;
        Project projectEntity = new Project();
        projectEntity.setProjId(projId);
        User developer1 = new User();
        developer1.setUserRole("Dev");
        User developer2 = new User();
        developer2.setUserRole("Dev");
        projectEntity.setUsers(List.of(developer1, developer2));

        when(projectRepository.findById(projId)).thenReturn(Optional.of(projectEntity));
        when(modelMapper.map(developer1, DeveloperDTO.class)).thenReturn(new DeveloperDTO());
        when(modelMapper.map(developer2, DeveloperDTO.class)).thenReturn(new DeveloperDTO());

        // Act
        List<DeveloperDTO> result = projectService.getDevelopersByProjectId(projId);

        // Assert
        assertEquals(2, result.size());
        verify(modelMapper, times(2)).map(any(), eq(DeveloperDTO.class));
        verify(projectRepository).findById(projId);
    }

    @Test
    void testGetTestEngineersByProjectId() {
        // Arrange
        int projId = 2;
        Project projectEntity = new Project();
        projectEntity.setProjId(projId);
        User testEngineer1 = new User();
        testEngineer1.setUserRole("Testing");
        User testEngineer2 = new User();
        testEngineer2.setUserRole("Testing");
        projectEntity.setUsers(List.of(testEngineer1, testEngineer2));

        when(projectRepository.findById(projId)).thenReturn(Optional.of(projectEntity));
        when(modelMapper.map(testEngineer1, TestEngineerDTO.class)).thenReturn(new TestEngineerDTO());
        when(modelMapper.map(testEngineer2, TestEngineerDTO.class)).thenReturn(new TestEngineerDTO());

        // Act
        List<TestEngineerDTO> result = projectService.getTestEngineersByProjectId(projId);

        // Assert
        assertEquals(2, result.size());
        verify(modelMapper, times(2)).map(any(), eq(TestEngineerDTO.class));
        verify(projectRepository).findById(projId);
    }
}

