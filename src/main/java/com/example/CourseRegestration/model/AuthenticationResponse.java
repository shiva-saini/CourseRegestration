package com.example.CourseRegestration.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AuthenticationResponse {
    private String jwt;
    public AuthenticationResponse(String jwt){
        this.jwt = jwt;
    }

    public String getJwt(){
        return jwt;
    }
}
