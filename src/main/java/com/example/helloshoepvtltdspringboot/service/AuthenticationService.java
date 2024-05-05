package com.example.helloshoepvtltdspringboot.service;


import com.example.helloshoepvtltdspringboot.reqAndresp.response.JwtAuthResponse;
import com.example.helloshoepvtltdspringboot.reqAndresp.secure.SignIn;
import com.example.helloshoepvtltdspringboot.reqAndresp.secure.SignUp;

public interface AuthenticationService {
    JwtAuthResponse signIn(SignIn signIn);
    JwtAuthResponse signUp(SignUp signUp);
    JwtAuthResponse refreshToken(String accessToken);
}
