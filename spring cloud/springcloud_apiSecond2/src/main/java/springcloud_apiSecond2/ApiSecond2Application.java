package springcloud_apiSecond2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ApiSecond2Application {
    @RequestMapping("/")
    public String home() {
        return "Hello world 2";
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiSecond2Application.class, args);
    }
}
