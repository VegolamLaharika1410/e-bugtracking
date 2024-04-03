package com.project.bugtrackingsystem.controller;

import com.project.bugtrackingsystem.dto.BugDTO;
//import com.project.bugtrackingsystem.dto.ProjectDTO;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import com.project.bugtrackingsystem.service.TestEngineerServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testengineers")
public class TestEngineerController {

	@Autowired
	private TestEngineerServiceImpl testEngineerService;


	@PostMapping("/add")
	public TestEngineerDTO addTestEngineer(@RequestBody TestEngineerDTO testEngineerDTO) {
		testEngineerDTO.setUserRole("TestEngineer");
		return testEngineerService.addTestEngineer(testEngineerDTO);
	}

	@PutMapping("/update")
	public TestEngineerDTO updateTestEngineer(@RequestBody TestEngineerDTO testEngineerDTO) {
		return testEngineerService.updateTestEngineer(testEngineerDTO);
	}

	@GetMapping("/{id}")
	public TestEngineerDTO getTestEngineerById(@PathVariable Integer id) {
		return testEngineerService.getTestEngById(id);
	}

	@GetMapping("/all")
	public Page<TestEngineerDTO> getAllTestEngineers() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<TestEngineerDTO> page = testEngineerService.getAllTesters(pageable);
		return page;
	}

//	@GetMapping("/{id}/projects")
//	public List<ProjectDTO> getProjectsByTestEngineerId(@PathVariable Integer id) {
//		return testEngineerService.getProjectsByTestEngId(id);
//	}

	@DeleteMapping("/delete/{testerId}")
	public void deleteTestEngineer(@PathVariable Integer testerId) {
		// Implement logic to delete the test engineer by id
		testEngineerService.deleteTestEngineer(testerId);
		System.out.println("Test engineer with ID " + testerId + " deleted successfully");
	}
}