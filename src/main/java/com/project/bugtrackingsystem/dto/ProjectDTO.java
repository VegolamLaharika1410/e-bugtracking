package com.project.bugtrackingsystem.dto;

import java.util.List;
import javax.validation.constraints.NotBlank;
import com.project.bugtrackingsystem.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProjectDTO {
	
    private Integer projId;
    
    @NotBlank(message = "name cannot be blank")
    private String projName;
    
    @NotBlank(message = "description cannot be blank")
    private String projectDescription;
    
    @NotBlank(message = "status cannot be blank")
    private String projStatus;
    private List<User> users;

}