package com.project.bugtrackingsystem.controller;

import com.project.bugtrackingsystem.dto.BugDTO;
import com.project.bugtrackingsystem.service.BugServiceImpl;
import com.project.bugtrackingsystem.util.BugStatus;
import com.project.bugtrackingsystem.util.Severity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;
import java.util.List;

@RestController
@RequestMapping("/bugs")
public class BugController {

	@Autowired
	private BugServiceImpl bugService;


	@PostMapping("/create")
	public BugDTO createBug(@RequestBody BugDTO bugDTO) {
		return bugService.createBug(bugDTO);
	}
	
	@GetMapping("/{id}")
	public BugDTO findBugById(@PathVariable Integer id) {
		return bugService.findBugById(id);
	}
	
	@GetMapping("/all")
	public Page<BugDTO> findAllBugs() {
		Pageable pageable = PageRequest.of(0, 10);
		Page<BugDTO> page = bugService.findAllBugs(pageable);
		return page;
	}
	
	@GetMapping("/byProject/{projectId}")
	public List<BugDTO> findBugsByProjectId(@PathVariable Integer projectId) {
		return bugService.findAllBugsByProjectId(projectId);
	}
	
	@GetMapping("/byDeveloper/{devId}")
	public List<BugDTO> findBugsByDeveloperId(@PathVariable Integer devId) {
		return bugService.findAllBugsByDevId(devId);
	}
	
	@GetMapping("/byTestEngineer/{testerId}")
	public List<BugDTO> findBugsByTestEngineerId(@PathVariable Integer testerId) {
		return bugService.findAllBugsByTesterId(testerId);
	}
	
	@GetMapping("/byStatus/{status}")
	public List<BugDTO> findBugsByStatus(@PathVariable BugStatus status) {
		return bugService.findBugsByStatus(status);
	}
	
	@GetMapping("/bySeverity/{severity}")
	public List<BugDTO> findBugsBySeverity(@PathVariable Severity severity) {
		return bugService.findBugsBySeverity(severity);
	}
	
	@PutMapping("/update")
	public BugDTO updateBug(@RequestBody BugDTO bugDTO) {
		return bugService.updateBug(bugDTO);
	}

	@DeleteMapping("/delete/{id}")
	public String deleteBugById(@PathVariable Integer id) {
		// Implement logic to delete the bug by ID
		return "Bug with ID " + id + " deleted successfully";
	}
}