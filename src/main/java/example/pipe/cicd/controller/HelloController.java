package example.pipe.cicd.controller;

import example.pipe.cicd.entity.Hello;
import example.pipe.cicd.service.HelloService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@Slf4j
public class HelloController {

    private final HelloService helloService;

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/hello")
    public String hello() {
        return "안녕!@!";
    }

    @GetMapping("/")
    public String home() {
        return "hi";
    }

    @GetMapping("/test")
    public String port() {
       return "green 가자!";
    }

    @GetMapping("/plus")
    public Hello plus(){
        return helloService.save(Hello.builder().world(UUID.randomUUID().toString()).build());
    }

    @GetMapping("/read")
    public List<Hello> read() {
        List<Hello> result = helloService.findAll();
        log.info("result = {}" ,result);
        return result;
    }


}
