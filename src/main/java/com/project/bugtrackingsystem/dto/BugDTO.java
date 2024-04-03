package com.project.bugtrackingsystem.dto;

import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
public class BugDTO {

	private Integer bugId;
	
	@NotBlank(message = "title cannot be blank")
	private String bugTitle;
	
	@NotBlank(message = "description cannot be blank")
	private String bugDescription;
	
	@NotBlank(message = "Severity cannot be blank")
	private Severity severity;
	
	@NotBlank(message = "created by cannot be blank")
	private TestEngineerDTO createdBy;

	@NotBlank(message = "Assign to cannot be blank")
	private DeveloperDTO assignTo;
	
	@NotBlank(message = "status cannot be blank")
	private BugStatus status;
	
	@NotNull
	private LocalDate startDate;
	
	@NotNull
	private LocalDate lastUpdatedDate;
	
	private ProjectDTO project;
	
	
}