package com.project.bugtrackingsystem.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;


@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@DiscriminatorValue("TestEngineer")
public class TestEngineer extends User implements Serializable {

	private String testerName;
	private String testerSkill;
}