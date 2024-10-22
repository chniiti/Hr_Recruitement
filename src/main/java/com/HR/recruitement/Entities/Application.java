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

public class Application implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    @ManyToOne
    @JoinColumn(name = "applicationStatus_id")
    private ApplicationStatus applicationStatus;

    @ManyToMany
    @JoinTable(
            name = "application_role",
            joinColumns = @JoinColumn(name = "criteria_id"),
            inverseJoinColumns = @JoinColumn(name = "application_id")
    )
    private Set<Criteria> criteria=new HashSet<>();

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private List<Interview> interviews;


    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "score_id", referencedColumnName = "id")
    private Score score;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL)
    private List<Evaluation> evaluations;

}
