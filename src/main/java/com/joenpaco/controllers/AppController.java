package com.joenpaco.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	@Value(value = "${config.horario.apertura}")
	private Integer apertura;
	
	@Value(value = "${config.horario.cierre}")
	private Integer cierre;
	
	@GetMapping(value = {"/", "/index"})
	public String index(Model model) {
		
		model.addAttribute("titulo", "Bienvenido al horario de atención a clientes");
		
		return "index";
		
	}
	
	@GetMapping(value = {"/cerrado"})
	public String cerrado(Model model) {
		
		model.addAttribute("titulo", "Fuera de horario de atención");
		
		String mensaje = "Cerrado, por favor visítenos desde las " + apertura + " hrs. hasta las " + cierre + " hrs.";
		
		model.addAttribute("mensaje", mensaje);
		
		return "cerrado";
		
	}

}
