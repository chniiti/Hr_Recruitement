package com.HR.recruitement.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.io.Serializable;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Candidate extends User implements Serializable {

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Resume> resumes;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Skills> skills;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Experience> experiences;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Education> educations;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<Application> applications;
}
