package example.pipe.cicd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/hello")
    public String hello() {
        return "안녕!@!";
    }

    @GetMapping("/")
    public String home() {
        return "Home";
    }

    @GetMapping("/test")
    public String port() {
       return "green 가자!";
    }

}
