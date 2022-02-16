package com.pani.contatti.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pani.contatti.model.Contatto;
import com.pani.contatti.service.ContattoService;

@Controller
public class ContattiController {
	
	@Autowired
	private ContattoService contattoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView();
		List<Contatto> contattiList = contattoService.getAll();
		
		mv.setViewName("home"); 		// la pagina deve essere in template
		mv.addObject("listaContatti", contattiList);
		mv.addObject("contatto", new Contatto());
		
		return mv;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView saveContatto(Contatto contatto) {
		contattoService.saveContatto(contatto);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/modifica/{id}", method = RequestMethod.GET)
	public ModelAndView editContatto(@PathVariable String id) {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("editpage");
		mv.addObject("contatto", contattoService.findContatto(id));
		
		return mv; 
	}
	
	@RequestMapping(value = "/elimina/{id}", method = RequestMethod.GET)
	public ModelAndView deleteContattoTemp(@PathVariable String id) {
		ModelAndView mv = new ModelAndView();
		Optional<Contatto> contatto = contattoService.findContatto(id);
		
		mv.setViewName("deletepage");
		mv.addObject("contatto", contatto.get());			// metodo .get() tira fuori l'oggetto dal wrapper
		
		return mv; 
	}
	
	@RequestMapping(value = "/conferma", method = RequestMethod.POST)
	public ModelAndView deleteContatto(Contatto contatto) {
		contattoService.deleteContatto(contatto.getId());
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/statistica", method = RequestMethod.GET)
	public ModelAndView getStatistiche(@RequestParam String username) {
		long conteggio = contattoService.count();
		List<Contatto> contatto = contattoService.getByUsername(username);
		List<Contatto> contattiGiovani = contattoService.findByEtaBetween(1, 21);
		List<Contatto> contattoIM = contattoService.findByNomeStartingWith("M");
		List<Contatto> contattoFA = contattoService.findByNomeEndingWith("a");
		List<Contatto> contattoMichele = contattoService.findContattoByNome("Michele");
		List<Contatto> contattoIMR = contattoService.findContattoByRegex("^M.*e");
		List<Contatto> contattiGiovaniQuery = contattoService.findContattoEtaBetween(1, 22);
		
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("statpage");
		
		mv.addObject("usercontatto", contatto);
		mv.addObject("conteggio", conteggio);
		mv.addObject("contattiGiovani", contattiGiovani);
		mv.addObject("contattoIM", contattoIM);
		mv.addObject("contattoFA",  contattoFA);
		mv.addObject("contattoMichele", contattoMichele);
		mv.addObject("contattoIMR", contattoIMR);
		mv.addObject("contattiGiovaniQuery", contattiGiovaniQuery);
		
		
		return mv;
		
	}
}
