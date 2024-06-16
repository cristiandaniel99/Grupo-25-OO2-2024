package com.unla.grupo25.sistemastock.controllers;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo25.sistemastock.dtos.StockDTO;
import com.unla.grupo25.sistemastock.dtos.UserDTO;
import com.unla.grupo25.sistemastock.entities.Compra;
import com.unla.grupo25.sistemastock.entities.User;
import com.unla.grupo25.sistemastock.helpers.ViewRouteHelper;
import com.unla.grupo25.sistemastock.services.ICompraService;
import com.unla.grupo25.sistemastock.services.IStockService;
import com.unla.grupo25.sistemastock.services.IProductoService;

@Controller
@RequestMapping("/store")
public class CompraController {
	
	private IStockService stockService;
	private ICompraService compraService;
	private IProductoService productoService;
	private ModelMapper modelMapper = new ModelMapper();
	
	public CompraController(IStockService stockService, ICompraService compraService) {
		this.stockService = stockService;
		this.compraService = compraService;
	}
	
	
	@GetMapping("")
	public ModelAndView store() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.STORE_INDEX);
		mAV.addObject("stocks", stockService.getAll());
		mAV.addObject("stock", new StockDTO());
		mAV.addObject("username", authentication.getName());
		return mAV;
		
	}
	
	@PostMapping("/comprar")
	public RedirectView procesarCompra(@RequestParam(name= "productoId") int productoId, @RequestParam(name="cantidad") int cantidad) throws Exception {
		
		try {
			stockService.comprarProducto(productoId, cantidad);
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			UserDTO userDTO = modelMapper.map(userDetails, UserDTO.class);
			compraService.insertOrUpdate(new Compra(productoService.findById(productoId), modelMapper.map(userDTO, User.class), LocalDate.now() , cantidad ));
			
		}catch(Exception e){
			throw new Exception ("No se pudo realizar la compra");
		}
       

		return new RedirectView(ViewRouteHelper.ROUTE_STOCK_IDEX);
		
	}
	
}
