package springcloud_apiFirst2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class ApiFirst2Application {
    @RequestMapping("/")
    public String home() {
        return "Hello world2";
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiFirst2Application.class,args);
    }

}
