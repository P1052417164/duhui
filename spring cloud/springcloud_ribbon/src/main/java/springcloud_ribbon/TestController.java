package springcloud_ribbon;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@Configuration
@EnableHystrix
public class TestController {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("/getTestMsg")
    public String getTestMsg() {
        RestTemplate rt = getRestTemplate();
        String result = rt.getForObject("http://apiFirst/", String.class);
        return result;
    }

    /**
     * 调用 user微服务
     */
    @HystrixCommand(fallbackMethod = "getDefaultUser")
    @GetMapping("getUser")
    public String getUser(Integer id) {
        String url = "http://apiFirst/";
        return getRestTemplate().getForObject(url, String.class);
    }

    public String getDefaultUser(Integer id) {
        System.out.println("熔断，默认回调函数");
        return "{\"id\":-1,\"name\":\"熔断用户\",\"password\":\"123456\"}";
    }
}
