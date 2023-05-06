package example.pipe.cicd.util;

import example.pipe.cicd.entity.Hello;
import example.pipe.cicd.service.HelloService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DbInit {

    private final HelloService helloService;


    @PostConstruct
    void init() {

        helloService.deleteAll();

        for (int i=1; i<=10; i++) {
            helloService.save(Hello.builder().world("korea"+i).build());
        }

        List<Hello> result = helloService.findAll();

        System.out.println(result);

    }


}
