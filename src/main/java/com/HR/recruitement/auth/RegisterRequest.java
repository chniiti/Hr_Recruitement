package com.HR.recruitement.auth;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor


public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
}
