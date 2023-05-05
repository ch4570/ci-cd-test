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
        StringBuilder sb = new StringBuilder();
        String container = port == 8081 ? "blue" : "green";


       return sb.append("현재 실행중인 port 번호는 ")
               .append(port)
               .append("입니다. 현재 실행중인 container의 이름은 ")
               .append(container)
               .append("입니다.")
               .toString();
    }

}
