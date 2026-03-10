package me.scpark.springdeveloper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LabMission0310 {
    @GetMapping ("/hello")
    public String hello(@RequestParam("name") String name) {
        return "반갑습니다 " + name + " 님!";
    }
}
