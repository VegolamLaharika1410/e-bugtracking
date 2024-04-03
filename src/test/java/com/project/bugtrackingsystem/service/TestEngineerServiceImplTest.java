package com.project.bugtrackingsystem.service;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.project.bugtrackingsystem.dto.TestEngineerDTO;
import com.project.bugtrackingsystem.entity.TestEngineer;
import com.project.bugtrackingsystem.repository.TestEngineerRepository;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
class TestEngineerServiceImplTest {

    @Mock
    private TestEngineerRepository testEngineerRepository;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private TestEngineerServiceImpl testEngineerService;

    @Test
    void testAddTestEngineer() {
        // Arrange
        TestEngineerDTO testEngineerDTO = new TestEngineerDTO();
        TestEngineer testEngineerEntity = new TestEngineer();
        when(modelMapper.map(testEngineerDTO, TestEngineer.class)).thenReturn(testEngineerEntity);
        when(testEngineerRepository.save(testEngineerEntity)).thenReturn(testEngineerEntity);
        when(modelMapper.map(testEngineerEntity, TestEngineerDTO.class)).thenReturn(testEngineerDTO);

        // Act
        TestEngineerDTO result = testEngineerService.addTestEngineer(testEngineerDTO);

        // Assert
        assertEquals(testEngineerDTO, result);
        verify(modelMapper).map(testEngineerDTO, TestEngineer.class);
        verify(testEngineerRepository).save(testEngineerEntity);
        verify(modelMapper).map(testEngineerEntity, TestEngineerDTO.class);
    }



    @Test
    void testUpdateTestEngineer_TestEngineerNotFound() {
        // Arrange
        int testerId = 1;
        TestEngineerDTO testEngineerDTO = new TestEngineerDTO();
        testEngineerDTO.setUserId(testerId);
        when(testEngineerRepository.findById(testerId)).thenReturn(java.util.Optional.empty());

        // Act and Assert
        assertNull(testEngineerService.updateTestEngineer(testEngineerDTO));
        verify(testEngineerRepository).findById(testerId);
    }

    @Test
    void testGetTestEngById() {
        // Arrange
        int testerId = 1;
        TestEngineerDTO testEngineerDTO = new TestEngineerDTO();
        TestEngineer testEngineerEntity = new TestEngineer();
        when(testEngineerRepository.findById(testerId)).thenReturn(java.util.Optional.of(testEngineerEntity));
        when(modelMapper.map(testEngineerEntity, TestEngineerDTO.class)).thenReturn(testEngineerDTO);

        // Act
        TestEngineerDTO result = testEngineerService.getTestEngById(testerId);

        // Assert
        assertEquals(testEngineerDTO, result);
        verify(testEngineerRepository).findById(testerId);
        verify(modelMapper).map(testEngineerEntity, TestEngineerDTO.class);
    }

    @Test
    void testGetTestEngById_TestEngineerNotFound() {
        // Arrange
        int testerId = 1;
        when(testEngineerRepository.findById(testerId)).thenReturn(java.util.Optional.empty());

        // Act and Assert
        assertNull(testEngineerService.getTestEngById(testerId));
        verify(testEngineerRepository).findById(testerId);
    }

    
}

