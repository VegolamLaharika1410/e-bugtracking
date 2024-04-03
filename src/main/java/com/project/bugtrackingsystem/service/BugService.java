package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.BugDTO;
import com.project.bugtrackingsystem.util.BugStatus;
import com.project.bugtrackingsystem.util.Severity;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
 
public interface BugService {
	
    public BugDTO createBug(BugDTO bugDTO);
    public BugDTO updateBug(BugDTO bugDTO);
    public BugDTO findBugById(Integer bugId);
    
    public Page<BugDTO> findAllBugs(Pageable pageable);
    public List<BugDTO> findAllBugsByProjectId(Integer projId);
    public List<BugDTO> findAllBugsByDevId(Integer projId);
    public List<BugDTO> findAllBugsByTesterId(Integer projId);
    

    public List<BugDTO> findBugsByStatus(BugStatus status); 
    public List<BugDTO> findBugsBySeverity(Severity severity);

}