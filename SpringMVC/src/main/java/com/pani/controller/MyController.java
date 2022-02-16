package com.pani.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {

@RequestMapping("/mess")
public ModelAndView modelAndView(@RequestParam (value = "a" ,required = false,defaultValue = "default") String a) {
	String param = "domanda";
	ModelAndView mvw = new ModelAndView("risposta");
	mvw.addObject("parametro", param);
	mvw.addObject("richiesta",a);
	return mvw;
}


}
