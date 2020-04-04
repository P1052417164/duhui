package com.dh.dubbo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

import dh.DubboTest;
@RestController

@RequestMapping("/user")
@CrossOrigin
public class DubboTestController {

	@Reference(version = "0.0.1-SNAPSHOT")
	private DubboTest dubboTest;
	@RequestMapping("/getUserById")
	public Map<String, Object> getUser(HttpServletRequest request) {
		String dd = dubboTest.getDh();
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("result", dd);
		return result;
	}

}
