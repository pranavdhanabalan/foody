package com.pranavd.foody.Controller;

import com.pranavd.foody.Model.User;
import com.pranavd.foody.Repository.UserRepository;
import com.pranavd.foody.Security.JwtUtil;
import com.pranavd.foody.Service.AuthService;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UserRepository userRepository;
    private final AuthService authService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String,String> body){
        String email=body.get("email");
        String password=body.get("password");

        var userOpt=userRepository.findByuserEmail(email);

        if (userOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email");
        }

        var user = userOpt.get();
        if (!passwordEncoder.matches(password, user.getUserPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }

        String token = jwtUtil.generateToken(email);
        return ResponseEntity.ok(Map.of("token", token));
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Map<String,String> body){
        String userName=body.get("userName");
        String email = body.get("email");
        String password = passwordEncoder.encode(body.get("password"));
        if (userRepository.findByuserEmail(email).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Email already exists");
        }
        authService.createUser(User.builder().userName(userName).userEmail(email).userPassword(password).build());
        return ResponseEntity.ok("User registered");
    }

}
