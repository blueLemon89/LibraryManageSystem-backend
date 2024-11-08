package lm.libraryManagementSystem.controller;

import lm.libraryManagementSystem.common.Constants;
import lm.libraryManagementSystem.model.LoginRequest;
import lm.libraryManagementSystem.model.User;
import lm.libraryManagementSystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:8080")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public Map<String, Object> loginUser(@RequestBody LoginRequest loginRequest) {
        Map<String, Object> result = new HashMap<>();
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(), loginRequest.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);
            result.put("username", loginRequest.getUsername());
            result.put(Constants.MESSAGE, "successfully logged in");
            result.put("status", "OK");
        } catch (Exception e) {
            result.put("username", loginRequest.getUsername());
            result.put(Constants.MESSAGE, "Incorrect username or password. Please try again");
            result.put("status", "BAD");
        }
        return result;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        if (userService.isExistUser(user.getName()) != 0) {
            return new ResponseEntity<>("Username is already taken", HttpStatus.BAD_REQUEST);
        }
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", user.getName());
        paramMap.put("email", user.getEmail());
        paramMap.put("password", passwordEncoder.encode(user.getPassword()));
        userService.insertUser(paramMap);

        return ResponseEntity.ok("User registered successfully");
    }

    // API Lấy thông tin người dùng hiện tại
    @GetMapping("/current-user")
    public ResponseEntity<User> getCurrentUser() {
        User currentUser = userService.getCurrentUser();
        return ResponseEntity.ok(currentUser);
    }
}
