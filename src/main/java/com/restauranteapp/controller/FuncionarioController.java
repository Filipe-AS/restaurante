package com.restauranteapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.restauranteapp.model.Funcionario;
import com.restauranteapp.repository.FuncionarioRepository;

@Controller
public class FuncionarioController {
	
	@Autowired
	private FuncionarioRepository FuncR; 
	
	@RequestMapping(value="/cadastraFuncionario", method=RequestMethod.GET)
	public String form() {
		return "funcionario/formFuncionario";
	}

	@RequestMapping(value="/cadastraFuncionario", method=RequestMethod.POST)
	public String form(Funcionario funcionario) {
		
		FuncR.save(funcionario);
		
		return "redirect:/cadastraFuncionario";
	}
	
	@RequestMapping("/listaFuncionarios")
	public ModelAndView listaFuncionario() {
		ModelAndView mv = new ModelAndView("funcionario/listaFuncionario");
		Iterable<Funcionario> funcionario = FuncR.findAll();
		mv.addObject("funcionarios", funcionario);
		return mv;
	
	}
}
