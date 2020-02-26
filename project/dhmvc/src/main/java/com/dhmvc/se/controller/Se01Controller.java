package com.dhmvc.se.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/se")
public class Se01Controller {

    @RequestMapping("se01")
    public ModelAndView se(HttpServletRequest requet, HttpServletResponse response, ModelAndView m) {
        System.out.println("d");
        return m;
    }

    @RequestMapping("se01/getD")
    @ResponseBody
    public Map<String, Object> ses(HttpServletRequest requet, HttpServletResponse response) {
        System.out.println("d");

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("dd", "dd");
        m.put("date",new Date());
        return m;
    }
    @RequestMapping("se02")
    @ResponseBody
    public String ses2(HttpServletRequest requet, HttpServletResponse response) {
        System.out.println("d");

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("dd", "dd");
        m.put("date",new Date());
        return "d";
    }
    @RequestMapping("se022")
    @ResponseBody
    public String ses22(HttpServletRequest requet, HttpServletResponse response) {
        System.out.println("d");

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("dd", "dd");
        m.put("date",new Date());
        return "d";
    }
}
