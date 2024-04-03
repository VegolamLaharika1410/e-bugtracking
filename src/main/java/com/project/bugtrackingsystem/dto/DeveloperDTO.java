package com.project.bugtrackingsystem.dto;

import java.time.LocalDate;
import java.util.List;

import javax.validation.constraints.NotBlank;

import com.project.bugtrackingsystem.util.BugStatus;
import com.project.bugtrackingsystem.util.Severity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DeveloperDTO extends UserDTO {
	
	@NotBlank(message = "name cannot be blank")
	private String devName;
	
	@NotBlank(message = "skill cannot be blank")
	private String devSkill;
}