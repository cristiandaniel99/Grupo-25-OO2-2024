package com.unla.grupo25.sistemastock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo25.sistemastock.dtos.StockDTO;
import com.unla.grupo25.sistemastock.entities.Producto;
import com.unla.grupo25.sistemastock.helpers.ViewRouteHelper;
import com.unla.grupo25.sistemastock.services.IStockService;


@Controller
@RequestMapping("/stock")
public class StockController {
	
	private IStockService stockService;
	
	public StockController(IStockService stockService) {
		this.stockService = stockService;
	}
	
	/*@GetMapping("/altastock")
	public ModelAndView altaStock() { 
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.ALTA_STOCK); 
		mAV.addObject("productos",productservice.findall()); 
		mAV.addObject("producto", new Producto());
		return mAV; 
	}*/
	
	
	@GetMapping("")
	public ModelAndView index() { 
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.STOCK_INDEX); 
		mAV.addObject("stocks",stockService.getAll()); 
		mAV.addObject("stock", new StockDTO());
		return mAV; 
	}
	
	@PostMapping("/save") 
	public RedirectView create(@ModelAttribute("stock") StockDTO stockDTO) {
		stockService.insertOrUpdate(stockDTO); 
		return new RedirectView(ViewRouteHelper.ROUTE_STOCK_IDEX);
	}
	
	
	/*@PostMapping("/decrement")
	public RedirectView decrementStock(StockDTO stockDTO) {
		stockService.decrement(stockDTO);
	}*/
	
	
}
