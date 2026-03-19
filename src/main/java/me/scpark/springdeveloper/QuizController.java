package me.scpark.springdeveloper;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuizController {
    @GetMapping("/quiz") // http://localholst:8090/quiz?code=1
    public ResponseEntity<String> quiz(@RequestParam("code") int code) {
        switch (code) {
            case 1 :
                return ResponseEntity.created(null).body("Created!");
            case 2 :
                return ResponseEntity.badRequest().body("Bad Request");
            default:
                return ResponseEntity.ok().body("Ok");
        }
    }
    @PostMapping("/quiz")
    public ResponseEntity<String> quiz2(@RequestBody Code code) {
        switch (code.value()) {
            case 1 :
                return ResponseEntity.status(404).body("Forbidden");
            default:
                return ResponseEntity.ok().body("Ok");
        }
    }
}

record Code(int value) {}