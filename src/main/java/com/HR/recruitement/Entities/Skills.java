package com.HR.recruitement.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.repository.cdi.Eager;

import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Skills implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String skillName;
    private int proficiencyLevel;

    @ManyToOne
    @JoinColumn(name = "skill_id")
    private Candidate candidate;

}
