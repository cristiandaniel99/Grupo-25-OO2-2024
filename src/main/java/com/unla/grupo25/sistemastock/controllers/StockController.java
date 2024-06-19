package com.unla.grupo25.sistemastock.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo25.sistemastock.dtos.StockDTO;
import com.unla.grupo25.sistemastock.entities.Lote;
import com.unla.grupo25.sistemastock.entities.Producto;
import com.unla.grupo25.sistemastock.entities.Proveedor;
import com.unla.grupo25.sistemastock.entities.StockProducto;
import com.unla.grupo25.sistemastock.helpers.ViewRouteHelper;
import com.unla.grupo25.sistemastock.services.IStockService;
import com.unla.grupo25.sistemastock.services.ILoteService;
import com.unla.grupo25.sistemastock.services.IProductoService;
import com.unla.grupo25.sistemastock.services.IProveedorService;


@Controller
@RequestMapping("/stock")
public class StockController {
	
	private IStockService stockService;
	private IProductoService productoService;
	private ILoteService loteService;
	private IProveedorService proveedorService;
	
	public StockController(IStockService stockService, IProductoService productoService, ILoteService loteService, IProveedorService proveedorService) {
		this.stockService = stockService;
		this.productoService = productoService;
		this.loteService = loteService;
		this.proveedorService = proveedorService;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/alta")
    public ModelAndView altaStock() {
        ModelAndView mAV = new ModelAndView(ViewRouteHelper.ALTA_STOCK);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<Proveedor> proveedores = proveedorService.getAll();
        mAV.addObject("productos", productoService.getAll());
        mAV.addObject("username", authentication.getName());
        mAV.addObject("proveedores", proveedores);
        mAV.addObject("stockProducto", new StockProducto());
        return mAV;
    }
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("")
	public ModelAndView index() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView mAV = new ModelAndView(ViewRouteHelper.STOCK_INDEX); 
		mAV.addObject("stocks",stockService.getAll()); 
		mAV.addObject("username", authentication.getName());
		mAV.addObject("stock", new StockDTO());
		return mAV; 
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PostMapping("/save") 
	public RedirectView create(@ModelAttribute(name= "stockProducto") StockProducto stockProducto, @RequestParam("productoId") int productoId,
							   @RequestParam ("proveedorId") int proveedorId) {
		Producto producto = productoService.findById(productoId);
		StockProducto stockProductoExist = stockService.findByStockProductoId(productoId);
		if(stockProductoExist != null) {
			stockProductoExist.setCantidad(stockProductoExist.getCantidad() + stockProducto.getCantidad());
			stockProductoExist.setMinimaStock(stockProducto.getMinimaStock());
			stockService.insertOrUpdate(stockProductoExist);
		}else {
			stockProducto.setProducto(producto);
			stockService.insertOrUpdate(stockProducto);
		}
		Optional <Proveedor> proveedor = proveedorService.findById(proveedorId); 
		Lote lote = new Lote();
		
		lote.setCantidadRecibida(stockProducto.getCantidad());
		lote.setFechaDeRecepcion(LocalDate.now());
		lote.setProducto(producto);
		lote.setPrecioCompra(producto.getCosto());
		lote.setProveedor(proveedor.get());
		
		loteService.insertOrUpdate(lote);
		
		return new RedirectView(ViewRouteHelper.ROUTE_STOCK_IDEX);
		
	}

}
