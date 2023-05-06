package example.pipe.cicd.repository;

import example.pipe.cicd.entity.Hello;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelloRepository extends JpaRepository<Hello, Long> {

}
