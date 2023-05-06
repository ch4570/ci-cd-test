package example.pipe.cicd.transation;

import example.pipe.cicd.entity.Hello;
import example.pipe.cicd.service.HelloService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransactionTest {

    @Autowired
    private HelloService helloService;


    @Test
    @DisplayName("Master 쓰기 호출")
    @Transactional
    void write() {

        helloService.save(Hello.builder().world("japan").build());

    }

    @Test
    @DisplayName("Slave 읽기 호출")
    @Transactional(readOnly = true)
    void read() {

        helloService.findAll();
    }
}
