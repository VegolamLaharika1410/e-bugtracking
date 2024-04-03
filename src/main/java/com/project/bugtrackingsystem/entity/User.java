package com.project.bugtrackingsystem.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING, length = 20)
@DiscriminatorValue("user_id") // Add this line to specify the discriminator value for the User class
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "username", unique = true)
    private String userName;

    @Column(name = "password")
    private String userPassword;

    @Column(name = "email")
    private String userEmail;

    @Column(name = "user_contact")
    private String userContact; 

    @Column(name = "user_role")
    private String userRole;
    
    @ManyToMany
    @JoinTable(name = "user_project",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "proj_id"))
    @JsonIgnore
    private List<Project> projects;
}