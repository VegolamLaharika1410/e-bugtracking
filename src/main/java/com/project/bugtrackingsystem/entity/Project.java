package com.project.bugtrackingsystem.entity;

import javax.persistence.*;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;
import java.util.List;


@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "projects")
public class Project implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proj_id")
	private Integer projId;

	@Column(name = "proj_name")
	private String projName;

	@Column(name = "project_description")
	private String projectDescription;

	@Column(name = "proj_status")
	private String projStatus;
	
	@ManyToMany(mappedBy = "projects")
	@JsonIgnore
    private List<User> users;
}