package springcloud_eurekaServerTwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerTwoApplication {
    @RequestMapping("/ss")
    public String home() {
        return "Hello world";
    }

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerTwoApplication.class,args);
    }
}
