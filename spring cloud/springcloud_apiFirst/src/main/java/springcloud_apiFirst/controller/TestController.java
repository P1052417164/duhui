package springcloud_apiFirst.controller;

import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import springcloud_apiFirst.service.TestService;

@RestController
@RequestMapping("/test")
public class TestController {
	@Resource
	private TestService testService;
	@RequestMapping("/test1")
	public Map<String, Object> getTest1() throws InterruptedException {
		Map<String, Object> result = testService.test1();
		System.out.print("test");
		return result;
	}
	@RequestMapping("/test2")
	public Map<String, Object> getTest2() throws InterruptedException {
		Map<String, Object> result = testService.test2();
		System.out.print("test");
		return result;
	}
	@RequestMapping("/test3")
	public Map<String, Object> getTest3()
			throws InterruptedException, ExecutionException {
		Future<Map<String, Object>> result = testService.test3();
		System.out.print("test");
		return result.get();
	}
}
