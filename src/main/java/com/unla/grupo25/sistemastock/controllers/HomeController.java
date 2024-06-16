package com.unla.grupo25.sistemastock.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo25.sistemastock.helpers.ViewRouteHelper;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@GetMapping("/index")
	public ModelAndView index() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.INDEX);
		mAV.addObject("username", authentication.getName());
		return mAV;
	}
	
	@GetMapping("/")
	public RedirectView redirectViewToHomeIndex() {
		return new RedirectView(ViewRouteHelper.ROUTE_INDEX);
	}
	
	
	
}
