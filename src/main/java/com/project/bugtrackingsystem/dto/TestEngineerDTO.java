package com.project.bugtrackingsystem.dto;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestEngineerDTO extends UserDTO {
	
	@NotBlank(message = "name cannot be blank")
	private String testerName;
	
	@NotBlank(message = "skill cannot be blank")
	private String testerSkill;
}