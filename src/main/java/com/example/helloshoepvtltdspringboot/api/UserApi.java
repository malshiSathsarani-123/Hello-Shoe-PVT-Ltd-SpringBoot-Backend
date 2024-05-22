package com.example.helloshoepvtltdspringboot.api;


import com.example.helloshoepvtltdspringboot.dto.CustomerDTO;
import com.example.helloshoepvtltdspringboot.dto.EmployeeDTO;
import com.example.helloshoepvtltdspringboot.dto.UserDTO;
import com.example.helloshoepvtltdspringboot.reqAndresp.response.JwtAuthResponse;
import com.example.helloshoepvtltdspringboot.reqAndresp.secure.SignIn;
import com.example.helloshoepvtltdspringboot.reqAndresp.secure.SignUp;
import com.example.helloshoepvtltdspringboot.service.AuthenticationService;
import com.example.helloshoepvtltdspringboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:63342")
public class UserApi {
   private final AuthenticationService authenticationService;

   @Autowired
   private final UserService userService;
    @GetMapping("/getEmployee")
    List<EmployeeDTO> getAllEmployee(){
        return userService.getAllEmployee();
    }

    @GetMapping("/getUser")
    List<UserDTO> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthResponse> signUp(@RequestBody SignUp signUpReq) {
       return ResponseEntity.ok(authenticationService.signUp(signUpReq));
    }
    @PostMapping("/signing")
    public ResponseEntity<JwtAuthResponse> signIn(@RequestBody SignIn signInReq) {
        return ResponseEntity.ok(authenticationService.signIn(signInReq));
    }

    @PostMapping("/refresh")
    public ResponseEntity<JwtAuthResponse> refreshToken(@RequestParam ("refreshToken") String refreshToken) {
        return ResponseEntity.ok(authenticationService.refreshToken(refreshToken));
    }
}
