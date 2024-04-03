package com.project.bugtrackingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.project.bugtrackingsystem.dto.BugDTO;
import com.project.bugtrackingsystem.entity.Bug;
import com.project.bugtrackingsystem.exception.BugException;
import com.project.bugtrackingsystem.repository.BugRepository;

@ExtendWith(MockitoExtension.class)
class BugServiceImplTest {

    @Mock
    private BugRepository bugRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private BugServiceImpl bugService;

    @Test
    void testCreateBug() {
        // Arrange
        BugDTO bugDTO = new BugDTO();
        Bug bugEntity = new Bug();
        when(modelMapper.map(bugDTO, Bug.class)).thenReturn(bugEntity);
        when(bugRepository.save(bugEntity)).thenReturn(bugEntity);
        when(modelMapper.map(bugEntity, BugDTO.class)).thenReturn(bugDTO);

        // Act
        BugDTO result = bugService.createBug(bugDTO);

        // Assert
        assertEquals(bugDTO, result);
        verify(modelMapper).map(bugDTO, Bug.class);
        verify(bugRepository).save(bugEntity);
        verify(modelMapper).map(bugEntity, BugDTO.class);
    }

    @Test
    void testUpdateBug() throws BugException {
        // Arrange
        BugDTO bugDTO = new BugDTO();
        bugDTO.setBugId(1);
        Bug existingBugEntity = new Bug();
        when(bugRepository.findById(1)).thenReturn(Optional.of(existingBugEntity));
        Bug updatedEntity = new Bug();
        when(modelMapper.map(bugDTO, Bug.class)).thenReturn(updatedEntity);
        when(bugRepository.save(updatedEntity)).thenReturn(updatedEntity);
        when(modelMapper.map(updatedEntity, BugDTO.class)).thenReturn(bugDTO);

        // Act
        BugDTO result = bugService.updateBug(bugDTO);

        // Assert
        assertEquals(bugDTO, result);
        verify(bugRepository).findById(1);
        verify(modelMapper).map(bugDTO, Bug.class);
        verify(bugRepository).save(updatedEntity);
        verify(modelMapper).map(updatedEntity, BugDTO.class);
    }

    @Test
    void testUpdateBug_BugNotFound() {
        // Arrange
        BugDTO bugDTO = new BugDTO();
        bugDTO.setBugId(1);
        when(bugRepository.findById(1)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(BugException.class, () -> bugService.updateBug(bugDTO));
        verify(bugRepository).findById(1);
    }

    @Test
    void testFindBugById() throws BugException {
        // Arrange
        BugDTO bugDTO = new BugDTO();
        bugDTO.setBugId(1);
        Bug bugEntity = new Bug();
        when(bugRepository.findById(1)).thenReturn(Optional.of(bugEntity));
        when(modelMapper.map(bugEntity, BugDTO.class)).thenReturn(bugDTO);

        // Act
        BugDTO result = bugService.findBugById(1);

        // Assert
        assertEquals(bugDTO, result);
        verify(bugRepository).findById(1);
        verify(modelMapper).map(bugEntity, BugDTO.class);
    }

    @Test
    void testFindBugById_BugNotFound() {
        // Arrange
        when(bugRepository.findById(1)).thenReturn(Optional.empty());

        // Act and Assert
        assertThrows(BugException.class, () -> bugService.findBugById(1));
        verify(bugRepository).findById(1);
    }

}

