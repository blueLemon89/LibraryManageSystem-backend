package lm.libraryManagementSystem.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class HomeController {

    @GetMapping("/home")
    public ResponseEntity<String> index() {
        return ResponseEntity.ok().body("Hello World!");
    }
}
