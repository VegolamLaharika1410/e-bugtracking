package com.project.bugtrackingsystem.entity;

import java.io.Serializable;

import java.time.LocalDate;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.bugtrackingsystem.util.BugStatus;
import com.project.bugtrackingsystem.util.Severity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "bugs")
public class Bug implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bug_id")
	private Integer bugId;

    @Column(name = "bug_title")
    private String bugTitle;

    @Column(name = "bug_description")
    private String bugDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "severity")
    private Severity severity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "created_by_id", referencedColumnName = "user_id")
    private TestEngineer createdBy;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "assign_to_id", referencedColumnName = "user_id")
    private Developer assignTo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private BugStatus status;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "last_updated_date")
    private LocalDate lastUpdatedDate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "proj_id")
    private Project project;
}