package com.HR.recruitement.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Resume implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private Boolean active;
    private LocalDateTime lastUpdate;


    @ManyToOne
    @JoinColumn(name = "resume_id")
    private Candidate candidate;

    @PreUpdate
    @PrePersist
    public void updateTimestamp() {
        this.lastUpdate= LocalDateTime.now();
    }
}
