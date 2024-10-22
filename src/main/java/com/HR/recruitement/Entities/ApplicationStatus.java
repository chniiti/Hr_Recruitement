package com.HR.recruitement.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ApplicationStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String statusName;
    private String description;

    @OneToMany(mappedBy = "applicationStatus", cascade = CascadeType.ALL)
    private List<Application> applications;

}
