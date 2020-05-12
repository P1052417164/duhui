package springcloud_apiFirst.service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	public Map<String, Object> test1() throws InterruptedException {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "dh");
		Thread.sleep(5000 * 1);
		return result;
	}

	@Async
	public Map<String, Object> test2() throws InterruptedException {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "dhAsync");
		Thread.sleep(5000 * 1);
		return result;
	}

	@Async
	public Future<Map<String, Object>> test3() throws InterruptedException {
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("msg", "dhAsyncFutureTask");
		Thread.sleep(5000 * 1);
		Future<Map<String, Object>> future;
		future = new AsyncResult<Map<String, Object>>(result);
		return future;
	}
}
