package ua.lviv.ai.oop_labs.second;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"ua.lviv.ai.oop_labs.second.dataaccess", "ua.lviv.ai.oop_labs.second.business", "ua.lviv.ai.oop_labs.second.controller"})
@EnableJpaRepositories({"ua.lviv.ai.oop_labs.second.dataaccess"})
public class SecondOopLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondOopLabApplication.class, args);
    }

}
