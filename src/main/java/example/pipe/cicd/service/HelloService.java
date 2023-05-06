package example.pipe.cicd.service;

import example.pipe.cicd.entity.Hello;
import example.pipe.cicd.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class HelloService {

    private final HelloRepository helloRepository;

    public List<Hello> findAll() {
        return helloRepository.findAll();
    }


    @Transactional
    public Hello save(Hello hello) {
        return helloRepository.save(hello);
    }

    @Transactional
    public void deleteAll() {
        helloRepository.deleteAll();
    }

}
