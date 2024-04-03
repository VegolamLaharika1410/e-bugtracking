package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.BugDTO;
//import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import com.project.bugtrackingsystem.entity.Bug;
import com.project.bugtrackingsystem.entity.Developer;
//import com.project.bugtrackingsystem.entity.Project;
import com.project.bugtrackingsystem.entity.TestEngineer;
//import com.project.bugtrackingsystem.repository.ProjectRepository;
import com.project.bugtrackingsystem.repository.TestEngineerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TestEngineerServiceImpl implements TestEngineerService {

    @Autowired
    private TestEngineerRepository testEngineerRepository;

//    @Autowired
//    private ProjectRepository projectRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public TestEngineerDTO addTestEngineer(TestEngineerDTO testEngineerDTO) {
        TestEngineer testEngineer = modelMapper.map(testEngineerDTO, TestEngineer.class);
        testEngineer = testEngineerRepository.save(testEngineer);
        return modelMapper.map(testEngineer, TestEngineerDTO.class);
    }

    @Override
    public TestEngineerDTO updateTestEngineer(TestEngineerDTO testEngineerDTO) {
        TestEngineer existingTestEngineerEntity = testEngineerRepository.findById(testEngineerDTO.getUserId()).orElse(null);

        if (existingTestEngineerEntity != null) {
            // Update the fields as needed
            existingTestEngineerEntity.setTesterName(testEngineerDTO.getTesterName());
            existingTestEngineerEntity.setUserEmail(testEngineerDTO.getUserEmail());
            // Continue updating other fields

            existingTestEngineerEntity = testEngineerRepository.save(existingTestEngineerEntity);
            return modelMapper.map(existingTestEngineerEntity, TestEngineerDTO.class);
        } else {
            return null; // Handle the case where the test engineer is not found
        }
    }

    @Override
    public TestEngineerDTO getTestEngById(Integer testerId) {
        TestEngineer testEngineerEntity = testEngineerRepository.findById(testerId).orElse(null);

        if (testEngineerEntity != null) {
            return modelMapper.map(testEngineerEntity, TestEngineerDTO.class);
        } else {
            return null; // Handle the case where the test engineer is not found
        }
    }

    @Override
    public Page<TestEngineerDTO> getAllTesters(Pageable pageable) {
    	Page<TestEngineer> testEngineerEntities = testEngineerRepository.findAll(pageable);

		/*
		 * return testEngineerEntities.stream() .map(testEngineer ->
		 * modelMapper.map(testEngineer, TestEngineerDTO.class))
		 * .collect(Collectors.toList());
		 */
    	
    	Page<TestEngineerDTO> testEngineerDtoPage = testEngineerEntities.map(te -> modelMapper.map(te, TestEngineerDTO.class));
		return testEngineerDtoPage;
    }

    @Override
	public void deleteTestEngineer(Integer testerId) {
		
		TestEngineer testEngineerEntity = modelMapper.map(testerId, TestEngineer.class);
		
		testEngineerRepository.deleteById(testerId);
	}
    
//    @Override
//    public List<ProjectDTO> getProjectsByTestEngId(Integer testEngId) {
//        TestEngineer testEngineerEntity = testEngineerRepository.findById(testEngId).orElse(null);
//
//        if (testEngineerEntity != null) {
//            List<Project> projectsForTestEngineer = testEngineerRepository.findByTestEngineer(testEngineerEntity);
//
//            return projectsForTestEngineer.stream()
//                    .map(project -> modelMapper.map(project, ProjectDTO.class))
//                    .collect(Collectors.toList());
//        } else {
//            return null; // Handle the case where the test engineer is not found
//        }
//    }
}
