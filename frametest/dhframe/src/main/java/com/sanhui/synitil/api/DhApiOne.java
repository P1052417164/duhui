package com.sanhui.synitil.api;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DhApiOne {
	 @SuppressWarnings("unused")
	@RequestMapping("/SynOMS/login")
	public String login(HttpServletRequest request,HttpServletResponse response) {
		   int i=0;
			i++;
			List<String> te=new ArrayList<String>();
			te.forEach((d)->{});
			String ddd=request.getSession().getId();
			request.getHeaderNames();
			request.getCookies();
			response.setHeader("token", "token=1");
			response.setHeader("tokenfdfdfd", "token=1");
			response.setHeader("Access-Control-Allow-Credentials", "true");
			response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	        return "Hello World!";
	    }
}
