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

public class Document implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String description;
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "document_id")
    private User user;
}
