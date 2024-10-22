package com.HR.recruitement.auth;

import lombok.*;



    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class AuthenticationResponse {

        private String token;
    }

