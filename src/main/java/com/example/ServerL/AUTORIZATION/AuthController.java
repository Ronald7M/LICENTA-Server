package com.example.ServerL.AUTORIZATION;

import com.example.ServerL.AUTORIZATION.AuthRequest;
import com.example.ServerL.AUTORIZATION.AuthResponse;
import com.example.ServerL.AUTORIZATION.JwtUtil;
import com.example.ServerL.Tables.USER.User;
import com.example.ServerL.Tables.USER.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        User user = userService.findByUsernameAndPassword(authRequest.getUsername(), authRequest.getPassword());
        if (user != null) {
            String token = jwtUtil.generateToken(user.getUsername());
            System.out.println(new AuthResponse(token).getToken());
            return ResponseEntity.ok(new AuthResponse(token));

        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}