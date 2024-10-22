package com.HR.recruitement.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Experience implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Date starDate;
    private Date endDate;
    private String responsibilities;

    @ManyToOne
    @JoinColumn(name = "experience_id")
    private Candidate candidate;
}
