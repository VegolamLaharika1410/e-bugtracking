package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.BugDTO;
import com.project.bugtrackingsystem.entity.Bug;
import com.project.bugtrackingsystem.exception.BugException;
import com.project.bugtrackingsystem.repository.BugRepository;
import com.project.bugtrackingsystem.util.BugStatus;
import com.project.bugtrackingsystem.util.Severity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BugServiceImpl implements BugService {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BugDTO createBug(BugDTO bugDTO) {
        Bug bug = modelMapper.map(bugDTO, Bug.class);
        bug = bugRepository.save(bug);
        return modelMapper.map(bug, BugDTO.class);
    }

    @Override
    public BugDTO updateBug(BugDTO bugDTO) throws BugException {
        Bug existingBugEntity = bugRepository.findById(bugDTO.getBugId()).orElse(null);
        if (existingBugEntity != null) {
            Bug updateEntity=modelMapper.map(bugDTO, Bug.class);
            updateEntity = bugRepository.save(updateEntity);
            return modelMapper.map(updateEntity, BugDTO.class);
        } else {
        	throw new BugException("No bug data found"); // Handle the case where the bug is not found
        }
    }

    @Override
    public BugDTO findBugById(Integer bugId) throws BugException {
    	
        Bug bugEntity = bugRepository.findById(bugId).orElse(null);
        
        if (bugEntity != null) {
            return modelMapper.map(bugEntity, BugDTO.class);
        } else {
            throw new BugException("No bugs found with id "+bugId);
        }
    }
    @Override
    public Page<BugDTO> findAllBugs(Pageable pageable) {
    	
        Page<Bug> bugEntities = bugRepository.findAll(pageable);
        Page<BugDTO> bugDtoPage = bugEntities.map(bg -> modelMapper.map(bg, BugDTO.class));
        		return bugDtoPage;
        		
    }
    
    @Override
    public List<BugDTO> findAllBugsByProjectId(Integer projId) throws BugException {
        List<Bug> bugEntities = bugRepository.findByProject(projId);
 
        if (bugEntities != null && !bugEntities.isEmpty()) {
            return bugEntities.stream()
                    .map(bug -> modelMapper.map(bug, BugDTO.class))
                    .toList();
        } else {
            throw new BugException("No bugs found for project with id " + projId);
        }
    }
    
    @Override
	public List<BugDTO> findAllBugsByDevId(Integer devId) {
        List<Bug> bugEntities = bugRepository.findByProject(devId);
      return bugEntities.stream()
              .map(bug -> modelMapper.map(bug, BugDTO.class))
              .toList();
  }
	@Override
	public List<BugDTO> findAllBugsByTesterId(Integer testerId) {
        List<Bug> bugEntities = bugRepository.findByProject(testerId);
      return bugEntities.stream()
              .map(bug -> modelMapper.map(bug, BugDTO.class))
              .toList();
  }
    @Override
    public List<BugDTO> findBugsByStatus(BugStatus status) {
        List<Bug> bugEntities = bugRepository.findByStatus(status);
       
        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .toList();
    }

    @Override
    public List<BugDTO> findBugsBySeverity(Severity severity) {
        List<Bug> bugEntities = bugRepository.findBySeverity(severity);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .toList();
    }
}
