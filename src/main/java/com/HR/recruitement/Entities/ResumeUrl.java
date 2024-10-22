package com.HR.recruitement.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResumeUrl extends Resume implements Serializable {

    private String url;

}
