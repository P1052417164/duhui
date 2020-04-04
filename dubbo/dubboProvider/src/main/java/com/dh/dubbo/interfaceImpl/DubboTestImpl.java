package com.dh.dubbo.interfaceImpl;

import org.springframework.stereotype.Component;

import com.alibaba.dubbo.config.annotation.Service;

import dh.DubboTest;

@Component
@Service(version = "0.0.1-SNAPSHOT", timeout = 10000)
public class DubboTestImpl implements DubboTest {

	@Override
	public String getDh() {
		// TODO Auto-generated method stub
		return "hello dh";
	}

}
