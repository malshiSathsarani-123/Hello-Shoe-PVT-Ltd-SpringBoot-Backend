package com.example.helloshoepvtltdspringboot.service.impl;

import com.example.helloshoepvtltdspringboot.dto.UserDTO;
import com.example.helloshoepvtltdspringboot.enums.Role;
import com.example.helloshoepvtltdspringboot.repositary.UserDao;
import com.example.helloshoepvtltdspringboot.reqAndresp.response.JwtAuthResponse;
import com.example.helloshoepvtltdspringboot.reqAndresp.secure.SignIn;
import com.example.helloshoepvtltdspringboot.reqAndresp.secure.SignUp;
import com.example.helloshoepvtltdspringboot.service.AuthenticationService;
import com.example.helloshoepvtltdspringboot.service.JWTService;
import com.example.helloshoepvtltdspringboot.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceIMPL implements AuthenticationService {
    private final UserDao userDao;
    private final JWTService jwtService;
    private final Mapping mapping;
    //utils
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthResponse signIn(SignIn signIn) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signIn.getEmail(),signIn.getPassword()));
        var userByEmail = userDao.findByEmail(signIn.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
       var generatedToken = jwtService.generateToken(userByEmail);
       return JwtAuthResponse.builder().token(generatedToken).build() ;
    }

    @Override
    public JwtAuthResponse signUp(SignUp signUp) {
        var buildUser = UserDTO.builder()
                .id(nextUserId())
                .email(signUp.getEmail())
                .name(signUp.getName())
                .password(passwordEncoder.encode(signUp.getPassword()))
                .role(Role.valueOf(signUp.getRole()))
                .build();
        var savedUser = userDao.save(mapping.toUserEntity(buildUser));
        var genToken = jwtService.generateToken(savedUser);
        return JwtAuthResponse.builder().token(genToken).build();
    }

    @Override
    public JwtAuthResponse refreshToken(String accessToken) {
        var userName = jwtService.extractUsername(accessToken);
        var userEntity = userDao.findByEmail(userName).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var refreshToken = jwtService.generateToken(userEntity);
        return JwtAuthResponse.builder().token(refreshToken).build();
    }

    public String nextUserId() {
        String maxId = userDao.findMaxId();
        if (maxId != null){
            return generateNextUserId(maxId);
        }else {
            return "U-001";
        }
    }

    private static String generateNextUserId(String lastUserId) {
        String numericPart = lastUserId.substring(2);
        int nextNumericValue = Integer.parseInt(numericPart) + 1;
        String nextNumericPart = String.format("%03d", nextNumericValue);
        return "U-" + nextNumericPart;
    }
}

