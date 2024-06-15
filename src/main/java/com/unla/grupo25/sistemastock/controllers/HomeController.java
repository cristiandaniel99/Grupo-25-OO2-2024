package com.unla.grupo25.sistemastock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo25.sistemastock.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/index")
	public String index() {
		return ViewRouteHelper.INDEX;
	}
	
	@GetMapping("/")
	public RedirectView redirectViewToHomeIndex() {
		return new RedirectView(ViewRouteHelper.ROUTE_INDEX);
	}
	
	
	
}
