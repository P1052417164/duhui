package com.sanhui.synitil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import com.sanhui.synitil.api.Aff;

@SpringBootApplication
@MapperScan("com.sanhui.synitil.workflow.dao")
@EnableCaching

public class SynOmsApplication {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Aff dd = new Aff();
		int[] dddd = {6, 5, 4, 3, 1, 2, 3, 4};

		dd.sort(dddd, 0, 7);
		List<String> ddd = new ArrayList<String>();
		ArrayList<String> re=new ArrayList<String>();
		JButton jButton = new JButton("My JButton");

		jButton.addActionListener(e -> System.out.println("Button Pressed!"));
		ddd.forEach(n -> System.out.println("dd"));
		Map<String, Object> dds = new HashMap<String, Object>(200);
		SpringApplication.run(SynOmsApplication.class, args);

	}

}
