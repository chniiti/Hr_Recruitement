package com.HR.recruitement.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class JobOpportunitie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long jobOpportunitiyId;
    private String jobOpportunitieName;
    private String description;
    private Date startDate;
    private Date endDate;
    private double annualSalary;
    private double hourlySalary;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "recruiter_id")
    private Recruiter recruiter;
}
