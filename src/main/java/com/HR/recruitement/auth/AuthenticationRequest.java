package com.HR.recruitement.auth;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class AuthenticationRequest {
    private String email;
    private String password;
}
