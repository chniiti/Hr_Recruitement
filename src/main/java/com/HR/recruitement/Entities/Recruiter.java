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


public class Recruiter extends User implements Serializable {

    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
    private List<JobOpportunitie> jobOpportunities;
}
