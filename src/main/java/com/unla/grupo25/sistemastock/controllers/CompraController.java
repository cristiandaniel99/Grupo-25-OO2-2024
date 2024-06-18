package com.unla.grupo25.sistemastock.controllers;

import java.time.LocalDate;
import java.util.Optional;

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

import com.unla.grupo25.sistemastock.dtos.CompraDTO;
import com.unla.grupo25.sistemastock.dtos.StockDTO;
import com.unla.grupo25.sistemastock.dtos.UserDTO;
import com.unla.grupo25.sistemastock.entities.Compra;
import com.unla.grupo25.sistemastock.entities.Producto;
import com.unla.grupo25.sistemastock.entities.User;
import com.unla.grupo25.sistemastock.helpers.ViewRouteHelper;
import com.unla.grupo25.sistemastock.services.ICompraService;
import com.unla.grupo25.sistemastock.services.IStockService;
import com.unla.grupo25.sistemastock.services.implementation.UserService;
import com.unla.grupo25.sistemastock.services.IProductoService;

@Controller
@RequestMapping("/store")
public class CompraController {
	
	private IStockService stockService;
	private ICompraService compraService;
	private IProductoService productoService;
	private UserService userService;
	
	public CompraController(IStockService stockService, ICompraService compraService, IProductoService productoService, UserService userService) {
		this.stockService = stockService;
		this.compraService = compraService;
		this.productoService = productoService;
		this.userService = userService;
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
	public RedirectView procesarCompra(@RequestParam(name= "productoId") int productoId, 
									   @RequestParam(name="cantidad") int cantidad) throws Exception {
		
		try {
			stockService.BajaStockPorCompra(productoId, cantidad);
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			UserDetails userDetails = (UserDetails) authentication.getPrincipal();
			User user = userService.findByUsername(userDetails.getUsername());
			
			Optional<Producto> productoOptional  = productoService.findById(productoId);
			Producto producto = productoOptional.get();
			
			Compra compra = new Compra();
			compra.setCantidad(cantidad);
			compra.setCliente(user);
			compra.setFechaCompra(LocalDate.now());
			compra.setProducto(producto);
			
			compraService.insertOrUpdate(compra);
			
		}catch(Exception e){
			throw new Exception ("No se pudo realizar la compra");
		}
		
		return new RedirectView(ViewRouteHelper.ROUTE_STORE_IDEX);
		
	}
	
}
