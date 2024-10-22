package com.HR.recruitement.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Evaluation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String comments;

    @ManyToOne
    @JoinColumn(name ="evaluation_id")
    private Application application;

}
