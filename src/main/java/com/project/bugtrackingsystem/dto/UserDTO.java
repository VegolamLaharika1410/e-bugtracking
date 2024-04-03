package com.project.bugtrackingsystem.dto;

import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDTO implements Serializable{
	private Integer userId;
	

    @NotBlank(message = "name cannot be blank")
	private String userName;
    
    @NotBlank(message = "password cannot be blank")
    @Size(min = 6,max = 10)
	private String userPassword;
    
    @NotBlank(message = "email cannot be blank")
	private String userEmail;
    
    @NotBlank(message = "contact cannot be blank")
    @Size(min=10,max=10)
	private String userContact;
    
	//Developer, TestEngineer
    @NotBlank(message = "Role cannot be Blank")
    @Pattern(regexp = "(Developer|TestEngineer)$")
	private String userRole;
    private List<ProjectDTO> projects;
}