package com.unla.grupo25.sistemastock.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.unla.grupo25.sistemastock.dtos.ProductoDTO;
import com.unla.grupo25.sistemastock.dtos.StockDTO;
import com.unla.grupo25.sistemastock.helpers.ViewRouteHelper;
import com.unla.grupo25.sistemastock.services.IProductoService;

import com.unla.grupo25.sistemastock.entities.Producto;
import com.unla.grupo25.sistemastock.services.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@Controller
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private IProductoService productoService;
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ModelAndView listarProductos() {
    	ModelAndView mAV = new ModelAndView(ViewRouteHelper.PRODUCTO_INDEX); 
		mAV.addObject("productos",productoService.getAll()); 
		mAV.addObject("producto", new ProductoDTO());
		return mAV; 
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/editar/{id}")
    public ModelAndView mostrarFormularioEditar(@PathVariable int id) {
        Optional<Producto> producto = productoService.findById(id);
        ModelAndView modelAndView = new ModelAndView(ViewRouteHelper.FORM_PRODUCTO); 
        modelAndView.addObject("producto", producto.orElse(new Producto()));
        return modelAndView;
    }
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/save") 
	public ModelAndView create(@ModelAttribute("producto") ProductoDTO productoDTO) {
		productoService.insertOrUpdate(productoDTO); 
		return new ModelAndView("redirect:/productos");
	}
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/eliminar/{id}")
    public ModelAndView eliminarProducto(@PathVariable int id) {
        productoService.remove(id);
        return new ModelAndView("redirect:/productos");
    }
}


	
	

