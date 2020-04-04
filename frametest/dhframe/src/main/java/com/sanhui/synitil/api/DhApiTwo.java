package com.sanhui.synitil.api;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DhApiTwo {
	@SuppressWarnings("unused")
	@RequestMapping("/SynOMS/search")
	public String search(HttpServletRequest request,HttpServletResponse response) {
		   int i=0;
			i++;
			String dd=request.getSession().getId();
			request.getHeaderNames();
			request.getCookies();
			response.setHeader("token", "token=1");
			response.setHeader("tokenfdfdfd", "token=1");
			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
			response.setStatus(200);
		return "Hello World!";
	}

}
