package com.pani.security.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.pani.security.model.Contatto;
import com.pani.security.service.ContattoService;

@Controller
public class ContattiController {
	
	@Autowired
	private ContattoService contattoService;
	
	@RequestMapping(value = "/",method = RequestMethod.GET)
	public ModelAndView homePage(){
		return new ModelAndView("home");
	}
	

	@RequestMapping(value = "/api/contatti",method = RequestMethod.GET)
	public ModelAndView listaContatti() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("contatti");
		List<Contatto> listaContatti = contattoService.getAll();
		mv.addObject("listaContatti",listaContatti);
		return mv;
	}

	
}
