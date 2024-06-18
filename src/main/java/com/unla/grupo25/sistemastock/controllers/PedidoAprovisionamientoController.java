package com.unla.grupo25.sistemastock.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.unla.grupo25.sistemastock.dtos.PedidoAprovisionamientoDTO;
import com.unla.grupo25.sistemastock.dtos.ProductoDTO;
import com.unla.grupo25.sistemastock.entities.Proveedor;
import com.unla.grupo25.sistemastock.entities.StockProducto;
import com.unla.grupo25.sistemastock.helpers.ViewRouteHelper;
import com.unla.grupo25.sistemastock.services.IPedidoAprovisionamientoService;
import com.unla.grupo25.sistemastock.services.IProductoService;
import com.unla.grupo25.sistemastock.services.implementation.PedidoAprovisionamientoService;
import com.unla.grupo25.sistemastock.services.implementation.ProductoService;
import com.unla.grupo25.sistemastock.services.implementation.ProveedorService;
import com.unla.grupo25.sistemastock.services.implementation.StockService;

@Controller
@PreAuthorize("hasRole('ROLE_ADMIN')")
@RequestMapping("/pedidoAprov")
public class PedidoAprovisionamientoController {

	@Autowired
    private PedidoAprovisionamientoService pedidoAprovisionamientoService;

    @Autowired
    private ProveedorService proveedorService;
   
    @Autowired
    private StockService stockProductoService;
    
    private ProductoService productoService;
    
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/generarPedido")
    public String mostrarFormulario(Model model) {
        List<StockProducto> productosBajoStock = pedidoAprovisionamientoService.findProductosBajoStock();
        List<Proveedor> proveedores = proveedorService.findAll();
        model.addAttribute("productosBajoStock", productosBajoStock);
        model.addAttribute("proveedores", proveedores);
        return ViewRouteHelper.PEDIDO_APROV;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/generar")
    public String generarPedido(@RequestParam Integer productoId, @RequestParam Integer cantidad, @RequestParam Integer proveedorId) {
        pedidoAprovisionamientoService.generarPedidoDeAprovisionamiento(productoId, cantidad, proveedorId);
        return "redirect:/pedidoAprov/generarPedido";
    }  
    
   

    
}
