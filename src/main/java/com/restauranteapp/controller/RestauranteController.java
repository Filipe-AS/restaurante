package com.restauranteapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.restauranteapp.model.Restaurante;
import com.restauranteapp.repository.RestauranteRepository;

@Controller
public class RestauranteController {
	
	@Autowired
	private RestauranteRepository restauranteR;
	
	@RequestMapping(value="/cadastraRestaurante", method=RequestMethod.GET)
	public String form() {
		return "restaurante/formRestaurante";
	}
	
	@RequestMapping(value="/cadastraRestaurante", method=RequestMethod.POST)
	public String form(Restaurante restaurante) {
		
		restauranteR.save(restaurante);
		
		return "redirect:/cadastraRestaurante";
	}
	
	@RequestMapping("/listaRestaurantes")
	public ModelAndView listaRestaurante() {
		ModelAndView mv = new ModelAndView("restaurante/listaRestaurante");
		Iterable<Restaurante> restaurante = restauranteR.findAll();
		mv.addObject("restaurantes", restaurante);
		return mv;
	}
	

}
