package br.com.fservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class MainController extends AbstractController{
	
	
	@RequestMapping(method=RequestMethod.GET)
	
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("index");
		mv.getModelMap().addAttribute ("name", "Cristian Clever de Oliveira");
		return mv;
	}

	
	@Override
	public Class<?> getControllerClass() {
		return MainController.class;
	}
	
	

}
